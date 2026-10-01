package donguk.프로그래머스.lv3;

import java.util.Arrays;

public class 숫자게임_순열ver {
    static class Solution{
        static int[] tmp;
        static int answer;
        public int solution(int[]A , int[] B){
            answer = 0;
            int n = A.length;
            tmp = new int[n];
            boolean[] visited = new boolean[n];
            perm(0, visited, A, B);
            return answer;
        }


        public void perm(int cnt ,boolean[] visited, int[]A , int[]B){
            if(cnt == A.length){
                int num = 0;
                System.out.println("num ="+num);
                System.out.println("tmp ="+Arrays.toString(tmp));
                for (int i = 0; i < A.length; i++) {
                    if (A[i] < tmp[i]) {
//                        System.out.println("A[i] ="+A[i]+" tmp[i] ="+tmp[i]);
                        num++;
                    }
                }
//                if(num == 3)
//                    System.out.println("tmp ="+Arrays.toString(tmp));
                System.out.println("num ="+num);
                System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
                answer = Math.max(num, answer);
                return;
            }

            for (int j = 0; j<A.length; j++){
                if(visited[j])
                    continue;

                visited[j] = true;
                tmp[cnt] = B[j];

                perm(cnt+1,visited,A,B);

                visited[j]=false;
            }
        }
    }

    public static void main (String[] args){
        int[] A1 = {5, 1, 3, 7};
        int[] B1 = {2, 2, 6, 8};

        int[] A2 = {2, 2, 2, 2};
        int[] B2 = {1, 1, 1, 1};

        Solution sol = new Solution();
        System.out.println(sol.solution(A1, B1));
//        System.out.println(sol.solution(A2, B2));
    }
}
