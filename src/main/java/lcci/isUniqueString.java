package lcci;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by wangyuedong02 on 2021/3/3 下午3:37
 *
 * @link https://leetcode-cn.com/problems/is-unique-lcci/
 * @description 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 */

public class isUniqueString {
    /**
     * HashMap方法
     *
     * @param astr
     * @return
     */
    public static boolean isUnique(String astr) {
        HashMap map = new HashMap();
        for (int i = 0; i < astr.length(); i++) {
            if (map.containsKey(astr.charAt(i))) {
                return false;
            } else {
                map.put(astr.charAt(i), 1);
            }
        }
        return true;
    }

    /**
     * 使用位运算
     *
     * @param astr
     * @return
     */
    public static boolean isUniqueWithBit(String astr) {
        int bitFlag = 0;
        for (int i = 0; i < astr.length(); i++) {
            int whichBit = astr.charAt(i) - 'a';
            if ((bitFlag & 1 << whichBit) > 0) {
                return false;
            } else {
                bitFlag |= 1 << whichBit;
            }
        }
        return true;
    }

    /**
     * 先排序再比较
     * @param astr
     * @return
     */
    public static boolean isUniqueWithSort(String astr) {
        char[] chars = astr.toCharArray();
        Arrays.sort(chars);
        //数组转化String:https://www.cnblogs.com/chengzilomo/p/5063881.html
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str1 = "leetcode";
        String str2 = "abc";
        System.out.println(isUniqueWithBit(str1));
        System.out.println(isUniqueWithBit(str2));
        System.out.println(isUniqueWithSort(str1));
        System.out.println(isUniqueWithSort(str2));
        System.out.println(1 << 2); //左移
        System.out.println(0 >> 2); //右移
        System.out.println('b' - 'a');
    }
}

