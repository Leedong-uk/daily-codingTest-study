package donguk.week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15683 {
    static int[][][] dirs;
    static int cctvCount ;
    static int[] dx = {-1, 0, 1, 0}; // 상, 우, 하, 좌
    static int[] dy = {0, 1, 0, -1};
    static StringTokenizer sz;
    static ArrayList<int[]> cctvList;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sz = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(sz.nextToken());
        int M = Integer.parseInt(sz.nextToken());
        int[][] board = new int[N][M];
        answer = Integer.MAX_VALUE;
        // 상, 우, 하, 좌 (0,1,2,3)
        dirs = new int[][][]{
                {},                                   // 0번 인덱스 맞추는 용
                {{0},{1},{2},{3}},                    // 1번
                {{0,2},{1,3}},                        // 2번
                {{0,1},{1,2},{2,3},{3,0}},            // 3번
                {{0,1,2},{1,2,3},{2,3,0},{3,0,1}},    // 4번
                {{0,1,2,3}}                           // 5번
        };


        cctvList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            sz = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int tmp = Integer.parseInt(sz.nextToken());
                board[i][j] = tmp;
                if (tmp >= 1 && tmp <= 5) {
                    cctvList.add(new int[]{i, j, tmp});
                }
            }
        }

        cctvCount = cctvList.size();

//        System.out.println(Arrays.deepToString(board));

        dfs(0, board);
        System.out.println(answer);


    }
    static void dfs(int cnt , int[][] board) {

        if (cnt == cctvCount) {
            answer = Math.min(answer, calculate(board));
            return;
        }

        int[] cctv = cctvList.get(cnt);

        for (int[] rotates : dirs[cctv[2]]) {

            int[][] copy = new int[board.length][board[0].length];
            for (int i = 0; i < board.length; i++) {
                copy[i] = board[i].clone();
            }


            for (int rotate : rotates) {
                calCctv(copy, rotate, cctv[0], cctv[1]);
            }

            dfs(cnt + 1, copy);
        }
    }

    static void calCctv(int[][] board , int dir , int x , int y) {
        int nx = x + dx[dir];
        int ny = y + dy[dir];

        while (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length) {
            if (board[nx][ny] == 6) break;
            if (board[nx][ny] == 0) {
                board[nx][ny] = -1;
            }
            nx += dx[dir];
            ny += dy[dir];
        }
    }

    static int calculate(int[][] board) {
        int cnt = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0) cnt++;
            }
        }
        return cnt;
    }

}
