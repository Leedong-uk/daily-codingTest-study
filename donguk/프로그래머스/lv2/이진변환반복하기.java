package donguk.프로그래머스.lv2;

import java.util.Arrays;

public class 이진변환반복하기 {
    static class Solution {
        public int[] solution(String s){
            int[] answer = {};
            int binaryCount = 0;
            int zeroCount = 0 ;
            int tmpLength = 0;
            StringBuilder tmp = new StringBuilder();

            while (!s.equals("1")) {
                for (int i = 0; i < s.length(); i++) {
                    if(s.charAt(i) == '0'){
                        zeroCount++;
                    }else{
                        tmp.append(s.charAt(i));
                    }
                }
//                System.out.println(tmp.toString());
                tmpLength = tmp.length();
//                System.out.println(tmpLength);
                s = Integer.toBinaryString(tmpLength);
//                System.out.println(s);
                tmp.setLength(0);
                binaryCount++;
//                System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");

            }
            answer = new int[]{binaryCount, zeroCount};
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String s1 = "110010101001";
        String s2 = "01110";
        String s3 = "1111111";

        System.out.println(Arrays.toString(s.solution(s1)));
        System.out.println(Arrays.toString(s.solution(s2)));
        System.out.println(Arrays.toString(s.solution(s3)));
    }
}
