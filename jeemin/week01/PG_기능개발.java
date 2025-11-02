package jeemin.week01;
import java.util.*;
public class PG_기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] days = new int[speeds.length];

        for (int i = 0; i < speeds.length; i++) {
            days[i] = (100 - progresses[i]) / speeds[i];
            if ((100 - progresses[i]) % speeds[i] != 0) {
                days[i]++;
            }
        }

        int[] deploy = new int[]{1, days[0]};
        for (int i = 1; i < speeds.length; i++) {
            if (deploy[1] < days[i]) {
                list.add(deploy[0]);
                deploy = new int[]{1, days[i]};
            }
            else {
                deploy = new int[]{deploy[0] + 1, deploy[1]};
            }
        }
        list.add(deploy[0]);
        int[] answer = list.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}
