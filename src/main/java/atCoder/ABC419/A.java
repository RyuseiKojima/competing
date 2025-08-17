package atCoder.ABC419;

import java.util.Scanner;

class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String S = sc.next();

        sc.close();

        String red = "red";
        String blue = "blue";
        String green = "green";

        if (S.equals(red)) {
            System.out.println("SSS");
        } else if (S.equals(blue)) {
            System.out.println("FFF");
        } else if (S.equals(green)) {
            System.out.println("MMM");
        } else {
            System.out.println("Unknown");
        }
    }
}
