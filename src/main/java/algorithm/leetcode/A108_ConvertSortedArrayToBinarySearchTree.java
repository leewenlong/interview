package algorithm.leetcode;

public class A108_ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null||nums.length==0) {
            return null;
        }
        int mid = nums.length/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = build(nums,0,mid-1);
        root.right = build(nums,mid+1,nums.length-1);
        return root;
    }

    public TreeNode build(int[] nums,int left,int right) {
        if (left>right){
            return null;
        }
        int mid = (right+left)>>1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = build(nums,left,mid-1);
        root.right = build(nums,mid+1,right);
        return root;

    }
}
