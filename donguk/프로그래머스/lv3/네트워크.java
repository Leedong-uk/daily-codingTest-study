package donguk.프로그래머스.lv3;
public class 네트워크 {
    static class Solution {
        public int solution(int n, int[][] computers) {
            int answer = 0;
            boolean[] visited = new boolean[n];

            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    dfs(i, computers, visited);
                    answer++;
                }
            }

            return answer;
        }

        public void dfs(int me, int[][] computers, boolean[] visited) {
            visited[me] = true;

            for (int node = 0; node < computers[me].length; node++) {
                if (computers[me][node] == 1 && !visited[node]) {
                    dfs(node, computers, visited);
                }
            }

            return;
        }
    }

    public static void main(String[] args){
        int n =3;
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

        Solution sol = new Solution();
        System.out.println(sol.solution(n, computers));
    }
}
