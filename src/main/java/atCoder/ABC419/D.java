package atCoder.ABC419;

import java.util.Scanner;

class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        String S = sc.next();
        String T = sc.next();

        int[] flg = new int[N + 1];
        for (int i = 0; i < M; i++) {
            int L = sc.nextInt() - 1;
            int R = sc.nextInt() - 1;

            flg[L] ^= 1;
            flg[R + 1] ^= 1;
        }

        sc.close();

        int position = 0;
        for (int i = 0; i < N; i++) {
            if (flg[i] == 1) {
                position ^= 1;
            }
            System.out.print(position == 0 ? S.charAt(i) : T.charAt(i));
        }
        System.out.println();
    }
}
