package jeemin.week02;
import java.util.*;

public class PG_블록이동하기 {
    public int solution(int[][] board) {
        int answer = 0;
        int n = board.length;
        int[] dest = new int[]{n - 1, n - 1};

        Queue<int[]> q = new LinkedList<>();
        // 첫 번째 좌표, 두 번째 좌표, 가로세로(0, 1), 시간
        q.offer(new int[]{0, 0, 0, 1, 0, 0});

        boolean[][][][] visited = new boolean[n][n][n][n];

        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};

        while(!q.isEmpty()) {
            int[] now = q.poll();
            int[] loc1 = new int[]{now[0], now[1]};
            int[] loc2 = new int[]{now[2], now[3]};
            int wl = now[4];
            int time = now[5];

            // 목적지 도착한 경우
            if (Arrays.equals(loc1, dest) || Arrays.equals(loc2, dest)) {
                return time;
            }

            // 상하좌우 이동
            for (int i = 0; i < 4; i++) {
                int x1 = loc1[0] + dx[i];
                int y1 = loc1[1] + dy[i];
                int x2 = loc2[0] + dx[i];
                int y2 = loc2[1] + dy[i];

                if (inRange(x1, y1, n) && inRange(x2, y2, n) && board[x1][y1] == 0 && board[x2][y2] == 0 && !visited[x1][y1][x2][y2]) {
                    q.offer(new int[]{x1, y1, x2, y2, wl, time + 1});
                    visited[x1][y1][x2][y2] = true;
                    visited[x2][y2][x1][y1] = true;
                }
            }

            // 가로일때 회전
            if (wl == 0) {
                // 위로 회전
                if (loc1[0] > 0 && board[loc1[0] - 1][loc1[1]] == 0 && board[loc2[0] - 1][loc2[1]] == 0) {
                    if (!visited[loc1[0] - 1][loc1[1]][loc1[0]][loc1[1]]) {
                        q.offer(new int[]{loc1[0] - 1, loc1[1], loc1[0], loc1[1], 1, time + 1});
                        visited[loc1[0] - 1][loc1[1]][loc1[0]][loc1[1]] = true;
                        visited[loc1[0]][loc1[1]][loc1[0] - 1][loc1[1]] = true;
                    }
                    if (!visited[loc2[0] - 1][loc2[1]][loc2[0]][loc2[1]]) {
                        q.offer(new int[]{loc2[0] - 1, loc2[1], loc2[0], loc2[1], 1, time + 1});
                        visited[loc2[0] - 1][loc2[1]][loc2[0]][loc2[1]] = true;
                        visited[loc2[0]][loc2[1]][loc2[0] - 1][loc2[1]] = true;
                    }
                }
                // 아래로 회전
                if (loc1[0] < n - 1 && board[loc1[0] + 1][loc1[1]] == 0 && board[loc2[0] + 1][loc2[1]] == 0) {
                    if (!visited[loc1[0]][loc1[1]][loc1[0] + 1][loc1[1]]) {
                        q.offer(new int[]{loc1[0], loc1[1], loc1[0] + 1, loc1[1], 1, time + 1});
                        visited[loc1[0]][loc1[1]][loc1[0] + 1][loc1[1]] = true;
                        visited[loc1[0] + 1][loc1[1]][loc1[0]][loc1[1]] = true;
                    }
                    if (!visited[loc2[0]][loc2[1]][loc2[0] + 1][loc2[1]]) {
                        q.offer(new int[]{loc2[0], loc2[1], loc2[0] + 1, loc2[1], 1, time + 1});
                        visited[loc2[0]][loc2[1]][loc2[0] + 1][loc2[0]] = true;
                        visited[loc2[0] + 1][loc2[0]][loc2[0]][loc2[1]] = true;
                    }
                }
            }
            // 세로일때 회전
            else {
                // 왼쪽으로 회전
                if (loc1[1] > 0 && board[loc1[0]][loc1[1] - 1] == 0 && board[loc2[0]][loc2[1] - 1] == 0) {
                    if (!visited[loc1[0]][loc1[1] - 1][loc1[0]][loc1[1]]) {
                        q.offer(new int[]{loc1[0], loc1[1] - 1, loc1[0], loc1[1], 0, time + 1});
                        visited[loc1[0]][loc1[1] - 1][loc1[0]][loc1[1]] = true;
                        visited[loc1[0]][loc1[1]][loc1[0]][loc1[1] - 1] = true;
                    }
                    if (!visited[loc2[0]][loc2[1] - 1][loc2[0]][loc2[1]]) {
                        q.offer(new int[]{loc2[0], loc2[1] - 1, loc2[0], loc2[1], 0, time + 1});
                        visited[loc2[0]][loc2[1] - 1][loc2[0]][loc2[1]] = true;
                        visited[loc2[0]][loc2[1]][loc2[0]][loc2[1] - 1] = true;
                    }
                }
                // 오른쪽으로 회전
                if (loc1[1] < n - 1 && board[loc1[0]][loc1[1] + 1] == 0 && board[loc2[0]][loc2[1] + 1] == 0) {
                    if (!visited[loc1[0]][loc1[1]][loc1[0]][loc1[1] + 1]) {
                        q.offer(new int[]{loc1[0], loc1[1], loc1[0], loc1[1] + 1, 0, time + 1});
                        visited[loc1[0]][loc1[1]][loc1[0]][loc1[1] + 1] = true;
                        visited[loc1[0]][loc1[1] + 1][loc1[0]][loc1[1]] = true;
                    }
                    if (!visited[loc2[0]][loc2[1] + 1][loc2[0]][loc2[1]]) {
                        q.offer(new int[]{loc2[0], loc2[1], loc2[0], loc2[1] + 1, 0, time + 1});
                        visited[loc2[0]][loc2[1] + 1][loc2[0]][loc2[1]] = true;
                        visited[loc2[0]][loc2[1]][loc2[0]][loc2[1] + 1] = true;
                    }
                }
            }
        }

        return -1;
    }

    static boolean inRange(int x, int y, int n) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}
