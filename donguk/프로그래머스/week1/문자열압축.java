package donguk.프로그래머스.week1;

public class 문자열압축 {
    static class Solution {
        public int solution(String s) {
            int answer = s.length();

            for (int i = 1; i <= s.length() / 2; i++) {
                StringBuilder sb = new StringBuilder();

                String lastString = s.substring(0, i);
                int cnt = 1;

                for (int j = i; j <= s.length() - i; j += i) {
                    String current = s.substring(j, j + i);

                    if (current.equals(lastString)) {
                        cnt++;
                    } else {
                        if (cnt == 1) {
                            sb.append(lastString);
                        } else {
                            sb.append(cnt).append(lastString);
                        }

                        lastString = current;
                        cnt = 1;
                    }
                }

                if (cnt == 1) {
                    sb.append(lastString);
                } else {
                    sb.append(cnt).append(lastString);
                }

                // 마지막에 남은 문자열 추가
                sb.append(s.substring(s.length() / i * i));

                answer = Math.min(answer, sb.length());
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution("aabbaccc"));                 // 7
        System.out.println(sol.solution("ababcdcdababcdcd"));         // 9
        System.out.println(sol.solution("abcabcdede"));               // 8
        System.out.println(sol.solution("abcabcabcabcdededededede")); // 14
        System.out.println(sol.solution("xababcdcdababcdcd"));        // 17
    }
}