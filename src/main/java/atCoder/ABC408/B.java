package atCoder.ABC408;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int c = sc.nextInt();
            if (!arrayList.contains(c)) arrayList.add(c);
        }
        Collections.sort(arrayList);
        System.out.println(arrayList.size());
        String result = arrayList.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
        System.out.println(result);

        sc.close();
    }
}
