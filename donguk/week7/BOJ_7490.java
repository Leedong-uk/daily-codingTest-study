package donguk.week7;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_7490 {
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            M = Integer.parseInt(br.readLine());
            bfs(1, "1");

            if (i < N - 1) System.out.println();
        }
    }

    private static void bfs(int cnt, String str) {
        if (cnt == M) {
            if (calculate(str) == 0) {
                System.out.println(str);
            }
            return;
        }

        int next = cnt + 1;

        bfs(next, str + " " + next);
        bfs(next, str + "+" + next);
        bfs(next, str + "-" + next);
    }

    private static int calculate(String str) {
        str = str.replace(" ", "");

        int sum = 0;
        int num = 0;
        int flag = 1;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (Character.isDigit(c)) {

                num = num * 10 + (c - '0');
            } else {

                sum += flag * num;
                num = 0;

                if (c == '+') flag = 1;
                else if (c == '-') flag = -1;
            }
        }

        sum += flag * num;
        return sum;
    }
}

