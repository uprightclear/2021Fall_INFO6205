package question3_3;

import question3_1.ListNode;

public class Main {
    public static void main(String[] args) {
        ListNode a = new ListNode(2);
        ListNode dummy = a;
        dummy.next = new ListNode(4);
        dummy = dummy.next;
        dummy.next = new ListNode(3);
        dummy = dummy.next;
        dummy.next = null;

        ListNode b = new ListNode(5);
        ListNode dummy2 = b;
        dummy2.next = new ListNode(6);
        dummy2 = dummy2.next;
        dummy2.next = new ListNode(4);
        dummy2 = dummy2.next;
        dummy2.next = null;

        printList(addTwoNumbers(a, b));
    }

    //Time Complexity: o(n) n is the max length of 2 given lists
    //Space Complexity: o(n)
    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tail = new ListNode(0);
        ListNode dummy = tail;
        int sum = 0;
        while(l1 != null || l2 != null || sum != 0){
            sum += (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val);
            tail.next = new ListNode(sum % 10);
            tail = tail.next;
            sum /= 10;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        return dummy.next;
    }

    private static void printList(ListNode node){
        ListNode temp = node;
        while(temp != null){
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
}
