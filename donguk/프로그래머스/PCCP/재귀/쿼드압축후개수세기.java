package donguk.프로그래머스.PCCP.재귀;

import java.util.Arrays;

public class 쿼드압축후개수세기 {
    static class Solution{
        public int[] solution(int[][] arr){
            int[] answer ={};
            return answer;
        }
    }

    public static void main(String[] args){
        Solution sol = new Solution();

        int[][] arr1={{1,1,0,0},
                      {1,0,0,0},
                      {1,0,0,1},
                      {1,1,1,1}};

        int[][] arr2={{1,1,1,1,1,1,1,1},
                      {0,1,1,1,1,1,1,1},
                      {0,0,0,0,1,1,1,1},
                      {0,1,0,0,1,1,1,1},
                      {0,0,0,0,0,0,1,1},
                      {0,0,0,0,0,0,0,1},
                      {0,0,0,0,1,0,0,1},
                      {0,0,0,0,1,1,1,1}};

        System.out.println(Arrays.toString(sol.solution(arr1)));
        System.out.println(Arrays.toString(sol.solution(arr2)));
    }
}
