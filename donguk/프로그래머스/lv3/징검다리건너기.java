package donguk.프로그래머스.lv3;

public class 징검다리건너기 {
    static class Solution {

        public int solution(int[] stones, int k) {
            int result = 0;
            int left = 1;
            int right = 200000000;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (canCross(stones, k, mid)) {
                    result = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            return result;
        }

        public boolean canCross(int[] stones, int k, int people) {
            int cnt = 0;

            for (int stone : stones) {
                if (stone < people) {
                    cnt++;
                } else {
                    cnt = 0;
                }

                if (cnt >= k) {
                    return false;
                }
            }

            return true;
        }
    }

    public static void main(String[] args) {
        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3;

        Solution sol = new Solution();
        System.out.println(sol.solution(stones, k));
    }
}