N = int(input())
buildings = list(map(int, input().split()))

left = [0 for _ in range(N)]
right = [0 for _ in range(N)]
idx = [100001 for _ in range(N)]

# 왼쪽 건물 확인
stack = [(buildings[0], 0)]
for i in range(1, N):
    # stack에 더 작은 빌딩들 제거
    while 1:
        if stack and stack[-1][0] <= buildings[i]: stack.pop()
        else: break
    
    if stack:
        left[i] = len(stack)
        idx[i] = stack[-1][1]
    stack.append((buildings[i], i))

# 오른쪽 건물 확인
stack = [(buildings[N - 1], N - 1)]
for i in range(N - 2, -1, -1):
    # stack에 더 작은 빌딩들 제거
    while 1:
        if stack and stack[-1][0] <= buildings[i]: stack.pop()
        else: break
    if stack:
        right[i] = len(stack)
        if abs(stack[-1][1] - i) < abs(idx[i] - i): idx[i] = stack[-1][1]
    stack.append((buildings[i], i))

for i in range(N):
    if idx[i] != 100001:
        print(left[i] + right[i], idx[i] + 1)
    else:
        print(left[i] + right[i])