package donguk.프로그래머스.lv3;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class 단어변환 {
    static class Solution{
        public int solution(String begin,String target,String[] words){
            int answer = 0;
            Deque<String> dq = new ArrayDeque<>();
            HashMap<String, Boolean> visited = new HashMap<>();
            HashMap<String, Integer> distance = new HashMap<>();
            HashMap<String, Set<String>> dic = new HashMap<>();
            dic.put(begin, new HashSet<>());

            for (int i = 0; i < words.length; i++) {
                if (compareWord(begin, words[i]) == 1) {
                    dic.get(begin).add(words[i]);
                }
            }
            visited.put(begin, false);
            distance.put(begin, 0);

            for(int i = 0 ; i<words.length;i++){
                dic.put(words[i], new HashSet<>());
                visited.put(words[i], false);
                distance.put(words[i], 0);
                for (int j = 0 ; j<words.length; j++){
                    if (i == j )
                        continue;
                    if(compareWord(words[i],words[j]) == 1){
                        dic.get(words[i]).add(words[j]);
                    }
                }
            }

            visited.put(begin, true);
            distance.put(begin, 0);
            dq.addLast(begin);
//            System.out.println("visited =" + visited);
//            System.out.println("distance =" + distance);
//            System.out.println("dq =" + dq);

            while (dq.size()!=0) {
                String start = dq.pollFirst();
//                System.out.println("start ="+start);

                if(start.equals(target)){
//                    System.out.println("===결과 발견 ==");
                    answer = distance.get(start);
                    break;
                }

//                System.out.println("dic.get(start) ="+dic.get(start));
                for(String next : dic.get(start)){
//                    System.out.println("next ="+next);
                    if(!visited.get(next)){
                        visited.put(next, true);
                        dq.addLast(next);
                        distance.put(next, distance.get(start) + 1);
                    }
                }
            }

            return answer;
        }
    }

    static int compareWord(String word1, String word2){
        int result = 0;
        for (int i = 0; i < word1.length(); i++) {
            if(word1.charAt(i) != word2.charAt(i))
                result++;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String begin1 = "hit";
        String target1 = "cog";
        String[] words1 = {"hot", "dot", "dog", "lot", "log", "cog"};

        String begin2 = "hit";
        String target2 = "cog";
        String[] words2 = {"hot", "dot", "dog", "lot", "log"};

        System.out.println(sol.solution(begin1, target1, words1));
        System.out.println(sol.solution(begin2, target2, words2));
    }
}
