package atCoder.ABC409;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] set = new int[n+1];

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            int lim = Math.min(num, n);
            for (int j = 0; j <= lim; j++) {
                set[j]++;
            }
        }

        int max = 0;

        for (int i = 1; i <= n; i++) {
            if (set[i] >= i) max = Math.max(max, i);
        }
        System.out.println(max);
        sc.close();
    }
}
