package donguk.프로그래머스.PCCP.배열;

import java.util.Arrays;

public class 행렬의곱셈 {
    static class Solution{
        public int[][] solution(int[][] arr1, int[][] arr2) {
            int[][] answer = {};
            return answer;
        }
    }

    public static void main(String[] args){
        Solution sol = new Solution();

        int[][] firstArr1 = {{1, 4}, {3, 2}, {4, 1}};
        int[][] firstArr2 = {{3, 3}, {3, 3}};

        int[][] secondArr1 = {{2, 3, 2}, {4, 2, 4}, {3, 1, 4}};
        int[][] secondArr2 = {{5, 4, 3}, {2, 4, 1}, {3, 1, 1}};

        int[][] solution1 = sol.solution(firstArr1, firstArr2);
        int[][] solution2 = sol.solution(secondArr1, secondArr2);

        System.out.println(Arrays.deepToString(solution1));
        System.out.println(Arrays.deepToString(solution2));


    }
}
