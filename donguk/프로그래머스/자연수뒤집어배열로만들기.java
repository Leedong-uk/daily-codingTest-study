package donguk.프로그래머스;

import java.util.Arrays;

public class 자연수뒤집어배열로만들기 {
    static class Solution {
        public int[] solution(long n) {

            String number = String.valueOf(n);
            int[] answer = new int[number.length()];

            for (int i = 0; i<number.length();i++) {
                answer[i] = number.charAt(number.length()-i-1) - '0';
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        long n = 12345;
        int[] result = sol.solution(n);
        System.out.println(Arrays.toString(result));
    }
}
