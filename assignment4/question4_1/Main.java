package question4_1;

public class Main {
    public static void main(String[] args) {
        ListNode example = new ListNode(4);
        ListNode dummy = example;
        dummy.next = new ListNode(5);
        dummy = dummy.next;
        ListNode input = dummy;
        dummy.next = new ListNode(1);
        dummy = dummy.next;
        dummy.next = new ListNode(9);
        dummy = dummy.next;
        dummy.next = null;

        deleteNode(input);
        printList(example);
    }

    //Time Complexity: o(1)
    //Space Complexity: o(1)
    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
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
