package interview.offer;

public class ArrayMultiply {
    /**
     * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
     * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
     * 不能使用除法。
     * @param A
     * @return
     * 注意：B[i]的积中无A[i], 将乘积以i为界分为左右两部分
     */
    public int[] multiply(int[] A) {
        if (A == null || A.length < 2) {
            return null;
        }
        int[] left = new int[A.length];
        left[0] = 1;
        for (int i = 1; i < A.length; i++) {
            left[i] = A[i - 1] * left[i - 1];
        }

        int[] right = new int[A.length];
        right[A.length - 1] = 1;
        for (int i = A.length - 2; i > -1; i--) {
            right[i] = A[i + 1] * right[i + 1];
        }

        int[] B = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            B[i] = left[i] * right[i];
        }
        return B;
    }
}
