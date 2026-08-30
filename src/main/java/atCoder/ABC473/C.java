package atCoder.ABC473;

import java.util.*;

class C {
    record ClassInfo(int classNumber, int studentCount) {}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] A = new int[N + 1];
        int[] counts = new int[K + 1];
        int max = 0;
        for (int i = 1; i <= N; i++) {
            A[i] = sc.nextInt();
            counts[A[i]]++;
            max = Math.max(max, counts[A[i]]);
        }

        List<ClassInfo> classes = new ArrayList<>();

        for (int i = 1; i <= K; i++) {
            classes.add(new ClassInfo(i, counts[i]));
        }
        classes.sort(
            Comparator.comparingInt(ClassInfo::studentCount)
                    .reversed()
        );
        int ans = 0;
        for (ClassInfo classInfo : classes) {
            int studentCount = classInfo.studentCount;

            if (studentCount < max - 1) break;

            ans++;
        }

        System.out.println(ans);
        sc.close();
    }
}