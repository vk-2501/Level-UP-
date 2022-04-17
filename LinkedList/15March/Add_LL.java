public class Add_LL{
    public class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
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

    // 2->3->4->5 
    // 4->2->9->8
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        //rev the lists
        l1=rev(l1);
        l2=rev(l2);
        ListNode dummy=new ListNode(-1),prev=dummy;

        ListNode c1=l1,c2=l2;
        int carry=0;
        while(c1!=null || c2!=null || carry!=0 ){
            int sum=carry+(c1!=null? c1.val:0)+(c2!=null?c2.val:0);
            prev.next=new ListNode(sum%10);
            carry=sum/10;

            prev=prev.next;
            if(c1!=null) c1=c1.next;
            if(c2!=null) c2=c2.next;
        }
        

        l1=rev(l1);
        l2=rev(l2);
        ListNode head=dummy.next;
        dummy.next=null;
        head=rev(head);
        return head;

    }
}