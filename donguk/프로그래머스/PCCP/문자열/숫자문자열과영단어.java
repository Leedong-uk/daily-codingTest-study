package donguk.프로그래머스.PCCP.문자열;

import java.util.HashMap;

public class 숫자문자열과영단어 {
    static class Solution{
        public int solution(String s){
            int answer = 0;
            StringBuilder result = new StringBuilder();
            StringBuilder tmp = new StringBuilder();
            HashMap<String, Integer> dic = new HashMap<>();

            dic.put("zero", 0);
            dic.put("one", 1);
            dic.put("two", 2);
            dic.put("three", 3);
            dic.put("four", 4);
            dic.put("five", 5);
            dic.put("six", 6);
            dic.put("seven", 7);
            dic.put("eight", 8);
            dic.put("nine", 9);

            for(int i = 0 ; i< s.length();i++){
                char c = s.charAt(i);

                if ('0' <= c && c <= '9') {
                    result.append(c);
                    continue;
                }

                tmp.append(c);

                if (dic.keySet().contains(tmp.toString())) {
                    result.append(dic.get(tmp.toString()));
                    tmp = new StringBuilder();
                }
            }
            answer = Integer.parseInt(result.toString());
            return answer;
        }
    }

    public static void main(String[] args){
        Solution sol = new Solution();

        String s1 = "one4seveneight";
        String s2 = "23four5six7";
        String s3 = "2three45sixseven";
        String s4 = "123";

        System.out.println(sol.solution(s1));
        System.out.println(sol.solution(s2));
        System.out.println(sol.solution(s3));
        System.out.println(sol.solution(s4));


    }
}
