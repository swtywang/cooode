package lcci;

/**
 * Created by wangyuedong02 on 2021/3/12 下午5:28
 *
 * @link https://leetcode-cn.com/problems/sum-lists-lcci/
 * @desc 给定两个用链表表示的整数，每个节点包含一个数位。这些数位是反向存放的，也就是个位排在链表首部。编写函数对这两个整数求和，并用链表形式返回结果。
 */
public class Number14 {
    /**
     * 错误做法，可能会溢出
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbersWrong(ListNode l1, ListNode l2) {
        long sum1 = 0;
        int order1 = 0;
        ListNode temp1 = l1;
        while (temp1 != null) {
            sum1 += temp1.val * Math.pow(10, order1);
            order1++;
            temp1 = temp1.next;
        }

        long sum2 = 0;
        int order2 = 0;
        ListNode temp2 = l2;
        while (temp2 != null) {
            sum2 += temp2.val * Math.pow(10, order2);
            order2++;
            temp2 = temp2.next;
        }

        long result = sum1 + sum2;
        String str_result = String.valueOf(result);
        ListNode head = new ListNode(Integer.parseInt(String.valueOf(str_result.charAt(str_result.length() - 1))));
        ListNode cur = head;
        for (int i = 1; i < str_result.length(); i++) {
            ListNode temp = new ListNode(Integer.parseInt(String.valueOf(str_result.charAt(str_result.length() - i - 1))));
            cur.next = temp;
            cur = cur.next;
        }
        return head;
    }

    public static ListNode Solution(ListNode l1, ListNode l2) {
        int flag = (l1.val + l2.val) / 10;
        ListNode head = new ListNode((l1.val + l2.val) % 10);
        l1 = l1.next;
        l2 = l2.next;
        ListNode cur = head;
        while (l1 != null || l2 != null) {
            int val1;
            int val2;
            if (l1 != null) {
                val1 = l1.val;
                l1 = l1.next;
            } else {
                val1 = 0;
            }
            if (l2 != null) {
                val2 = l2.val;
                l2 = l2.next;
            } else {
                val2 = 0;
            }
            int total = val1 + val2 + flag;
            flag = total / 10;
            int val3 = total % 10;

            ListNode node = new ListNode(val3);
            cur.next = node;
            cur = node;

        }
        if (flag>0){
            ListNode node = new ListNode(flag);
            cur.next = node;
        }
        return head;
    }


    public static void main(String[] args) {
        ListNode head1 = new ListNode(9);
        ListNode head2 = new ListNode(1);
        ListNode node1 = new ListNode(9);
        ListNode node2 = new ListNode(9);
        ListNode node3 = new ListNode(9);
        ListNode node4 = new ListNode(9);
        ListNode node5 = new ListNode(9);
        ListNode node6 = new ListNode(9);
        ListNode node7 = new ListNode(9);
        ListNode node8 = new ListNode(9);
        ListNode node9 = new ListNode(9);
//        head1.next = node1;
        head2.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        Solution(head1, head2);
    }
}
