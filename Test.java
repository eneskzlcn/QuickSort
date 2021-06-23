package quicksort_algorithms;

import java.util.Random;

public class Test {
    public static void main(String[] args)
    {
        // This is unsorted array
        Integer sizes[] = {4000000,8000000,16000000,32000000,64000000,128000000};

        int seed = 100;
        for (int l = 1; l < 10; l++) {

            System.out.print("\n\t Run:"+l+",Seed:"+seed+"\n");
            for (int count = 0; count < sizes.length;count++)
            {
                Integer[] array = new Integer[sizes[count]];
                Random rnd = new Random(seed);
                for (int i = 0; i < array.length; i++) {
                    array[i] = rnd.nextInt(100);
                }
                System.out.print("\nFor size of "+sizes[count]+":");

                 //QuickSort3WayPartition.randomizedQuickSort(array,0, array.length-1);
                 //reverse(array);
                //QuickSort2WayPartition.quickSort(array,0, array.length-1);
                //reverse(array);
                long starttime = System.currentTimeMillis();
                QuickSort3WayPartition.quickSort3Way(array,0, array.length-1);
                long endtime = System.currentTimeMillis();
                System.out.print((endtime-starttime) + " ms");

            }
            seed+=50;
        }
    }
        public static void reverse(Integer[] input) {
            int last = input.length - 1;
            int middle = input.length / 2;
            for (int i = 0; i <= middle; i++)
            {
                Integer temp = input[i];
                input[i] = input[last - i];
                input[last - i] = temp;
            }
        }
}