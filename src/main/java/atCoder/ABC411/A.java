package atCoder.ABC411;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        int l = sc.nextInt();

        System.out.println(s.length() >= l ? "Yes" : "No");

        sc.close();
    }
}
