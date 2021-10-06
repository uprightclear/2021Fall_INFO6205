package question4_2;

import question4_1.ListNode;

public class Main {
    public static void main(String[] args) {
        Node example = new Node(3);
        Node dummy = example;
        dummy.next = new Node(4);
        dummy = dummy.next;
        dummy.next = new Node(1);
        dummy = dummy.next;
        dummy.next = example;

        printList(insert(example, 2));
    }

    //Time Complexity: o(n)
    //Space Complexity: o(1)
    public static Node insert(Node head, int insertVal) {
        if(head == null) {
            Node newNode = new Node(insertVal, null);
            newNode.next = newNode;
            return newNode;
        }

        Node pre = head;
        Node cur = head.next;

        while(cur.next != head.next) {
            if(pre.val <= insertVal && insertVal <= cur.val) {
                pre.next = new Node(insertVal, cur);
                return head;
            } else if(pre.val > cur.val) {
                if(insertVal >= pre.val || insertVal <= cur.val) {
                    pre.next = new Node(insertVal, cur);
                    return head;
                }
            }
            pre = cur;
            cur = cur.next;
        }

        pre.next = new Node(insertVal, cur);
        return head;
    }

    private static void printList(Node node){
        Node temp = node;
        do{
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }while(temp != node);
        System.out.println("end");
    }
}
