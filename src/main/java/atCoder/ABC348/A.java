package atCoder.ABC348;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if ((i+1) % 3 == 0) {
                sb.append('x');
            } else {
                sb.append('o');
            }
        }
        System.out.println(sb.toString());
        sc.close();
    }
}
