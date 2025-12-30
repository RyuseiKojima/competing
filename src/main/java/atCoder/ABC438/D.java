package atCoder.ABC438;

import java.util.*;

class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        long INF = 1000000000000000010L;
        
        int n = sc.nextInt();
        long[] a = new long[n];
        long[] b = new long[n];
        long[] c = new long[n];
        
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
        }
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextLong();
        }
        for (int i = 0; i < n; i++) {
            c[i] = sc.nextLong();
        }
        
        // dp[n+1][4]の2次元配列
        long[][] dp = new long[n + 1][4];
        
        // 全ての要素を-INFで初期化
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 4; j++) {
                dp[i][j] = -INF;
            }
        }
        
        dp[0][0] = 0;
        
        for (int i = 0; i < n; i++) {
            // a[i]を選ぶ場合
            for (int j = 0; j <= 1; j++) {
                dp[i + 1][1] = Math.max(dp[i + 1][1], dp[i][j] + a[i]);
            }
            // b[i]を選ぶ場合
            for (int j = 1; j <= 2; j++) {
                dp[i + 1][2] = Math.max(dp[i + 1][2], dp[i][j] + b[i]);
            }
            // c[i]を選ぶ場合
            for (int j = 2; j <= 3; j++) {
                dp[i + 1][3] = Math.max(dp[i + 1][3], dp[i][j] + c[i]);
            }
        }
        
        System.out.println(dp[n][3]);
        sc.close();
    }
}