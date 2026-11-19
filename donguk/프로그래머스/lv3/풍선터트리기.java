package donguk.프로그래머스.lv3;

public class 풍선터트리기 {
    static class Solution{
        public int solution(int[] a){
            int answer = 0;

            int[] left = new int[a.length];
            int[] right = new int[a.length];

            int leftMin = a[0];
            int rightMin = a[a.length-1];

            left[0] = a[0];
            right[a.length - 1] = a[a.length-1];

            for(int i = 1 ; i<a.length;i++){
                leftMin = Math.min(leftMin, a[i - 1]);
                left[i] = leftMin;
            }

            for(int i = a.length-2; i>=0 ; i-- ){
                rightMin = Math.min(rightMin, a[i + 1]);
                right[i] = rightMin;
            }


            for (int i = 0; i < a.length; i++) {
                int tmp = 0;

                if (left[i] < a[i]) {
                    tmp++;
                }
                if (right[i] < a[i]) {
                    tmp++;
                }

                if (tmp <= 1) {
                    answer++;
                }
            }

            return answer;
        }

        public static void main (String[] args){
            Solution sol = new Solution();

            int[] a1 = {9, -1, -5};
            int[] a2 = {-16, 27, 65, -2, 58, -92, -71, -68, -61, -33};

            System.out.println(sol.solution(a1));
            System.out.println(sol.solution(a2));
        }
    }
}
