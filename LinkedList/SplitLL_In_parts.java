public class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode ans[]=new ListNode[k];
        int totlength=len(head);
        
        int len=totlength/k;
        int remainder=totlength%k;
        
        ListNode curr=head,prev=null;
        int i=0;
        while(curr!=null && i<k){
            ans[i]=curr;
            
            for(int j=0;j<len+(remainder>0?1:0);j++){
                prev=curr;
                curr=curr.next;
            }
            
            prev.next=null;
            i++;
            remainder--;
        }
        return ans;
        
    }
    
    public int len(ListNode head){
        int c=0;
        while(head!=null){
            c++;
            head=head.next;
        }
        return c;
    }
}