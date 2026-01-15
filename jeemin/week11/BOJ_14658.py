N, M, L, K = map(int, input().split())

stars = []
xList = []
yList = []
for _ in range(K):
    s = list(map(int, input().split()))
    stars.append(s)
    xList.append(s[0])
    yList.append(s[1])

ans = 0
for x in xList:
    for y in yList:
        cnt = 0
        for a, b in stars:
            if x <= a <= x + L and y <= b <= y + L:
                cnt += 1
        ans = max(ans, cnt)
print(K - ans)