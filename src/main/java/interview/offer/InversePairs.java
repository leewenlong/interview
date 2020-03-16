package interview.offer;

public class InversePairs {
    /**
     * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
     * 输入一个数组,求出这个数组中的逆序对的总数P。
     * 并将P对1000000007取模的结果输出。 即输出P%1000000007
     * @param array
     * @return
     */
    int total = 0;
    public int InversePairs(int [] array) {
        if (array!=null){
            mergeSort(array,0,array.length-1);
        }
        return total;
    }
    private void mergeSort(int[] array,int start,int end){
        if (start>=end){
            return;
        }
        int mid = (start+end)/2;
        mergeSort(array,start,mid);
        mergeSort(array,mid+1,end);

        merge(array,start,mid,end);
    }

    private void merge(int[] array, int start, int mid, int end) {
        int[] temp = new int[end-start+1];
        int left = start;
        int right = mid;
        int i = 0;
        while (left<=mid&&right<=end){
            if (array[left]<=array[right]){
                temp[i++] = array[left++];
            }else {
                temp[i++] = array[right++];
                total += mid-left+1;
            }
            if (total>1000000007){
                total = total%1000000007;
            }
        }

        while (left<=mid){
            temp[i++] = array[left++];
        }

        while (right<=end){
            temp[i++] = array[right++];
        }
        for (int j = 0; j < temp.length; j++) {
            array[start+j] = temp[j];
        }
    }
}
