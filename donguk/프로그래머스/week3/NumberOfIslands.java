package donguk.프로그래머스.week3;

import java.util.ArrayDeque;

public class NumberOfIslands {
    static class Solution{
        public int numIsLands(char[][] grid){
            int answer = 0;
            ArrayDeque<int[]> q = new ArrayDeque<>();
            int n = grid.length;
            int m = grid[0].length;
            int[] dx = {0, 0, 1, -1};
            int[] dy = {1, -1, 0, 0};
            boolean[][] visited = new boolean[n][m];

            for(int i = 0 ; i<n ; i++){
                for(int j = 0; j<m ; j++){
                    if(grid[i][j] != '1')
                        continue;

                    if(!visited[i][j]){
                        answer++;
                        int[] position = new int[2];
                        position[0] = i;
                        position[1] = j;

                        q.add(position);
                        visited[i][j] = true;

                        while(!q.isEmpty()){
                            int[] current = q.pop();
                            int currentX = current[0];
                            int currentY = current[1];

                            for(int k =0; k<4;k++){
                                int nx = currentX + dx[k];
                                int ny = currentY + dy[k];

                                if(0<= nx && nx < n && 0<= ny && ny< m){
                                    if(grid[nx][ny] == '1' && !visited[nx][ny]){
                                        int[] newPosition = new int[2];
                                        newPosition[0] = nx;
                                        newPosition[1] = ny;
                                        q.add(newPosition);
                                        visited[nx][ny] = true;
                                    }
                                }
                            }

                        }
                    }
                }
            }


            return answer;
        }
    }

    public static void main(String[] args){
        Solution sol = new Solution();

        char[][] grid1 = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        char[][] grid2 = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };

        System.out.println(sol.numIsLands(grid1));
        System.out.println(sol.numIsLands(grid2));
    }
}
