package donguk.프로그래머스.week3;

import java.util.ArrayDeque;

public class 응급차최단거리2 {
    static class Solution {
        public int solution(int[][] city) {

            int answer = -1;
            int n = city.length;
            int m = city[0].length;
            int[] dx = {0, 0, 1, -1, 1, 1, -1, -1};
            int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};

            boolean[][] visited = new boolean[n][m];
            ArrayDeque<int[]> q = new ArrayDeque<>();
            int[][] map = new int[n][m];

            if(city[0][0]==1)
                return answer;

            int[] position = {0, 0};

            map[0][0] = 1;
            q.add(position);
            visited[0][0] = true;

            while(!q.isEmpty()){
                int[] current = q.pop();
                int currentX = current[0];
                int currentY = current[1];
                int currentValue = map[currentX][currentY];

                for(int k =0 ; k<8; k++){
                    int nx = currentX + dx[k];
                    int ny = currentY + dy[k];

                    if(0<= nx && nx < n && 0<= ny && ny < m){
                        if(city[nx][ny]== 0 && !visited[nx][ny]){
                            int[] newPosition = {nx, ny};
                            map[nx][ny] = currentValue + 1;
                            q.add(newPosition);
                            visited[nx][ny] = true;
                        }
                    }
                }

            }

            if (map[n - 1][m - 1] != 0) {
                answer = map[n - 1][m - 1];
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] city1 = {{0,0,1,0},{1,0,1,0},{1,0,0,0}};
        int[][] city2 = {{0,1,0},{0,1,0},{0,0,0},{1,1,0},{0,0,0}};
        int[][] city3 = {{0,0,0,0},{1,1,1,0},{1,0,0,0},{1,1,1,1}};
        int[][] city4 = {{1,0,0,0},{1,1,1,0},{1,0,0,0},{1,1,1,0}};

        System.out.println(sol.solution(city1));
        System.out.println(sol.solution(city2));
        System.out.println(sol.solution(city3));
        System.out.println(sol.solution(city4));

    }

}
