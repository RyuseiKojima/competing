package atCoder.ABC420;

import java.util.*;

class E {
    static class DSU {
        /** 各頂点の親 */
        int[] parent;
        /** 連結成分のサイズ */
        int[] size;

        DSU(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        /**
         * 頂点 x のリーダーを返す
         */
        int leader(int x) {
            if (parent[x] == x) return x;
            return parent[x] = leader(parent[x]);
        }

        /**
         * 連結成分が同じか判定する
         * @param a
         * @param b
         * @return
         */
        boolean same(int a, int b) {
            return leader(a) == leader(b);
        }

        /**
         * 連結成分をマージする
         * @param a
         * @param b
         * @return
         */
        int merge(int a, int b) {
            a = leader(a);
            b = leader(b);
            if (a == b) return a;
            if (size[a] < size[b]) {
                int tmp = a; a = b; b = tmp;
            }
            parent[b] = a;
            size[a] += size[b];
            return a;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();
        DSU dsu = new DSU(n + 1);

        int[] c = new int[n + 1]; // 各頂点の色 (0=白, 1=黒)
        int[] s = new int[n + 1]; // 各連結成分の黒い頂点の数

        while (q > 0) {
            int typ = sc.nextInt();

            if (typ == 1) {
                // 頂点 u, v を結ぶ
                int u = sc.nextInt();
                int v = sc.nextInt();
                u = dsu.leader(u);
                v = dsu.leader(v);
                if (u != v) {
                    int w = dsu.merge(u, v); // 新しい leader
                    s[w] = s[u] + s[v];     // 黒色頂点数をまとめる
                    if (w != u) s[u] = 0;
                    if (w != v) s[v] = 0;
                }
            }
            else if (typ == 2) {
                // 頂点 u の色を反転
                int u = sc.nextInt();
                int root = dsu.leader(u);
                s[root] -= c[u];   // 反映前の色を削除
                c[u] ^= 1;         // 反転
                s[root] += c[u];   // 新しい色を反映
            }
            else {
                // 頂点 u から黒色に到達できるか
                int u = sc.nextInt();
                int root = dsu.leader(u);
                if (s[root] > 0) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            }

            q--;
        }
        sc.close();
    }
}