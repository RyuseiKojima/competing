package atCoder.ABC437;

import java.util.*;

class D {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();  // 配列aの要素数
		int m = sc.nextInt();  // 配列bの要素数
		
		// 配列aの入力
		long[] a = new long[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextLong();
		}
		
		// 配列bの入力
		long[] b = new long[m];
		for (int i = 0; i < m; i++) {
			b[i] = sc.nextLong();
		}
		
		// 配列aをソート（二分探索のため）
		Arrays.sort(a);
		
		// 配列aの累積和を計算（modをとりながら）
		long[] sum = new long[n + 1];
		int p = 998244353;  // modの値
		for (int i = 0; i < n; i++) {
			sum[i + 1] = sum[i] + a[i];
			sum[i + 1] %= p;
		}
		
		// 答えを計算
		long ans = 0;
		for (int i = 0; i < m; i++) {
			// 配列a内でb[i]以下の要素がいくつあるかを二分探索で求める
			int j = Arrays.binarySearch(a, b[i]);
			if (j < 0) {
				// b[i]が配列a内に存在しない場合、挿入位置を取得
				j = -j - 1;
			}
			
			// b[i]より小さい要素について、|b[i] - a[k]|の総和を計算
            // = (b[i] - a[0]) + (b[i] - a[1]) + ... + (b[i] - a[j-1])
            // = b[i] * j - (a[0] + a[1] + ... + a[j-1])
			// = b[i] * j - sum[j]
			long x = (b[i] * j - sum[j]) % p;
			
			// b[i]以上の要素について、|b[i] - a[k]|の総和を計算
            // = (a[j] - b[i]) + (a[j+1] - b[i]) + ... + (a[n-1] - b[i])
            // = (a[j] + a[j+1] + ... + a[n-1]) - b[i] * (n - j)
			// = (sum[n] - sum[j]) - b[i] * (n - j)
			long y = ((sum[n] - sum[j]) - (b[i] * (n - j))) % p;
			
			// 各クエリの結果を合計
			ans += (x + y) % p;
			ans %= p;
		}
		
		// 負の値になる可能性があるためpを加算してからmodをとる
		ans += p;
		ans %= p;
		
		System.out.println(ans);

		sc.close();
	}
}