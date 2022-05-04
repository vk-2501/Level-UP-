public class Reverse_in_k_grp {
    ListNode th=null,tt=null;
    public void addFirst(ListNode node ){
        if(th==null){
            th=tt=node;
        }
        else {
            node.next=th;
            th=node;
        }
    }
    
    public int len(ListNode head){
        ListNode curr=head;
        int c=0;
        while(curr!=null){
            c++;
            curr=curr.next;
        }
        
        return c;
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        
        if(head==null || head.next==null || k==0)
            return head;
        
        int length=len(head);
        
        ListNode at=null,ah=null,curr=head;
        while(length>=k){
            int tempk=k;
            while(curr!=null && tempk-->0){
                ListNode forw=curr.next;
                curr.next=null;
                addFirst(curr);
                curr=forw;
            }
            
            if(ah==null){
                ah=th;
                at=tt;
            }
            else{
                at.next=th;
                at=tt;
            }
            
            th=null;
            tt=null;
            
            
            length-=k;
        }
        
        at.next=curr;
        return ah;
    }


    //without global static nodes (th and tt)
    public void addFirst(ListNode node,ListNode[] pair ){
        if(pair[0]==null){
            pair[0]=pair[1]=node;
        }
        else {
            node.next=pair[0];
            pair[0]=node;
        }
    }
    
    
    //length of list
    public int len(ListNode head){
        ListNode curr=head;
        int c=0;
        while(curr!=null){
            c++;
            curr=curr.next;
        }
        
        return c;
    }
    
    
    //actual function
    public ListNode reverseKGroup(ListNode head, int k) {
        
        ListNode pair[]=new ListNode[2];
        
        if(head==null || head.next==null || k==0)
            return head;
        
        int length=len(head);
        
        ListNode at=null,ah=null,curr=head;
        while(length>=k){
            int tempk=k;
            while(curr!=null && tempk-->0){
                ListNode forw=curr.next;
                curr.next=null;
                addFirst(curr,pair);
                curr=forw;
            }
            
            if(ah==null){
                ah=pair[0];
                at=pair[1];
            }
            else{
                at.next=pair[0];
                at=pair[1];
            }
            
            pair[0]=null;
            pair[1]=null;
            
            
            length-=k;
        }
        
        at.next=curr;
        return ah;
    }

}

