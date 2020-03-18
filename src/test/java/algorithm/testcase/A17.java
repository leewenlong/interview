package algorithm.testcase;

import algorithm.leetcode.A17_LetterCombinationsOfAPhoneNumber;
import org.junit.Assert;
import org.junit.Test;

public class A17 {

    @Test
    public void testletterCombinations() {
        String[] result = {"adg","adh","adi","aeg","aeh","aei","afg","afh","afi","bdg","bdh","bdi","beg","beh","bei","bfg","bfh","bfi","cdg","cdh","cdi","ceg","ceh","cei","cfg","cfh","cfi"};

        A17_LetterCombinationsOfAPhoneNumber combinations = new A17_LetterCombinationsOfAPhoneNumber();

        Assert.assertArrayEquals(result,combinations.letterCombinations("234").toArray());
        Assert.assertArrayEquals(result,combinations.letterCombinations_1("234").toArray());

    }
}
