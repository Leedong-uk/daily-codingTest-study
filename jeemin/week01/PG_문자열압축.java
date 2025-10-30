package jeemin.week01;
import java.util.*;
public class PG_문자열압축 {
    public int solution(String s) {
        int answer = s.length();
        // i개 단위로 잘라 압축
        for (int i = 1; i <= s.length() / 2; i++) {
            int cnt = 1;
            int sum = 0;
            String word = s.substring(0, i);
            for (int j = i; i + j <= s.length(); j += i) {
                String next = s.substring(j, j + i);
                // 연속하는 경우
                if (word.equals(next)) {
                    cnt++;
                }
                // 연속하지 않는 경우
                else {
                    if (cnt > 1) { sum += String.valueOf(cnt).length(); }
                    sum += i;
                    cnt = 1;
                    word = next;
                }
                // 마지막 그룹인 경우
                if (j == s.length() - s.length() % i - i) {
                    if (cnt > 1) { sum += String.valueOf(cnt).length(); }
                    sum += i;
                }
            }
            sum += s.length() % i;
            answer = Math.min(answer, sum);
        }
        return answer;
    }
}
