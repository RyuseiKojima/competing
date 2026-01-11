package atCoder.ABC440;

import java.util.*;

class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 配列Aのサイズ
        int Q = sc.nextInt(); // クエリ数
        long[] A = new long[N]; // 禁止された整数の配列
        
        // 禁止された整数を入力
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextLong();
        }
        Arrays.sort(A); // 二分探索のためにソート
        
        StringBuilder sb = new StringBuilder();
        
        // 各クエリを処理
        for (int i = 0; i < Q; i++) {
            long X = sc.nextLong(); // 開始位置
            long Y = sc.nextLong(); // X以上でY番目の「使える整数」を求める

            int idx2 = Arrays.binarySearch(A, X);
            if (idx2 < 0) idx2 = -(idx2 + 1); // X未満の要素数
            
            // 二分探索で答えを探す
            // 答えは X 以上、X+Y+N 以下の範囲にある
            long l = X, r = X + Y + N;
            
            while (l < r) {
                long m = (l + r) / 2;
                
                int idx1 = Arrays.binarySearch(A, m + 1);
                if (idx1 < 0) idx1 = -(idx1 + 1); // m+1未満の要素数
                
                // [X, m] の範囲に含まれる禁止された整数の個数
                long banned = idx1 - idx2;
                
                // [X, m] の範囲で使える整数の個数
                // (m-X+1) は範囲内の全整数の個数、bannedを引いて使える個数を得る
                long ok = (m - X + 1) - banned;
                
                // Y個以上の使える整数があれば、答えはm以下
                if (ok >= Y) r = m;
                else l = m + 1;
            }
            
            sb.append(l).append('\n'); // Y番目の使える整数を追加
        }
        
        System.out.print(sb.toString()); // 全クエリの結果を出力

        sc.close();
    }
}