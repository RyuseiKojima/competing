package atCoder.ABC426;

import java.util.Scanner;

class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String X = sc.next();
        int length = X.length();

        sc.close();

        for (int i = 1; i < length; i++) {
            if (X.charAt(i) != X.charAt(i - 1)) {
                if (i > 1) {
                    System.out.println(X.charAt(i));
                } else {
                    System.out.println(X.charAt(i + 1) == X.charAt(i) ? X.charAt(0) : X.charAt(1));
                }
                return;
            }
        }
    }
}
