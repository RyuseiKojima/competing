package atCoder.ABC440;

import java.util.Scanner;

class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int X = sc.nextInt();
        int Y = sc.nextInt();

        for (int i = 0; i < Y; i++) {
            X *= 2;
        }
        System.out.println(X);
        sc.close();
    }
}
