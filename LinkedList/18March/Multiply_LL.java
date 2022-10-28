
import java.util.*;
public class Multiply_LL {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public static ListNode rev(ListNode head){
        if(head==null || head.next==null)
        return head;
        
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
    
    public static ListNode mul(ListNode head,int num){
        ListNode curr=head;
        int carry=0;
        ListNode dummy=new ListNode(-1);
        ListNode ac=dummy;
        
        while(curr!=null || carry!=0){
            int sum=carry+(curr!=null?curr.val*num:0);
            int digit=sum%10;
            carry=sum/10;
            
            ac.next=new ListNode(digit);
            if(curr!=null)curr=curr.next;
            
            ac=ac.next;
        }
        return dummy.next;
    }
    
    public static void addTwoLL(ListNode prod,ListNode atr){
        ListNode c1=prod;
        ListNode c2=atr;
        
        int carry=0;
        while(c1!=null || carry!=0){
            int sum=carry+(c1!=null?c1.val:0)+(c2.next!=null?c2.next.val                   :0);
            int digit=sum%10;
            carry=sum/10;
            
            if(c2.next!=null)
            c2.next.val=digit;
            else
            c2.next=new ListNode(digit);
            
            if(c1!=null) c1=c1.next;
            c2=c2.next;
            
        }
    }

    public static ListNode multiplyTwoLL(ListNode l1, ListNode l2)     {
        l1=rev(l1);
        l2=rev(l2);
        ListNode dummy=new ListNode(-1);
        ListNode atr=dummy;
        ListNode l2_itr=l2;
        
        while(l2_itr!=null){
            ListNode prod=mul(l1,l2_itr.val);
            l2_itr=l2_itr.next;
            addTwoLL(prod,atr);
            atr=atr.next;
        }
        
        return rev(dummy.next);
    }