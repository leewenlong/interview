package interview.offer;

public class PrintArrayJoinMinNumber {
    /**
     * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
     * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
     * @param numbers
     * @return
     * 原理:两个数字分别拼接对方，然后比较排序，
     *
     */
    public String PrintMinNumber(int [] numbers) {
        if (numbers == null || numbers.length==0) {
            return "";
        }
        quickSort(numbers,0,numbers.length-1);
        StringBuilder builder = new StringBuilder();
        for (int s : numbers) {
            builder.append(s);
        }
        return builder.toString();
    }

    private void quickSort(int[] arrays,int start,int end) {
        if (start >= end) {
            return;
        }
        int mid = arrays[start];
        int left = start;
        int right = end;
        while (left < right) {
            while (Long.valueOf(arrays[right] + "" + mid) > Long.valueOf(mid + "" + arrays[right]) && left < right) {
                right--;
            }
            while (Long.valueOf(arrays[left] + "" + mid) <= Long.valueOf(mid + "" + arrays[left]) && left < right) {
                left++;
            }
            if (left < right) {
                int t = arrays[left];
                arrays[left] = arrays[right];
                arrays[right] = t;
            }
        }
        arrays[start] = arrays[left];
        arrays[left] = mid;
        quickSort(arrays, start, left - 1);
        quickSort(arrays, left + 1, end);
    }
}
