class Solution {
    public Node flatten(Node head) {
      if(head==null){
        return null;
      }
      Node cur=head;
      while(cur!=null){
        if(cur.child==null){
            cur=cur.next;
            continue;
        }
      
     Node child=cur.child;
     Node tail=child;
     while(tail.next !=null){
        tail=tail.next;
     }
     if(cur.next !=null){
        tail.next=cur.next;
        cur.next.prev=tail;
     }
     cur.next=child;
     child.prev=cur;
     cur.child=null;

     cur=cur.next;
      }
    return head;

    }
}
