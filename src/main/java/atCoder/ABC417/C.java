package atCoder.ABC417;
import java.util.*;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 入力
        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        sc.close();

        // Ai + i の度数分布を作成
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int key = A[i] + i;
            // 度数分布に値を追加
            freq.put(key, freq.getOrDefault(key, 0) + 1);
        }

        // j - A[j] の登場回数の総和を計算
        long result = 0;
        for (int j = 0; j < N; j++) {
            int key = j - A[j];
            // 度数分布から対応する値を取得し、結果に加算
            result += freq.getOrDefault(key, 0);
        }

        // 出力
        System.out.println(result);

        sc.close();
    }
}
