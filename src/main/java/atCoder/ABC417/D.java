package atCoder.ABC417;
import java.util.*;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] P = new int[N][3];
        for (int i = 0; i < N; i++) {
            P[i][0] = sc.nextInt(); // p（プレゼントの価値）
            P[i][1] = sc.nextInt(); // a（テンション上げ度）
            P[i][2] = sc.nextInt(); // b（テンション下げ度）
        }

        int M = 0;
        for (int[] gift : P) {
            // プレゼントの価値とテンション上げ度の合計を計算し、最大値を求める
            M = Math.max(M, gift[0] + gift[1]);
        }

        // dp[i][j]は、i番目のプレゼントまで選んだときにテンションがjのときの最終的なテンションを表す
        int[][] dp = new int[N + 1][M + 1];

        // 全てのプレゼントを受け取ったときのテンション
        for (int j = 0; j <= M; j++) dp[N][j] = j;

        for (int i = N - 1; i >= 0; i--) {
            int p = P[i][0];
            int a = P[i][1];
            int b = P[i][2];
            for (int j = 0; j <= M; j++) {
                // テンションがプレゼントの価値以下の場合
                if (j <= p) {
                    // 現在のテンションにテンション上げ度を加え、テンションが最大値を超えないようにする
                    if (j + a <= M)
                        dp[i][j] = dp[i + 1][j + a];
                    else
                        dp[i][j] = j + a;
                } else {
                    // テンションがプレゼントの価値を超える場合
                    // 現在のテンションからテンション下げ度を引き、次のプレゼントを考慮する
                    dp[i][j] = dp[i + 1][j - Math.min(j, b)];
                }
            }
        }

        // テンション下げ度の累積和を計算
        int[] sumB = new int[N];
        sumB[0] = P[0][2];
        for (int i = 1; i < N; i++) {
            sumB[i] = sumB[i - 1] + P[i][2];
        }

        int Q = sc.nextInt();
        for (int i = 0; i < Q; i++) {
            int x = sc.nextInt();
            System.out.println(access(dp, sumB, x, N, M));
        }
        sc.close();
    }

    /**
     * アクセス関数
     * @param dp // dpテーブル
     * @param sumB // テンション下げ度の累積和
     * @param x // クエリの値
     * @param N // プレゼントの数
     * @param M // テンションの最大値
     * @return
     */
    static int access(int[][] dp, int[] sumB, int x, int N, int M) {
        if (x <= M) return dp[0][x];

        int idx = lowerBound(sumB, x - M);
        if (idx == sumB.length) return x - sumB[sumB.length - 1];

        return dp[idx + 1][x - Math.min(x, sumB[idx])];
    }

    static int lowerBound(int[] arr, int target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] < target) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}
