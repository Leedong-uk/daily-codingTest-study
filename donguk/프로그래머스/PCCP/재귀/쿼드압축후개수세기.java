package donguk.프로그래머스.PCCP.재귀;

import java.util.Arrays;

public class 쿼드압축후개수세기 {
    static class Solution{
        static int zeroCnt;
        static int oneCnt;

        public int[] solution(int[][] arr){
            zeroCnt = 0;
            oneCnt = 0;

            check(0, 0, arr.length, arr);
            int[] answer = {zeroCnt, oneCnt};

            return answer;
        }

        public void check(int offsetX ,int offsetY , int size , int[][] arr){
            int tmpZero = 0;
            int tmpOne = 0;


//            재귀
            for(int i=offsetX; i<offsetX+size; i++){
                for(int j = offsetY; j<offsetY+size; j++){
                    if(arr[i][j] == 1)
                        tmpOne++;
                    else
                        tmpZero++;
                }
            }

//            종료 조건
            if (tmpZero == size * size) {
                zeroCnt++;
                return;
            }

            if(tmpOne ==size*size){
                oneCnt++;
                return;
            }

//            재귀
            int half = size / 2;

            check(offsetX, offsetY, half, arr);
            check(offsetX, offsetY + half, half, arr);
            check(offsetX + half, offsetY, half, arr);
            check(offsetX + half, offsetY + half, half, arr);
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
