package algorithm.leetcode;

public class A242_ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length()!=t.length()){
            return false;
        }

        int[] count = new int[26];
        for (int i = 0; i < t.length(); i++) {
            count[t.charAt(i) -'a']++;
            count[s.charAt(i) -'a']--;
        }
        for (int i : count) {
            if (i!=0){
                return false;
            }
        }
        return true;
    }
}
