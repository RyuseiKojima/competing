package atCoder.ABC408;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] ts = new int[n];
        boolean flg = true;

        for (int i = 0; i < n; i++) ts[i] = sc.nextInt();

        sc.close();

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                if (ts[i] > s) {
                    flg = false;
                    break;
                }
            } else {
                if (ts[i] - ts[i-1] > s) {
                    flg = false;
                    break;
                }
            }
        }
        if (flg) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
