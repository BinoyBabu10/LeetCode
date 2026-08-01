class Solution {
    public int majorityElement(int[] nums) {
        int c=0;
        int count=0;
        for(int n:nums){
            if(count==0){
                c=n;
            }
            if(n==c){
                count++;
            }
            else{
                count--;
            }
        }

        return c;
    }
}