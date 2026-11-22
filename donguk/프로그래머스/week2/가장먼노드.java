package donguk.프로그래머스.week2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class 가장먼노드 {
    static class Solution{
        public int solution(int n , int[][] edge){
            int answer = 0;
            boolean[] visited = new boolean[n];
            ArrayDeque<Integer> q = new ArrayDeque<>();
            HashMap<Integer, Integer> map = new HashMap<>();
            HashMap<Integer, ArrayList<Integer>> dic = new HashMap<>();

            for (int i = 0; i < n; i++) {
                map.put(i,0);
                dic.put(i, new ArrayList<>());
            }

            for(int[] e : edge){
                int from = e[0]-1;
                int to = e[1]-1;

                dic.get(from).add(to);
                dic.get(to).add(from);

            }

//            System.out.println("dic: "+dic);
//            System.out.println("map: "+map);

            q.add(0);
            visited[0] = true;


            while(!q.isEmpty()){
                int node = q.pop();
//                System.out.println("node: " + node);
                for(int next :dic.get(node)){
                    if(!visited[next]){
                        int newValue = map.get(node)+1;
                        map.put(next, newValue);
                        q.add(next);
                        visited[next] = true;
                    }
                }
            }

            int max = Collections.max(map.values());

            for(int value: map.values()){
                if(value==max){
                    answer++;
                }
            }
            return answer;
        }
    }

    public static void main (String[] args){
        Solution sol = new Solution();

        int n = 6;
        int[][] vertex = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        System.out.println(sol.solution(n,vertex));
    }
}
