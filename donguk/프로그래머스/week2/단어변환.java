package donguk.프로그래머스.week2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;

public class 단어변환 {
    static class Solution{
        public int solution(String begin, String target, String[] words){
            int answer = 0;
            HashMap<String, ArrayList<String>> dic = new HashMap<>();
            HashMap<String,Boolean> visited = new HashMap<>();
            HashMap<String, Integer> map = new HashMap<>();
            ArrayDeque<String> q = new ArrayDeque<>();

            dic.put(begin, new ArrayList<>());
            visited.put(begin, false);
            map.put(begin, 0);
            map.put(target, 0);


            for(String word : words){
                dic.put(word, new ArrayList<>());
                visited.put(word, false);
                map.put(word, 0);

                int diff = 0;
                for(int i = 0 ; i<word.length();i++){
                    if(word.charAt(i) != begin.charAt(i)){
                        diff++;
                    }
                }
                if(diff==1){
                    dic.get(begin).add(word);
                }
            }


            for(int i = 0 ; i<words.length;i++){
                for(int j = i+1; j<words.length; j++){
                    int diff = 0;

                    for(int k = 0 ; k<words[i].length();k++){
                        if(words[i].charAt(k) != words[j].charAt(k))
                            diff++;
                    }

                    if(diff == 1)
                        dic.get(words[i]).add(words[j]);
                        dic.get(words[j]).add(words[i]);
                }

            }

//            System.out.println(dic);

            q.add(begin);
            visited.put(begin, true);

            while(!q.isEmpty()){
                String current = q.pop();
                int currentValue = map.get(current);

                for(String next : dic.get(current)){
                    if(!visited.get(next)){
                        q.add(next);
                        visited.put(next, true);
                        map.put(next, currentValue + 1);
                    }
                }

            }

            answer = map.get(target);

            return answer;
        }
    }

    public static void main(String[] args){
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
