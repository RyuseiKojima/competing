package atCoder.ABC349;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        int[] counts = new int[30];
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            counts[index]++;
        }

        int[] char_counts = new int[101];

        for (int count : counts) {
            char_counts[count]++;
        }

        boolean flg = true;
        for (int i = 1; i < char_counts.length; i++) {
            if (char_counts[i] == 1 || char_counts[i] > 2) {
                flg = false;
                break;
            }
        }

        System.out.println(flg ? "Yes" : "No");
    }
}
