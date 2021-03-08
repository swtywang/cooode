package lcci;

/**
 * Created by wangyuedong02 on 2021/3/5 上午11:05
 *
 * @link https://leetcode-cn.com/problems/one-away-lcci/
 * @description 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
 */
public class oneEditAway {
    public static boolean Solution(String str1, String str2) {
        int len_str1 = str1.length();
        int len_str2 = str2.length();
        if (Math.abs(len_str1 - len_str2) > 1) {
            return false;
        }
        //str1存放长的，str2存放短的
        if (len_str1 < len_str2) {
            String temp = str1;
            str1 = str2;
            str2 = temp;
        }
        int bigLen = str1.length();
        int shortLen = str2.length();
        if (len_str1 == len_str2) {
            //只可能通过替换的方式达到一致
            int diff = 0;
            for (int i = 0; i < len_str1; i++) {
                if (str1.charAt(i) != str2.charAt(i)) {
                    diff++;
                }
                if (diff > 1) {
                    return false;
                }
            }
            return true;
        } else {
            //通过删除/添加一个字符的方式，短的只可能是添加
            /**
             * 开始的做法，每次便利需要拼接字符串存到StringBuilder中，比较笨拙
             StringBuilder sb = new StringBuilder();
             //通过删除or添加，短的添加
             for (int i = 0; i < bigLen; i++) {
             sb.append(str1, 0, i);
             sb.append(str1.substring(i + 1));
             if (sb.toString().equals(str2)) {
             return true;
             }
             sb.delete(0,bigLen);
             }
             **/
            int str1Index = 0;
            int str2Index = 0;
            int count = 0;
            while (str1Index < bigLen && str2Index < shortLen) {
                if (str1.charAt(str1Index) == str2.charAt(str2Index)) {
                    str1Index++;
                    str2Index++;
                } else {
                    str1Index++;
                    count++;
                }

            }
            return count <= 1;
        }
    }

    public static void main(String[] args) {
        String str1 = "pael";
        String str2 = "pal";
        System.out.println(Solution(str1, str2));
    }

}
