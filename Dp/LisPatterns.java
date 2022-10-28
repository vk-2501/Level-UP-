public class LisPatterns{

    //Lis_Memo
    public int Lis_Memo(int[] nums,int idx,int[] dp){
        if(dp[idx]!=0)
        return dp[idx];

        int maxl=1;
        for(int i=idx-1;i>=0;i--){
            if(nums[idx]>nums[i]){
               int recans=Lis_Memo(nums,i,dp);
               maxlen=Math.max(recans+1,maxlen); 
            }
            
        }
        return dp[idx]=maxlen;
    }

    //Lis_Tab left to right
    public int Lis_Tab_LR(int[] nums,int[] dp){
      
        int maxl=1,n=nums.length;
        for(int i=0;i<n;i++){
            dp[i]=1;
            for(int j=i-1;j>=0;j--){
                if(nums[j]<nums[i])
                dp[i]=Math.max(dp[i],dp[j]+1);
            }
            
            maxl=Math.max(maxl,dp[i]);
    }

    //LDS_Tabu  left to right
    public void Lds_Tabu_LR(int[] nums,int[] dp){
        int maxl=0,n=nums.length;
          for(int i=n-1;i>=0;i--){
              dp[i]=1;
              for(int j=i+1;j<n;j++){
                  if(nums[j]<nums[i])
                  dp[i]=Math.max(dp[i],dp[j]+1);
              }
              maxl=Math.max(maxl,dp[i]);
          }
          // return maxl;
      }



    //Longest Bitonic Subsequence
    public void Lis(int[] nums,int[] dp){
        
        int maxl=1,n=nums.length;
        for(int i=0;i<n;i++){
            dp[i]=1;
            for(int j=i-1;j>=0;j--){
                if(nums[j]<nums[i])
                dp[i]=Math.max(dp[i],dp[j]+1);
            }
            
            maxl=Math.max(maxl,dp[i]);
        }
    }
    
     public void Lds(int[] nums,int[] dp){
      int maxl=0,n=nums.length;
        for(int i=n-1;i>=0;i--){
            dp[i]=1;
            for(int j=i+1;j<n;j++){
                if(nums[j]<nums[i])
                dp[i]=Math.max(dp[i],dp[j]+1);
            }
            maxl=Math.max(maxl,dp[i]);
        }
        // return maxl;
    }
    
    public int LongestBitonicSequence(int[] nums)
    {
        // Code here
        int[] li=new int[nums.length];
        int[] ld=new int[nums.length];
    
        Lis(nums,li);
        Lds(nums,ld);
       
        int ml=0;
        for(int i=0;i<nums.length;i++){
            ml=Math.max(ml,li[i]+ld[i]-1);
            
        }
        return ml;
    }

    // maximum sum Bitonic
    public static void Lis(int[] nums,int[] dp){
        
        int maxl=1,n=nums.length;
        for(int i=0;i<n;i++){
            dp[i]=nums[i];
            for(int j=i-1;j>=0;j--){
                if(nums[j]<nums[i])
                dp[i]=Math.max(dp[i],dp[j]+nums[i]);
            }
            
            maxl=Math.max(maxl,dp[i]);
        }
        
       
    }
    
     public static void Lds(int[] nums,int[] dp){
        
        int maxl=0,n=nums.length;
        for(int i=n-1;i>=0;i--){
            dp[i]=nums[i];
            for(int j=i+1;j<n;j++){
                if(nums[j]<nums[i])
                dp[i]=Math.max(dp[i],dp[j]+nums[i]);
            }
            
            maxl=Math.max(maxl,dp[i]);
        }
        
        // return maxl;
    }
    
    public static int maxSumBS(int arr[], int n)
    {
           int[] li=new int[arr.length];
        int[] ld=new int[arr.length];
        
        
        Lis(arr,li);
        Lds(arr,ld);
        
        
        int ml=0;
        for(int i=0;i<arr.length;i++){
            ml=Math.max(ml,li[i]+ld[i]-arr[i]);
            
        }
        return ml;
    }

}