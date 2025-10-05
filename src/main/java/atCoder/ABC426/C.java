package atCoder.ABC426;

import java.util.*;

class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int q = sc.nextInt();
        
        // pc配列を初期化（インデックス0は0、それ以外は1）
        int[] pc = new int[n + 1];
        Arrays.fill(pc, 1);
        pc[0] = 0;
        
        int o = 1; // 現在処理している位置
        
        // q回のクエリを処理
        while (q-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            
            int res = 0;
            
            // oからxまでの範囲を処理
            while (o <= x) {
                res += pc[o];        // 結果に加算
                pc[y] += pc[o];      // pc[y]に移動
                o++;                 // 次の位置へ
            }
            
            System.out.println(res);
        }
        
        sc.close();
    }
}