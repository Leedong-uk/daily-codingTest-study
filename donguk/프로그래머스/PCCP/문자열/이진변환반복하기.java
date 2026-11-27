package donguk.프로그래머스.PCCP.문자열;

import java.util.Arrays;

public class 이진변환반복하기 {
    static class Solution {
        public int[] solution(String s){
            int[] answer = new int[2];
            int zeroCnt = 0;
            int step = 0;
            StringBuilder sb ;

            while(!s.equals("1")){
                step++;
                sb = new StringBuilder();

                for(int i = 0 ; i < s. length(); i ++){
                    if(s.charAt(i)=='0'){
                        zeroCnt++;
                    }else{
                        sb.append(s.charAt(i));
                    }
                }

                int tmp = sb.length();
                sb = new StringBuilder();

                while(tmp>0){
                    int r = tmp%2;
                    tmp = tmp/2;
                    sb.append(r);
                }

                sb.reverse();
                s = sb.toString();
            }
            answer[0] = step;
            answer[1] = zeroCnt;
            return answer;
        }
    }

    public static void main(String[] args){
        Solution sol = new Solution();

        String s1 = "110010101001";
        String s2 = "01110";
        String s3 = "1111111";

        System.out.println(Arrays.toString(sol.solution(s1)));
        System.out.println(Arrays.toString(sol.solution(s2)));
        System.out.println(Arrays.toString(sol.solution(s3)));
    }
}

