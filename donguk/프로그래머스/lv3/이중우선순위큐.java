package donguk.프로그래머스.lv3;


import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class 이중우선순위큐 {
    static class Solution{
        public int[] solution(String[] operations) {
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            int[] answer ={};

            for(String operation : operations){
                String[] tmp = operation.split(" ");
                String command = tmp[0];
                int number = Integer.parseInt(tmp[1]);

                if (command.equals("I")){
                    maxHeap.add(number);
                    minHeap.add(number);
                }else if (command.equals("D") && maxHeap.size() != 0 ){
                    if (number == 1){
                        int num = maxHeap.poll();
                        minHeap.remove(num);
                    }
                    else{
                        int num = minHeap.poll();
                        maxHeap.remove(num);
                    }
                }
            }
            Integer maxValue = maxHeap.poll();
            Integer minValue = minHeap.poll();

            if(maxValue==null )
                maxValue = 0;
            if(minValue == null)
                minValue = 0;

            answer = new int[]{maxValue,minValue};
            return answer;
        }
    }

    public static void main(String[] args) {
        String[] operations1 = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        String[] operations2 = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};

        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(operations1)));
        System.out.println(Arrays.toString(sol.solution(operations2)));
    }
}
