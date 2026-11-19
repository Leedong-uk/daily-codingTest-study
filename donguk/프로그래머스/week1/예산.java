package donguk.프로그래머스.week1;

import java.util.Arrays;

public class 예산 {
    static class Solution {
        public int solution(int[] d, int budget) {
            int answer = 0;

            Arrays.sort(d);
            int cnt = 0;

            for(int i = 0 ; i < d.length;i++){
                int tmp = budget - d[i];

                if (tmp >= 0) {
//                    System.out.println(tmp);
                    budget = tmp;
                    cnt++;
                } else {
                    break;
                }
            }

            return cnt;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] d1 = {1, 3, 2, 5, 4};
        int budget1 = 9;

        int[] d2 = {2, 2, 3, 3};
        int budget2 = 10;

        System.out.println(sol.solution(d1, budget1));
        System.out.println(sol.solution(d2, budget2));
    }
}
