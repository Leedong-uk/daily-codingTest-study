package donguk.프로그래머스.lv3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class 여행경로 {
    static class Solution{
        String[] answer = {};
        HashMap<String, ArrayList<String[]>> dic;
        boolean[] visited ;
        ArrayList<String> tmp;

        public String[] solution(String[][] tickets) {

            dic = new HashMap<>();
            visited = new boolean[tickets.length];
            tmp = new ArrayList<>();

            for(int i = 0 ; i< tickets.length;i++){
                String[] ticket = tickets[i];

                String from = ticket[0];
                String to = ticket[1];

                dic.putIfAbsent(from, new ArrayList<>());
                dic.get(from).add(new String[]{to, String.valueOf(i)});
            }


            for (ArrayList<String[]> list : dic.values()) {
                Collections.sort(list, (a, b) -> a[0].compareTo(b[0]));
            }

            tmp.add("ICN");
            dfs("ICN", tickets);

            return answer;
        }


        public boolean dfs (String start,String[][]tickets){
            if(tmp.size() == tickets.length + 1){
                answer = tmp.toArray(new String[0]);
                return true;
            }

            if (!dic.containsKey(start)) {
                return false;
            }

            for(String[] node :dic.get(start)){
                String next = node[0];
                int idx = Integer.parseInt(node[1]);

                if(visited[idx])
                    continue;

                visited[idx] = true;
                tmp.add(next);

                if(dfs(next,tickets))
                    return true;

                visited[idx] = false;
                tmp.remove(tmp.size() - 1);
            }
            return false;
        }
    }

    public static void main (String[]args){
        String[][] tickets1 = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        String[][] tickets2 = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};

        Solution sol = new Solution();
//        System.out.println(Arrays.toString(sol.solution(tickets1)));
        System.out.println(Arrays.toString(sol.solution(tickets2)));
    }
}
