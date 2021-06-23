package quicksort_algorithms;


import java.util.Random;

public class QuickSort3WayPartition {
    private static Random random = new Random();

    public static int[] partition3(Integer[] a, int l, int r) {
        Integer x = a[l];
        int m1 = l;
        int m2 = r;

        int i = l + 1;

        while (i <= m2) {
            if (a[i] > x) {
                swap(a, i, m2);
                m2--;
            } else if (a[i] < x) {
                swap(a, m1, i);
                m1++;
                i++;
            } else {
                i++;
            }
        }

        int[] m = {m1, m2};
        return m;
    }

    public static void swap(Integer[] a, int i, int j) {
        Integer temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void quickSort3Way(Integer[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        int m[] = partition3(a, l, r);
        quickSort3Way(a, l, m[0] - 1);
        quickSort3Way(a, m[1] + 1, r);
    }

    public static void main(String[] args) {
        Integer[] array = new Integer[8000000];
        Random rnd = new Random();

        for (int i = 0; i < array.length; i++) {
            rnd.setSeed(i);
            array[i] = rnd.nextInt(100);
        }
        long starttime = System.currentTimeMillis();
        quickSort3Way(array, 0, array.length - 1);
        long endtime = System.currentTimeMillis();
        /*
        for (int i = 0; i < array.length; i++) {
            System.out.println("array[" + i + "]" + array[i]);
        }*/
        System.out.println("süre= "+(endtime-starttime));
    }
}
