package donguk.프로그래머스.PCCP.재귀;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 하노이의탑 {
//    재귀
//    1. 상태 -> 재귀의 단계를 설명해줄 변수들의 집합..?
//        -> 문제를 보고 큰 문제를 표현할 수 있는 변수들을 생각해 보자
//    2. 종료 부분 -> 해당 문제에서 "가장 작은 부분 문제"
//        -> 가장 작은 부분집합을 상태로 표현 하는 걸 생각해보자
//    3. 점화식 -> 상태를 가장 작은 문제로 전이시킬 식
    static class Solution{
        public int[][] solution(int n){
            List<int[]> process = new ArrayList<>();
            hanoi(n, 1, 3, process);
            return process.toArray(new int[0][]);
        }

        public void hanoi(int n ,int from , int to,List<int[]>process) {

//            종료 조건
            if (n == 1) {
                process.add(new int[]{from, to});
                return;
            }

            int empty = 6-from-to;

            hanoi(n - 1, from, empty,process);
            hanoi(1,from,to,process);
            hanoi(n - 1, empty, to,process);

        }

    }

    public static void main(String[] args){
        Solution sol = new Solution();

        int n = 2;

        System.out.println(Arrays.toString(sol.solution(2)));
    }
}
