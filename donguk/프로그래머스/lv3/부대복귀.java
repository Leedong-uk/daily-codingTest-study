package donguk.프로그래머스.lv3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;

public class 부대복귀 {
    static class Solution{
        public int[] solution(int n, int[][] roads , int[] sources, int destination) {
            int[] answer = new int[sources.length];
            HashMap<Integer, ArrayList<Integer>> route = new HashMap<>();

            for (int[] road : roads) {
                int x = road[0];
                int y = road[1];

                route.putIfAbsent(x, new ArrayList<>());
                route.putIfAbsent(y, new ArrayList<>());

                route.get(x).add(y);
                route.get(y).add(x);
            }

            int[] distance = new int[n + 1];
            Arrays.fill(distance, -1);

            Deque<Integer> dq = new ArrayDeque<>();

            distance[destination] = 0;
            dq.addLast(destination);

            while(!dq.isEmpty()){
                int current = dq.poll();

                for(int next: route.getOrDefault(current,new ArrayList<>())){
                    if (distance[next] != -1)
                        continue;
                    distance[next] = distance[current]+1;
                    dq.addLast(next);
                }
            }

            for (int i = 0; i < sources.length; i++) {
                answer[i] = distance[sources[i]];
            }

            return answer;
        }


        public static void main (String[] args){
            int n1 = 3;
            int[][] roads1 = {{1, 2}, {2, 3}};
            int[] sources1 = {2, 3};
            int destination1 = 1;

            int n2 = 5;
            int[][] roads2 = {{1, 2},{1,4},{2,4},{2,5},{4,5}};
            int[] sources2 = {1,3,5};
            int destination2 = 5;

            Solution sol = new Solution();
//            System.out.println(Arrays.toString(sol.solution(n1, roads1, sources1, destination1)));
            System.out.println(Arrays.toString(sol.solution(n2, roads2, sources2, destination2)));
        }
    }
}
