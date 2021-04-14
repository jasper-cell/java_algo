package niuke;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Utils {

    public static ListNode generateList(){
        ListNode node1 = new ListNode((int)(Math.random() * 100));
        ListNode node2 = new ListNode((int)(Math.random() * 100));
        ListNode node3 = new ListNode((int)(Math.random() * 100));
        ListNode node4 = new ListNode((int)(Math.random() * 100));
        ListNode node5 = new ListNode((int)(Math.random() * 100));

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        return node1;
    }

    public static void iteratorList(ListNode head){
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        int[] a = {2,5,1,4,2,5,6};
        Arrays.sort(a);
        System.out.println(a.toString());

        int b = Arrays.asList(a) instanceof ArrayList ? 1 :0;
        System.out.println(b);
    }
}
