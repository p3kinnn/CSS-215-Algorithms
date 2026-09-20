import java.util.LinkedList;
import java.util.Scanner;
public class SecondTask {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        ListNode node1 = new ListNode(10);
        ListNode node2 = new ListNode(20);
        ListNode node3 = new ListNode(30);
        ListNode node4 = new ListNode(40);
        ListNode node5 = new ListNode(50);
        ListNode node6 = new ListNode(60);
        ListNode node7 = new ListNode(70);
        ListNode node8 = new ListNode(80);
        node1.previous = null;
        node1.next = node2;
        node2.previous = node1;
        node2.next = node3;
        node3.previous = node2;
        node3.next = node4;
        node4.previous = node3;
        node4.next = node5;
        node5.previous = node4;
        node5.next = node6;
        node6.previous = node5;
        node6.next = node7;
        node7.previous = node6;
        node7.next = node8;
        node8.previous = node7;
        node8.next = null;
        int len = 1;
        ListNode head = node1;
        ListNode tail = node1;
        ListNode temp1 = head;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }
        num = num % len;
        if (num == 0) {
            while (temp1 != null) {
                System.out.println(temp1.val);
                temp1 = temp1.next;
            }
        }
        else {
            ListNode current = head;
            for (int i = 0; i < num - 1; i++) {
                current = current.next;
            }

            ListNode newHead = current.next;
            current.next = null;
            tail.next = head;
            ListNode temp2 = newHead;


            while (temp2 != null) {
                System.out.println(temp2.val);
                temp2 = temp2.next;
            }
        }
    }
}

