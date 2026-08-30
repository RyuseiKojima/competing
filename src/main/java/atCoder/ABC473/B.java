package atCoder.ABC473;

import java.util.*;

class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int sum = 0;
        int[] counts = new int[101];
        for (int i = 0; i < N; i++) {
            int A = sc.nextInt();
            counts[A]++;
        }

        for (int i = 1; i <= 100; i++) {
            if (counts[i] % 2 > 0) sum += i;
        }

        System.out.println(sum);

        sc.close();
    }
}
