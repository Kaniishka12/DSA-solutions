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
    public ListNode middleNode(ListNode head) {
      ListNode temp=head;
      int c=0;
      while(temp!=null){
        c++;
        temp=temp.next;
        
      }
      int i=0;
      int idx=(int)(c/2);
      ListNode emp=head;
      while(i<idx){
       emp=emp.next;
       i++;
      }
      return emp;
    }
}