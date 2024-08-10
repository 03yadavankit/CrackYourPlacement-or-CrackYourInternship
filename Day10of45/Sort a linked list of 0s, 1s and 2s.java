package Day10of45;

class Solution {
    // Function to sort a linked list of 0s, 1s, and 2s.
    static Node segregate(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Step 1: Count the number of 0s, 1s, and 2s
        int count0 = 0, count1 = 0, count2 = 0;
        Node temp = head;
        
        while (temp != null) {
            if (temp.data == 0) {
                count0++;
            } else if (temp.data == 1) {
                count1++;
            } else {
                count2++;
            }
            temp = temp.next;
        }

        // Step 2: Overwrite the linked list with the correct number of 0s, 1s, and 2s
        temp = head;
        
        // Place 0s
        while (count0 > 0) {
            temp.data = 0;
            temp = temp.next;
            count0--;
        }
        
        // Place 1s
        while (count1 > 0) {
            temp.data = 1;
            temp = temp.next;
            count1--;
        }
        
        // Place 2s
        while (count2 > 0) {
            temp.data = 2;
            temp = temp.next;
            count2--;
        }
        
        return head;
    }
}

