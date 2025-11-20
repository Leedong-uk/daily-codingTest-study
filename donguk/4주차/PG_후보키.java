package donguk.week02;

import java.util.*;

public class PG_후보키 {
    int n;
    int m;
    int answer;
    ArrayList<ArrayList<Integer>> subsets ;
    ArrayList<ArrayList<Integer>> candidates;

    public int soulution(String[][] relation) {
        int answer = 0;
        n = relation.length;
        m = relation[0].length;
        subsets = new ArrayList<>();
        candidates = new ArrayList<>();

        int[] a = new int[m];
        for (int i = 0; i < m; i++) {
            a[i] = i;
        }

        subs(a, 0, new ArrayList<>());
        System.out.println("subsets = " + subsets);

        for (ArrayList sub : subsets) {
            boolean flag = check(sub,relation);
            if(flag) answer++;
        }


        return answer;
    }

    public boolean check (ArrayList<Integer> nums, String[][] relation) {

        // 최소성 check
        /*
        candidate = [ [1,2] , [0,2] , [1,2,3]]
        now = [1]
        이 case 는 고려할 필요가 없음 sub 에 애초에 작은것 부터 되어있음

        candidate = [[1] [0,3]]
        now = [1,2]
         */
        Set<Integer> now = new HashSet<>(nums);
        for (ArrayList key : candidates) {
            if(now.containsAll(key)) return false;
        }

        Set<String> set = new HashSet<>();
        //유일성 check
        /*
         이건 유일성 체크 num 의 조합에 따라 string 을 만들어서
         임시 set 에 넣어두고 set의 크기가 배열의 크기와 같아지면 유일성이 보장된다 (중복이 없다는뜻) (중복이 있으면 set의 크기가 더 작게 나온다 )
         */
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for(int num : nums) {
                sb.append(relation[i][num]);
            }
            set.add(sb.toString());
        }

        if(set.size() != n) return false;
        candidates.add((ArrayList<Integer>) now);
        return true;

    }

    public void subs(int[] a, int cnt, ArrayList<Integer> current) {
        if (cnt == m) {
            if (!current.isEmpty()) {
                subsets.add(new ArrayList<>(current));
            }
            return;
        }
        subs(a, cnt + 1, current);
        current.add(a[cnt]);
        subs(a, cnt + 1, current);
        current.remove(current.size() - 1);
    }

    public static void main(String[] args) {
        PG_후보키 test = new PG_후보키();
        String[][] relation = {{"100", "ryan", "music", "2"}, {"200", "apeach", "math", "2"}, {"300", "tube", "computer", "3"}, {"400", "con", "computer", "4"}, {"500", "muzi", "music", "3"}, {"600", "apeach", "music", "2"}};
        System.out.println("test.soulution(relation) = " + test.soulution(relation));
    }
}
