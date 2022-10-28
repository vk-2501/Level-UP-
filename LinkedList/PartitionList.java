class Solution {
    public ListNode PartitionList(ListNode head, int x) {
        if(head==null || head.next==null )
            return head;
        
        ListNode sHead=new ListNode(-1);
        ListNode st=sHead;
        ListNode lHead=new ListNode(-1);
        ListNode lt=lHead;
        
        ListNode curr=head;
        while(curr!=null){
            if(curr.val<x){
                st.next=curr;
                st=st.next;
                
            }
            else{
                lt.next=curr;
                lt=lt.next;
                
            }
            
            curr=curr.next;
        }
        
        lt.next=null;
        st.next=lHead.next;
        
        return sHead.next;
        
    }
}
