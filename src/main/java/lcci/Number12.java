package lcci;

/**
 * Created by wangyuedong02 on 2021/3/12 下午3:19
 *
 * @link https://leetcode-cn.com/problems/delete-middle-node-lcci/
 */


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Number12 {
    public static void deleteNode(ListNode node) {
        //遍历条件：当前节点-倒数第二个节点
        ListNode cur = node;
        while (cur.next != null) {
            ListNode next = cur.next;
            cur.val = next.val;
            if (cur.next.next == null) {
                cur.next = null;
                break;
            }
            cur = cur.next;
        }
    }

    /**
     * 这咱没想到
     * @param node
     */
    public static void deleteNodeSmart(ListNode node){
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        deleteNode(node3);
    }
}

