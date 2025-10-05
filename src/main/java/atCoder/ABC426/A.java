package atCoder.ABC426;

import java.util.Scanner;

class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String X = sc.next();
        String Y = sc.next();

        sc.close();

        if (X.equals("Ocelot")) {
            System.out.println(Y.equals("Ocelot") ? "Yes" : "No");
        } else if (X.equals("Serval")) {
            System.out.println(Y.equals("Ocelot") || Y.equals("Serval") ? "Yes" : "No");
        } else {
            System.out.println(Y.equals("Ocelot") || Y.equals("Serval") || Y.equals("Lynx") ? "Yes" : "No");
        }
    }
}
