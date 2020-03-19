package algorithm.leetcode;

import algorithm.other.ManacherAlgorithm;

public class A5_LongestPalindromicSubstring {

    /**
     * @see ManacherAlgorithm another answer O(n)
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length()<2) {
            return s;
        }
        int[] result = {0,0};//start,maxlen
        for (int i = 0; i < s.length() ; i++) {
            expandCenter(s,i,i,result);//奇数个
            expandCenter(s,i,i+1,result);//偶数个
        }
        return s.substring(result[0],result[0]+result[1]);
    }

    private void expandCenter(String s,int left,int right,int[] result){

        while (left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        if (result[1]<(right-left)-1){
            result[1] = right-left-1;
            result[0] = left+1;
        }
    }
}
