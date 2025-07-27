package atCoder.ABC347;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> sets = new ArrayList<>();
        String s = sc.next();

        sc.close();

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String val = s.substring(i, j+1);
                if (!sets.contains(val)) {
                    sets.add(val);
                }
            }
        }

        System.out.println(sets.size());
    }
}
