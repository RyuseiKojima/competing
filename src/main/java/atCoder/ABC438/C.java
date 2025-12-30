package atCoder.ABC438;

import java.util.*;

class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        ArrayList<Integer> q = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            int v = sc.nextInt();
            q.add(v);
            
            // 最後の4つの要素が全て同じかチェック
            if (q.size() >= 4) {
                int size = q.size();
                if (q.get(size - 1).equals(q.get(size - 2)) &&
                    q.get(size - 2).equals(q.get(size - 3)) &&
                    q.get(size - 3).equals(q.get(size - 4))) {
                    // 最後の4つを削除
                    for (int j = 0; j < 4; j++) {
                        q.remove(q.size() - 1);
                    }
                }
            }
        }
        
        System.out.println(q.size());
        sc.close();
    }
}