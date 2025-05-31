package atCoder.ABC406;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        long maxVal = 1L;
        for (int i = 0; i < k; i++) {
            maxVal *= 10;
        }
        maxVal--;
        long ans = 1L;

        for (int i = 0; i < n; i++) {
            long a = sc.nextLong();
            if (maxVal / a < ans) {
                ans = 1L;
            } else {
                ans *= a;
            }
        }

        sc.close();
        System.out.println(ans);
    }
}
