package donguk.프로그래머스.lv3;

public class 거스름돈 {
    static class Solution{
        public int solution(int n , int[] money){
            int answer = 0;
            int[] dp = new int[n + 1];
            int mod = 1000000007;

            dp[0] = 1;

            for(int coin: money){
                for(int i = coin; i<=n; i++){
                    dp[i] = (dp[i]+dp[i-coin])%mod;
                }
            }


            return dp[n];
        }
    }

    public static void main(String[] args){
        int n = 5;
        int[] money = {1, 2, 5};

        Solution sol = new Solution();
        System.out.println(sol.solution(n, money));
    }
}
