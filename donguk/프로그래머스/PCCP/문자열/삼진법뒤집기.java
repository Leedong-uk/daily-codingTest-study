package donguk.프로그래머스.PCCP.문자열;

public class 삼진법뒤집기 {
    static class Solution{
        public int solution(int n){
            int answer = 0;
            StringBuilder sb = new StringBuilder();

            while(n>0){
                int r = n%3;
                n = n/3;
                sb.append(r);
            }

            int m = sb.length();
            for(int i = 0; i<sb.length();i++){
                if(sb.charAt(i)=='0')
                    continue;
                else{
                    answer += (sb.charAt(i)-'0')  * ( (int) Math.pow(3, (m - i - 1)) );
                }
            }

            return answer;
        }
    }

    public static void main (String[] args){
        Solution sol = new Solution();
        int n1 = 45;
        int n2 = 125;

        System.out.println(sol.solution(n1));
        System.out.println(sol.solution(n2));
    }
}
