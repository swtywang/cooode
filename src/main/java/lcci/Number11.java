package lcci;

/**
 * Created by wangyuedong02 on 2021/3/12 下午3:55
 *
 * @Link https://leetcode-cn.com/problems/kth-node-from-end-of-list-lcci/
 * @desc 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 */


public class Number11 {

    public int kthToLast(ListNode head, int k) {
        //1.遍历长度N
        //2.返回第N-k+1个节点的值
        int length = 0;
        ListNode cur = head;

        while (cur != null) {
            length++;
            cur = cur.next;
        }

        int index = length - k + 1;
        ListNode cur1 = head;
        while (--index>0){
            cur1 = cur1.next;
        }
        return cur1.val;

    }
}
