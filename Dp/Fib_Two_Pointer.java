public class Fib_Two_Pointer {
     /*
     * 1. Faith
     * 2. Tree Diagram
     * 3. Recursion
     * 4. Recursion -> Memoization
     * 5. Obervation
     * 6. Memoization -> Tabulation after observation
     * 7. Optimization
     */

     //Recursion 
     public static int fibo_recur(int n){

        if(n==0 || n==1)
        return n;

        int fm1=fibo_recur(n-1);
        int fm2=fibo_recur(n-2);
        return fm1+fm2;
     }

     //Memo
     public  int fibo_memo(int n,int[] dp){

        if(n==0 || n==1)
        return dp[n]=n;

        if(dp[n]!=0)
        return dp[n];

        int fm1=fibo_memo(n-1,dp);
        int fm2=fibo_memo(n-2,dp);
        return dp[n]=fm1+fm2;
     }

     //Tabulation
     public  int fibo_tab(int N,int[] dp){
        
        for(int n=0;n<=N;n++){
            if(n<=1){
            dp[n]=n;
            continue;
            }

            dp[N]=dp[N-1]+dp[N-2];


        }

        return dp[N];
     }

     //optimization
     public  int fibo_opti(int N,int[] dp){
        int a =0,b=1;
        for(int n=0;n<N;n++){
            int sum=a+b;
            a=b;
            b=sum;
        }
        return a;
     }


     // 1137 leetcode
     public  int tribo_memo(int n,int[] dp){

        if(n==0 || n==1)
        return dp[n]=n;

        if(n==2)
        return dp[n]=1;

        if(dp[n]!=0)
        return dp[n];

        int fm1=tribo_memo(n-1,dp);
        int fm2=tribo_memo(n-2,dp);
        int fm3=tribo_memo(n-3,dp);
        return dp[n]=fm1+fm2+fm3;
     }

     //Tabulation
     public  int tribo_tabu(int n,int[] dp){

        for(int i=0;i<=n;i++){
            if(i<=2){
                dp[i]=(i==0)?0:1;
                continue;
            }

            dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
        }
        return dp[n];
     }

     //Leetcode 70
     public int climbStairs_recur(int n) {
    
        if(n<=1){
            return 1;
        }
     
     int a=climbStairs_recur(n-1);
     int b=climbStairs_recur(n-2);
     
     return a+b;
     
        }

    public int climbStairs_memo(int n,int[] dp) {

        if(n<=1){
            return 1;
        }
        
        int a=climbStairs_memo(n-1,dp);
        int b=climbStairs_memo(n-2,dp);
        
        return a+b;
        
   }


   public int climbStairs_tabu(int N,int[] dp) {
      for(int n=0;n<=N;n++){
         if(n<=1){
            dp[n]=1;
            continue;
        }

        dp[n]=dp[n-1]+dp[n-2];
      }
      return dp[N];  
 }

 //746 leetcode [Min Cost Climbing Stairs]
 public int mincost_recur(int[] costs,int n){

   if(n<=1){
      return costs[n];
   }

   int fm1=mincost_recur(costs,n-1);
   int fm2=mincost_recur(costs,n-2);

   return Math.min(fm1,fm2)+(n==costs.length?0:costs[n]);

 }

 //memo
 public int mincost_memo(int[] costs,int n,int[] dp){

   if(n<=1){
      return dp[n]=costs[n];
   }

   if(dp[n]!=0)
   return dp[n];

   int fm1=mincost_memo(costs,n-1,dp);
   int fm2=mincost_memo(costs,n-2,dp);

   int ans= Math.min(fm1,fm2)+(n==costs.length?0:costs[n]);
   return dp[n]=ans;


 }

 //tabu
 public int mincost_tabu(int[] costs,int n,int[] dp){

   for(int i=0;i<=n;i++){
       if(i<=1){
      dp[i]=costs[i];
      continue;
     }

     dp[i]=Math.min(dp[i-1],dp[i-2])+(i==costs.length?0:costs[i]);
     }

     return dp[n];
  }
  

  //Maze paths leetcode
  public int uniquePaths(int m, int n) {
        
   int[][] dir={{0,1},{1,0}};
   int count= helper(0,0,m-1,n-1,dir);
   
    return count;
}


public int helper(int sr,int sc,int er,int ec,int[][] dir){
    
    if(sr==er && sc==ec){
        return 1;
    }
    
    int count=0;
    
    for(int d=0;d<dir.length;d++){
        int r=sr+dir[d][0];
        int c=sc+dir[d][1];
        
        if(r>=0 && c>=0 && r<=er && c<=ec){
            count+=helper(r,c,er,ec,dir);
        }
    }
    return count;
}

public int helper_memo(int sr,int sc,int er,int ec,int[][] dir,int[][] dp){
    
   if(sr==er && sc==ec){
       return dp[sr][sc]= 1;
   }
   
   if(dp[sr][sc]!=0)
   return dp[sr][sc];
   
   int count=0;
   
   for(int d=0;d<dir.length;d++){
       int r=sr+dir[d][0];
       int c=sc+dir[d][1];
       
       if(r>=0 && c>=0 && r<=er && c<=ec){
           count+=helper(r,c,er,ec,dir);
           
       }
   }
   return dp[sr][sc]=count;
}

public int helper_tabu(int sr,int sc,int er,int ec,int[][] dir,int[][] dp){
    
   for(int i=sr;i<=er;i++){
      for(int j=sc;j<=ec;j++){
         if(sr==er && sc==ec){
             dp[sr][sc]= 1;
             continue;
        }
        int count=0;
   
      for(int d=0;d<dir.length;d++){
       int r=sr+dir[d][0];
       int c=sc+dir[d][1];
       
       if(r>=0 && c>=0 && r<=er && c<=ec){
           count+=dp[r][c];
           
       }
   }
        dp[sr][sc]=count;
      }
   }
   return dp[er][ec];
}
  
   
   
   
   
}






   


 }




