package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @see interview.offer.CharPermutation
 * decision tree,backtrack
 */
public class A46_Permutations {
    public List<List<Integer>> permute(int[] nums) {

        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result,temp,nums);

        return result;
    }

    private void backtrack(List<List<Integer>> result,List<Integer> temp,int[] nums){
        if (temp.size() == nums.length){
            result.add(new ArrayList<>(temp));
        }else {
            for (int i = 0; i < nums.length; i++) {
                if (temp.contains(nums[i])){
                    continue;
                }
                temp.add(nums[i]);
                backtrack(result,temp,nums);
                temp.remove(temp.size()-1);
            }
        }
    }
}
