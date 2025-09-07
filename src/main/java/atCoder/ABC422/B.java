package atCoder.ABC422;

import java.util.Scanner;

class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int H = sc.nextInt();
        int W = sc.nextInt();

        char[][] C = new char[H+2][W+2];

        for (int i = 1; i <= H; i++) {
            String line = sc.next();
            for (int j = 1; j <= W; j++) {
                C[i][j] = line.charAt(j - 1);
            }
        }

        boolean flg = true;

        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= W; j++) {
                if (C[i][j] == '.') continue;
                int cnt = 0;
                if (C[i-1][j] == '#') cnt++;
                if (C[i+1][j] == '#') cnt++;
                if (C[i][j-1] == '#') cnt++;
                if (C[i][j+1] == '#') cnt++;
                if (!(cnt == 2 || cnt == 4)) {
                    flg = false;
                    break;
                }
            }
            if (!flg) break;
        }

        System.out.println(flg ? "Yes" : "No");

        sc.close();
    }
}
