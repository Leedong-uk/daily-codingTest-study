package donguk.프로그래머스.week2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;

public class 네트워크 {
    static class Solution{
        public int solution(int n , int[][] computers) {
            int answer = 0;
            ArrayDeque<Integer> q = new ArrayDeque<>();
            boolean[] visited = new boolean[computers.length];
            HashMap<Integer, ArrayList<Integer>> dic = new HashMap<>();

            for(int i = 0 ; i<computers.length; i++){
                dic.put(i, new ArrayList<>());
            }

            for (int i = 0; i < computers.length; i++) {
                for (int j = 0; j < computers[i].length; j++) {

                    if (i == j) {
                        continue;
                    }

                    if (computers[i][j] == 1) {
                        dic.get(i).add(j);
                    }
                }
            }

            for (int i = 0; i < computers.length; i++) {
                if(!visited[i]){
                    q.add(i);
                    visited[i] = true;

                    while (!q.isEmpty()) {
                        int node = q.pop();

                        for (int next : dic.get(node)) {
                            if(!visited[next]){
                                q.add(next);
                                visited[next] = true;
                            }
                        }
                    }

                    answer++;
                }

            }


            return answer;
        }
    }

    public static void main(String[] args){
        Solution sol = new Solution();

        int n1 = 3;
        int[][] computers1 = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

        int n2 = 3;
        int[][] computers2 = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};

        System.out.println(sol.solution(n1, computers1));
        System.out.println(sol.solution(n2, computers2));
    }
}
