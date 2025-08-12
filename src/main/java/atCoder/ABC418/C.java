package atCoder.ABC418;
import java.util.*;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 入力
        int N = sc.nextInt(), Q = sc.nextInt();
        int[] A = new int[N];
        int A_Max = 0;
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
            A_Max = Math.max(A_Max, A[i]);
        }
        int[] B = new int[Q];
        for (int i = 0; i < Q; i++) B[i] = sc.nextInt();

        int[] count_minus = new int[A_Max + 2];
        for (int a : A) count_minus[a + 1]--;

        long[] X = new long[A_Max + 1];
        int curCount = N; // C[1] の値
        X[1] = 1;
        for (int i = 2; i <= A_Max; i++) {
            X[i] = X[i - 1] + curCount;
            curCount += count_minus[i];
        }

        for (int b : B) System.out.println(b > A_Max ? -1 : X[b]);

        sc.close();
    }
}
