package donguk.프로그래머스.week3;

import java.util.ArrayDeque;

public class 미로탈출 {
    static class Solution{
        public int solution(String[] maps) {
            int answer = -1;
            int[] lever = new int[2];
            int[] start = new int[2];
            int[] exit = new int[2];
            ArrayDeque<int[]> q;
            int[][] board = new int[maps.length][maps[0].length()];
            boolean[][] visited;
            int[] dx = {0, 0, 1, -1};
            int[] dy = {1, -1, 0, 0};

            for(int i =0; i<maps.length;i++){
                for(int j = 0; j<maps[i].length();j++){
                    if(maps[i].charAt(j) == 'L'){
                        lever[0] = i;
                        lever[1] = j;
                    }

                    if(maps[i].charAt(j) =='E'){
                        exit[0] = i;
                        exit[1] = j;
                    }

                    if(maps[i].charAt(j) == 'S'){
                        start[0] = i;
                        start[1] = j;
                    }

                    board[i][j] = -1;
                }
            }

            q  = new ArrayDeque<>();
            visited = new boolean[maps.length][maps[0].length()];

            q.add(lever);
            visited[lever[0]][lever[1]] = true;
            board[lever[0]][lever[1]] = 0;

            while(!q.isEmpty()){
                int[] current = q.pop();
                int currentX = current[0];
                int currentY = current[1];
                int currentValue = board[currentX][currentY];

                for(int k =0 ; k<4 ; k++){
                    int nx = currentX + dx[k];
                    int ny = currentY + dy[k];

                    if(0<= nx && nx < maps.length && 0<= ny && ny< maps[0].length()){
                        if(maps[nx].charAt(ny) != 'X' && !visited[nx][ny]){
                            board[nx][ny] = currentValue+1;
                            int [] position = {nx,ny};
                            q.add(position);
                            visited[nx][ny] = true;
                        }
                    }
                }
            }

            if (board[start[0]][start[1]] != -1 && board[exit[0]][exit[1]] != -1) {
                answer = board[start[0]][start[1]] + board[exit[0]][exit[1]];
            }

            return answer;
        }

    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] maps1 = {"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"};
        String[] maps2 = {"LOOXS","OOOOX","OOOOO","OOOOO","EOOOO"};

        System.out.println(sol.solution(maps1));
        System.out.println(sol.solution(maps2));
    }

}
