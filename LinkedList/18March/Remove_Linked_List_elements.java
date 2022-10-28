//HomeWork Ques 1

//Solution 

public class Remove_Linked_List_elements {
    public class ListNode{
        int val;
            ListNode next;
            ListNode() {}
            ListNode(int val) { this.val = val; }
            ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode removeElements(ListNode head, int val) {
        
        if(head==null )
            return head;
        if(head.next==null && head.val==val)
            return null;        
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        
        ListNode prev=dummy;
        
        ListNode curr=head;
        
        while(curr!=null){
            if(curr.val==val){
                curr=curr.next;
                
            }
            
            else{
                prev.next=curr;
                prev=prev.next;
                curr=curr.next;
            }
        }
        prev.next=curr;
        
        return dummy.next;
       
    }
}
