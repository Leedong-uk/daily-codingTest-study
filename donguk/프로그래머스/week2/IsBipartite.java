package donguk.프로그래머스.week2;

import java.util.ArrayDeque;
import java.util.HashMap;

public class IsBipartite {
    static class Solution{
        public boolean isBipartite(int[][] graph){
            boolean answer = true;
            ArrayDeque<Integer> q = new ArrayDeque<>();
            // 0: 미방문 , 1: Red, 2: Blue
            HashMap<Integer, Integer> map = new HashMap<>();

            for(int i=0 ; i<graph.length; i++){
                map.put(i, 0);
            }

            for(int i = 0 ; i<graph.length;i++){
                if(map.get(i) != 0 )
                    continue;

                q.add(i);
                map.put(i, 1);

                while(!q.isEmpty()){
                    int current = q.pop();
                    int currentColor = map.get(current);

                    for(int next : graph[current]){
                        if(map.get(next) == 0){
                            map.put(next,3-currentColor);
                            q.add(next);

                        }else{
                            if(map.get(next) == currentColor){
                                return false;
                            }
                        }
                    }
                }
            }


            return answer;
        }
    }


    public static void main (String[] args){
        Solution sol = new Solution();

        int[][] graph1 = {{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};
        int[][] graph2 = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};

        System.out.println(sol.isBipartite(graph1));
        System.out.println(sol.isBipartite(graph2));
    }
}
