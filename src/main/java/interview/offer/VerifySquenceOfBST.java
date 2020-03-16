package interview.offer;

public class VerifySquenceOfBST {
    /**
     * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
     * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
     * @param sequence
     * @return
     */
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return VerifySquenceOfBST0(sequence,0,sequence.length-1);
    }

    private boolean VerifySquenceOfBST0(int[] sequence,int start,int end){
        if (start >=end){
            return true;
        }

        int mid = start;
        for (int i = start; i <= end; i++) {
            if (sequence[i]>=sequence[end]){
                mid = i;
                break;
            }
        }
        for (int i = mid+1; i < end; i++) {
            if (sequence[i] < sequence[end]) {
                return false;
            }
        }

        return VerifySquenceOfBST0(sequence,start,mid-1)
                && VerifySquenceOfBST0(sequence,mid,end-1);

    }
}
