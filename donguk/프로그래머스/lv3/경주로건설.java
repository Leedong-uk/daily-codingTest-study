package donguk.프로그래머스.lv3;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class 경주로건설 {
    static class Solution{
        Deque<int[]> dq;
        int[] dx;
        int[] dy;
        int n ;
        int[][][] cost;
//      시작:-1, 오른쪽 : 0 , 왼 : 1 , 아래 : 2 , 위 : 3

        public int solution(int[][] board) {
            dx = new int[]{0,0,1,-1};
            dy = new int[]{1,-1,0,0};
            dq = new ArrayDeque<>();
            n = board.length;
            cost = new int[n][n][4];

            for(int i = 0 ; i<n;i++){
                for (int j = 0 ; j<n ; j++){
                    Arrays.fill(cost[i][j], Integer.MAX_VALUE);
                }
            }

            dq.addLast(new int[]{0, 0, -1});


            while(!dq.isEmpty()){
                int[] tmp = dq.poll();
                int x = tmp[0];
                int y = tmp[1];
                int direct = tmp[2];
                int curCost = direct == -1 ? 0 : cost[x][y][direct];

                for(int k = 0 ; k<4 ; k++){
                    int nx = x +dx[k];
                    int ny = y + dy[k];

                    if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                        if( board[nx][ny] != 1){
                            int nextCost;

                            if(direct == -1 || direct == k ){
                                nextCost = curCost + 100;
                            }else{
                                nextCost = curCost+ 600;
                            }

                            if(cost[nx][ny][k]> nextCost){
                                cost[nx][ny][k] = nextCost;
                                dq.addLast(new int[]{nx, ny, k});
                            }

                        }
                    }

                }
            }

            int answer = Integer.MAX_VALUE;
            for(int k = 0; k<4;k++){
                answer = Math.min(answer,cost[n - 1][n - 1][k]);
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        int[][] board1 = {{0,0,0},{0,0,0},{0,0,0}};
        int[][] board2 = {{0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0},{0,0,0,0,1,0,0,0},{0,0,0,1,0,0,0,1},{0,0,1,0,0,0,1,0},{0,1,0,0,0,1,0,0},{1,0,0,0,0,0,0,0}};
        int[][] board3 = {{0,0,1,0},{0,0,0,0},{0,1,0,1},{1,0,0,0}};
        int[][] board4 = {{0, 0, 0, 0, 0, 0}, {0, 1, 1, 1, 1, 0}, {0, 0, 1, 0, 0, 0}, {1, 0, 0, 1, 0, 1}, {0, 1, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0}};

        Solution sol = new Solution();
        System.out.println(sol.solution(board1));
        System.out.println(sol.solution(board2));
        System.out.println(sol.solution(board3));
        System.out.println(sol.solution(board4));
    }
}
