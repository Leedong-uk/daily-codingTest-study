package donguk.프로그래머스.PCCP;

import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

public class 붕대감기 {
    static class Solution{
        public int solution(int[] bandage, int health, int[][] attacks) {

            int t = bandage[0];
            int heal = bandage[1];
            int currentHealth = health;
            int continuous = 0 ;
            int extraHeal = bandage[2];
            HashMap<Integer, Integer> attack = new HashMap<>();

            for (int i = 0; i < attacks.length; i++) {
                attack.put(attacks[i][0], attacks[i][1]);
            }

            Set<Integer> attackTimes = attack.keySet();
            int maxTime = Collections.max(attackTimes);
//            System.out.println("attackTimes =" + attackTimes + " maxTime = " + maxTime);

            for (int i = 1; i < maxTime + 1; i++) {

                if (currentHealth <= 0) {
                    currentHealth = -1;
                    break;
                }

                if (attackTimes.contains(i)) {
                    continuous = 0;
                    currentHealth -= attack.get(i);
                    System.out.println( "시간: "+i+" 현재 체력: "+currentHealth+" 연속 성공: "+continuous);
                }
                else {
                    continuous += 1;
                    if (continuous == t) {
                        currentHealth += (extraHeal + heal);
                        if(currentHealth >=health)
                            currentHealth = health;
                        continuous = 0;
                        System.out.println( "시간: "+i+" 현재 체력: "+currentHealth+" 연속 성공: "+continuous);
                    }else{
                        currentHealth += heal;
                        if(currentHealth >= health)
                            currentHealth = health;
                        System.out.println( "시간: "+i+" 현재 체력: "+currentHealth+" 연속 성공: "+continuous);
                    }
                }
            }
            if (currentHealth <= 0) {
                return -1;
            } else {
                return currentHealth;
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] bandage1 = {5, 1, 5};
        int health1 = 30;
        int[][] attacks1 = {{2, 10}, {9, 15}, {10, 5}, {11, 5}};
        System.out.println(sol.solution(bandage1, health1, attacks1));
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");

        int[] bandage2 = {3, 2, 7};
        int health2 = 20;
        int[][] attacks2 = {{1, 15}, {5, 16}, {8,6}};
        System.out.println(sol.solution(bandage2, health2, attacks2));
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");

        int[] bandage3 = {4, 2, 7};
        int health3 = 20;
        int[][] attacks3 = {{1, 15}, {5, 16}, {8,6}};
        System.out.println(sol.solution(bandage3, health3, attacks3));
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");

        int[] bandage4 = {1, 1, 1};
        int health4 = 5;
        int[][] attacks4 = {{1,2}, {3,2}};
        System.out.println(sol.solution(bandage4, health4, attacks4));
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
    }
}
