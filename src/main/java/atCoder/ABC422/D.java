package atCoder.ABC422;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        List<Integer> ans = new ArrayList<>();
        ans.add(K);

        // N 回分割を繰り返す
        for (int n = 0; n < N; n++) {
            List<Integer> nxt = new ArrayList<>();
            for (int a : ans) {
                nxt.add(a / 2); // a を 2 分割
                nxt.add(a - a / 2); // 切り上げた方
            }
            ans = nxt; // 更新
        }

        // max と min を求める
        int max = Collections.max(ans);
        int min = Collections.min(ans);

        System.out.println(max - min);

        // 最終的な配列を出力
        System.out.println(ans.stream()
                .map(String::valueOf)
                .collect(java.util.stream.Collectors.joining(" ")));

        sc.close();
    }
}
