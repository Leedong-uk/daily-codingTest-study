package donguk.프로그래머스.week1;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
    static class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            int[] result = new int[temperatures.length];
            Stack<Integer> stack = new Stack<>();

            for(int i = 0 ; i<temperatures.length;i++){
                if (stack.isEmpty()) {
                    stack.push(i);
                    continue;
                }

                if (temperatures[stack.peek()] >= temperatures[i]) {
                    stack.push(i);
                }
                else {
                    while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                        int top = stack.pop();
                        result[top] = i - top;
                    }
                    stack.push(i);
                }
            }

            while(!stack.isEmpty()){
                int tmp = stack.pop();
                result[tmp] = 0;
            }

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
