import java.util.List;

public class Subtract_LL{
    public class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode rev(ListNode head){
          
        if (head == null || head.next == null)
          return head;
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
    
        public  static int len(ListNode head){
            int c=0;
            while(head!=null){
                c++;
                head=head.next;
            }
            return c;
        }
    
        public static int isBigger(ListNode l1, ListNode l2){
           
            int len1=len(l1),len2=len(l2);
            
            if(len1==len2){
                ListNode c1=l1,c2=l2;
                while(c1!=null) 
                {
                    if(c1.val!=c2.val)
                    return c1.val-c2.val;
                    
                    c1=c1.next;
                    c2=c2.next;
                }
                
            }
    
            return len1-len2;
    
        }
    
      public static ListNode subtractTwoNumbers(ListNode l1, ListNode l2) {
       
       if(isBigger(l1,l2)<0){
                //swap the lists
                ListNode temp=l1;
                l1=l2;
                l2=temp;
            }
            
            if (l2 == null)
          return l1;
    
    
    
            //rev the lists
            l1=rev(l1);
            l2=rev(l2);
            ListNode dummy=new ListNode(-1);
            ListNode prev=dummy;
    
            ListNode c1=l1,c2=l2;
            int borrow=0;
            while(c1!=null || c2!=null){
                int val=borrow+(c1!=null? c1.val:0)-(c2!=null?c2.val:0);
                if(val<0){
                    val+=10;
                    borrow=-1;
                }
                else{
                    borrow=0;
                }
                prev.next=new ListNode(val);
              
    
                prev=prev.next;
                if(c1!=null) c1=c1.next;
                if(c2!=null) c2=c2.next;
            }
            
            // undo the changes made while reversing
            l1=rev(l1);
            l2=rev(l2);
    
            //declare newhead
            ListNode head=dummy.next;
            dummy.next=null;
            head=rev(head);
    
            // Remove the leading zeroes
            c1=head;
            while(c1.next!=null){
                if(c1.val!=0){
                    break;
                }
                c1=c1.next;
            }
            
            
            return c1;
      }
}