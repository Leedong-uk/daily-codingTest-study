
package donguk.프로그래머스.PCCP.배열;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class 거리두기확인하기 {
    static class Solution {
        public int[] solution(String[][] places) {
            int[] answer = new int[places.length];

            int[] dx = {0, 0, 1, -1};
            int[] dy = {1, -1, 0, 0};

            int[][] map;
            boolean[][] visited;
            ArrayDeque<int[]> q;
            ArrayList<int[]> start;
            ArrayList<Integer> tmp = new ArrayList<>();

            for (String[] place : places) {
                start = new ArrayList<>();
                boolean flag = false;

                for (int i = 0; i < place.length; i++) {
                    for (int j = 0; j < place[i].length(); j++) {
                        if (place[i].charAt(j) == 'P') {
                            start.add(new int[]{i, j});
                        }
                    }
                }

                for (int[] s : start) {

                    q = new ArrayDeque<>();
                    visited = new boolean[place.length][place[0].length()];
                    map = new int[place.length][place[0].length()];

                    q.add(s);
                    visited[s[0]][s[1]] = true;

                    while (!q.isEmpty()) {
                        int[] current = q.pop();
                        int x = current[0];
                        int y = current[1];
                        int currentValue = map[x][y];

                        if (currentValue + 1 > 2)
                            continue;

                        for (int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];

                            if (0 <= nx && nx < place.length &&
                                    0 <= ny && ny < place[0].length()) {

                                if (!visited[nx][ny] && place[nx].charAt(ny) != 'X') {

                                    if (place[nx].charAt(ny) == 'P') {
                                        flag = true;
                                        break;
                                    }

                                    q.add(new int[]{nx, ny});
                                    visited[nx][ny] = true;
                                    map[nx][ny] = currentValue + 1;
                                }
                            }
                        }

                        if (flag)
                            break;
                    }

                    if (flag)
                        break;
                }

                tmp.add(flag ? 0 : 1);
            }

            for (int i = 0; i < answer.length; i++) {
                answer[i] = tmp.get(i);
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
