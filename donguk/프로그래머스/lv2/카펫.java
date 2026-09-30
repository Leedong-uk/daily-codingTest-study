package donguk.프로그래머스.lv2;

import java.util.Arrays;

public class 카펫 {
    static class Solution{
        public int[] solution(int brown, int yellow) {
            int[] answer = {};

            if (yellow == 1) {
                return new int[]{3, 3};
            }

            for (int i = 1; i < yellow; i++) {
                int m = -1;
                if (yellow % i == 0) {
                     m = yellow / i;
                }

                if (m != -1 && (2 * m + 2 * i + 4 == brown)) {
                    answer = new int[]{m + 2, i + 2};
                    break;
                }

            }

            return answer;
        }
    }

    public static void main(String[] args){
        int brown1 = 10;
        int yellow1 = 2;

        int brown2 = 8;
        int yellow2 = 1;

        int brown3 = 24;
        int yellow3 = 24;

        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(brown1, yellow1)));
        System.out.println(Arrays.toString(sol.solution(brown2, yellow2)));
        System.out.println(Arrays.toString(sol.solution(brown3, yellow3)));

    }
}
