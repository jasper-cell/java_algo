package niuke;

public class MergeTwoList {
    public static ListNode megerTwoList(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        ListNode head = (l1.val < l2.val)?l1:l2;
        ListNode tail = head;

        l1 = (head == l1)?l1.next:l1;
        l2 = (head == l2)?l2.next:l2;

        while (l1 != null && l2 != null){
            if(l1.val < l2.val){
                tail.next = l1;
                l1 = l1.next;
            }
            else{
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        tail.next = (l1 ==null) ?l2:l1;
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = Utils.generateList();
        ListNode l2 = Utils.generateList();
        ListNode node = megerTwoList(l1, l2);

        Utils.iteratorList(node);
    }
}
