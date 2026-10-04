package donguk.프로그래머스.lv3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;

public class 여행경로 {
    static class Solution{
        public String[] solution(String[][] tickets) {
            String[] answer = {};
            Deque<String> dq = new ArrayDeque<>();
            HashMap<String, ArrayList<String>> dic = new HashMap<>();

            for(String[] ticket : tickets){
                String from = ticket[0];
                String to = ticket[1];
                dic.putIfAbsent(from, new ArrayList<>());
                dic.get(from).add(to);
            }

            return answer;
        }

        public boolean dfs(int cnt , String[][] tickets){
            if(cnt == tickets.length){
                //여기서 결과 담고
                return true ;
            }
            // 가능한 항공권 선택
            // visited로 백트래킹

            return false;
        }
    }

    public static void main (String[]args){
        String[][] tickets1 = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        String[][] tickets2 = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};

        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(tickets1)));
        System.out.println(Arrays.toString(sol.solution(tickets2)));
    }
}
