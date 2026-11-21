package donguk.프로그래머스.week1;

import java.util.ArrayDeque;
import java.util.Arrays;

public class 기능개발 {
    static class Solution{
        public int[] solution(int[] progresses, int[] speeds) {

            ArrayDeque<Integer> progress = new ArrayDeque<>();
            ArrayDeque<Integer> speed = new ArrayDeque<>();
            ArrayDeque<Integer> result = new ArrayDeque<>();

            for (int i : progresses) {
                progress.add(i);
            }

            for(int s : speeds){
                speed.add(s);
            }

            while(!progress.isEmpty()){
                int cnt = 1;

                int p = progress.pollFirst();
                int s = speed.pollFirst();

                int day = (100 - p) / s;

                if ((100 - p) % s != 0) {
                    day ++;
                }

                while(!progress.isEmpty()){
                    if (progress.peek() + speed.peek() * day >= 100) {
                        progress.pollFirst();
                        speed.pollFirst();
                        cnt++;
                    }
                    else
                        break;
                }

                result.addLast(cnt);
            }

            int[] answer = new int[result.size()];

            for (int i = 0; !result.isEmpty(); i++) {
                answer[i] = result.pollFirst();
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] progresses1 = {93, 30, 55};
        int[] speeds1 = {1, 30, 5};

        int[] progresses2 = {95, 90, 99, 99, 80, 99};
        int[] speeds2 = {1, 1, 1, 1, 1, 1};

        System.out.println(Arrays.toString(sol.solution(progresses1, speeds1)));
        System.out.println(Arrays.toString(sol.solution(progresses2, speeds2)));
    }
}
