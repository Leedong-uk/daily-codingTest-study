package donguk.프로그래머스.lv3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;

public class 가장먼노드 {
    static class Solution{

        HashMap<Integer, ArrayList<Integer>> route;
        boolean[] visited;
        int[] map ;
        Deque<Integer> dq;

        public int solution(int n , int[][] edge){
            int answer = 0;
            visited = new boolean[n + 1];
            route = new HashMap<>();
            map = new int[n + 1];
            dq = new ArrayDeque<>();

            for (int[] node : edge){
                int from = node[0];
                int to = node[1];

                route.putIfAbsent(from, new ArrayList<>());
                route.putIfAbsent(to, new ArrayList<>());
                route.get(from).add(to);
                route.get(to).add(from);
            }

            visited[0] = true;
            visited[1] = true;
            map[1] = 0;
            dq.addLast(1);
            int maxValue = 0;

            while(!dq.isEmpty()){
                int current = dq.poll();

                for(int next : route.get(current)){
                    if(visited[next])
                        continue;
                    map[next] = map[current] + 1;
                    visited[next] = true;
                    dq.addLast(next);
                    maxValue = Math.max(map[next], maxValue);
                }
            }


            for(int x : map){
                if (x == maxValue)
                    answer++;

            }

            return answer;
        }


    }

    public static void main(String args[]){
        int n =6;
        int[][] vertex = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};

        Solution sol = new Solution();
        System.out.println(sol.solution(n, vertex));
    }
}
