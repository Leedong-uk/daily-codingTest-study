package donguk.프로그래머스.lv3;

public class 입국심사 {
    static class Solution{
        public long solution(int n , int[] times){
            long answer = 0;
            long left= 1;
            long right = (long) n * times[0];

            for (int time : times) {
                right = Math.min(right, (long) n * time);
            }

            while(left<= right){
                long mid = (left + right) / 2;

                if(hello(mid,times,n)){
                    answer = mid;
                    right = mid -1;
                }else{
                    left = mid+1;
                }

            }
            return answer;
        }

        public boolean hello(long mid, int[] times, int n) {
            long cnt = 0;

            for (int time : times) {
                cnt += mid / time;
            }

            if (cnt >= n)
                return true;

            return false;
        }
    }

    public static void main (String[] args){
        Solution sol = new Solution();
        int n = 6;
        int[] times = {7, 10};
        System.out.println(sol.solution(n, times));
    }
}
