package donguk.프로그래머스.lv3;

public class 스티커모으기 {
    static class Solution {
        public int solution(int sticker[]) {
            int answer = 0;

            int[] dp = new int[sticker.length];

            //
            dp[0] = sticker[0];
            dp[1] = Math.max(sticker[0], sticker[1]);

            for(int i = 2 ; i<sticker.length;i++){
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + sticker[i]);
            }

            return answer;
        }
    }

    public static void main (String[]args) {
        int[] sticker1 = {14, 6, 5, 11, 3, 9, 2, 10};
        int[] sticker2 = {1, 3, 2, 5, 4};

        Solution sol = new Solution();
        System.out.println(sol.solution(sticker1));
        System.out.println(sol.solution(sticker2));
    }
}
