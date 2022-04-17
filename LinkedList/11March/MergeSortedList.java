class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode c1=list1;
        ListNode c2=list2;
        ListNode dummy=new ListNode(-1);
        ListNode prev=dummy;
        
        while(c1!=null && c2!=null){
            if(c1.val<c2.val){
                prev.next=c1;
                prev=prev.next;
                c1=c1.next;
            }
            else{
                prev.next=c2;
                prev=prev.next;
                c2=c2.next;
            }
        }
        
       prev.next=(c1!=null?c1:c2);
        return dummy.next;
    }
}