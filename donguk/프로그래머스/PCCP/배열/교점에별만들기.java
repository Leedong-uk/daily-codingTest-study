
package donguk.프로그래머스.PCCP.배열;

import java.util.ArrayList;
import java.util.Arrays;

public class 교점에별만들기 {
    static class Solution {
        public String[] solution(int[][] line) {
            ArrayList<long[]> tmp = new ArrayList<>();

            long maxX = Long.MIN_VALUE;
            long maxY = Long.MIN_VALUE;
            long minX = Long.MAX_VALUE;
            long minY = Long.MAX_VALUE;

            for (int i = 0; i < line.length - 1; i++) {
                long A = line[i][0];
                long B = line[i][1];
                long E = line[i][2];

                for (int j = i + 1; j < line.length; j++) {
                    long C = line[j][0];
                    long D = line[j][1];
                    long F = line[j][2];

                    long denominator = A * D - B * C;

                    if (denominator == 0) {
                        continue;
                    }

                    long xNumerator = B * F - E * D;
                    long yNumerator = E * C - A * F;

                    if (xNumerator % denominator == 0
                            && yNumerator % denominator == 0) {

                        long x = xNumerator / denominator;
                        long y = yNumerator / denominator;

                        maxX = Math.max(x, maxX);
                        maxY = Math.max(y, maxY);
                        minX = Math.min(x, minX);
                        minY = Math.min(y, minY);

                        tmp.add(new long[]{x, y});
                    }
                }
            }

            int width = (int) (maxX - minX + 1);
            int height = (int) (maxY - minY + 1);

            char[][] map = new char[height][width];

            for (int i = 0; i < height; i++) {
                Arrays.fill(map[i], '.');
            }

            for (long[] t : tmp) {
                int x = (int) (t[0] - minX);
                int y = (int) (maxY - t[1]);

                map[y][x] = '*';
            }

            String[] answer = new String[height];

            for (int i = 0; i < height; i++) {
                answer[i] = new String(map[i]);
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] line1 = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};
        int[][] line2 = {{0, 1, -1}, {1, 0, -1}, {1, 0, 1}};
        int[][] line3 = {{1, -1, 0}, {2, -1, 0}};
        int[][] line4 = {{1, -1, 0}, {2, -1, 0}, {4, -1, 0}};

    }
}
