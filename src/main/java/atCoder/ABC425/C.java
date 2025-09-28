package atCoder.ABC425;

import java.util.*;

class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int Q = sc.nextInt();

        int[] A = new int[N + 1];
        long[] Sum = new long[2 * N + 1];

        for (int i = 1; i <= N; i++) {
            A[i] = sc.nextInt();
            Sum[i] = Sum[i - 1] + A[i];
        }
        for (int i = N + 1; i <= 2 * N; i++) {
            Sum[i] = Sum[i - 1] + A[i - N];
        }

        int offset = 1; // 配列のオフセット

        for (int i = 0; i < Q; i++) {
            int queryType = sc.nextInt();
            if (queryType == 1) {
                int c = sc.nextInt();
                offset += c;
                if (offset > N) {
                    offset -= N;
                }
            } else {
                int L = sc.nextInt() + offset - 1;
                int R = sc.nextInt() + offset - 1;
                System.out.println(Sum[R] - Sum[L - 1]);
            }
        }

        sc.close();
    }
}