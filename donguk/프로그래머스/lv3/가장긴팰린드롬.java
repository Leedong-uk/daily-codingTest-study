package donguk.프로그래머스.lv3;

public class 가장긴팰린드롬 {
    static class Solution{
        int answer;
        public int solution(String s){
            answer = 0;
            for(int i = 0; i<s.length();i++){
                int tmp = Math.max(oddCheck(s, i), evenCheck(s, i));
                answer = Math.max(tmp, answer);
            }
            return answer;
        }

        public int oddCheck(String s, int start) {
            int result = 1;
            int left = start -1;
            int right = start +1;

            while(left>=0 && right < s.length()){
                if(s.charAt(left) == s.charAt(right)){
                    result +=2;
                    left--;
                    right++;
                }else{
                    break;
                }
            }
            return result;
        }

        public int evenCheck(String s, int start){
            int result = 2;
            if (start-1 < 0 )
                return 0;
            if(s.charAt(start) != s.charAt(start-1))
                return 0;

            int leftCenter = start-1;
            int rightCenter = start;

            int left = leftCenter-1;
            int right = rightCenter+1;

            while(left>= 0 && right <s.length()){
                if (s.charAt(left) == s.charAt(right)) {
                    result+=2;
                    left--;
                    right ++;
                }
                else{
                    break;
                }
            }
            return result;
        }

        public static void main(String[] args){
            String s1 = "abcdcba";
            String s2 = "abacde";

            Solution sol = new Solution();

            System.out.println(sol.solution(s1));
            System.out.println(sol.solution(s2));
        }
    }
}
