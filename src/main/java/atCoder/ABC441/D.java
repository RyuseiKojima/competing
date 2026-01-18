package atCoder.ABC441;

import java.util.*;

class D {
	static ArrayList<Edge>[] list;  // 隣接リスト（有向グラフ）
	static int l;  // 移動回数
	static int s;  // コストの下限
	static int t;  // コストの上限
	static TreeSet<Integer> ans;  // 条件を満たす頂点の集合（重複排除＆昇順）

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();  // 頂点数
		int m = sc.nextInt();  // 辺数
		l = sc.nextInt();  // 移動回数
		s = sc.nextInt();  // コスト下限
		t = sc.nextInt();  // コスト上限
		ans = new TreeSet<>();

		// グラフの初期化
		list = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			list[i] = new ArrayList<>();
		}
		
		// 辺の情報を読み込み（1-indexedを0-indexedに変換）
		for (int i = 0; i < m; i++) {
			int u = sc.nextInt()-1;  // 始点
			int v = sc.nextInt()-1;  // 終点
			int c = sc.nextInt();    // コスト
			list[u].add(new Edge(v,c));
		}

		// 頂点0（入力では頂点1）からDFSで全探索
		dfs(0,0,0);
		
		// 条件を満たす頂点を昇順に出力（0-indexedを1-indexedに戻す）
		for(Integer it: ans) {
			System.out.println(it+1);
		}
		System.out.println();
        sc.close();
    }

	// 深さ優先探索
	// d: 現在の移動回数, cur: 現在の頂点, cost: これまでのコストの合計
	static void dfs(int d, int cur, long cost) {
		// ちょうどL回移動した時
		if(d == l) {
			// コストがS以上T以下なら、その頂点を答えに追加
			if(cost >= s && cost <= t) {
				ans.add(cur);
			}
			return;
		}

		// 現在の頂点から出ている全ての辺を探索
		for(Edge e: list[cur]) {
			dfs(d+1, e.to, cost+e.weight);
		}
	}

	static class Edge {
		int to;
		int weight;
		Edge(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}
}