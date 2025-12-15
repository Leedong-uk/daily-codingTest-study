package donguk.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_22251 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String line = bf.readLine();
            if(line.equals("end")) break;

            boolean oWin, xWin;
            int xCount = 0 , oCount = 0;
            char[][] test = new char[3][3];

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    char tmp = line.charAt(i * 3 + j);
                    test[i][j] = tmp;

                    if(tmp == 'X') xCount++;
                    else if (tmp =='O') oCount++;
                }
            }

//            System.out.println(Arrays.deepToString(test));

            // 1. x가 이겼는지 o가 이겼는지 계산
            oWin = calculateWin(test, 'O');
            xWin = calculateWin(test, 'X');

//            System.out.println("oWin = " + oWin);
//            System.out.println("xWin = " + xWin);

            // 2. 둘다 이긴경우
            if(xWin && oWin) System.out.println("invalid");

            //3. x만 이긴 경우
            else if (xWin) {
                if (xCount - oCount == 1) System.out.println("valid");
                else System.out.println("invalid");
            }

            //4. O만 이긴 경우
            else if (oWin) {
                if(xCount-oCount == 0) System.out.println("valid");
                else System.out.println("invalid");
            }
            //5. 둘다 안이긴 경우
            else{
                if(xCount == 5 & oCount == 4) System.out.println("valid");
                else System.out.println("invalid");
            }


        }
    }
    
    static boolean calculateWin(char[][] test , char target) {
        for (int i = 0; i < 3; i++) {
            if(test[i][0] == target && test[i][1] == target && test[i][2]==target) return true;
        }

        for (int i = 0; i < 3; i++) {
            if(test[0][i]== target && test[1][i] == target && test[2][i]==target) return true;
        }
        
        if(test[0][0] == target && test[1][1]==target && test[2][2]== target) return true;
        
        if(test[0][2] == target && test[1][1] == target && test[2][0] == target) return true;
        return false;
    }
}
