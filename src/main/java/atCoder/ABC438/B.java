package atCoder.ABC438;

import java.util.Scanner;

class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        String A = sc.next();
        String B = sc.next();

        int[] S = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            S[i] = A.charAt(N - i) - '0';
        }

        int[] T = new int[M + 1];
        for (int i = 1; i <= M; i++) {
            T[i] = B.charAt(M - i) - '0';
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= N - M + 1; i++) {
            int count = 0;
            int target = i;
            for (int j = 1; j <= M; j++) {
                int SDigit = S[target];
                int TDigit = T[j];
                while (SDigit != TDigit) {
                    TDigit = (TDigit + 1) % 10;
                    count++;
                }
                target++;
            }
            min = Math.min(min, count);
        }

        System.out.println(min);

        sc.close();
    }
}
