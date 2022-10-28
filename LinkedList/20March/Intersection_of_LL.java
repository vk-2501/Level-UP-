public public class Intersection_of_LL {
    public int len(ListNode head){
        int c=0;
        ListNode curr=head;
        while(curr!=null){
            c++;
            curr=curr.next;
        }
        return c;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int n1=len(headA);
        int n2=len(headB);
        
        int diff=0;
        ListNode curr1=null;
             ListNode curr2=null;
        if(n1>n2){
            diff=n1-n2;
            curr1=headA;
            curr2=headB;
        }
        else{
            diff=n2-n1;
            curr1=headB;
            curr2=headA;
        }
        
        while(diff-->0){
            curr1=curr1.next;
        }
        
        while(curr1!=curr2){
            curr1=curr1.next;
            curr2=curr2.next;
            
            
            
        }
        
        if(curr1!=curr2)
            return null;
        else
            return curr1;
    }

    public ListNode getTail(ListNode node){
        if(node==null || node.next==null)
            return node;
        
        ListNode curr=node;
        while(curr.next!=null){
            curr=curr.next;
            
        }
        
        return curr;
    }


    //Most Efficient Method
    public ListNode detectNode_02(ListNode head){
        if(head==null || head.next==null)
            return null;
        
        ListNode fast=head,slow=head;
        
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            
            if(fast==slow)
                break;
        }
        
        if(fast==null || fast.next==null)
            return null;
        
        slow=head;
        while(fast!=slow){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null)
            return null;
        
        ListNode tail=getTail(headA);
        tail.next=headB;
        
        ListNode ansNode=detectNode(headA);
        tail.next=null;
        return ansNode;
    }
}
