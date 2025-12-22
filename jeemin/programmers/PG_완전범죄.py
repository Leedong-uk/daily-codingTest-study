# Lv. 2

def solution(info, n, m):
    INF = 10**9

    # dp[b] = B 흔적이 b일 때 가능한 A 흔적의 최소값
    dp = [INF] * m
    dp[0] = 0

    for a_cost, b_cost in info:
        new_dp = [INF] * m  # ✅ 스킵 금지: 이번 물건을 반드시 처리해야 하므로 INF로 시작

        for b in range(m):
            if dp[b] == INF:
                continue

            # 1) A가 훔치는 경우: A 증가, B 그대로
            na = dp[b] + a_cost
            if na < n:
                new_dp[b] = min(new_dp[b], na)

            # 2) B가 훔치는 경우: B 증가, A 그대로
            nb = b + b_cost
            if nb < m:
                new_dp[nb] = min(new_dp[nb], dp[b])

        dp = new_dp

    ans = min(dp)
    return ans if ans < n else -1