package question3_6;

import question3_1.ListNode;

public class Main {
    static int ptr;
    public static void main(String[] args) {
        ListNode example = new ListNode(3);
        ListNode dummy = example;
        dummy.next = new ListNode(2);
        dummy = dummy.next;
        ListNode intersection = dummy;
        dummy.next = new ListNode(0);
        dummy = dummy.next;
        dummy.next = new ListNode(-4);
        dummy = dummy.next;
        dummy.next = intersection;

        if(cycleBegin(example) != null) System.out.println("tail connects to node index " + ptr);
        else System.out.println("no cycle");
    }

    //Time Complexity: o(n)
    //Space Complexity: o(1)
    private static ListNode cycleBegin(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null){
            slow = slow.next;
            if(fast.next != null){
                fast = fast.next.next;
            }else{
                return null;
            }
            if(fast == slow){
                ListNode begin = head;
                while(begin != slow){
                    slow = slow.next;
                    begin = begin.next;
                    ptr++;
                }
                return begin;
            }
        }
        return null;
    }
}
