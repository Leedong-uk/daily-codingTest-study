package donguk.week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_14502 {

    static int N, M;
    static int[][] board;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sz = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(sz.nextToken());
        M = Integer.parseInt(sz.nextToken());

        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        makeWall(0);
        System.out.println(answer);
    }

    // 3개 벽을 세우기
    static void makeWall(int wallCnt) {
        if (wallCnt == 3) {
            checkSafeArea();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 0) {
                    board[i][j] = 1;
                    makeWall(wallCnt + 1);
                    board[i][j] = 0;
                }
            }
        }
    }

    //안전영역
    static void checkSafeArea() {
        int[][] newBoard = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                newBoard[i][j] = board[i][j];
            }
        }

        bfs(newBoard);

        int safe = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (newBoard[i][j] == 0) safe++;
            }
        }

        answer = Math.max(answer, safe);
    }

    // 바이러스 BFS
    static void bfs(int[][] newBoard) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        Deque<int[]> queue = new ArrayDeque<>();


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (newBoard[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                    if (newBoard[nx][ny] == 0) {
                        newBoard[nx][ny] = 2;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
