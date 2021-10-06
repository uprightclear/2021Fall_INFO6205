package question4_4;

import question4_1.ListNode;

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

        printList(reverseBetween(example, 2, 4));
    }


    //Time Complexity: o(n)
    //Space Complexity: o(1)
    public static ListNode tmp;
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == 1) return reverseN(head, right);
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }

    public static ListNode reverseN(ListNode head, int n){
        if(n == 1){
            tmp = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n -1);
        head.next.next = head;
        head.next = tmp;
        return last;
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
