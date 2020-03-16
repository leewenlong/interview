package interview.offer;

public class GetNumberCountOfK {
    /**
     * 统计一个数字在排序数组中出现的次数。
     * @param array
     * @param k
     * @return
     */
    public int GetNumberOfK(int [] array , int k) {
        if (array == null || array.length==0) {
            return 0;
        }
        return getNumberStart(array,k+0.1) - getNumberStart(array,k-0.1);

    }

    private int getNumberStart(int [] array , double k) {
        int mid = 0;
        int start = 0;
        int end = array.length-1;
        while (start<=end){
            mid = (start+end)>>1;
            if (array[mid] > k){
                end = mid-1;
            }else {
                start = mid+1;
            }
        }
        return start;
    }
}
