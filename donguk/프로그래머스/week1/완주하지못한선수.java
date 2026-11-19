package donguk.프로그래머스.week1;

public class 완주하지못한선수 {
    static class Solution{
        public String solution(String[] participant, String[] completion){
            String answer = "";
            int total = 0 ;

            for(String p : participant){
                total += p.hashCode();
            }

            for(String c : completion){
                total -= c.hashCode();
            }

            for(String p : participant){
                if (p.hashCode() == total) {
                    answer = p;
                }
            }

            return answer;
        }
    }

    public static void main (String[] args) {
        Solution sol = new Solution();

        String[] participant1 = {"leo", "kiki", "eden"};
        String[] completion1 = {"eden", "kiki"};

        String[] participant2 = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion2 = {"josipa", "filipa", "marina", "nikola"};

        String[] participant3 = {"mislav", "stanko", "mislav", "ana"};
        String[] completion3 = {"stanko", "ana", "mislav"};

        System.out.println(sol.solution(participant1, completion1));
        System.out.println(sol.solution(participant2, completion2));
        System.out.println(sol.solution(participant3, completion3));

    }

}
