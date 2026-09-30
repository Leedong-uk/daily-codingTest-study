package donguk.프로그래머스.lv2;
import java.util.*;

public class 올바른괄호 {
    static class Solution{
        boolean solution (String s){
            boolean answer = true;
            HashMap<String, String> dic = new HashMap<>();
            Deque<String> dq = new ArrayDeque<>();
            dic.put(")", "(");

            for (int i = 0; i < s.length(); i++) {
                String c = String.valueOf(s.charAt(i));
//                System.out.println(c);

                if (c.equals(")") && dq.size() != 0) {
//                    System.out.println("1111");
//                    System.out.println("dq의 peek값 ="+dq.peek()+"dic.get의 값 ="+dic.get(")"));
                    if (dq.peek().equals(dic.get(")")) ) {
//                        System.out.println("2222");
                        dq.pop();
                    }
                }else{
                    dq.addLast(c);
//                    System.out.println(dq);
                }

            }

            if (dq.size() != 0) {
                answer = false;
            }else{
                answer = true;
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        String s1 = "()()";
        String s2 = "(())()";
        String s3 = ")()(";
        String s4 = "(()(";

        Solution sol = new Solution();
        System.out.println(sol.solution(s1)); // true
        System.out.println(sol.solution(s2)); // true
        System.out.println(sol.solution(s3)); // false
        System.out.println(sol.solution(s4)); // false
    }
}
