import copy

N, M = map(int, input().split())
office = []
for _ in range(N):
    office.append(list(map(int, input().split())))

cctv = []
for i in range(N):
    for j in range(M):
        if 0 < office[i][j] < 6: cctv.append((i, j))

dirct = [(-1, 0), (0, 1), (1, 0), (0, -1)]

types = [
    [],
    [[0], [1], [2], [3]],
    [[0, 2], [1, 3]],
    [[0, 1], [1, 2], [2, 3], [3, 0]],
    [[0, 1, 2], [1, 2, 3], [2, 3, 0], [3, 0, 1]],
    [[0, 1, 2, 3]]
]

def simulation(idx, c, office, type):
    tempt = copy.deepcopy(office)
    for t in type:
        x = idx[0]
        y = idx[1]
        while 1:
            x += dirct[t][0]
            y += dirct[t][1]

            if x < 0 or x >= N or y < 0 or y >= M: break    # 범위를 넘은 경우 멈추기
            if tempt[x][y] == 6: break # 벽인 경우 멈추기
            if 0 < tempt[x][y] < 6 or tempt[x][y] == -1: continue # cctv가 있거나 이미 감시 가능한 영역은 넘기기
            tempt[x][y] = -1
    
    return tempt

def countBlind(office):
    cnt = 0
    for offi in office:
        for o in offi:
            if o == 0: cnt += 1
    return cnt

ans = 65
def dfs(idx, office):
    global ans
    if idx == len(cctv):    # cctv 모두 탐색한 경우
        ans = min(ans, countBlind(office))  # 사각지대 수
        return
    cctvIdx = cctv[idx]
    c = office[cctvIdx[0]][cctvIdx[1]]
    for type in types[c]:
        dfs(idx + 1, simulation(cctvIdx, c, office, type))

    return

dfs(0, office)
print(ans)