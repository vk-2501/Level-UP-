public class chocolate_Distribution {
    public long findMinDiff (ArrayList<Long> a, long n, long m)
    {
        // your code here
        Collections.sort(a);
        long ans=(long)1e9;
        for(int i=0;i<=a.size()-(int)m;i++){
            long miw=a.get(i);
            long maxw=a.get(i+(int)m-1);
            ans=Math.min(ans,maxw-miw);
        }
        
        return ans;
    }
}
