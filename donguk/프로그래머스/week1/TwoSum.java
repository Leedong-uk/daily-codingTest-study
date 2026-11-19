package donguk.프로그래머스.week1;

import java.util.Arrays;

public class TwoSum {
    static class Solution {
        public int[] twoSum(int[] nums, int target){
            int[] result = new int[2];
            int[] dic = new int[nums.length];
            boolean[] visited = new boolean[nums.length];

//            1번: 인덱스를 저장할 hashMap -> nums[i] 이 중복되면 index를 저장이 덮어진다.
            for(int i = 0 ; i<nums.length;i++){
                dic[i] = nums[i];
            }

//            2번: nums 정렬
            Arrays.sort(nums);

//            3번: twoPointer 로 풀기
            int start = 0;
            int end = nums.length-1;

//            System.out.println("start: " + start + " , end: " + end);
//            2 3 4

            while(start < end){
                int tmp = nums[start] + nums[end];
//                System.out.println(tmp);
                if (tmp < target) {
                    start ++;
                }
                else if (tmp > target){
                    end --;
                }
                else{
                    System.out.println("✨발견✨start: " + start + " , end: " + end);

                    for(int i = 0 ; i<nums.length;i++){
                        if (dic[i] == nums[start] && !visited[i]) {
                            result[0] = i;
                            visited[i] = true;
                            break;
                        }
                    }

                    for(int i = 0 ; i<nums.length;i++){
                        if (dic[i] == nums[end] && !visited[i]) {
                            result[1] = i;
                            break;
                        }
                    }

                    break;
                }
            }

            return result;
        }
    }
    public static void main (String[] args){
        Solution sol = new Solution();

        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;

        int[] nums2 = {3,2,4};
        int target2 = 6;

        int[] nums3 = {3,3};
        int target3 = 6;

        System.out.println(Arrays.toString(sol.twoSum(nums1, target1)));
        System.out.println(Arrays.toString(sol.twoSum(nums2, target2)));
        System.out.println(Arrays.toString(sol.twoSum(nums3, target3)));
    }
}
