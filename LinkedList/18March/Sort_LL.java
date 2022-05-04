public class Sort_LL {
    public ListNode sortList(ListNode head) {
        
        if(head==null || head.next==null)
            return head;
        
        ListNode mid=middle(head);
        ListNode newhead=mid.next;
        mid.next=null;
        ListNode left=sortList(head);
        ListNode right=sortList(newhead);
        
        return mergetwolists(left,right);
        
    }
    
        public ListNode middle(ListNode head){
        ListNode slow=head,fast=head;
        
        while(fast.next!=null && fast.next.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    
    public ListNode mergetwolists(ListNode l1,ListNode l2){
        if(l1==null || l2==null)
            return l1!=null?l1:l2;
        
        ListNode dummy=new ListNode(-1);
        ListNode prev=dummy;
        
        ListNode c1=l1;
        ListNode c2=l2;
        
        while(c1!=null && c2!=null){
            if(c1.val<c2.val){
                prev.next=c1;
                c1=c1.next;
            }
            else{
                prev.next=c2;
                c2=c2.next;
            }
            prev=prev.next;
        }
        
        prev.next=c1!=null?c1:c2;
        
        return dummy.next;
        
        
    }
}
