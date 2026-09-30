package donguk.프로그래머스.lv2;

public class 다음큰숫자 {
    static class Solution{
        public int solution(int n) {
            int answer = 0;
            String number = Integer.toBinaryString(n);
            int oneCount = 0;
            for (int i = 0; i < number.length(); i++) {
                if (number.charAt(i) == '1') {
                    oneCount++;
                }
            }

            n++;
            while (true) {
//                System.out.println(n);
                int oneCount2 = 0;
                String newNumber = Integer.toBinaryString(n);


                for (int i = 0; i < newNumber.length(); i++) {
                    if (newNumber.charAt(i) == '1') {
                        oneCount2++;
                    }
                }

//                if (n == 23) {
//                    System.out.println("mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm"+oneCount2);
//                    System.out.println("mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm"+newNumber);
//                }


                if (oneCount == oneCount2) {
                    answer = n;
                    break;
                }
                n++;
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        int n = 78;
        int n2 = 15;

        Solution sol = new Solution();
        System.out.println(sol.solution(n));
        System.out.println(sol.solution(n2));


    }
}
