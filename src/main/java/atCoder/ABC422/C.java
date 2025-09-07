package atCoder.ABC422;

import java.util.Scanner;

class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int Q = sc.nextInt();

        for (int q = 0; q < Q; q++) {
            long A = sc.nextLong();
            long B = sc.nextLong();
            long C = sc.nextLong();

            long base = Math.min(A, C);
			long min = (A + B + C) / 3;
            System.out.println(Math.min(base, min));
        }

        sc.close();
    }
}
