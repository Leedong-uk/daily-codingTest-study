package donguk.프로그래머스.lv3;

import java.util.Collections;
import java.util.PriorityQueue;

public class 야근지수 {
    static class Solution{
        public long solution(int n , int[] works){
            long answer = 0;
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            int sum = 0;

            for (int i : works){
                sum+=i;
                maxHeap.add(i);
            }

            n = Math.min(n, sum);

            while(n>0){
                int maxNode = maxHeap.poll();
                if(maxNode <= 0)
                    return 0;

                maxNode--;
                maxHeap.add(maxNode);
                n--;
            }

            for(int i : maxHeap){
                answer += (i * i);
            }

            return answer;
        }
    }

    public static void main(String[] args){
        int n1 = 4;
        int[] works1 = {4, 3, 3};

        int n2 = 1;
        int[] works2 = {2,1,2};

        int n3 = 3;
        int[] works3 = {1,1};

        Solution sol = new Solution();
        System.out.println(sol.solution(n1, works1));
        System.out.println(sol.solution(n2, works2));
        System.out.println(sol.solution(n3, works3));


    }
}
