package atCoder.ABC416;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        int N = S.length();
        StringBuilder sb = new StringBuilder();
        int point = 0;
        boolean isFirst = true;

        while (point < N) {
            if (S.charAt(point) == '#') {
                sb.append(S.charAt(point));
                isFirst = true;
            } else {
                if (isFirst) {
                    sb.append('o');
                    isFirst = false;
                } else {
                    sb.append(S.charAt(point));
                }
            }
            point++;
        }

        System.out.println(sb.toString());
        sc.close();
    }
}
