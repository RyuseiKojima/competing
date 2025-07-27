package atCoder.ABC416;
import java.util.*;

public class C {
    static int N, K, X;
    static String[] S;
    static ArrayList<String> list = new ArrayList<>();

    // 幅優先探索で全ての組み合わせを生成
    public static void dfs(String crr, int count) {
        if (count == K) {
            list.add(crr);
            return;
        }

        for (String s : S) {
            dfs(crr + s, count + 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        X = sc.nextInt();
        S = new String[N];
        for (int i = 0; i < N; i++) S[i] = sc.next();

        dfs("", 0);

        Collections.sort(list);
        System.out.println(list.get(X - 1));

        sc.close();
    }
}
