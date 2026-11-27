package donguk.프로그래머스.PCCP.문자열;

public class 문자열다루기기본 {
    static class Solution{
        public boolean solution(String s){
            boolean answer = true;


            for(int i=0; i<s.length(); i++){
                char ch = s.charAt(i);
                int diff = ch - '0';

                if(diff <0 || diff>9){
                    return false;
                }

            }


            return answer;
        }
    }

    public static void main(String[] args){
        Solution sol = new Solution();

        String s1 = "a234";
        String s2 = "1234";

        System.out.println(sol.solution(s1));
        System.out.println(sol.solution(s2));
    }
}
