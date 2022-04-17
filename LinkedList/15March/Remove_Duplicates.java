public class Remove_Duplicates {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public ListNode deleteDuplicates_83(ListNode head) {
       if(head==null || head.next==null)
            return head;
        
        ListNode prev=head,curr=head.next;
        while(curr!=null){
            if(prev.val==curr.val){
                curr=curr.next;
            }
            
            else if(prev.val!=curr.val){
                prev.next=curr;
                curr=curr.next;
                prev=prev.next;
            }
        }
        prev.next=curr;
        
        return head;
    }

    public ListNode deleteDuplicates_82(ListNode head) {//leetcode 82
        if(head==null || head.next==null)
            return head;
        
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode prev=dummy;
    
        while(head!=null){
            if(head.next!=null && head.val==head.next.val)
            {
                while(head.next!=null && head.val==head.next.val){
                    head=head.next;
                }
                
                prev.next=head.next;
            }
            else
            {
                prev=prev.next;
            }
            
            head=head.next;
        }
        return dummy.next;
    }
}