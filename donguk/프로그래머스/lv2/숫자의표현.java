package donguk.프로그래머스.lv2;

public class 숫자의표현 {
    static class Solution{
        public int solution(int n){
            int answer = 0;
            for(int i = 1 ; i< (n/2)+1 ; i++){
                int current = 0;
                int start = i;

                while (current <= n) {
                    if (current == n){
                        answer+=1;
                        break;
                    }
                    current +=start;
                    start++;
                }


            }
            return answer+1;

        }
    }

    public static void main(String[] args){
        int n = 15;
        Solution sol = new Solution();
        System.out.println(sol.solution(n));
    }
}
