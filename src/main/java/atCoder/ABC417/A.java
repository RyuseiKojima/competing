package atCoder.ABC417;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();

        String s = sc.next();

        String result = s.substring(a, n - b);

        System.out.println(result);
        sc.close();
    }
}
