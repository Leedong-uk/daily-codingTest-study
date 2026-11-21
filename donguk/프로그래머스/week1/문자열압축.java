package donguk.프로그래머스.week1;

public class 문자열압축 {
    static class Solution{
        public int solution(String s){
            int answer = 0;
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String s1 = "aabbaccc";
        String s2 = "ababcdcdababcdcd";
        String s3 = "abcabcdede";
        String s4 = "abcabcabcabcdededededede";
        String s5 = "xababcdcdababcdcd";

        System.out.println(sol.solution(s1));
        System.out.println(sol.solution(s2));
        System.out.println(sol.solution(s3));
        System.out.println(sol.solution(s4));
        System.out.println(sol.solution(s5));


    }
}
