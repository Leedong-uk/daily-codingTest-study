package donguk.프로그래머스.PCCP.문자열;

public class 문자열압축 {
    static class Solution {
        public int solution(String s) {
            int answer = Integer.MAX_VALUE;
            StringBuilder result;

            for (int i = 1; i < s.length() / 2 + 1; i++) {
//                cutPoint -> 얼마만큼의 크기로 짜를 것이냐?
                int cutPoint = i;
                int cnt = 1;
                String lastString = s.substring(0, i);
                result = new StringBuilder();
                boolean flag = false;

//                    cutPoint 크기로 짜르고
//                    짜른게..sb의 가장 마지막 과 비교해 (같아 ?, 달라 ?)
//                    -> 같으면 : cnt++ 하고 다음 껄로 넘어가
//                    -> 다르면? : cnt 가 1인지 확인하고 (1이야?,아니야?)
//                        -> 1이면: lastString에 저장된 문자열 답에 넣고, lastString은 현재 문자열만 들어가게
//                        -> 1이 아니면: cnt+sb에 저장된 문자열을 답에 넣고 , sb는 현재 문자열만 들어가게 하고 , cnt =1 로 초기화

                for (int j = cutPoint; j < s.length(); j += cutPoint) {
//                    System.out.println("cutPoint: " + cutPoint + " j= " + j);

                    if(j+cutPoint>s.length()){
                        if(cnt>1){
                            result.append(cnt).append(lastString);
                        }
                        else{
                            result.append(lastString);
                        }

                        result.append(s.substring(j,s.length()));
                        flag = true;
                        break;
                    }


                    String current = s.substring(j, j + cutPoint);
//                    System.out.println("lastString: " + lastString + " current: " + current);

                    if (lastString.equals(current)){
                        cnt++;
                    }else{
                        if(cnt == 1){
                            result.append(lastString);
                            lastString = current;
                        }else{
                            result.append(cnt).append(lastString);
                            lastString = current;
                            cnt=1;
                        }
                    }

                }

                if (!flag && cnt > 1)
                    result.append(cnt).append(lastString);
                else if(!flag && cnt <=1) {
                    result.append(lastString);
                }


//                System.out.println("cutPoint: " + cutPoint +" 압축된 모양: "+result+ " -> " + result.length());
//                System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
                answer = Math.min(answer, result.length());

            }
            return answer;
        }

        public static void main(String[] args) {
            Solution sol = new Solution();

            String s1 = "aabbaccc";
            String s2 = "ababcdcdababcdcd";
            String s3 = "abcabcdede";
            String s4 = "abcabcabcabcdededededede";
            String s5 = "xababcdcdababcdcd";

            System.out.println(sol.solution(s1));
            System.out.println(sol.solution(s2));
            System.out.println(sol.solution(s3));
            System.out.println(sol.solution(s4));
            System.out.println(sol.solution(s5));

        }
    }
}
