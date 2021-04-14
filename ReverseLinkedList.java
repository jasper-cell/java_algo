package niuke;

public class ReverseLinkedList {

    public ListNode reverse(ListNode head){
        while (head == null || head.next == null){
            return head;
        }

        ListNode pre = null;
        ListNode cur = head;
        ListNode temp;

        while (cur != null){
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }

        return pre;
    }
}
