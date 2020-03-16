package algorithm.primary.sort;

public class HeapSort {
    public static void heapSort(int[] arrays){
        if (arrays == null||arrays.length < 2) {
            return;
        }
        buildMaxHeap(arrays,arrays.length);
        int max;
        for (int i = arrays.length-1; i > 0; i--) {
            max = arrays[0];
            arrays[0] = arrays[i];
            arrays[i] = max;
            buildMaxHeap(arrays,i);
        }
    }

    private static void buildMaxHeap(int[] arrays,int end){
        int parent,child,temp;
        for (int i = 1; i < end; i++) {//每次假设前面的都是已经排好序了，只有一个时不用排序
            child = i;//叶子结点,假设为每次排序时最后一个叶子结点
            parent = (child-1)>>1;//父结果
            temp = arrays[child];
            while (parent>=0 && arrays[parent]<temp){
                arrays[child] = arrays[parent];
                child = parent;
                parent = (parent-1)>>1;
            }
            arrays[child] = temp;
        }
    }
}
