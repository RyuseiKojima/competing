package atCoder.ABC411;
import java.util.*;

class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // マスの数
        int Q = sc.nextInt(); // クエリの数
        int[] A = new int[N + 2]; // 各マスの状態を表す配列
        int ans = 0;

        for (int q = 0; q < Q; q++) {
            int i = sc.nextInt();
            if (A[i - 1] == A[i + 1]) { // iの前後のマスが同じ状態ならば、iを反転したときに黒が連続する区間の数が変わる
                if (A[i - 1] == A[i]) { // iの前後のマスとiのマスが同じ状態ならば、iを反転したときに区間が1つ増える
                    ans += 1;
                } else { // iの前後のマスとiのマスが異なる状態ならば、iを反転したときに区間が1つ減る
                    ans -= 1;
                }
            }
            A[i] ^= 1; // iのマスを反転する
            System.out.println(ans);
        }

        sc.close();
    }
}