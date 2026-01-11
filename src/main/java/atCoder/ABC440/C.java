package atCoder.ABC440;

import java.util.*;

class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // テストケース数

        while (T-- > 0) {
            int N = sc.nextInt(), W = sc.nextInt(); // N: マスの数, W: 選ぶマスの数
            int M = 2 * W; // 周期性を扱うための配列サイズ（2W個の余りパターン）
            long[] b = new long[M]; // 各余りグループのコストの合計を保存

            // 各マスのコストをその余り（i % M）に基づいてグループ化
            // 同じ余りを持つマスは同じグループに属する
            for (int i = 1; i <= N; i++) b[i % M] += sc.nextLong();

            // 初期ウィンドウ: 余り0からW-1までのW個のグループを選択
            long sum = 0;
            for (int i = 0; i < W; i++) sum += b[i];

            long ans = sum; // 最小コストの初期値
            
            // スライディングウィンドウで全ての開始位置を試す
            // 開始位置sを1からM-1まで変化させ、連続するW個のグループを選択
            for (int s = 1; s < M; s++) {
                sum -= b[s - 1];             // 左端のグループを除外
                sum += b[(s + W - 1) % M];   // 右端のグループを追加
                ans = Math.min(ans, sum);    // 最小値を更新
            }

            System.out.println(ans); // 最小コストを出力
        }

        sc.close();
    }
}