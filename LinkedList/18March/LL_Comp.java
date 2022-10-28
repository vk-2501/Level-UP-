import java.util.*;

public class LL_Comp{
    public class ListNode{
        int val;
            ListNode next;
            ListNode() {}
            ListNode(int val) { this.val = val; }
            ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static int Comp(ListNode head,int[] nums){
        if(head==null || nums.length==0) return 0;

        HashSet<Integer> hs=new HashSet<>();
        for(int val:nums) hs.add(val);

        int comp=0;
        ListNode curr=head;
        while(curr!=null){
            if(hs.contains(curr.val) && (curr.next==null || !hs.contains(curr.next.val))){
                comp++;
            }
            curr=curr.next;

        }
        return comp;
    }
}