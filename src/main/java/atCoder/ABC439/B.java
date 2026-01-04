package atCoder.ABC439;

import java.util.HashSet;
import java.util.Scanner;

class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashSet<Integer> set = new HashSet<>();
        int N = sc.nextInt();
        while (true) {
            set.add(N);
            int next = 0;
            while (N > 0) {
                int digit = N % 10;
                N /= 10;
                next += (int) Math.pow(digit, 2);
            }
            if (next == 1) {
                System.out.println("Yes");
                break;
            }
            if (set.contains(next)) {
                System.out.println("No");
                break;
            }
            N = next;
        }

        sc.close();
    }
}
