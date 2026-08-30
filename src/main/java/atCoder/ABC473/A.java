package atCoder.ABC473;

import java.util.*;

class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int sum = 0;
        int A = 0;
        for (int i = 0; i < N; i++) {
            A = sc.nextInt();
            if (i >= N / 2) sum += A;
        }
        System.out.println(sum);
        sc.close();
    }
}
