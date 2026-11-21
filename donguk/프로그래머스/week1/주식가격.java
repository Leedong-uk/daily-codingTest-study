package donguk.프로그래머스.week1;

import java.util.Arrays;
import java.util.Stack;

public class 주식가격 {
    static class Solution{
        public int[] solution (int[] prices) {
            int[] result = new int[prices.length];
            Stack<Integer> stack = new Stack<>();

            for(int i = 0 ; i < prices.length; i++){

                if(stack.isEmpty()){
                    stack.push(i);
                    continue;
                }

                int top = stack.peek();
                int current = i;

                if (prices[top] <= prices[current]) {
                    stack.push(current);
                }
                else{
                    while(!stack.isEmpty() && prices[stack.peek()] > prices[current]){
                        top = stack.pop();
                        result[top] = current - top;
                    }
                    stack.push(current);
                }

            }

            while(!stack.isEmpty()){
                int tmp = stack.pop();
                result[tmp] = prices.length - 1 - tmp;
            }

            return result;
        }
    }

    public static void main(String[] args){
        Solution sol = new Solution();

        int[] prices1 = {1, 2, 3, 2, 3};
        int[] prices2 = {1, 2, 3, 2, 2, 3, 3, 2, 1, 2};

        System.out.println(Arrays.toString(sol.solution(prices1)));
        System.out.println(Arrays.toString(sol.solution(prices2)));
    }
}
