package atCoder.ABC423;

import java.util.Scanner;

class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int X = sc.nextInt();
        int C = sc.nextInt();

        int ans = 0;
        int mult = 1;
        while (true) {
            int set = 1000 * mult;

            if ((set / 1000 * C) + set > X) break;

            ans = set;
            mult++;
        }

        System.out.println(ans);

        sc.close();
    }
}
