package algo.supo3;

import java.util.*;

public class Permutations {
    /**
     * @return true if s1 is a permutation of s2
     */
    public static boolean arePermuations(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        char[] ca1 = s1.toCharArray();
        char[] ca2 = s2.toCharArray();
        Arrays.sort(ca1);
        Arrays.sort(ca2);

        for (int i = 0; i < s1.length(); ++i) {
            if (ca1[i] != ca2[i]) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(arePermuations("abcd", "abdc"));
    }
}
