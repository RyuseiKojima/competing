import java.util.*;

/**
 * チートシート
 */
class Cheat {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// Stack<String> S = new Stack<>();
		// Queue<String> T = new LinkedList<>();
		// Queue<Integer> T2 = new PriorityQueue<>();
		// Map<String, Integer> scoreMap = new HashMap<>();
		// TreeSet<Integer> S2 = new TreeSet<>();

		// // スタート地点をキューに追加
		// cur[1] = 0;
		// Queue<State> Q = new PriorityQueue<>();
		// Q.add(new State(cur[1], 1));

		// // ダイクストラ法
		// while (Q.size() >= 1) {
		// 	// 次に確定させるべき頂点を求める
		// 	// （ここでは、優先度付きキュー Q の最小要素を取り出し、これを Q から削除する）
		// 	int pos = Q.remove().pos;

		// 	// Q の最小要素が「既に確定した頂点」の場合
		// 	if (kakutei[pos]) {
		// 		continue;
		// 	}

		// 	// cur[x] の値を更新する
		// 	kakutei[pos] = true;
		// 	for (int i = 0; i < G[pos].size(); i++) {
		// 		Edge e = G[pos].get(i);
		// 		if (cur[e.to] > cur[pos] + e.cost) {
		// 			cur[e.to] = cur[pos] + e.cost;
		// 			Q.add(new State(cur[e.to], e.to));
		// 		}
		// 	}
		// }

		sc.close();
	}

	static int N, X;
	static int[] A;

	/**
	 * 整数 x が何番目に存在するかを返す
	 * @param x 整数
	 * @return 整数 x の位置
	 */
	static int search(int x) {
		int L = 1, R = N;
		while (L <= R) { // 探索範囲がなくなるまで、比較を続ける
			int M = (L + R) / 2;
			if (x < A[M]) R = M - 1;
			if (x == A[M]) return M;
			if (x > A[M]) L = M + 1;
		}
		return -1; // 整数 x が存在しない（注：この問題の制約で -1 が返されることはない）
	}

	// a の b 乗を m で割った余りを返す関数
	// 変数 a は a^1 → a^2 → a^4 → a^8 → a^16 → ･･･ と変化
	static long Power(long a, long b, long m) {
		long p = a, Answer = 1;
		for (int i = 0; i < 60; i++) {
			long wari = (1L << i);
			if ((b / wari) % 2 == 1) {
				Answer = (Answer * p) % m; // 「a の 2i 乗」が掛けられるとき
			}
			p = (p * p) % m;
		}
		return Answer;
	}

	// a ÷ b を m で割った余りを返す関数
	static long Division(long a, long b, long m) {
		return (a * Power(b, m - 2, m)) % m;
	}

	// 二次元の点を扱うクラス Point2D
	static class Point2D {
		int x, y;
		public Point2D(int x, int y) {
			this.x = x;
			this.y = y;
		}
		// 2 点間の距離を求める関数
		double dist(Point2D p) {
			return Math.sqrt((x - p.x) * (x - p.x) + (y - p.y) * (y - p.y));
		}
	}

	// int 型のペアのクラス PairInt
	static class PairInt {
		int first, second;
		public PairInt(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}

	// 重み付きグラフの辺のクラス Edge
	static class Edge {
		int to, cost; // 行き先 to、長さ cost
		public Edge(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
	}

	// 文字列のハッシュを実装したクラス StringHash
	static class StringHash {
		static final int MOD = 2147483647;
		long[] power100;
		long[] h;
		StringHash(String S) {
			int N = S.length();
			// 文字列を数値に変換
			int[] T = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				T[i] = (int)(S.charAt(i - 1) - 'a') + 1;
			}
			// 100 の n 乗（本文中の B^0, B^1, ... に対応）を前計算する
			power100 = new long[N + 1];
			power100[0] = 1;
			for (int i = 1; i <= N; i++) {
				power100[i] = power100[i - 1] * 100 % MOD;
			}
			// H[1], H[2], ..., H[N] を前計算する
			h = new long[N + 1];
			h[0] = 1;
			for (int i = 1; i <= N; i++) {
				h[i] = (h[i - 1] * 100 + T[i]) % MOD;
			}
		}
		// S[l, r] のハッシュ値を返す関数
		// 余りの計算に注意！（5.3 節）
		long hashValue(int l, int r) {
			long val = h[r] - h[l - 1] * power100[r - l + 1] % MOD;
			if (val < 0) {
				val += MOD;
			}
			return val;
		}
	}

    // セグメント木 (min 取得用)
    static class SegmentTree {
        int size;
        long[] dat;
        long INF;

        SegmentTree(int n, long inf) {
            size = 1;
            this.INF = inf;
            while (size < n) size *= 2; // 2の累乗に拡張
            dat = new long[size * 2];
            Arrays.fill(dat, inf); // 初期値は INF
        }

        // 値の更新
        void update(int pos, long x) {
            pos += size - 1;
            dat[pos] = x;
            while (pos >= 2) {
                pos /= 2;
                dat[pos] = Math.min(dat[pos * 2], dat[pos * 2 + 1]);
            }
        }

        // 区間 [l, r) の最小値を取得
        long query(int l, int r, int a, int b, int u) {
            if (r <= a || b <= l) return INF; // 完全に外
            if (l <= a && b <= r) return dat[u]; // 完全に内
            int m = (a + b) / 2;
            long left = query(l, r, a, m, u * 2);
            long right = query(l, r, m, b, u * 2 + 1);
            return Math.min(left, right);
        }
    }

	static boolean[] visited; // 頂点 x が青色の場合、visited[x] = true
	static ArrayList<Integer>[] G;
	static void dfs(int pos) { // pos は現在位置
		visited[pos] = true;
		for (int i : G[pos]) {
			if (visited[i] == false) {
				dfs(i);
			}
		}
	}

	/**
	 * ダイクストラ法
	 * @param start 開始ノード
	 * @param G グラフ
	 * @param N ノード数
	 * @return 最短距離
	 */
    static int[] dijkstra(int start, List<Edge>[] G, int N) {
        final int INF = Integer.MAX_VALUE / 2;
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        boolean[] used = new boolean[N + 1];
        PriorityQueue<State> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.add(new State(0, start));
        while (!pq.isEmpty()) {
            State s = pq.poll();
            if (used[s.pos]) continue;
            used[s.pos] = true;
            for (Edge e : G[s.pos]) {
                if (dist[e.to] > dist[s.pos] + e.cost) {
                    dist[e.to] = dist[s.pos] + e.cost;
                    pq.add(new State(dist[e.to], e.to));
                }
            }
        }
        return dist;
    }

	// ダイクストラ法の (cur[x], x) を管理するクラス（cur[x] = dist, x = pos に対応）
	static class State implements Comparable<State> {
		int dist, pos;
		public State(int dist, int pos) {
			this.dist = dist;
			this.pos = pos;
		}
		@Override public int compareTo(State s) {
			// State 型同士の比較をする関数
			if (this.dist < s.dist) {
				return -1;
			}
			if (this.dist > s.dist) {
				return 1;
			}
			return 0;
		}
	}

	// Union-Find 木を実装したクラス UnionFind
	static class UnionFind {
		int n;
		int[] par;
		int[] size;

		// n 頂点の Union-Find を作成
		public UnionFind(int n) {
			this.n = n;
			par = new int[n + 1];
			size = new int[n + 1];
			Arrays.fill(par, -1); // 最初は親が無い (par[i] = -1)
			Arrays.fill(size, 1); // 最初はグループの頂点数が 1 (size[i] = 1)
		}

		// 頂点 x の根を返す関数
		int root(int x) {
			while (true) {
				if (par[x] == -1) {
					break;  // 1 個先（親）がなければ、ここが根
				}
				x = par[x]; // 1 個先（親）に進む
			}
			return x;
		}

		// 要素 u と v を統合する関数
		void unite(int u, int v) {
			int rootU = root(u);
			int rootV = root(v);
			if (rootU == rootV) {
				return; // u と v が同グループのときは処理を行わない
			}
			if (size[rootU] < size[rootV]) {
				par[rootU] = rootV;
				size[rootV] += size[rootU];
			}
			else {
				par[rootV] = rootU;
				size[rootU] += size[rootV];
			}
		}

		// 要素 u と v が同一のグループかどうかを返す関数
		boolean same(int u, int v) {
			return root(u) == root(v);
		}
	}

	// 最大フローを求める用の辺のクラス FlowEdge
	static class FlowEdge {
		int to, cap, rev;
		public FlowEdge(int to, int cap, int rev) {
			this.to = to;
			this.cap = cap;
			this.rev = rev;
		}
	}

	// 最大フローを行うクラス MaximumFlow
	static class MaximumFlow {
		int n;
		boolean[] used;
		ArrayList<FlowEdge>[] G;

		// 頂点数 N の残余グラフを準備
		public MaximumFlow(int n) {
			this.n = n;
			used = new boolean[n + 1];
			ArrayList<FlowEdge>[] G = new ArrayList[n + 1];
			for (int i = 1; i <= n; i++) {
				G[i] = new ArrayList<FlowEdge>();
			}
		}

		// 頂点 a から b に向かう、上限 c リットル／秒の辺を追加
		void addEdge(int a, int b, int c) {
			int currentGa = G[a].size();
			int currentGb = G[b].size();
			G[a].add(new FlowEdge(b, c, currentGb));
			G[b].add(new FlowEdge(a, 0, currentGa));
		}

		// 深さ優先探索（F はスタートから pos に到達する過程での " 残余グラフの辺の容量 " の最小値）
		// 返り値は流したフローの量（流せない場合は 0 を返す）
		int dfs(int pos, int goal, int F) {
			// ゴールに到着：フローを流せる！
			if (pos == goal) {
				return F;
			}
			used[pos] = true;
			// 探索する
			for (int i = 0; i < G[pos].size(); i++) {
				FlowEdge e = G[pos].get(i);
				// 容量 0 の辺は使えない
				if (e.cap == 0) {
					continue;
				}
				// 既に訪問した頂点に行っても意味がない
				if (used[e.to]) {
					continue;
				}
				// 目的地までのパスを探す
				int flow = dfs(e.to, goal, Math.min(F, e.cap));
				// フローを流せる場合、残余グラフの容量を flow だけ増減させる
				if (flow >= 1) {
					G[pos].get(i).cap -= flow;
					G[e.to].get(e.rev).cap += flow;
					return flow;
				}
			}
			// すべての辺を探索しても見つからなかった…
			return 0;
		}

		// 頂点 s から頂点 t までの最大フローの総流量を返す
		int maxFlow(int s, int t) {
			final int INF = 1000000000;
			int totalFlow = 0;
			while (true) {
				Arrays.fill(used, false);
				int f = dfs(s, t, INF);
				// フローを流せなくなったら操作終了
				if (f == 0) {
					break;
				}
				totalFlow += f;
			}
			return totalFlow;
		}
	}
}