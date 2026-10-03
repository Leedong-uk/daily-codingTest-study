package donguk.프로그래머스.lv3;

import java.util.ArrayList;
import java.util.HashMap;

public class 베스트앨범 {
    static class Solution{
        public int[] solution(String[] genres, int[] plays){
            HashMap<String, ArrayList<int[]>> dic = new HashMap<>();
            HashMap<String, Integer> total = new HashMap<>();

            for (int i = 0; i < genres.length; i++) {
                dic.putIfAbsent(genres[i], new ArrayList<>());
                total.putIfAbsent(genres[i], 0);

                dic.get(genres[i]).add(new int[]{i,plays[i]});
                total.put(genres[i], total.get(genres[i]) + plays[i]);
            }

            for(String genre : dic.keySet()){
                dic.get(genre).sort((a, b) -> {
                    if (a[1] == b[1]) {
                        return a[0] - b[0];
                    }
                    return b[1] - a[1];
                });
            }

            ArrayList<String> genreList = new ArrayList<>(dic.keySet());
            genreList.sort((a, b) -> total.get(b) - total.get(a));

            ArrayList<Integer> result = new ArrayList<>();

            for ( String genre : genreList){
                ArrayList<int[]> songs = dic.get(genre);
                result.add(songs.get(0)[0]);

                if (songs.size()>=2){
                    result.add(songs.get(1)[0]);
                }
            }

            int[] answer = new int[result.size()];
            for (int i = 0; i < result.size(); i++) {
                answer[i] = result.get(i);
            }

            return answer;
        }

        public static void main (String[] args) {
            Solution sol = new Solution();
            String[] genres = {"classic", "pop", "classic", "classic", "pop"};
            int[] plays = {500, 600, 150, 800, 2500};

            System.out.println(sol.solution(genres, plays));
        }
    }
}
