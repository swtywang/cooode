package lcci;


/**
 * Created by wangyuedong02 on 2021/3/5 下午2:58
 *
 * @link https://leetcode-cn.com/problems/compress-string-lcci/
 */
public class compressString {
    /**
     * 我们从左往右遍历字符串，用 chch 记录当前要压缩的字符，\textit{cnt}cnt 记录 chch 出现的次数，如果当前枚举到的字符 s[i]s[i] 等于 chch ，我们就更新 \textit{cnt}cnt 的计数，即 cnt = cnt + 1，否则我们按题目要求将 chch 以及 \textit{cnt}cnt 更新到答案字符串 \textit{ans}ans 里，即 ans = ans + ch + cnt，完成对 chch 字符的压缩。随后更新 chch 为 s[i]s[i]，cntcnt 为 11，表示将压缩的字符更改为 s[i]s[i]。
     * <p>
     * 在遍历结束之后，我们就得到了压缩后的字符串 \textit{ans}ans，并将其长度与原串长度进行比较。如果长度没有变短，则返回原串，否则返回压缩后的字符串。
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/compress-string-lcci/solution/zi-fu-chuan-ya-suo-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param s
     * @return
     */
    public static String Solution(String s) {
        //需要判空，否则空指针
        if (s.length() == 0) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        //开始拼接
        Character cur = s.charAt(0);
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == cur) {
                count++;
            } else {
                sb.append(cur);
                sb.append(count);
                cur = s.charAt(i);
                count = 1;
            }
        }
        sb.append(cur);
        sb.append(count);
        return sb.toString().length() >= s.length() ? s : sb.toString();
    }

    public static void main(String[] args) {
        String s = "abbccd";
        System.out.println(Solution(s));
    }
}
