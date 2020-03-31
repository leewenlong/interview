package algorithm.leetcode;

import java.util.*;

public class A78_Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        if (nums == null || nums.length==0){
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        subsets(result,nums,list,0);
        return new ArrayList<>(result);
    }

    private void subsets(Collection<List<Integer>> result, int[] nums, List<Integer> list, int index) {
        if (index == nums.length){
            if (!result.contains(list)){
                result.add(new ArrayList<>(list));
            }
            return;
        }
        subsets(result,nums,list,index+1);

        list.add(nums[index]);
        subsets(result,nums,list,index+1);
        list.remove(list.size()-1);
    }

    public List<List<Integer>> subsetsII(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length==0){
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length+1; i++) {
            subsets(result,nums,list,0);
        }
        return result;
    }

}
