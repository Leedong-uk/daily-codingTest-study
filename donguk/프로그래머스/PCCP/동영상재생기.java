package donguk.프로그래머스.PCCP;

public class 동영상재생기 {
    static class Solution{
        public int timeToSec(String time) {
            String[] parts = time.split(":");
            int minute = Integer.parseInt(parts[0]);
            int seconds = Integer.parseInt(parts[1]);
            return minute*60+seconds;
        }

        public String secToTime(int sec) {
            int minute = sec / 60;
            int second = sec % 60;
            return String.format("%02d:%02d", minute, second);
        }

        public String solution(String video_len, String pos , String op_start, String op_end, String[] commands ) {
            String answer = "";
            int totalSec = timeToSec(video_len);
            int posSec = timeToSec(pos);
            int opStartSec = timeToSec(op_start);
            int opEndSec = timeToSec(op_end);
            int current = posSec;
            if (opStartSec <= current && current <=opEndSec){
                current = opEndSec;
            }
            System.out.println("[시작 위치] = " + current);
            for (String command : commands){
                if (command == "next") {
                    current +=10;
                    if (totalSec - current < 10) {
                        current = totalSec;
                    }
                    System.out.println("[next 후 위치] = " + current);

                } else if (command == "prev") {
                    current -=10;
                    if (current < 10) {
                        current = 0;
                    }

                    System.out.println("[prev 후 위치] = " + current);
                }

                if (opStartSec <= current && current <=opEndSec){
                    current = opEndSec;
                }
            }
            answer = secToTime(current);
            return answer;
        }

        public static void main(String[] args) {
            Solution sol = new Solution();

            //   == 1 ==
            String video_len1 = "34:33";
            String pos1 = "13:00";
            String op_start1 = "00:55";
            String op_end1 = "02:55";
            String[] commands1 = {"next", "prev"};
            System.out.println(sol.solution(video_len1, pos1, op_start1, op_end1, commands1));
            System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");

            //   == 2 ==
            String video_len2 = "10:55";
            String pos2 = "00:05";
            String op_start2 = "00:15";
            String op_end2 = "06:55";
            String[] commands2 = {"prev","next","next" };
            System.out.println(sol.solution(video_len2, pos2, op_start2, op_end2, commands2));
            System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");

            //   == 3 ==
            String video_len3 = "07:22";
            String pos3 = "04:05";
            String op_start3 = "00:15";
            String op_end3 = "04:07";
            String[] commands3 = {"next"};
            System.out.println(sol.solution(video_len3, pos3, op_start3, op_end3, commands3));
            System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        }
    }
}
