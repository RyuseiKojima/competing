package atCoder.ABC438;

import java.util.Scanner;

class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int D = sc.nextInt();
        int F = sc.nextInt();

        while (F <= D) {
            F += 7;
        }
        System.out.println(F - D);
        sc.close();
    }
}
