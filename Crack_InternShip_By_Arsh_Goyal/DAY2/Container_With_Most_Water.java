class Solution {
    public int maxArea(int[] height) {
        int i=0;
        int j=height.length-1;
        
        int wa=0;
        while(i<j){
            int wid=j-i;
            int min=Math.min(height[i],height[j]);
            
           wa= Math.max(wa,wid*min);
            
            if(height[i]<height[j]){
                i++;
            }
            else{
                j--;
            }
            
        }
        
        return wa;
    }
}public class Container_With_Most_Water {
    
}
