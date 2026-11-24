
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

            int[] start = {m - 1, 0};
            q.add(start);

            visited[start[0]][start[1]][0] = true;

            while (!q.isEmpty()) {
                int[] current = q.poll();

                int x = current[0];
                int y = current[1];

                // 일반 이동
                for (int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];

                    if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                        continue;
                    }

                    if (isHole[nx][ny] || visited[nx][ny][0]) {
                        continue;
                    }

                    q.add(new int[]{nx, ny});
                    visited[nx][ny][0] = true;
                    map[nx][ny][0] = map[x][y][0] + 1;
                }

                // 신발을 아직 사용하지 않은 경우만 점프
                if (!visited[x][y][1]) {
                    for (int k = 0; k < 4; k++) {
                        int nx = x + jx[k];
                        int ny = y + jy[k];

                        if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                            continue;
                        }

                        if (isHole[nx][ny] || visited[nx][ny][1]) {
                            continue;
                        }

                        q.add(new int[]{nx, ny});
                        visited[nx][ny][1] = true;
                        map[nx][ny][1] = map[x][y][0] + 1;
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
