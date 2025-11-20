package donguk.week02;

import java.util.Arrays;

public class Comb {
    static int N = 4, R = 3, C = 0;
    int[] a = {1, 2, 3, 4};
    int[] b = new int[R];

    public void comb(int cnt, int start) {
        if (cnt == R) {
            System.out.println(Arrays.toString(b));
            C++;
            return;
        }
        for (int i = start; i < N ; i++) {
            b[cnt] = a[i];
            comb(cnt + 1, i + 1);
        }
    }

    public static void main(String[] args) {
        Comb test = new Comb();
        test.comb(0, 0);
        System.out.println(C);
    }
}
