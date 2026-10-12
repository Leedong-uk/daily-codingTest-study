package donguk.프로그래머스.lv3;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 디스크컨트롤러 {
    static class Solution{
        PriorityQueue<int[]> pq;
        public int solution(int[][] jobs){
            int answer = 0;

//            1. 소요시간이 짧은것
//            2. 작업의 요청 시각이 빠른것
//            3. 작업의 번호가 작은 것 순

            pq = new PriorityQueue<>((a,b)-> {
                if(a[0] != b[0]) return a[0]-b[0];
                if(a[1]!=b[1]) return a[1]-b[1];
                return a[2]-b[2];
            });

            Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

            int current = 0;
            int jobOrder = 0;
            int totalTime = 0;

            while(jobOrder < jobs.length-1){
                if(jobs[jobOrder][0] > current){
                    current++;
                    continue;
                }else{
                    if(pq.isEmpty()){
                        totalTime += (current + jobs[jobOrder][1] - jobs[jobOrder][0]);
                        jobOrder++;
                        current++;
                    }
                }


            }


            for(int i = 0 ; i<jobs.length;i++){
                int start = jobs[i][0];
                int time = jobs[i][1];
                pq.add(new int[]{time,start,i});
            }

            return answer;
        }

        public static void main(String[] args){
            int[][] jobs = {{0, 3}, {1, 9}, {3, 5}};
            Solution sol = new Solution();
            System.out.println(sol.solution(jobs));
        }
    }
}
