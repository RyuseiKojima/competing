package atCoder.ABC407;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        sc.close();

        double cnt = 0;
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                if (i + j >= x || Math.abs(i - j) >= y) cnt++;
            }
        }
        if (cnt == 0) {
            System.out.println(0);
        } else {
            System.out.println(cnt / 36.0);
        }
    }
}
