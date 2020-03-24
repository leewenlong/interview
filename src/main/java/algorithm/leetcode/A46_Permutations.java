package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class A46_Permutations {
    public List<List<Integer>> permute(int[] nums) {

        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        backTrack(result,temp,nums);

        return result;
    }

    private void backTrack(List<List<Integer>> result,List<Integer> temp,int[] nums){
        if (temp.size() == nums.length){
            result.add(new ArrayList<>(temp));
        }else {
            for (int i = 0; i < nums.length; i++) {
                if (temp.contains(nums[i])){
                    continue;
                }
                temp.add(nums[i]);
                backTrack(result,temp,nums);
                temp.remove(temp.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        A46_Permutations p = new A46_Permutations();
        int[] a = {1,2,3};
        System.out.println(p.permuteDFS(a));
    }

    public List<List<Integer>> permuteDFS(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        dfs(result,nums,0);

        return result;
    }

    private void dfs(List<List<Integer>> result,int[] nums,int start){
        //TODO
    }

    private void swap(int[] nums,int i,int j){
        if (i!=j){
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    }
}
