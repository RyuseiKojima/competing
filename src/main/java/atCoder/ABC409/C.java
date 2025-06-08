package atCoder.ABC409;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 入力: 点の数 N, 円周の長さ L
        int n = sc.nextInt();
        int l = sc.nextInt();
        int[] d = new int[n];
        for (int i = 1; i < n; i++) d[i] = sc.nextInt();

        sc.close();

        // Lが3で割り切れないなら正三角形はできない
        if (l % 3 != 0) {
            System.out.println(0);
            return;
        }

        int x = 0; // 点を移動させる
        int[] cnt = new int[l]; // 各位置に点がある回数を記録
        for (int i = 0; i < n; i++) {
            x += d[i]; // 最初以外は点を動かす
            x %= l; // 円周の長さで割れば1周目の点の値になる
            cnt[x]++;
        }

        long ans = 0;
        for (int i = 0; i < l / 3; i++) { // 点0から1/3の点を探索
            int a = cnt[i]; // 1点目に何個あるか
            int b = cnt[i + l / 3]; // 2点目に何個あるか
            int c = cnt[i + 2 * l / 3]; // 3点目に何個あるか
            ans += (long) a * b * c; // 3つをかけた数の正三角形を作れる
        }

        System.out.println(ans);
    }
}
