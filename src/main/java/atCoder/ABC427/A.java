package atCoder.ABC427;

import java.util.Scanner;

class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String S = sc.next();
        int length = S.length();
        int middle = length / 2;

        for (int i = 0; i < length; i++) {
            if (i == middle) {
                continue;
            } else {
                System.out.print(S.charAt(i));
            }
        }

        System.out.println();

        sc.close();
    }
}
