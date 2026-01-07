package donguk.week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_22866 {
    static Stack<Integer> Lstack;
    static Stack<Integer> Rstack;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer sz = new StringTokenizer(bf.readLine());

        int[] numbers = new int[N];
        ArrayList<Integer>[] indexes = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            indexes[i] = new ArrayList<>();
            int number = Integer.parseInt(sz.nextToken());
            numbers[i] = number;
        }

        Stack<Integer> stack = new Stack<>();
        //왼쪽->오른쪽
        for (int i = 0; i < N; i++) {
            while(!stack.isEmpty())
        }

        //오른쪽 -> 왼쪽


    }
}
