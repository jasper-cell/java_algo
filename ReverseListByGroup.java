package niuke;

import java.util.Stack;

class ListNode{
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class ReverseListByGroup {
    public static ListNode reverseListByGroup(ListNode head, int k){
        // 首先进行鲁棒性校验
        // 当链表为空或者链表中只有一个头结点的时候, 翻转是没有必要的, 并且当k<=1的时候翻转也是没有意义的
        if(head == null || head.next == null || k<=1){
            return head;
        }

        // 定义虚拟节点方便后面的使用
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        // 定义对应的链表的标记点
        ListNode pre = dummyHead;
        ListNode cur = head;
        ListNode temp = null;

        // 统计链表中节点的个数, 方便后面进行分组的操作
        int length = 0;
        while(head != null){
            length++;
            head = head.next;
        }

        for(int i =0; i < length/k; i++){  // 对链表的长度进行分组处理
            for(int j = 1; j < k; j++){  // 对k个元素进行翻转
                temp = cur.next;
                cur.next = temp.next;  // 此处需要特别的注意
                temp.next = pre.next;
                pre.next = temp;
            }

            pre = cur;
            cur = cur.next;
        }
//        String s = "1234";
//        char[] chars = s.toCharArray();
//        new Stack<>()
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode res = reverseListByGroup(node1, 2);
        while(res != null) {
            System.out.println(res.val);
            res = res.next;
        }

    }
}
