
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            
   ListNode ne=new ListNode(Integer.MIN_VALUE);
   ListNode n=ne;
   while(list1!=null && list2!=null){
    if(list1.val<=list2.val){
        ne.next=list1;
        list1=list1.next;
    }else{
        ne.next=list2;
        list2=list2.next;
    }
    ne=ne.next;
   }
   if(list1==null){
    ne.next=list2;
    
   }
   else{
    ne.next=list1;
  
   }
    return n.next;
        }
    
}