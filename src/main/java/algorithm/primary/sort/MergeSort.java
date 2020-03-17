package algorithm.primary.sort;

public class MergeSort {

    public static void mergeSort(int[] arrays) {
        if (arrays == null || arrays.length < 2) {
            return;
        }
        int[] temp = new int[arrays.length];
        sort0(arrays,0,arrays.length-1,temp);
    }

    public static void sort0(int[] arrays,int start ,int end,int[] temp) {
        if (start<end){
            int mid = (start+end)>>>1;
            sort0(arrays,start,mid,temp);
            sort0(arrays,mid+1,end,temp);
            merge(arrays,start,mid,end,temp);
        }
    }

    public static void merge(int[] arrays,int start ,int mid,int end,int[] temp) {
        int left = start;
        int right = mid+1;
        int index = 0;
        while (left<=mid&&right<=end){
            temp[index++] = arrays[left]<arrays[right]?arrays[left++]:arrays[right++];
        }
        while (left<=mid){
            temp[index++] = arrays[left++];
        }
        while (right<=end){
            temp[index++] = arrays[right++];
        }
        index = 0;
        while (start<=end){
            arrays[start++] = temp[index++];
        }
    }
}
