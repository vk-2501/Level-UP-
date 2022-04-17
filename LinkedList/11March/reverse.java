public class reverse {
    public ListNode rev(ListNode head){
        ListNode curr=head;
        ListNode prev=null;

        while(curr!=null){
            ListNode forw=curr.next;
            curr.next=prev;
            prev=curr;
            curr=forw;
        }
        return prev;
    }
}
