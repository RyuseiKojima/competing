package atCoder.ABC434;

import java.util.Scanner;

class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int W = sc.nextInt() * 1000;
        int H = sc.nextInt();

        int ans = 1;

        while (W >= ans * H) {
            ans++;
        }

        System.out.println(ans);

        sc.close();
    }
}
