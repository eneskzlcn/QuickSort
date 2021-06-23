
package quicksort_algorithms;

public class QuickSort2WayPartition {

        public static void quickSort2Way(Integer[] arr, int low, int high)
        {
            //partition part begins-----
            //check for empty or null array
            if (arr.length == 0){
                return;
            }

            if (low >= high){
                return;
            }

            int pivot = arr[low];
           

            // make left < pivot and right > pivot
            int i = low, j = high;
            while (i <= j)
            {
                //Check until all values on left side array are lower than pivot
                while (arr[i] < pivot)
                {
                    i++;
                }
                //Check until all values on left side array are greater than pivot
                while (arr[j] > pivot)
                {
                    j--;
                }
                //Now compare values from both side of lists to see if they need swapping
                //After swapping move the iterator on both lists
                if (i <= j)
                {
                    swap (arr, i, j);
                    i++;
                    j--;
                }
            }
            //quicksort part begin----
            //Do same operation as above recursively to sort two sub arrays
            if (low < j){
                quickSort2Way(arr, low, j);
            }
            if (high > i){
                quickSort2Way(arr, i, high);
            }
        }

        public static void swap (Integer array[], int x, int y)
        {
            int temp = array[x];
            array[x] = array[y];
            array[y] = temp;
        }

}
