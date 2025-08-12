package atCoder.ABC418;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String S = sc.next();
        sc.close();

        if (N < 3) {
            System.out.println("No");
            return;
        }

        if (S.charAt(N - 3) == 't' && S.charAt(N - 2) == 'e' && S.charAt(N - 1) == 'a') {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
