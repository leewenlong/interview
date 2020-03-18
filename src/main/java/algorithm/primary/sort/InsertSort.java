package algorithm.primary.sort;

public class InsertSort {
    public static void insertSort(int[] arrays){
        if (arrays == null||arrays.length < 2) {
            return;
        }
        int j;
        for (int i = 1; i < arrays.length; i++) {
            int temp = arrays[i];
            for (j = i; j >0 && arrays[j-1]>temp; j--) {
                arrays[j] = arrays[j-1];
            }
            arrays[j] = temp;
        }
    }

    public static void binaryInsertSort(int[] arrays){
        if (arrays == null||arrays.length < 2) {
            return;
        }
        int j,low,mid,high;
        for (int i = 1; i < arrays.length; i++) {
            int temp = arrays[i];
            low = 0;
            high = i-1;
            while (low<=high){
                mid = (low+high)>>1;
                if (arrays[mid] > temp){
                    high = mid-1;
                }else {
                    low = mid+1;
                }
            }
            for (j = i; j >low ; j--) {
                arrays[j] = arrays[j-1];
            }
            arrays[j] = temp;
        }
    }
}
