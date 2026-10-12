package donguk.프로그래머스.lv3;

import java.util.Arrays;
import java.util.HashMap;

public class 다단계_칫솔_판매 {
    static class Solution{
        HashMap<String,String> dic ;
        HashMap<String,Integer> money;
        public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount){
            int[] answer = new int[enroll.length];
            dic = new HashMap<>();
            money = new HashMap<>();

            for(int i = 0; i<enroll.length;i++){
                dic.put(enroll[i], referral[i]);
                money.put(enroll[i], 0);
            }

            for(int j = 0 ; j<seller.length;j++){
                int tmp = amount[j] *100;
                calculate(seller[j],tmp);
            }
            for(int k = 0; k<enroll.length;k++){
                answer[k] = money.get(enroll[k]);
            }
            return answer;
        }

        public void calculate(String seller , int amount){

            int nextMoney = amount/10;
            int currentMoney = amount - nextMoney;
            String next = dic.get(seller);

            money.put(seller, money.get(seller) + currentMoney);

            if (nextMoney == 0 || next.equals("-")) {
                return;
            }

            calculate(next, nextMoney);
        }
    }

    public static void main(String[] args){
        String[] enroll1 = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral1 = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller1 = {"young", "john", "tod", "emily", "mary"};
        int[] amount1 = {12, 4, 2, 5, 10};

        String[] enroll2 = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral2 = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller2 = {"sam", "emily", "jaimie", "edward"};
        int[] amount2 = {2, 3, 5, 4};

        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(enroll1, referral1, seller1, amount1)));
        System.out.println(Arrays.toString(sol.solution(enroll2, referral2, seller2, amount2)));
    }
}
