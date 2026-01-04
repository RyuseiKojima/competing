package atCoder.ABC439;

import java.util.*;

class D {
    /**
     * 商と割る数（3,5,7）をペアにするクラス
     */
    static class Pair {
        long div, type;
        Pair(long div, long type) {
            this.div = div; // 商
            this.type = type; // 割る数
        }
        
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return div == pair.div && type == pair.type;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(div, type);
        }
    }
    
    /**
     * インデックスとタイプ(7,5,3)をペアにするクラス
     */
    static class IndexPair implements Comparable<IndexPair> {
        long index;
        int type;
        IndexPair(long index, int type) {
            this.index = index;
            this.type = type;
        }
        
        @Override
        public int compareTo(IndexPair o) {
            return Long.compare(this.index, o.index);
        }
    }
    
    /**
     * 7,5,3で割ったときのインデックスリストを受け取り、条件を満たす組み合わせ数を返す
     * @param v7
     * @param v5
     * @param v3
     * @return
     */
    static long solve(List<Integer> v7, List<Integer> v5, List<Integer> v3) {
        long res = v7.size();
        res *= v5.size();
        res *= v3.size();
        if (res == 0) return 0; // いずれかが0なら終了
        
        List<IndexPair> vp = new ArrayList<>();
        for (long nx : v7) {
            vp.add(new IndexPair(nx, 7));
        }
        for (long nx : v5) {
            vp.add(new IndexPair(nx, 5));
        }
        for (long nx : v3) {
            vp.add(new IndexPair(nx, 3));
        }
        Collections.sort(vp);
        
        long p7 = 0, s7 = v7.size(); // 前から7の数、後ろから7の数
        long p3 = 0, s3 = v3.size(); // 前から3の数、後ろから3の数
        
        for (IndexPair nx : vp) {
            if (nx.type == 7) { // 7のときは前から1つ増やし、後ろから1つ減らす
                p7++;
                s7--;
            } else if (nx.type == 5) { // 5のときは7と3の組み合わせ数を引く
                res -= p7 * s3;
                res -= p3 * s7;
            } else if (nx.type == 3) { // 3のときは前から1つ増やし、後ろから1つ減らす
                p3++;
                s3--;
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        Map<Pair, List<Integer>> indexList = new HashMap<>(); // ペアをキーにしてインデックスリストを格納
        Set<Long> tst = new HashSet<>(); // ユニークキーを格納
        
        // 7, 5, 3で割れる数をそれぞれマップに格納
        for (int i = 0; i < n; i++) {
            long a = sc.nextLong();
            if (a % 7 == 0) {
                Pair key = new Pair(a / 7, 7);
                indexList.putIfAbsent(key, new ArrayList<>());
                indexList.get(key).add(i);
                // 7でユニークキーを追加（最も数が少ないため効率的）
                tst.add(a / 7);
            }
            if (a % 5 == 0) {
                Pair key = new Pair(a / 5, 5);
                indexList.putIfAbsent(key, new ArrayList<>());
                indexList.get(key).add(i);
            }
            if (a % 3 == 0) {
                Pair key = new Pair(a / 3, 3);
                indexList.putIfAbsent(key, new ArrayList<>());
                indexList.get(key).add(i);
            }
        }
        
        long res = 0;
        // ユニークキーごとに組み合わせ数を計算
        for (long nx : tst) {
            List<Integer> v7 = indexList.getOrDefault(new Pair(nx, 7), new ArrayList<>());
            List<Integer> v5 = indexList.getOrDefault(new Pair(nx, 5), new ArrayList<>());
            List<Integer> v3 = indexList.getOrDefault(new Pair(nx, 3), new ArrayList<>());
            res += solve(v7, v5, v3);
        }
        
        System.out.println(res);
        sc.close();
    }
}