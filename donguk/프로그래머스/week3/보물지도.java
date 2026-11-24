
package donguk.프로그래머스.week3;

import java.util.ArrayDeque;

public class 보물지도 {
    static class Solution {
        public int solution(int n, int m, int[][] hole) {
            int[][][] map = new int[m][n][2];
            boolean[][][] visited = new boolean[m][n][2];
            boolean[][] isHole = new boolean[m][n];

            ArrayDeque<int[]> q = new ArrayDeque<>();

            int[] dx = {0, 0, 1, -1};
            int[] dy = {1, -1, 0, 0};

            int[] jx = {0, 0, 2, -2};
            int[] jy = {2, -2, 0, 0};

            for (int[] h : hole) {
                isHole[m - h[1]][h[0] - 1] = true;
            }

            int[] start = {m - 1, 0, 0};
            q.add(start);
            visited[start[0]][start[1]][start[2]] = true;

//            visited[x][y][0] -> 신발을 사용하지 않고 도착 했나?
//            visited[x][y][1] -> 신발을 사용하고 도착 했나?
            /**
             * [0] → [0]: 일반 이동
             * [0] → [1]: 신발 점프
             * [1] → [1]: 일반 이동
             * [1] → [0]: 불가능
             */

            while (!q.isEmpty()) {
                int[] current = q.poll();

                int x = current[0];
                int y = current[1];
                int z = current[2];

//                일반 이동
                for(int k = 0 ; k<4; k++){
                    int nx = dx[k] + x;
                    int ny = dy[k] + y;

                    if(0<= nx && nx<m && 0<= ny && ny<n){
                        if(!isHole[nx][ny] && !visited[nx][ny][z]){
                            visited[nx][ny][z] = true;
                            map[nx][ny][z] = map[x][y][z] +1 ;
                            int[] newPos = {nx, ny,z};
                            q.add(newPos);
                        }
                    }
                }

//                신발을 사용하고 도착하기
                for(int k = 0; k<4; k++){
                    int nx = jx[k]+x;
                    int ny = jy[k]+y;

                    if(0<= nx && nx<m && 0<= ny && ny<n){
                        if(z==0 &&!isHole[nx][ny] && !visited[nx][ny][1]){
                            visited[nx][ny][1] = true;
                            map[nx][ny][1] = map[x][y][0] +1 ;
                            int[] newPos = {nx, ny,1};
                            q.add(newPos);
                        }
                    }
                }

            }

            int endX = 0;
            int endY = n - 1;

            int normal = visited[endX][endY][0]
                    ? map[endX][endY][0] : Integer.MAX_VALUE;

            int jump = visited[endX][endY][1]
                    ? map[endX][endY][1] : Integer.MAX_VALUE;

            int answer = Math.min(normal, jump);

            return answer == Integer.MAX_VALUE ? -1 : answer;
        }
    }
}
