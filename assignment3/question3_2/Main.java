package question3_2;

import question3_1.ListNode;

public class Main {
    public static void main(String[] args) {
        ListNode example = new ListNode(1);
        ListNode dummy = example;
        dummy.next = new ListNode(2);
        dummy = dummy.next;
        dummy.next = new ListNode(6);
        dummy = dummy.next;
        dummy.next = new ListNode(3);
        dummy = dummy.next;
        dummy.next = new ListNode(6);
        dummy = dummy.next;
        dummy.next = null;

        int target = 6;
        printList(removeNode(example, target));
    }

    //Time Complexity: o(n) n is the length of list
    //Space Complexity: o(1)
    private static ListNode removeNode(ListNode head, int target) {
        ListNode ans = new ListNode(0);
        ans.next = head;

        ListNode pre = ans, curr = head;
        while(curr != null) {
            if(curr.val == target) {
                pre.next = curr.next;
            } else {
                pre = curr;
            }
            curr = curr.next;
        }

        return ans.next;
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
