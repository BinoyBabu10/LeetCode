class Solution {
    public int majorityElement(int[] nums) {
      int candiate=0;
      int count=0;
      for(int n:nums){
        if(count==0){
            candiate=n;
        }
        if(n==candiate){
            count++;
        }
        else{
            count--;
        }
      }
      return candiate;
    }
}