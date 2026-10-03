package donguk.프로그래머스.lv3;

import java.util.HashSet;
import java.util.Set;

public class 불량사용자 {
    static class Solution{
        public int solution(String[] user_id,String[] banned_id){
            int answer = 0;
            boolean[] visited = new boolean[user_id.length];
            Set<Set<Integer>> result = new HashSet<>();
            dfs(0, banned_id , user_id,visited,result);
            answer = result.size();
            return answer;
        }

        public void dfs(int cnt, String[] banned_id,String[] user_id,boolean[] visited,Set<Set<Integer>> result ) {
            if (cnt == banned_id.length) {
                Set<Integer> set = new HashSet<>();

                for (int i = 0; i < visited.length; i++) {
                    if (visited[i]) {
                        set.add(i);
                    }
                }
                result.add(set);
                return;
            }

            for (int i = 0; i < user_id.length; i++) {
                if (user_id[i].length() != banned_id[cnt].length())
                    continue;
                if(visited[i])
                    continue;

                boolean check = true;
                for (int j = 0 ; j<banned_id[cnt].length(); j++){
                    if (banned_id[cnt].charAt(j) != '*' && banned_id[cnt].charAt(j) != user_id[i].charAt(j)) {
                        check = false;
                    }
                }

                if (check) {
                    visited[i] = true;
                    dfs(cnt + 1, banned_id, user_id, visited,result);
                    visited[i] = false;
                }
            }

        }

    }

    public static void main(String[] args) {
        String[] user_id1 = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id1 = {"fr*d*", "abc1**"};

        String[] user_id2 = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id2 = {"*rodo", "*rodo", "******"};

        String[] user_id3 = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id3 = {"fr*d*", "*rodo", "******", "******"};

        Solution sol = new Solution();
        System.out.println(sol.solution(user_id1, banned_id1));
        System.out.println(sol.solution(user_id2, banned_id2));
        System.out.println(sol.solution(user_id3, banned_id3));

    }
}
