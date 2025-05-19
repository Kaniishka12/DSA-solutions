
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            
    ListNode rn=new ListNode(Integer.MIN_VALUE);
    ListNode hn=rn;
    while(list1!=null && list2!=null){
        if(list1.val<=list2.val){
            rn.next=list1;
            list1=list1.next;
        }
        else{
             rn.next=list2;
            list2=list2.next;
        }
        rn=rn.next;
    }
    if(list1==null){
        rn.next=list2;
    }else if(list2==null){
     rn.next=list1;
    }
     return hn.next;

    
        }
    
}