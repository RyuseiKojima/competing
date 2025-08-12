package atCoder.ABC418;

import java.util.Scanner;

public class B {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String S = sc.next();
        sc.close();

        int N = S.length();

        double Answer = 0.00000000000;
        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 2; j < N; j++) {
                if (S.charAt(i) == 't' && S.charAt(j) == 't') {
                    int length = j - i + 1;
                    int count = 0;

                    for (int j2 = i; j2 <= j; j2++) {
                        if (S.charAt(j2) == 't') {
                            count++;
                        }
                    }
                    Answer = Math.max(Answer, (double) (count - 2) / (length - 2));
                }
            }
        }

        System.out.println(Answer);
    }
}
