package atCoder.ABC426;

import java.util.Scanner;

public class D {
    /**
     * 文字列sを単一文字にするための最小操作回数を計算
     * @param n 文字列の長さ
     * @param s 入力文字列（'0'と'1'のみ）
     * @return 最小操作回数
     */
    static int solve(int n, String s) {
        // mx[i]: 文字iの連続する最大長
        // cnt[i]: 文字iの総出現回数
        int[] mx = new int[2];
        int[] cnt = new int[2];
        
        // 連続するセグメントを分析
        for (int l = 0; l < n;) {
            int r = l + 1;
            // 同じ文字が続く範囲を見つける
            while (r < n && s.charAt(l) == s.charAt(r)) {
                r++;
            }
            
            int c = s.charAt(l) - '0';  // 文字を数値に変換（'0'→0, '1'→1）
            int len = r - l;            // セグメントの長さ
            
            mx[c] = Math.max(mx[c], len);  // 最大連続長を更新
            cnt[c] += len;                 // 総出現回数を加算
            
            l = r;  // 次のセグメントへ
        }
        
        int ans = 2 * n;  // 十分大きな初期値
        
        // 0と1のどちらを残すかを決定
        for (int i = 0; i < 2; i++) {
            // 戦略：文字iを残す場合
            // - 文字iの最大連続セグメントは1回の操作で除去可能
            // - 他のセグメントは2回の操作で除去
            // - 文字(1-i)は全て1回の操作で除去可能
            int cost = (cnt[i] - mx[i]) * 2 + cnt[i ^ 1];
            ans = Math.min(ans, cost);
        }
        
        return ans;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();  // テストケース数
        
        // 各テストケースを処理
        while (t-- > 0) {
            int n = sc.nextInt();       // 文字列の長さ
            String s = sc.next();       // 入力文字列
            
            // 最小操作回数を計算して出力
            System.out.println(solve(n, s));
        }
        
        sc.close();
    }
}
