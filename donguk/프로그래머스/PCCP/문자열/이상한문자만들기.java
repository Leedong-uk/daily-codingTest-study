package donguk.프로그래머스.PCCP.문자열;

import java.util.ArrayList;
import java.util.Arrays;

public class 이상한문자만들기 {
    static class Solution{
        public String solution(String s){
            String answer = "";
            StringBuilder sb;
            String[] tmp = s.split(" ");
            ArrayList<String> result = new ArrayList<>();

            for(String t : tmp){
                sb = new StringBuilder();

                for(int i = 0 ; i<t.length();i++){
                    if(i%2 == 0){
                        char ch = t.charAt(i);
                        if(97<= ch && ch<= 122){
                            char newCh = (char) (ch - 32);
                            sb.append(newCh);
                        }else{
                            sb.append(t.charAt(i));
                        }
                    }else{
                        char ch = t.charAt(i);
                        if(65<= ch && ch<=90){
                            char newCh = (char) (ch + 32);
                            sb.append(newCh);
                        }else{
                            sb.append(t.charAt(i));
                        }
                    }

                }

                result.add(sb.toString());
            }
            answer = String.join(" ", result);

            return answer;
        }
    }

    public static void main(String[] args){
        Solution sol = new Solution();

        String s = "try hello world";

        System.out.println(sol.solution(s));
    }
}
