# Lv. 2
from collections import deque
def solution(players, m, k):
    answer = 0
    server = deque()
    for i in range(len(players)):
        while server:    # 서버 반납
            if server[0]  + k <= i:
                server.popleft()
            else: break
        if (players[i] // m > len(server)):   # 서버 증설
            plus = players[i] // m - len(server)
            # print(i, plus)
            for _ in range(plus):
                answer += 1
                server.append(i)
    return answer