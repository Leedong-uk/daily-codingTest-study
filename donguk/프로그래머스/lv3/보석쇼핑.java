package donguk.프로그래머스.lv3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class 보석쇼핑 {
    static class Solution{
        public int[] solution(String[] gems) {
            int kind = new HashSet<>(Arrays.asList(gems)).size(); // O(N)
            HashMap<String, Integer> dic = new HashMap<>();

            int left = 0;
            int right = 0 ;

            int bestLeft=0;
            int bestRight = gems.length -1;


            //O(N)
            // 1. 일단 left ,right 찾기
            // 2. left를 가능한 줄이기
            // 3. 조건 깨지면 다시 right 늘리기

            while(right<gems.length){
                dic.put(gems[right], dic.getOrDefault(gems[right], 0) + 1);

                while(dic.size() == kind){
                    if(right - left < bestRight-bestLeft){
                        bestLeft = left;
                        bestRight = right;
                    }

                    dic.put(gems[left], dic.get(gems[left]) - 1);

                    if(dic.get(gems[left]) == 0 ){
                        dic.remove(gems[left]);
                    }
                    left++;
                }

                right++;

            }
            return new int[]{bestLeft + 1, bestRight + 1};
        }
    }

    public static void main (String[] args) {
        String[] gems1 = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        String[] gems2 = {"AA", "AB", "AC", "AA", "AC"};
        String[] gems3 = {"XYZ", "XYZ", "XYZ"};
        String[] gems4 = {"ZZZ", "YYY", "NNNN", "YYY", "BBB"};

        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(gems1)));
        System.out.println(Arrays.toString(sol.solution(gems2)));
        System.out.println(Arrays.toString(sol.solution(gems3)));
        System.out.println(Arrays.toString(sol.solution(gems4)));

    }
}
