/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
         if (head == null || k == 1) {
            return head;
        }

        // Count the total number of nodes
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupEnd = dummy;
        
        while (count >= k) {
            ListNode prev = null, curr = prevGroupEnd.next;
            ListNode nextGroupStart = curr;
            
            // Reverse k nodes
            for (int i = 0; i < k; i++) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            // Connect reversed part with previous and next groups
            prevGroupEnd.next = prev;
            nextGroupStart.next = curr;
            prevGroupEnd = nextGroupStart;

            count -= k;
        }

        return dummy.next;
    }
}