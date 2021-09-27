package question3_4;

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
        dummy.next = null;

        printList(groupNode(example));
    }

    //Time Complexity: o(n)
    //Space Complexity: o(1)
    private static ListNode groupNode(ListNode head) {
        ListNode oddHead = new ListNode(0);
        ListNode oddTail = oddHead;
        ListNode evenHead = new ListNode(0);
        ListNode evenTail = evenHead;

        boolean odd = true;
        while(head != null) {
            if(odd) {
                oddTail.next = head;
                oddTail = oddTail.next;
            } else {
                evenTail.next = head;
                evenTail = evenTail.next;
            }
            head = head.next;
            odd = !odd;
        }

        oddTail.next = evenHead.next;
        evenTail.next = null;

        return oddHead.next;
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
