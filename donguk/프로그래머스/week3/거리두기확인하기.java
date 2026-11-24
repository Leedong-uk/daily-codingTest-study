
package donguk.프로그래머스.week3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class 거리두기확인하기 {
    static class Solution {
        public int[] solution(String[][] places) {
            int[] answer = new int[places.length];

            ArrayDeque<int[]> q;
            boolean[][] visited;
            ArrayList<int[]> startPosition;
            int[][] map;

            int[] dx = {0, 0, 1, -1};
            int[] dy = {1, -1, 0, 0};

            for (int idx = 0; idx < places.length; idx++) {
                String[] place = places[idx];
                boolean stop = false;

                startPosition = new ArrayList<>();

                // 모든 P의 위치 수집
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        if (place[i].charAt(j) == 'P') {
                            startPosition.add(new int[]{i, j});
                        }
                    }
                }

                // 각 P를 시작점으로 BFS
                for (int[] p : startPosition) {
                    q = new ArrayDeque<>();
                    visited = new boolean[5][5];
                    map = new int[5][5];

                    q.add(p);
                    visited[p[0]][p[1]] = true;

                    while (!q.isEmpty()) {
                        int[] current = q.poll();

                        int currentX = current[0];
                        int currentY = current[1];
                        int currentValue = map[currentX][currentY];

                        for (int k = 0; k < 4; k++) {
                            int nx = currentX + dx[k];
                            int ny = currentY + dy[k];

                            if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5) {
                                continue;
                            }

                            if (visited[nx][ny] || place[nx].charAt(ny) == 'X') {
                                continue;
                            }

                            if (currentValue + 1 > 2) {
                                continue;
                            }

                            if (place[nx].charAt(ny) == 'P') {
                                stop = true;
                                break;
                            }

                            q.add(new int[]{nx, ny});
                            visited[nx][ny] = true;
                            map[nx][ny] = currentValue + 1;
                        }

                        if (stop) {
                            break;
                        }
                    }

                    if (stop) {
                        break;
                    }
                }

                answer[idx] = stop ? 0 : 1;
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String[][] places = {
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        };

        System.out.println(Arrays.toString(sol.solution(places)));
    }
}
