package donguk.프로그래머스.lv2;

public class 귤고르기 {
    static class Solution{
        public int solution(int k , int[] tangerine){
            int answer = 0;
            return answer;
        }
    }

    public static void main(String[] args) {
        int k1 = 6;
        int k2 = 4;
        int k3 = 2;

        int[] tangerine1 = new int[]{1, 3, 2, 5, 4, 5, 2, 3};
        int[] tangerine2 = new int[]{1, 3, 2, 5, 4, 5, 2, 3};
        int[] tangerine3 = new int[]{1, 1, 1, 1, 2, 2, 2, 3};

        Solution sol = new Solution();
        System.out.println(sol.solution(k1, tangerine1));
        System.out.println(sol.solution(k2, tangerine2));
        System.out.println(sol.solution(k3, tangerine3));

    }

}
