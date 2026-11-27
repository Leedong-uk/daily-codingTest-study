package donguk.프로그래머스.PCCP.문자열;

public class 신규아이디추천 {
    static class Solution{
        public String solution(String new_id){
            String answer = "";
            StringBuilder sb = new StringBuilder();

//            1단계
            new_id = new_id.toLowerCase();
            System.out.println("1단계: "+new_id);

//            2단계
            for(int i=0 ; i<new_id.length(); i++){
                char ch = new_id.charAt(i);
                if( ('a'<= ch && ch<= 'z') || ('0'<= ch && ch<= '9') || ( ch=='-' || ch=='_' || ch=='.' ))
                    sb.append(ch);
            }

            new_id = sb.toString();
            sb = new StringBuilder();
            System.out.println("2단계: "+new_id);

//            3단계
            for(int i =0; i<new_id.length(); i++){
                char ch = new_id.charAt(i);

                if(!sb.isEmpty() && sb.charAt(sb.length()-1) == '.' && ch =='.')
                    continue;
                sb.append(ch);
            }
            System.out.println("3단계: "+sb);

//            4단계
            if(!sb.isEmpty() && sb.charAt(0) == '.')
                sb.deleteCharAt(0);

            if(!sb.isEmpty() && sb.charAt(sb.length()-1)=='.')
                sb.deleteCharAt(sb.length()-1);

            System.out.println("4단계: "+sb);

//            5단계
            if(sb.isEmpty())
                sb.append('a');
            System.out.println("5단계: "+sb);

//            6단계
            if (sb.length() >= 16) {
                sb = new StringBuilder(sb.substring(0, 15));
                if(sb.charAt(sb.length()-1) == '.')
                    sb.deleteCharAt(sb.length()-1);
            }
            System.out.println("6단계: "+sb);

//            7단계
            if(sb.length()<=2){
                char ch = sb.charAt(sb.length() - 1);
                while(sb.length() < 3){
                    sb.append(ch);
                }
            }
            System.out.println("7단계: "+sb);

            answer = sb.toString();
            return answer;
        }
    }

    public static void main(String[] args){
        Solution sol = new Solution();

        String new_id1 = "...!@BaT#*..y.abcdefghijklm";
        String new_id2 = "z-+.^.";
        String new_id3 = "=.=";
        String new_id4 = "123_.def";
        String new_id5 = "abcdefghijklmn.p";

        System.out.println(sol.solution(new_id1));
//        System.out.println(sol.solution(new_id2));
//        System.out.println(sol.solution(new_id3));
//        System.out.println(sol.solution(new_id4));
//        System.out.println(sol.solution(new_id5));


    }
}
