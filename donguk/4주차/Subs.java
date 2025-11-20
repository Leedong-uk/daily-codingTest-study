package donguk.week02;

public class Subs {
    static int N = 4 , C = 0;
    int[] a = {1, 2, 3, 4};

    public void subs(int cnt, String str) {
        if (cnt == N) {
            System.out.println(str);
            C++;
            return;
        }

        subs(cnt+1, str);
        subs(cnt + 1, str + a[cnt]);
    }

    public static void main(String[] args) {
        Subs test = new Subs();
        test.subs(0,"");
        System.out.println(C);
    }
}
