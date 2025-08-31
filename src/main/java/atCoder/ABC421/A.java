package atCoder.ABC421;

import java.util.Scanner;

class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        String[] S = new String[N + 1];
        for (int i = 1; i <= N; i++) {
            S[i] = sc.next();
        }

        int X = sc.nextInt();
        String Y = sc.next();

        System.out.println(S[X].equals(Y) ? "Yes" : "No");

        sc.close();
    }
}
