public class Palindromiclist {
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null){
            return true;
        }
        
        ListNode middle=mid(head);
        ListNode newmid=middle.next;
        middle.next=null;
        newmid=rev(newmid);
    
        boolean res=true;
        ListNode c1=head;
        ListNode c2=newmid;
        while(c1!=null && c2!=null)
        {
            if(c1.val!=c2.val){
                res=false;
            break;
            }
            
            c1=c1.next;
            c2=c2.next;
        }
        
        return res;
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
