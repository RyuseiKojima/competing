package atCoder.ABC406;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        sc.close();

        if (a > c) {
            System.out.println("Yes");
        } else if (c > a) {
            System.out.println("No");
        } else if (b > d) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
