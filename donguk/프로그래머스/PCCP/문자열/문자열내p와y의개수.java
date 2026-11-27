package donguk.프로그래머스.PCCP.문자열;

public class 문자열내p와y의개수 {
    static class Solution{
        boolean solution(String s){
            boolean answer = true;
            int cntP = 0;
            int cntY = 0;

            for(int i = 0 ; i<s.length(); i++){
                if (s.charAt(i) == 'P'|| s.charAt(i) == 'p') {
                    cntP++;
                }else if (s.charAt(i) == 'Y'|| s.charAt(i) == 'y')
                    cntY++;
            }

            if(cntP != cntY)
                answer = false;

            return answer;
        }
    }


    public static void main(String[] args){
        Solution sol = new Solution();

        String s1 = "pPoooyY";
        String s2 = "Pyy";

        System.out.println(sol.solution(s1));
        System.out.println(sol.solution(s2));
    }
}
