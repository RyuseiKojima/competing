package atCoder.ABC420;

import java.util.Scanner;

class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int X = sc.nextInt();
        int Y = sc.nextInt();

        System.out.println(X + Y > 12 ? X + Y - 12 : X + Y);

        sc.close();
    }
}
