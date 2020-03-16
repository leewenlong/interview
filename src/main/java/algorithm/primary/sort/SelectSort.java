package algorithm.primary.sort;

public class SelectSort {
    public static void selectSort(int[] arrays) {
        if (arrays == null || arrays.length < 2) {
            return;
        }
        int min = 0;
        for (int i = 0; i < arrays.length-1; i++) {
            min = i;
            for (int j = i+1; j < arrays.length; j++) {
                if (arrays[j]<arrays[min]){
                    min = j;
                }
            }
            if (min != i){
                int t = arrays[i];
                arrays[i] = arrays[min];
                arrays[min] = t;
            }
        }

    }
}
