package atCoder.ABC421;

import java.util.Scanner;

class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        char[][] S = new char[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            String line = sc.next();
            for (int j = 1; j <= M; j++) {
                S[i][j] = line.charAt(j - 1);
            }
        }

        sc.close();

        int[] point = new int[N + 1];
        int max = 0;

        for (int i = 1; i <= M; i++) {
            int x_count = 0;
            for (int j = 1; j <= N; j++) {
                if (S[j][i] == '1') {
                    x_count++;
                }
            }
            if (x_count == 0 || x_count == N) continue;

            for (int j = 1; j <= N; j++) {
                if (S[j][i] == '1' && x_count <= N / 2 || S[j][i] == '0' && x_count > N / 2) {
                    point[j]++;
                    max = Math.max(max, point[j]);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (point[i] == max) {
                System.out.print(i + " ");
            }
        }

        System.out.println();
    }
}
