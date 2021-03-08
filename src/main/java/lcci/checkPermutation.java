package lcci;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by wangyuedong02 on 2021/3/3 下午5:06
 *
 * @link https://leetcode-cn.com/problems/check-permutation-lcci/
 * @description: 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 */
public class checkPermutation {
    /**
     * 排序
     *
     * @param s1
     * @param s2
     * @return
     */
    public static boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] ss1 = s1.toCharArray();
        char[] ss2 = s2.toCharArray();
        Arrays.sort(ss1);
        Arrays.sort(ss2);
        for (int i = 0; i < s1.length(); i++) {
            if (ss1[i] != ss2[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean CheckPermutationWithHashMap(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap();
        for (int i = 0; i < s1.length(); i++) {
            map.put(s1.charAt(i), map.get(s1.charAt(i)) == null ? 1 : map.get(s1.charAt(i)) + 1);
            map.put(s2.charAt(i), map.get(s2.charAt(i)) == null ? -1 : map.get(s2.charAt(i)) - 1);
        }
        Iterator<Character> iterator = map.keySet().iterator();
        // 从while循环中读取key
        while (iterator.hasNext()) {
            Character key = iterator.next();
            if (map.get(key) != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "bca";
        String s3 = "bcs";
        String s4 = "cws";
        String s5 = "asvnpzurz";
        String s6 = "urzsapzvn";
        System.out.println(CheckPermutation(s1, s2));
        System.out.println(CheckPermutation(s3, s4));
        System.out.println(CheckPermutation(s5, s6));
        System.out.println(CheckPermutationWithHashMap(s1, s2));
        System.out.println(CheckPermutationWithHashMap(s3, s4));
        System.out.println(CheckPermutationWithHashMap(s5, s6));
    }
}
