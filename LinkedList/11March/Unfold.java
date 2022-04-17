
public class Main{
public static void unfold(ListNode head) {
   ListNode fh=head;
   ListNode sh=fh.next;

   ListNode fp=fh;
   ListNode sp=sh;

   while(sp!=null && sp.next!=null){
       ListNode f=sp.next;
       fp.next=f;
       sp.next=f.next;

       fp=fp.next;
       sp=sp.next;


   }
   sh=rev(sh);
   fp.next=sh;
    
}


public static ListNode rev(ListNode head){
    ListNode curr=head;
    ListNode prev=null;
    
    while(curr!=null){
        ListNode next=curr.next;
        curr.next=prev;
        prev=curr;
        curr=next;
        
    
    }
    return prev;
}
}
