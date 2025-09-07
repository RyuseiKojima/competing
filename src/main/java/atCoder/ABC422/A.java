package atCoder.ABC422;

import java.util.Scanner;

class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String S = sc.next();

        int a = S.charAt(0) - '0';
        int b = S.charAt(2) - '0';

        if (b == 8) {
            System.out.println((a + 1) + "-" + 1);
        } else {
            System.out.println(a + "-" + (b + 1));
        }

        sc.close();
    }
}
