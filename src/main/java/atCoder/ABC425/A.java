package atCoder.ABC425;

import java.util.Scanner;

class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        sc.close();

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            int num = i * i * i;
            if (i % 2 == 1) num *= -1;
            ans += num;
        }
        System.out.println(ans);
    }
}
