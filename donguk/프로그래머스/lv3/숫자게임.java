package donguk.프로그래머스.lv3;

import java.util.Arrays;

public class 숫자게임 {
        static class Solution{
            public int solution(int[]A , int[] B){
                int answer = 0;
                Arrays.sort(B);
                Arrays.sort(A);
                int a = 0;
                int b = 0;

                while (a <A.length && b<B.length){
                    if(B[b] > A[a]){
                        answer++;
                        a++;
                        b++;
                    }
                    else{
                        b++;
                    }
                }
                return answer;
            }



        public static void main (String[] args){
            int[] A1 = {5, 1, 3, 7};
            int[] B1 = {2, 2, 6, 8};

            int[] A2 = {2, 2, 2, 2};
            int[] B2 = {1, 1, 1, 1};

            Solution sol = new Solution();
            System.out.println(sol.solution(A1, B1));
            System.out.println(sol.solution(A2, B2));
        }
    }
}
