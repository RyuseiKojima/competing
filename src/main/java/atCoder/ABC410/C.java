package atCoder.ABC410;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] numbers = new int[n+1];
        int point = 1;
        for (int i = 1; i <= n; i++) {
            numbers[i] = i;
        }
        for (int i = 0; i < q; i++) {
            int type = sc.nextInt();
            if (type == 1 || type == 2) {
                int p = sc.nextInt();
                if (p <= n - (point - 1)) {
                    p += point - 1;
                } else {
                    p -= n - (point - 1);
                }
                if (type == 1) {
                    int x = sc.nextInt();
                    numbers[p] = x;
                } else {
                    System.out.println(numbers[p]);
                }
            } else {
                int k = sc.nextInt();
                k %= n;
                if (point + k <= n) {
                    point += k;
                } else {
                    point += k - n;
                }
            }
        }
        sc.close();
    }
}
