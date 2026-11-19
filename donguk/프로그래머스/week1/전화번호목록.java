package donguk.프로그래머스.week1;

import java.util.HashSet;

public class 전화번호목록 {
    static class Solution{
        public boolean solution (String[] phone_book){
            HashSet<String> dic = new HashSet<>();

            for(String number : phone_book){
                dic.add(number);
            }

            for (String number : phone_book) {
                for (int i = 0; i < number.length(); i++) {
                    String prefix = number.substring(0, i);
                    if(dic.contains(prefix))
                        return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] phone_book1 = {"119", "97674223", "1195524421"};
        String[] phone_book2 = {"123","456","789"};
        String[] phone_book3 = {"12","123","1235","567","88"};

        System.out.println(sol.solution(phone_book1));
        System.out.println(sol.solution(phone_book2));
        System.out.println(sol.solution(phone_book3));
    }

}
