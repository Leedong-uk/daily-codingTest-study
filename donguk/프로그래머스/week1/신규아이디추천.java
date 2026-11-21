package donguk.프로그래머스.week1;

import java.util.HashSet;

public class 신규아이디추천 {
    static class Solution {
        public String solution(String new_id) {
            String answer = "";
//            원본
//            System.out.println("원본: "+new_id);

//            1단계
            answer = new_id.toLowerCase();
//            System.out.println("1단계: "+answer);


//          2단계: 알파벳 소문자 , 숫자 , 뺴기(-) , 밑줄(_), 마침표(.) 외 전부 제거
            StringBuilder sb = new StringBuilder();

            for(int i = 0 ; i<answer.length();i++){
                char c = answer.charAt(i);

                if (('a' <= c && c <= 'z') || ('0' <= c && c <= '9') || (c == '-' || c == '_' || c == '.')) {
                    sb.append(c);
                }
            }
//            System.out.println("2단계: "+sb.toString());

//            3단계: .가 2번 이상 연속된 부분을 하나의 마침표로 치환
            StringBuilder sb2 = new StringBuilder();
            for(int i = 0 ; i<sb.length();i++){
                char c = sb.charAt(i);

                if (c == '.' && sb2.length() > 0 && sb2.charAt(sb2.length() - 1) == '.') {
                    continue;
                }
                sb2.append(c);
            }
//            System.out.println("3단계: "+sb2.toString());


//            4단계: .이 처음이나 끝에 위치하면 제거
            if (sb2.length() > 0 && sb2.charAt(0) == '.') {
                sb2.deleteCharAt(0);
            }

            if (sb2.length() > 0 && sb2.charAt(sb2.length() - 1) == '.') {
                sb2.deleteCharAt(sb2.length() - 1);
            }

//            System.out.println("4단계: "+sb2.toString());

//            5단계: 빈 문자열이라면, new_id에 "a"를 대입한다
            if (sb2.isEmpty()) {
                sb2.append('a');
            }

//            6단계: new_id의 길이가 16자리 이상이면 -> 첫 15개의 문자를 제외한 나머지 문자 제거
//            제거 후 마침표가 끝에 위치한다면? -> 끝에 위치한 마침표(.) 제거
            if (sb2.length() >= 16) {
                sb2 = new StringBuilder(sb2.substring(0, 15));
                if (sb2.charAt(sb2.length()-1) == '.') {
                    sb2.deleteCharAt(sb2.length()-1);
                }
            }

//            7단계: new_id 의 길이가 2자 이하라면?
//            -> new_id 의 마지막 문자를 new_id 의 길이가 3이 될때까지 반복해서 붙인다
            if (sb2.length() <= 2) {
                char lastChar = sb2.charAt(sb2.length() - 1);
                int tmp = 3 - sb2.length();

                sb2.repeat(lastChar, tmp);
            }

            answer = sb2.toString();
            return answer;
        }
    }

    public static void main (String[] args){
        Solution sol = new Solution();

        String new_id1 = "...!@BaT#*..y.abcdefghijklm";
        String new_id2 = "z-+.^.";
        String new_id3 = "=.=";
        String new_id4 = "123_.def";
        String new_id5 = "abcdefghijklmn.p";

        System.out.println(sol.solution(new_id1));
        System.out.println(sol.solution(new_id2));
        System.out.println(sol.solution(new_id3));
        System.out.println(sol.solution(new_id4));
        System.out.println(sol.solution(new_id5));


    }
}

