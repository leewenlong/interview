package algorithm.leetcode;

import java.util.Arrays;

public class A260_SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor = xor ^ num;//最后两个不同数字的异或值
        }

//        xor &= -xor;//负数为正数取反+1;genius
        xor &= ~(xor - 1);//两个不同的数字或肯定有一个位数是不相同的,取最后一个是1的bit

        int[] ans = {0, 0};
        for (int num : nums) {
            if ((xor & num) == 0) {
                ans[0] = ans[0] ^ num;
            } else {
                ans[1] = ans[1] ^ num;
            }
        }
        return ans;
    }

}
