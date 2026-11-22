package donguk.프로그래머스.week2;

import java.util.ArrayDeque;
import java.util.HashMap;

public class CoinChange {
    static class Solution {
        public int coinChange(int[] coins, int amount) {
            int answer = 0;
            boolean[] visited = new boolean[amount + 1];
            ArrayDeque<Integer> q = new ArrayDeque<>();
            HashMap<Integer, Integer> dic = new HashMap<>();

            for (int i = 0; i < amount + 1; i++) {
                dic.put(i, -1);
            }

            q.add(0);
            visited[0] = true;
            dic.put(0, 0);

            while (!q.isEmpty()) {
                int current = q.poll();

                for (int coin : coins) {
                    if (coin <= amount - current) {
                        int next = current + coin;

                        if (!visited[next]) {
                            dic.put(next, dic.get(current) + 1);
                            q.add(next);
                            visited[next] = true;
                        }
                    }
                }
            }

            answer = dic.get(amount);

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] coins1 = {1, 2, 5};
        int amount1 = 11;

        int[] coins2 = {2};
        int amount2 = 3;

        int[] coins3 = {1};
        int amount3 = 0;

        System.out.println(sol.coinChange(coins1, amount1));
        System.out.println(sol.coinChange(coins2, amount2));
        System.out.println(sol.coinChange(coins3, amount3));
    }
}