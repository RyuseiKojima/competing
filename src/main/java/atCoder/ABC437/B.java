package atCoder.ABC437;

import java.util.Scanner;

class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int H = sc.nextInt();
        int W = sc.nextInt();
        int N = sc.nextInt();

        int[][] A = new int[H + 1][W + 1];

        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= W; j++) {
                A[i][j] = sc.nextInt();
            }
        }

        int[] B = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            B[i] = sc.nextInt();
        }

        int ans = 0;
        for (int i = 1; i <= H; i++) {
            int cnt = 0;
            for (int j = 1; j <= W; j++) {
                for (int k = 1; k <= N; k++) {
                    if (A[i][j] == B[k]) {
                        cnt++;
                    }
                }
            }
            ans = Math.max(ans, cnt);
        }

        System.out.println(ans);

        sc.close();
    }
}
