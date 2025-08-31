package atCoder.ABC421;

import java.util.Scanner;

class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // A と B が n 個ずつある
        String s = sc.next(); // 長さ 2n の文字列 S

        sc.close();

        long firstA = 0; // 最終形「ABAB…」に揃える場合のコスト
        long firstB = 0; // 最終形「BABA…」に揃える場合のコスト

        int i = 0; // 「ABAB…」の中で A が来るべき位置
        int j = 1; // 「BABA…」の中で A が来るべき位置

        for (int k = 0; k < 2 * n; k++) { // S の各文字を走査
            char ch = s.charAt(k);
            if (ch == 'A') { // A の位置だけ考える
                // 「ABAB…」に寄せる場合: A が 0,2,4,… に並ぶ
                firstA += Math.abs(k - i);
                i += 2;

                // 「BABA…」に寄せる場合: A が 1,3,5,… に並ぶ
                firstB += Math.abs(k - j);
                j += 2;
            }
        }
        long ans = Math.min(firstA, firstB);
        System.out.println(ans);
    }
}
