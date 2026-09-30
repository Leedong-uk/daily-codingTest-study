package donguk.프로그래머스.lv2;

import java.util.ArrayList;

public class JadenCase문자열만들기 {
    static class Solution{
        public String solution(String s){
            StringBuilder answer = new StringBuilder();
            boolean first = true;

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if(c == ' '){
                    answer.append(c);
                    first = true;
                }else {
                    if (first){
                        answer.append(Character.toUpperCase(c));
                        first= false;
                    }else{
                        answer.append(Character.toLowerCase(c));
                    }
                }
            }
            return answer.toString();
        }
    }

    public static void main(String[] args) {
        String s1 = "3people unFollowed me";
        String s2 = "for the last week";

        Solution sol = new Solution();

        System.out.println(sol.solution(s1));
        System.out.println(sol.solution(s2));
    }
}
