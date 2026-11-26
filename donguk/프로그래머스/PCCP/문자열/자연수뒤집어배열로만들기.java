package donguk.프로그래머스.PCCP.문자열;

public class 자연수뒤집어배열로만들기 {
    static class Solution{
        public int[] solution(long n ) {
            String tmp = String.valueOf(n);
            int max = tmp.length();
            int[] answer= new int[max];

            for(int i=0 ; i<max ; i++){
                answer[i] = (int) (n % 10);
                n /= 10;
            }

            return answer;
        }
    }

    public static void main(String[] args){
        Solution sol = new Solution();

        long n = 12345;
        System.out.println(sol.solution(n));

    }
}
