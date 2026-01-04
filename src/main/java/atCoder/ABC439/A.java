package atCoder.ABC439;

import java.util.Scanner;

class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        System.out.println((int)Math.pow(2, N) - 2 * N);

        sc.close();
    }
}
