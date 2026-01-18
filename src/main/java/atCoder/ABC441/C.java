package atCoder.ABC441;

import java.util.*;

class C {
    public static void main(String[] args) {
        // 入力を受け取る
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();  // カップの総数
        int K = sc.nextInt();  // 日本酒が入っているカップの数
        long X = sc.nextLong();  // 最低限飲みたい日本酒の量 (ml)
        int[] A = new int[N];  // 各カップの容量
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        
        // カップを容量の昇順にソート
        Arrays.sort(A);
        
        // 大きい方から順に累積和を計算（pref[i] = 上位i個の合計）
        long[] pref = new long[N + 1];
        for (int i = 0; i < N; i++) pref[i + 1] = pref[i] + A[N - 1 - i];
        sc.close();

        // i個のカップを選ぶ場合を全探索
        for (int i = 1; i <= N; i++) {
            // i個選んだ時に、最低限含まれる日本酒のカップ数
            // N個中K個が日本酒なので、i個選ぶと最低でも max(0, i-(N-K)) 個の日本酒が含まれる
            int r = i - (N - K);
            if (r <= 0) continue;  // 日本酒が1つも含まれない可能性がある場合はスキップ
            
            // 最悪のケース：選んだi個の中で、最も小さいr個が日本酒だった場合
            // 選んだi個の上位（大きい方）から、日本酒でないものを除いた最小のr個の合計
            long worst = pref[i] - pref[i - r];
            
            // 最悪のケースでもX ml以上になれば確実
            if (worst >= X) {
                System.out.println(i);
                return;
            }
        }
        
        // どの選び方でも不可能な場合
        System.out.println(-1);
    }
}