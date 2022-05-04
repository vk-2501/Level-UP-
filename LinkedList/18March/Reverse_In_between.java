public class Reverse_In_between {
    ListNode th=null,tt=null;
    public void addFirst(ListNode node){
        if(th==null){
            th=tt=node;
        }
        else{
            node.next=th;
            th=node;
        }
    }
    
public ListNode reverseBetween(ListNode head, int left, int right) {
        
        if(head==null || head.next==null || left==right)
            return head;
        
        ListNode curr=head;
        ListNode prev=null;
        int idx=1;
        
        while(curr!=null){
            while(curr!=null && idx>=left && idx<=right ){
              
                ListNode forw=curr.next;
                curr.next=null;
                addFirst(curr);
                curr=forw;
                idx++;
            }
            
            if(idx>right){
                if(prev==null){
                tt.next=curr;
                return th;
                }
               
                else{
                prev.next=th;
                tt.next=curr;
                return head;
                }
            }
            
            idx++;
            prev=curr;
            curr=curr.next;
        }
        
    
        
        return head;
    }
}
