package donguk.프로그래머스.week1;

public class 소수만들기 {
    static class Solution {
        public int solution(int[] nums) {
            int answer = 0;
            int max = 0;

            // 세 숫자의 합 중 최댓값 구하기
            for (int i = 0; i < nums.length; i++) {
                max = Math.max(max, nums[i]);
            }
            max *= 3;

            boolean[] visited = new boolean[max + 1];

            visited[0] = true;
            visited[1] = true;

            // 에라토스테네스의 체
            for (int i = 2; i < (int) Math.sqrt(max) + 1; i++) {

                if (visited[i]) {
                    continue;
                }

                for (int j = i * i; j <= max; j += i) {
                    visited[j] = true;
                }
            }

            // 숫자 3개 선택
            for (int i = 0; i < nums.length - 2; i++) {
                for (int j = i + 1; j < nums.length - 1; j++) {
                    for (int k = j + 1; k < nums.length; k++) {

                        int sum = nums[i] + nums[j] + nums[k];

                        if (!visited[sum]) {
                            answer++;
                        }
                    }
                }
            }


            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {1, 2, 3, 4};
        int[] nums2 = {1, 2, 7, 6, 4};

        System.out.println(sol.solution(nums1)); // 1
        System.out.println(sol.solution(nums2)); // 4
    }
}