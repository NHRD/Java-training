public class Shell {

    /* 別途作成したComparableを含むデータ型の名称が
    　 下記のComparableに入る。例えば日付を比べる場合は
       public static void sort(Date[] a) */

    public static void sort(Comparable[] a) {
        int N = a.length;

        int h = l;
        while (h < N/3) {
            h = 3 * h + 1;
        }

        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j-h);
                }
            }
            h = h/3;
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    
}