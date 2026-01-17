package atCoder.ABC441;

import java.util.*;

class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        String S = sc.next();
        String T = sc.next();
        int Q = sc.nextInt();

        for (int i = 0; i < Q; i++) {
            String w = sc.next();

            boolean isTakahashi = true;
            boolean isAoki = true;
            for (char c : w.toCharArray()) {
                boolean hasTakahashi = false;
                boolean hasAoki = false;
                for (int j = 0; j < N; j++) {
                    if (S.charAt(j) == c) {
                        hasTakahashi = true;
                        break;
                    }
                }
                for (int j = 0; j < M; j++) {
                    if (T.charAt(j) == c) {
                        hasAoki = true;
                        break;
                    }
                }
                if (!hasTakahashi) isTakahashi = false;
                if (!hasAoki) isAoki = false;
            }

            if (isTakahashi && !isAoki) {
                System.out.println("Takahashi");
            } else if (!isTakahashi && isAoki) {
                System.out.println("Aoki");
            } else {
                System.out.println("Unknown");
            }

        }

        sc.close();
    }
}
