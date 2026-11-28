package donguk.프로그래머스.PCCP.재귀;

public class 모음사전 {
    static class Solution{
        static int answer;
        public int solution(String word){
            answer = 0;
            String[] dic = {"A", "E", "I", "O", "U"};
            StringBuilder current = new StringBuilder();
            find("", word, 0, dic);
            return answer;
        }

        public void find(String current, String target, int cnt,String[] dic){

            if (current.equals(target)) {
                answer = cnt;
                return;
            }

            if(current.length()==5)
                return;


            for(int i = 0; i<dic.length;i++){
                cnt++;
                find(current+dic[i],target,cnt,dic);
            }

        }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        String word1 = "AAAAE";
        String word2 = "AAAE";
        String word3 = "I";
        String word4 = "EIO";

        System.out.println(sol.solution(word1));
        System.out.println(sol.solution(word2));
        System.out.println(sol.solution(word3));
        System.out.println(sol.solution(word4));

    }
}

