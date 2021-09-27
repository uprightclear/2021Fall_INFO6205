package question3_5;

import question3_1.ListNode;

public class Main {
    public static void main(String[] args) {
        ListNode example = new ListNode(1);
        ListNode dummy = example;
        dummy.next = new ListNode(2);
        dummy = dummy.next;
        dummy.next = new ListNode(3);
        dummy = dummy.next;
        dummy.next = new ListNode(4);
        dummy = dummy.next;
        dummy.next = new ListNode(5);
        dummy = dummy.next;
        dummy.next = new ListNode(6);
        dummy = dummy.next;
        dummy.next = null;

        System.out.println(findMiddle(example).val);
    }

    //Time Complexity: o(n)
    //Space Complexity: o(1)
    private static ListNode findMiddle(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
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
