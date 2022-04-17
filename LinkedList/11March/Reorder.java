public class Reorder {
    public void reorderList(ListNode head) {
        
        if(head==null || head.next==null)
            return;
        
        ListNode middle=mid(head);
        ListNode newMidHead=middle.next;
        middle.next=null;
        
        newMidHead=rev(newMidHead);
        
        ListNode newh=new ListNode(-1);
        ListNode prev=newh;
        
        ListNode c1=head;
        ListNode c2=newMidHead;
        ListNode f1=null;
        ListNode f2=null;
        
        
        
        while(c1!=null && c2!=null){
            f1=c1.next;
            f2=c2.next;
            
            c1.next=c2;
            c2.next=f1;
            
           c1=f1;
            c2=f2;
            
            
        }
        
        
        
    }
    
       public ListNode mid(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        
        while(fast.next!=null && fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    
        public  ListNode rev(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        
        while(curr!=null){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            
        }
        return prev;
    }
}
