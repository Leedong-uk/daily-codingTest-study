package donguk.프로그래머스.week2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;

public class 열쇠및객실 {
    static class Solution{
        public boolean canVisitAllRooms (List<List<Integer>> rooms){
            boolean answer = true;
            ArrayDeque<Integer> q = new ArrayDeque<>();
            boolean[] visited = new boolean[rooms.size()];


            q.add(0);
            visited[0] = true;

            while (!q.isEmpty()) {
                int current = q.pop();

                for(int next : rooms.get(current)){
                    if(!visited[next]){
                        q.add(next);
                        visited[next] = true;
                    }
                }
            }

            for (int i = 0; i < visited.length; i++) {
                if(!visited[i])
                    return false;
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        List<List<Integer>> rooms1 = Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(2),
                Arrays.asList(3),
                Arrays.asList()
        );

        List<List<Integer>> rooms2 = Arrays.asList(
                Arrays.asList(1,3),
                Arrays.asList(3,0,1),
                Arrays.asList(2),
                Arrays.asList(0)
        );

        System.out.println(sol.canVisitAllRooms(rooms1));
        System.out.println(sol.canVisitAllRooms(rooms2));
    }
}
