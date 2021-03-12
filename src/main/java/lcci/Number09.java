package lcci;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by wangyuedong02 on 2021/3/10 下午4:51
 *
 * @link https://leetcode-cn.com/problems/string-rotation-lcci/
 * @desc 字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。
 */
public class Number09 {
    /**
     * 没想到，记录一下
     *
     * @param s1
     * @param s2
     * @return
     */
    public static boolean isFlipedStringSimple(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        return (s1 + s1).contains(s2);
    }

    public static boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals("")) {
            return true;
        }
        for (int i = 0; i < s1.length(); i++) {
            if ((s1.substring(i) + s1.substring(0, i)).equals(s2)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "";
        String s2 = "";
//        System.out.println("aaa".indexOf("b"));
//        System.out.println("".indexOf(""));
//        System.out.println(isFlipedString(s1, s2));
//        System.out.println(isFlipedStringSimple(s1, s2));
        HashMap map = new HashMap();
        HashSet set = new HashSet();
        for (int i = 0; i < 5; i++) {
            map.put(10-i, i + 1);
            set.add(10-i);
        }
        System.out.println(set);
        System.out.println(map);

    }
}
