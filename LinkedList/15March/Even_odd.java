public class Even_odd{
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
     
    //pepcoding
    public static ListNode segregateEvenOdd(ListNode head) {
       
        if(head==null || head.next==null)
        return head;
        
        ListNode even=new ListNode(-1);
        ListNode ep=even;
        
        ListNode odd=new ListNode(-1);
        ListNode op=odd;
        
        ListNode curr=head;
        while(curr!=null){
         
            if(curr.val%2==0){
                ep.next=curr;
                ep=ep.next;
 
            }
            else {
                op.next=curr;
                op=op.next;
               
            }
            curr=curr.next;
        }
        
        if(op.next!=null){
            op.next=null;
        }
        
        ep.next=odd.next;
        return even.next;
        
     }
 
     //leetcode
     public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        
        ListNode even=new ListNode(-1);
        ListNode et=even;
        
        ListNode odd=new ListNode(-1);
        ListNode ot=odd;
        
        ListNode curr=head;
        int i=1;
        while(curr!=null){
            if(i%2!=0){
                ot.next=curr;
                ot=ot.next;
                
            }
            else{
                et.next=curr;
                et=ot.next;
            }
            curr=curr.next;
            i++;
        }
        
        //THIS IS IMPORTANT
        if(et.next!=null){
            et.next=null;
        }
        
        
        ot.next=even.next;
        return odd.next;
        
        
    }
}