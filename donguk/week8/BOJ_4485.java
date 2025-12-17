package donguk.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_4485 {
    static StringTokenizer sz;
    static int testNum = 1;
    static int N;
    static int[][] board;
    static int[] dx;
    static int[] dy;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            N = Integer.parseInt(br.readLine());
            if(N==0) break;

            board = new int[N][N];
            dx = new int[]{0, 0, 1, -1};
            dy = new int[]{1, -1, 0, 0};

            for (int i = 0; i < N; i++) {
                sz = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    int tmp = Integer.parseInt(sz.nextToken());
                    board[i][j] = tmp;
                }
            }

            int result = dijkstra();
            System.out.println("Problem "+testNum+": "+result);
            testNum++;
        }

    }

    static int dijkstra() {
        int [][] visited = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                visited[i][j] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        pq.offer(new int[]{0, 0, board[0][0]});
        visited[0][0] = board[0][0];

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int x = cur[0];
            int y = cur[1];
            int dist =  cur[2];

            if(dist>visited[x][y]) continue;

            for (int k = 0; k < 4; k++) {
                int nx = x +  dx[k];
                int ny = y +  dy[k];

                if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                    int totalDistance = board[nx][ny] + dist;

                    if(totalDistance < visited[nx][ny]) {
                        visited[nx][ny] = totalDistance;
                        pq.add(new int[]{nx, ny, totalDistance});
                    }
                }
            }
        }
        return visited[N-1][N-1];
    }

}
