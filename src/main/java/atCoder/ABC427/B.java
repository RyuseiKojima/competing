package atCoder.ABC427;

import java.util.Scanner;

class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] A = new int[N + 1];

        A[0] = 1;
        A[1] = 1;

        for (int i = 2; i <= N; i++) {
            int before = A[i - 1];
            int add = 0;
            while (before > 0) {
                int mod = before % 10;
                add += mod;
                before /= 10;
            }
            A[i] = A[i - 1] + add;
        }

        System.out.println(A[N]);
        sc.close();
    }
}
