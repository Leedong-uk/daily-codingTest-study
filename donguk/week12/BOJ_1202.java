package donguk.week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1202 {
    static StringTokenizer sz;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        sz = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(sz.nextToken());
        int K = Integer.parseInt(sz.nextToken());
        long result = 0;

        // 무게 , 가치 , (보석:0 가방:1)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {

            if (a[0] != b[0]) return a[0] - b[0];
            if (a[2] != b[2]) return a[2] - b[2];
            return a[1] - b[1];
        });

        for (int i = 0; i < N; i++) {
            sz = new StringTokenizer(bf.readLine());
            int M = Integer.parseInt(sz.nextToken());
            int V = Integer.parseInt(sz.nextToken());
            pq.add(new int[]{M, V, 0});
        }

        for (int i = 0; i < K; i++) {
            int B = Integer.parseInt(bf.readLine());
            pq.add(new int[]{B, 0, 1});
        }

        PriorityQueue<Integer> candidate = new PriorityQueue<>((a, b) -> b - a);


        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (cur[2] == 0) {
                candidate.add(cur[1]);
            } else {
                if(!candidate.isEmpty()) result += candidate.poll();
            }
        }

        System.out.println(result);
    }
}
