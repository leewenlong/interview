package algorithm.primary.sort;

public class BubbleSort {
    public static void bubbleSort(int[] arrays){
        if (arrays == null || arrays.length==1) {
            return;
        }
        for (int i = 0; i < arrays.length-1; i++) {
            for (int j = 0; j < arrays.length-i-1; j++) {
                if (arrays[j]>arrays[j+1]){
                    int temp = arrays[j];
                    arrays[j] = arrays[j+1];
                    arrays[j+1]=temp;
                }
            }
        }
    }
}
