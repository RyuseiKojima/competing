package atCoder.ABC416;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextInt();
        int L = sc.nextInt();
        int R = sc.nextInt();
        String S = sc.next();
        boolean flg = true;

        for (int i = L; i <= R; i++) {
            if (S.charAt(i - 1) != 'o') {
                flg = false;
                break;
            }
        }

        if (flg) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        sc.close();
    }
}
