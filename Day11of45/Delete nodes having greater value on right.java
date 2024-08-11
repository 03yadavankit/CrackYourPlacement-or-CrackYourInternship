package Day11of45;

class Solution {
    Node compute(Node head) {
        head = reverse(head);

        Node maxNode = head;
        Node current = head;

        while (current != null && current.next != null) {
            if (current.next.data < maxNode.data) {
                current.next = current.next.next;
            } else {
                current = current.next;
                maxNode = current;
            }
        }
        
        head = reverse(head);

        return head;
    }

    Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
