package donguk.프로그래머스.PCCP.배열;

import java.util.ArrayList;
import java.util.Arrays;

public class 삼각달팽이 {
    static class Solution{
        public int[] solution(int n) {
            int[] answer = {};
            int[][] map = new int[n][n];
            int x = 0;
            int y = 0;
            int cnt = 1;
            map[0][0] = 1;

            while(true){
                int before = cnt;

//                아래 방향
                while(true){
                    int nextX = x+1;
                    int nextY = y;

                    if(nextX<0 || nextX>=n || nextY<0 || nextY>=n || map[nextX][nextY]!=0)
                        break;

                    cnt++;
                    map[nextX][nextY] = cnt;
                    x = nextX;
                    y = nextY;

                }


//                오른쪽 방향
                while(true){
                    int nextX = x;
                    int nextY = y+1;

                    if(nextX<0 || nextX>=n || nextY<0 || nextY>=n || map[nextX][nextY]!=0)
                        break;

                    cnt++;
                    map[nextX][nextY] = cnt;
                    x = nextX;
                    y = nextY;

                }

//                대각 방향
                while(true){
                    int nextX = x-1;
                    int nextY = y-1;

                    if(nextX<0 || nextX>=n || nextY<0 || nextY>=n || map[nextX][nextY]!=0)
                        break;

                    cnt++;
                    map[nextX][nextY] = cnt;
                    x = nextX;
                    y = nextY;
                }

                if(before == cnt){
                    break;
                }
            }

            ArrayList<Integer> tmp = new ArrayList<>();

            for(int i = 0; i<n ; i++){
                for(int j=0; j<n ; j++){
                    if (map[i][j] != 0) {
                        tmp.add(map[i][j]);
                    }
                }
            }

            answer = new int[n * (n + 1) / 2];
            int idx = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= i; j++) {
                    answer[idx++] = map[i][j];
                }
            }
            return answer;
        }
    }

    public static void main(String[] args){
        Solution sol = new Solution();

//        int n1 = 4;
//        int n2 = 5;
//        int n3 = 6;

//        int n1 = 1;
//        int n2 = 2;
        int n3 = 3;


//        System.out.println(Arrays.toString(sol.solution(n1)));
//        System.out.println(Arrays.toString(sol.solution(n2)));
        System.out.println(Arrays.toString(sol.solution(n3)));
    }
}
