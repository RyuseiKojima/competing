package atCoder.ABC412;
import java.util.*;

class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            for (int j = 0; j < N; j++) {
                arr[j] = sc.nextInt();
            }
            int start = arr[0];
            int goal = arr[N - 1];
            Arrays.sort(arr);
            // startからgoalまでの範囲にある要素だけを配列にコピー
            int[] filtered = Arrays.stream(arr)
                                   .filter(x -> x >= start && x <= goal)
                                   .toArray();

            boolean canReach = true;
            int lastUsed = 0;   // 最後に倒したドミノの位置
            int nextTarget = 1; // 倒したい次のドミノの位置
            int usedCount = 2;  // 使用したドミノの数（最初の2個）

            while (lastUsed < filtered.length && nextTarget < filtered.length) {
                if (filtered[lastUsed] * 2 < filtered[nextTarget]) { // 倒せない場合
                    if (nextTarget - lastUsed <= 1) { // 倒せるドミノがない
                        canReach = false;
                        break;
                    }
                    lastUsed = nextTarget - 1;
                    usedCount++;
                } else if (nextTarget == filtered.length - 1) { // 最後まで倒せた
                    break;
                } else { // 次のターゲットに進む
                    nextTarget++;
                }
            }

            System.out.println(canReach ? usedCount : -1);
        }

        sc.close();
    }
}
