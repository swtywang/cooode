package jindian;

import java.util.HashMap;

/**
 * Created by wangyuedong02 on 2021/3/3 下午3:37
 *
 * @link https://leetcode-cn.com/problems/is-unique-lcci/
 */

public class isUniqueString {
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

    public static void main(String[] args) {
        String str1 = "leetcode";
        String str2 = "abc";
        System.out.println(isUniqueWithBit(str1));
        System.out.println(isUniqueWithBit(str2));
        System.out.println(1 << 2); //左移
        System.out.println(0 >> 2); //右移
        System.out.println('b' - 'a');
    }
}

