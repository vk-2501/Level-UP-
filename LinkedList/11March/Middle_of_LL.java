public static class Main{
  public static ListNode middle_1(ListNode head){
    //   first middle in case of even length
      ListNode fast=head;
      ListNode slow=head;

      while(fast.next!=null && fast.next.next!=null){
          fast=fast.next.next;
          slow=slow.next;
      }

      return slow;
      
  }

  public ListNode middleNode_2(ListNode head) {
        //gives second middle in case of even lengths
    if(head==null || head.next==null){
        return head;
    }
    ListNode slow=head,fast=head;
    while( fast!=null && fast.next!=null ){
        fast=fast.next.next;
        slow=slow.next;
    }
    return slow;
}

}
