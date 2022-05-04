public class SubArray_Sum_Divisible_By_K {
    public int subarraysDivByK(int[] nums, int k) {
        int sum=0;
        int ans=0;
        
        HashMap<Integer,Integer> hm=new HashMap<>();
        hm.put(sum,1);
        for(int val:nums){
            sum+=val;
            int key=sum%k;
            if(key<0){
                key+=k;
            }
            
            if(hm.containsKey(key)){
                ans+=hm.get(key);
                hm.put(key,hm.get(key)+1);
            }
            
            else{
                hm.put(key,1);
            }
        }
        
        return ans;
    }
}
