package lcci;

/**
 * Created by wangyuedong02 on 2021/3/4 上午11:05
 *
 * @link https://leetcode-cn.com/problems/string-to-url-lcci/
 * @description URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。
 * （注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）
 */
public class replaceSpaces {
    public static String replaceSpaces(String S, int length) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char ch = S.charAt(i);
            //比三目运算符执行时间短一倍以上，s.append(ch == ' '? "%20": ch)
            if (ch == ' ') {
                s.append("%20");
            } else {
                s.append(ch);
            }
        }
        return s.toString();
    }

    public static String SolutionWithArray(String S, int length) {
        char[] ch = new char[length * 3];
        int index = 0;
        for (int i = 0; i < length; i++) {
            char c = S.charAt(i);
            if (c == ' ') {
                ch[index++] = '%';
                ch[index++] = '2';
                ch[index++] = '0';
            } else {
                ch[index] = c;
                index++;
            }
        }
        return new String(ch, 0, index);
    }

    public static void main(String[] args) {
        String s = "     ";
        System.out.println(replaceSpaces(s, 5));
        System.out.println(SolutionWithArray(s, 5));
    }
}
