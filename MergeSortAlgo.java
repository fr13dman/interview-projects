import java.util.Arrays;
import java.io.*;
import java.util.*;
import java.text.*;

/**
 * Created by fr13dman on 12/21/16.
 * https://www.cs.cmu.edu/~adamchik/15-121/lectures/Sorting%20Algorithms/code/MergeSort.java (Reference)
 */
public class MergeSortAlgo {

    public static void main(String args[]) {
//        Integer[] a = new Integer[] {5, 3, 1, 9, 23, 2, 5, 13 , 0};
        Integer[] a = new Integer[]{2, 1, 3, 1, 2};
        //new MergeSortAlgo().merge(a);

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();
            Integer arr[] = new Integer[n];
            for (int arr_i = 0; arr_i < n; arr_i++) {
                arr[arr_i] = in.nextInt();
            }
            new MergeSortAlgo().merge(arr);

        }
    }

    private void merge(Comparable[] a) {
        Comparable[] tmp = Arrays.copyOf(a, a.length);
        //System.out.println(Arrays.toString(tmp));
        int swaps = sort(a, tmp, 0, a.length - 1);
        //System.out.println(Arrays.toString(tmp));
        System.out.println("Inversions: " + swaps);
    }

    private int sort(Comparable[] a, Comparable[] tmp, int start, int end) {
        if (a == null || tmp == null)
            return 0;

        int swaps = 0;
        if (start < end) {
            int mid = (int) Math.floor((start + end) / 2);
            //System.out.println(Arrays.toString(Arrays.copyOfRange(a, start, mid + 1)) + " Ranges: " + start + " - " + mid);
            //System.out.println(Arrays.toString(Arrays.copyOfRange(a, mid + 1, end + 1)) + " Ranges: " + (mid + 1) + " - " + end);
            swaps += sort(a, tmp, start, mid);
            swaps += sort(a, tmp, mid + 1, end);
            swaps += merge(a, tmp, start, mid + 1, end);
        }

        return swaps;
    }

    private int merge(Comparable[] a, Comparable[] b, int start, int mid, int end) {
        if (a == null || b == null)
            return 0;

        if(start > end)
            return 0;

        int left = start;
        int right = mid;
        int k = left;
        int swaps = 0;

        while (left < mid && right <= end) {
            if(a[left].compareTo(a[right]) <= 0)
                b[k++] = a[left++];
            else {
                b[k++] = a[right++];
                swaps = swaps + (mid - left);
            }
        }

        //Copy remaining items for left side
        while(left < mid)
            b[k++] = a[left++];

        //Copy remaining items for right side
        while(right <= end)
            b[k++] = a[right++];

        for(int i = start; i <= end; i++)
            a[i] = b[i];

        return swaps;
    }
}
