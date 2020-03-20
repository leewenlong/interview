package algorithm.leetcode;

public class A28_ImplementStr {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.isEmpty()) {
            return 0;
        }
        if (haystack == null || haystack.isEmpty()) {
            return -1;
        }
        return haystack.indexOf(needle);
    }

}
