package interview.offer;

public class GetUglyNumber {
    /**
     * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。
     * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
     * @param index
     * @return
     */
    public int GetUglyNumber_Solution(int index) {
        if (index<=6){
            return index;
        }
        int u2=0,u3=0,u5=0;
        int[] res = new int[index];
        res[0] = 1;
        for (int i = 1; i < index; i++) {
            res[i] = Integer.min(Integer.min(res[u2]*2,res[u3]*3),res[u5]*5);

            if (res[i] == res[u2]*2){
                u2++;
            }
            if (res[i] == res[u3]*3){
                u3++;
            }
            if (res[i] == res[u5]*5){
                u5++;
            }
        }

        return res[index-1];
    }
}
