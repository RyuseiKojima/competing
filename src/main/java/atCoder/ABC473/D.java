package atCoder.ABC473;

import java.util.*;

class D {
    /**
     * A_index 以降の値を決め、重み付き和の残りが remaining になる列を列挙する。
     * 問題の添字は1始まり、配列の添字は0始まりなので、A_index は array[index - 1] に対応する。
     *
     * @param index     現在値を決める添字（1以上n以下）
     * @param array     列Aを保存する配列
     * @param n         列Aの長さ
     * @param remaining まだ作る必要がある重み付き和
     */
    private static void dfs(int index, int[] array, int n, int remaining) {
        // 最後の要素は、n * A_n = remaining を満たす場合に一意に決まる。
        if (index == n) {
            if (remaining % n == 0) {
                array[n - 1] = remaining / n;
                printArray(array);
            }
            return;
        }

        // index * A_index が remaining を超えない範囲で A_index を試す。
        int maxValue = remaining / index;
        for (int value = 0; value <= maxValue; value++) {
            array[index - 1] = value;
            dfs(index + 1, array, n, remaining - value * index);
        }
    }

    /** 列Aを空白区切りで出力する。 */
    private static void printArray(int[] array) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                output.append(' ');
            }
            output.append(array[i]);
        }
        System.out.println(output);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] array = new int[n];
        dfs(1, array, n, k);

        scanner.close();
    }
}