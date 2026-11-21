package donguk.프로그래머스.week1;

import java.util.Arrays;

public class DailyTemperatures {
    static class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            int[] result = {};

            return result;
        }
    }

    public static void main (String[] args){
        Solution sol = new Solution();

        int[] temperatures1 = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] temperatures2 = {30,40,50,60};
        int[] temperatures3 = {30,60,90};

        System.out.println(Arrays.toString(sol.dailyTemperatures(temperatures1)));
        System.out.println(Arrays.toString(sol.dailyTemperatures(temperatures2)));
        System.out.println(Arrays.toString(sol.dailyTemperatures(temperatures3)));
    }
}
