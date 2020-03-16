package algorithm.primary.sort;

public class QuickSort {
    /**
     * O(nlogn)
     * @param arrays
     */
    public static void quickSort(int[] arrays) {
        if (arrays == null||arrays.length < 2) {
            return;
        }
        quickSort0(arrays,0,arrays.length-1);

    }

    private static void quickSort0(int[] arrays,int start ,int end) {
        if (start >= end) {
            return;
        }
        int left = start;
        int right = end;
        int temp = arrays[start];
        while (left < right) {
            while (left < right && arrays[right] > temp) {
                right--;
            }

            while (left < right && arrays[left] <= temp) {
                left++;
            }
            if (left < right) {
                int t = arrays[left];
                arrays[left] = arrays[right];
                arrays[right] = t;
            }
        }

        arrays[start] = arrays[left];
        arrays[left] = temp;
        quickSort0(arrays, start, left - 1);
        quickSort0(arrays, left + 1, end);

    }
}
