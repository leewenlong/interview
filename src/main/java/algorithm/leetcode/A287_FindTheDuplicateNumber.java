package algorithm.leetcode;

public class A287_FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {//原理同判断链表中的环的入口
        int fast = 0;
        int slow = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while (nums[fast] != nums[slow]);
        fast = 0;
        while (fast != slow){
            fast = nums[fast];
            slow = nums[slow];
        }
        return fast;
    }
}
