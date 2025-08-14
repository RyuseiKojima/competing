package atCoder.ABC412;
import java.util.*;

class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int count = 0;
        for (int i = 0; i < N; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            if (A < B) {
                count++;
            }
        }

        System.out.println(count);
        sc.close();
    }
}
