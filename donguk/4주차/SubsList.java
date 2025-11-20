package donguk.week02;

import java.util.ArrayList;

public class SubsList {
    static int N = 4, C = 0 ;
    int[] a = {1, 2, 3, 4};

    public void subsList(int cnt , ArrayList<Integer> list) {

        if (cnt == N) {
            System.out.println(list);
            C++;
            return;
        }

        subsList(cnt+1, list);
        list.add(a[cnt]);
        subsList(cnt + 1, list);
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        SubsList test = new SubsList();
        test.subsList(0, new ArrayList<>());
        System.out.println(C);
    }
}
