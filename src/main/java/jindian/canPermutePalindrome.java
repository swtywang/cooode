package jindian;

import java.util.*;

/**
 * Created by wangyuedong02 on 2021/3/4 下午4:00
 *
 * @link https://leetcode-cn.com/problems/palindrome-permutation-lcci/
 */
public class canPermutePalindrome {
    public static boolean SolutionWithArray(String s) {
        int[] array = new int[128];
        for (int i = 0; i < s.length(); i++) {
            array[s.charAt(i)]++;
        }
        int time = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                time++;
            }
        }
        return time <= 1;
    }

    public static boolean SolutionWithHashMap(String s) {
        HashMap<Character, Integer> map = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        int time = 0;
        Set set = map.keySet();
        Iterator<Character> it = set.iterator();
        while (it.hasNext()) {
            Character key = it.next();
            if (map.get(key) % 2 != 0) {
                time++;
            }
        }
        return time <= 1;
    }


    public static boolean SolutionWithStack(String s) {
        if (s.length()==0){
            return true;
        }
        Stack<Character> st = new Stack();
        char[] list = s.toCharArray();
        Arrays.sort(list);
        st.push(list[0]);
        for (int i = 1; i < list.length; i++) {
            //如果栈顶是当前的，就出栈，否则入栈
            if (st.size()==0 || list[i] != st.peek()) {
                st.push(list[i]);
            } else {
                st.pop();
            }
        }
        return st.size() <= 1;
    }

    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(SolutionWithHashMap(s));
        System.out.println(SolutionWithArray(s));
        System.out.println(SolutionWithStack(s));
    }
}
