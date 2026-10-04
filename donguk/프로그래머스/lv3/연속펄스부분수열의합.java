package donguk.프로그래머스.lv3;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class 연속펄스부분수열의합 {
    static class Solution {
        int[] pulse;
        PriorityQueue<Integer> result;
        ArrayList<Integer> tmp;

        public long solution(int[] sequence) {
            pulse = new int[500000];
            result = new PriorityQueue<>((a, b) -> b - a);
            tmp = new ArrayList<>();

            long answer = 0;

            for (int i = 0; i < 500000; i++) {
                if (i % 2 == 0)
                    pulse[i] = 1;
                else
                    pulse[i] = -1;
            }

            dfs(0,sequence,tmp);

            return result.poll();
        }

        public void dfs(int cnt , int[]sequence,ArrayList<Integer> tmp){
            if (cnt == sequence.length){
                int x = 0;

                for (int i = 0; i < tmp.size(); i++) {
                    x += (tmp.get(i) * pulse[i]);
                }

                result.add(x);
                return;
            }

            tmp.add(sequence[cnt]);
            dfs(cnt+1,sequence,tmp);
            tmp.remove(tmp.size() - 1);

            dfs(cnt+1,sequence,tmp);

        }

    }

    public static void main(String[] args) {
        int[] sequence = {2, 3, -6, 1, 3, -1, 2, 4};

        Solution sol = new Solution();
        System.out.println(sol.solution(sequence));
    }
}
