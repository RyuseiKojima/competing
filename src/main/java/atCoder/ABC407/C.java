package atCoder.ABC407;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        sc.close();
        int length = s.length();
        long cnt = 0;
        int nowVal = 0;
        for (int i = 0 ; i < length; i++) {
            int getVal = Character.getNumericValue(s.charAt(i));
            cnt++;
            nowVal++;
            if (nowVal == 10) nowVal = 0;
            if (i < length - 1) {
                if (getVal == 0) getVal = 10;
                int nextVal = Character.getNumericValue(s.charAt(i + 1));
                cnt += getVal - nextVal;
            } else {
                cnt += getVal;
            }
        }
        System.out.println(cnt);
    }
}
