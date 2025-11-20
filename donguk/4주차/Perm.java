package donguk.week02;

import java.util.Arrays;

public class Perm {
    static int N = 4  , R = 3 , C = 0 ;
    int[] a = {1, 2, 3, 4};
    int[] b = new int[R];
    boolean [] visited =  new boolean[N];
    public void perm(int cnt ) {
        if (cnt == R) {
            System.out.println(Arrays.toString(b));
            C++;
            return;
        }
        for (int i = 0; i < N; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            b[cnt] = a[i];
            perm(cnt + 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        Perm test = new Perm();
        test.perm(0);
        System.out.println("C = " + C);
    }
}
