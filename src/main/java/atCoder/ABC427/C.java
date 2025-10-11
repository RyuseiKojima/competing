package atCoder.ABC427;

import java.util.*;

class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt(); // 頂点数
        int M = sc.nextInt(); // 辺数
        
        // 辺の情報を格納
        int[][] edges = new int[M][2];
        for (int i = 0; i < M; i++) {
            edges[i][0] = sc.nextInt(); // 辺の始点
            edges[i][1] = sc.nextInt(); // 辺の終点
        }
        
        int ans = M; // 最悪の場合は全ての辺を削除
        
        // 2^N 通りの塗り方を全部探索する
        for (int bit = 0; bit < (1 << N); bit++) {
            int deleteCount = 0;
            
            // それぞれの辺を見て
            for (int i = 0; i < M; i++) {
                int u = edges[i][0];
                int v = edges[i][1];
                
                // 結んでいる頂点が同じ色で塗られていたら
                if (((bit >> u) & 1) == ((bit >> v) & 1)) {
                    deleteCount++; // カウントを増やす
                }
            }
            
            // 最小削除辺数を更新
            ans = Math.min(ans, deleteCount);
        }
        
        System.out.println(ans);
        sc.close();
    }
}