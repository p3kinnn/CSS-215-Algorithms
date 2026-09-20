import java.util.LinkedList;
public class FirstTask {
    public static void main(String[] args){
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode prev = null;
    node1.previous = null;
    node1.next = node2;
    node2.previous = node1;
    ListNode node3 = new ListNode(3);
    node2.next = node3;
    node3.previous = node2;
    ListNode node4 = new ListNode(4);
    node3.next = node4;
    node4.previous = node3;
    ListNode node5 = new ListNode(5);
    node4.next = node5;
    node5.previous = node4;

    ListNode node6 = new ListNode(6);
    node5.next = node6;
    node6.previous = node5;
    ListNode node7 = new ListNode(7);
    node6.next = node7;
    node7.previous = node6;
    ListNode newHead = node1;
    ListNode current = node1;
    while (current != null) {
        ListNode temp = current.previous;
        current.previous = current.next;
        current.next = temp;
        newHead = current;
        current = current.previous;

    }

            while (newHead != null) {
                System.out.println(newHead.val);
                newHead  = newHead.next;
            }
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode previous;
    ListNode(int val){
        this.val = val;
    }
}
