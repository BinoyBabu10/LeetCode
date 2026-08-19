class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer>ans=new ArrayList<>();
        int count1=0;
        int count2=0;
        int el1=0,el2=0;
        for(int n:nums){
            if(count1==0 && n!=el2){
                count1=1;
                el1=n;
            }
            else if(count2==0 && n!=el1){
                count2=1;
                el2=n;
            }
            else if(el1==n){
                count1++;
            }
            else if(el2==n){
                count2++;
            }
            else{
                count1--;
                count2--;
            }
        }
        count1=0;
        count2=0;
        for(int n:nums){
            if(n==el1){
                count1++;
            }
            else if(n==el2){
                count2++;
            }
        }
        if(count1>nums.length/3){
            ans.add(el1);
        }
        if(count2>nums.length/3){
            ans.add(el2);
        }
        return ans;
    }
}