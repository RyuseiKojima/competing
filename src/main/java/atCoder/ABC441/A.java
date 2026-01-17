package atCoder.ABC441;

import java.util.*;

class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int P = sc.nextInt();
        int Q = sc.nextInt();
        int X = sc.nextInt();
        int Y = sc.nextInt();

        System.out.println((X >= P && Y >= Q && X < P + 100 && Y < Q + 100) ? "Yes" : "No");
        sc.close();
    }
}
