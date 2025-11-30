package atCoder.ABC434;

import java.util.*;

class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 複数の雲から1つの雲を取り除いたときの空きマス数を求める問題
        
        // 2次元配列を初期化（2025x2025）
        int[][] a = new int[2025][2025]; // マスがいくつの雲に含まれるかのカウント用
        int[][] b = new int[2025][2025]; // 各マスがどの雲に含まれるかの重み付け用
        
        int n = sc.nextInt();
        
        // n個の雲領域を処理
        for (int k = 1; k <= n; k++) {
            int u = sc.nextInt();
            int d = sc.nextInt();
            int l = sc.nextInt();
            int r = sc.nextInt();
            
            // 雲の終端を1つ先に設定
            d++;
            r++;
            
            // いもす法：雲領域の累積和用の差分を設定
            a[u][l]++;
            a[u][r]--;
            a[d][l]--;
            a[d][r]++;
            
            // 雲番号kを重みとして同様に設定
            b[u][l] += k;
            b[u][r] -= k;
            b[d][l] -= k;
            b[d][r] += k;
        }
        
        // 横方向の累積和を計算
        for (int i = 0; i < 2025; i++) {
            for (int j = 0; j < 2025; j++) {
                if (j > 0) {
                    a[i][j] += a[i][j - 1];
                    b[i][j] += b[i][j - 1];
                }
            }
        }
        
        // 縦方向の累積和を計算
        for (int i = 0; i < 2025; i++) {
            for (int j = 0; j < 2025; j++) {
                if (i > 0) {
                    a[i][j] += a[i - 1][j];
                    b[i][j] += b[i - 1][j];
                }
            }
        }
        
        // 各雲ごとの結果をカウント
        int[] bk = new int[n + 1];
        for (int i = 1; i <= 2000; i++) {
            for (int j = 1; j <= 2000; j++) {
                if (a[i][j] == 0) {
                    // どの雲にも含まれないマス
                    bk[0]++;
                } else if (a[i][j] == 1) {
                    // 1つの雲のみに含まれるマス
                    bk[b[i][j]]++;
                }
            }
        }
        
        // 各雲について、それを除いた場合の空きマス数を出力
        for (int i = 1; i <= n; i++) {
            System.out.println(bk[0] + bk[i]);
        }
        
        sc.close();
    }
}