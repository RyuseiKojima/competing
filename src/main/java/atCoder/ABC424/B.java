package atCoder.ABC424;

import java.util.Scanner;

class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        int[] ansCount = new int[N + 1];

        for (int i = 0; i < K; i++) {
            int A = sc.nextInt();
            sc.nextInt();
            ansCount[A]++;

            if (ansCount[A] == M) {
                System.out.print(A + " ");
            }
        }
        System.out.println();

        sc.close();
    }
}
