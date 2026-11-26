package donguk.프로그래머스.PCCP.문자열;

public class 시저암호 {
    static class Solution{
        public String solution(String s, int n){
            String answer = "";
            StringBuilder sb = new StringBuilder();

            for(int i = 0; i<s.length(); i++){
                char c = s.charAt(i);

                if (c == ' ') {
                    sb.append(c);
                }else if (65 <= c && c<=90){
                    char newC = (char) (( (c - 65) + n) % 26 + 65);
                    sb.append(newC);

                }else if (97 <= c && c<=122){
                    char newC = (char) (( (c - 97) + n) % 26 + 97);
                    sb.append(newC);
                }
            }
            answer = sb.toString();
            return answer;
        }
    }

    public static void main(String[] args){
        Solution sol = new Solution();

        String s1 = "AB";
        int n1 = 1;

        String s2 = "z";
        int n2 = 1;

        String s3 ="a B z";
        int n3 = 4;

        System.out.println(sol.solution(s1,n1));
        System.out.println(sol.solution(s2,n2));
        System.out.println(sol.solution(s3,n3));
    }
}
