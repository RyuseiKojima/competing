package atCoder.ABC424;
import java.util.*;

class D {
	// 最小操作回数を記録するグローバル変数
	static int ans;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt(); // テストケース数
		
		// 各テストケースを処理
		for (int z = 0; z < t; z++) {
			int h = sc.nextInt(); // グリッドの高さ
			int w = sc.nextInt(); // グリッドの幅
			
			// グリッドを読み込み
			char[][] s = new char[h][w];
			for (int i = 0; i < h; i++) {
				s[i] = sc.next().toCharArray();
			}

			// 最小操作回数を初期化（十分大きな値）
			ans = 100;
			// DFSで最小操作回数を探索
			dfs(s, 0);
			System.out.println(ans);
		}
		sc.close();
	}

	/**
	 * 深さ優先探索で2x2ブロックを除去する最小操作回数を計算
	 * @param s グリッド（'#'と'.'で構成）
	 * @param cnt 現在の操作回数
	 */
	static void dfs(char[][] s, int cnt) {
		// 枝刈り：現在の操作回数が既知の最小値以上なら探索を打ち切り
		if (cnt >= ans) {
			return;
		}
		
		boolean flg = false; // 2x2ブロックが見つかったかのフラグ
		
		// グリッドを走査して2x2の'#'ブロックを探す
		label:
		for (int i = 1; i < s.length; i++) {
			for (int j = 1; j < s[i].length; j++) {
				// 2x2の'#'ブロックをチェック
				if (s[i - 1][j - 1] == '#' &&
						s[i - 1][j] == '#' &&
						s[i][j - 1] == '#' &&
						s[i][j] == '#') {
					flg = true;

					// 右下の'#'を'.'に変更して再帰探索
					s[i][j] = '.';
					dfs(s, cnt + 1);
					s[i][j] = '#'; // バックトラッキング

					// 右上の'#'を'.'に変更して再帰探索
					s[i - 1][j] = '.';
					dfs(s, cnt + 1);
					s[i - 1][j] = '#'; // バックトラッキング

					// 左下の'#'を'.'に変更して再帰探索
					s[i][j - 1] = '.';
					dfs(s, cnt + 1);
					s[i][j - 1] = '#'; // バックトラッキング
					
					// 最初に見つけた2x2ブロックのみ処理（探索順序の一意性のため）
					break label;
				}
			}
		}
		
		// 2x2ブロックが見つからない場合、最小操作回数を更新
		if (!flg) {
			ans = Math.min(ans, cnt);
		}
	}
}
