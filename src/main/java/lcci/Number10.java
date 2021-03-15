package lcci;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by wangyuedong02 on 2021/3/12 上午10:49
 *
 * @link https://leetcode-cn.com/problems/remove-duplicate-node-lcci/
 * @desc 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 */
public class Number10 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return head;
        }
        Set<Integer> in_data = new HashSet<Integer>();
        in_data.add(head.val);
        ListNode cur = head;
        while (cur.next != null) {
            ListNode next = cur.next;
            if (!in_data.add(next.val)) {
                cur.next = cur.next.next;
            } else {
                cur = next;
            }
        }
        cur.next = null;
        return head;
    }

    public static ListNode study(ListNode head) {
        if (head == null) {
            return head;
        }
        Set<Integer> occurred = new HashSet<Integer>();
        occurred.add(head.val);
        ListNode pos = head;
        // 枚举前驱节点
        while (pos.next != null) {
            // 当前待删除节点
            ListNode cur = pos.next;
            if (occurred.add(cur.val)) {
                pos = pos.next;
            } else {
                pos.next = pos.next.next;
            }
        }
        pos.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(2);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = null;
        removeDuplicateNodes(n1);
        while (n1.next != null) {
            System.out.println(n1.next.val);
        }
    }
}
