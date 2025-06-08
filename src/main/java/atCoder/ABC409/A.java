package atCoder.ABC409;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String a = sc.next();
        String b = sc.next();
        boolean flg = false;
        for (int i = 0; i < n; i++) {
            if (a.charAt(i) == 'o' && b.charAt(i) == 'o') {
                flg = true;
                break;
            }
        }
        System.out.println(flg ? "Yes" : "No");
        sc.close();
    }
}
