package atCoder.ABC418;
import java.util.*;

public class D {
    public static void main(String[] args) {
        // 入力
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String S = sc.next();
        sc.close();

        // DPテーブルの初期化
        int[][] dp = new int[N + 1][2]; // 0: 0を偶数個含む文字列の個数, 1: 0を奇数個含む文字列の個数
        for (int r = 1; r <= N; r++) {
            if (S.charAt(r - 1) == '0') {
                dp[r][0] = dp[r - 1][1];
                dp[r][1] = dp[r - 1][0] + 1;
            } else {
                dp[r][0] = dp[r - 1][0] + 1;
                dp[r][1] = dp[r - 1][1];
            }
        }

        long ans = 0;
        for (int r = 1; r <= N; r++) {
            ans += dp[r][0];
        }

        // 出力
        System.out.println(ans);
    }
}
