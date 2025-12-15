package donguk.추가공부;

import java.util.ArrayList;
import java.util.Arrays;

public class Pratice3 {
    static int N ,R , C;
    static int[] a;
    static int[] b;
    static boolean[] visited;
    public static void main(String[] args) {
        N= 4; R = 3; C = 0;
        a = new int[]{1, 2, 3, 4};
        b = new int[R];
        visited = new boolean[N];

//        perm(0);
//        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
//        comb(0, 0);
//        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
//        subs(0, "");
//        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
//        subsList(0,new ArrayList<>());

    }

//    static void perm(int cnt) {
//        if (cnt == R) {
//            System.out.println(Arrays.toString(b));
//            return;
//        }
//
//        for (int i = 0; i < N; i++) {
//            if(visited[i]) continue;
//            visited[i] = true;
//            b[cnt] = a[i];
//            perm(cnt + 1);
//            visited[i] = false;
//        }
//    }
//
//
//    static void comb(int cnt, int start) {
//        if (cnt == R) {
//            System.out.println(Arrays.toString(b));
//            return;
//        }
//
//        for (int i = start; i < N; i++) {
//            b[cnt] = a[i];
//            comb(cnt + 1, i + 1);
//        }
//    }
//
//    static void subs(int cnt , String str) {
//        if (cnt == N) {
//            System.out.println(str);
//            return;
//        }
//
//            subs(cnt + 1, str);
//            subs(cnt + 1, str + a[cnt]);
//
//    }
//
//    static void subsList(int cnt , ArrayList<Integer> list) {
//        if (cnt == N) {
//            System.out.println(list);
//            return;
//        }
//
//        subsList(cnt + 1, list);
//        list.add(a[cnt]);
//        subsList(cnt + 1, list);
//        list.remove(list.size() - 1);
//    }
}
