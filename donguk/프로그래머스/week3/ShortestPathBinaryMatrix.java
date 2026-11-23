package donguk.프로그래머스.week3;

import java.util.ArrayDeque;

public class ShortestPathBinaryMatrix {
    static class Solution {
        public int shortestPathBinaryMatrix(int[][] grid) {
            int answer = -1;
            int n = grid.length;
            int m = grid[0].length;

            if (grid[0][0] == 1 || grid[n - 1][m - 1] == 1) {
                return -1;
            }

            int[] dx = {0, 0, 1, -1, 1, 1, -1, -1};
            int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};

            ArrayDeque<int[]> q = new ArrayDeque<>();
            boolean[][] visited = new boolean[n][m];
            int[][] map = new int[n][m];

            int[] position = {0, 0};
            visited[0][0] = true;
            map[0][0] = 1;
            q.add(position);

            while (!q.isEmpty()) {
                int[] current = q.poll();
                int currentX = current[0];
                int currentY = current[1];
                int currentValue = map[currentX][currentY];

                for (int k = 0; k < 8; k++) {
                    int nx = currentX + dx[k];
                    int ny = currentY + dy[k];

                    if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                        if (grid[nx][ny] == 0 && !visited[nx][ny]) {
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

        int[][] grid1 = {{0, 1}, {1, 0}};
        int[][] grid2 = {{0, 0, 0}, {1, 1, 0}, {1, 1, 0}};
        int[][] grid3 = {{1, 0, 0}, {1, 1, 0}, {1, 1, 0}};

        System.out.println(sol.shortestPathBinaryMatrix(grid1)); // 2
        System.out.println(sol.shortestPathBinaryMatrix(grid2)); // 4
        System.out.println(sol.shortestPathBinaryMatrix(grid3)); // -1
    }
}