class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer>ans=new ArrayList<>();
        int count1=0,count2=0;
        int el1=0,el2=0;
        for(int num:nums){
            if(count1==0 && num!=el2){
                count1=1;
                el1=num;
            }
            else if(count2==0 && num!=el1){
                count2=1;
                el2=num;
            }
            else if(el1==num){
                count1++;
            }
            else if(el2==num){
                count2++;
            }
            else{
                count1--;
                count2--;
            }
            
        }

        // Step 2: Verify the candidates
        count1 = 0;
        count2 = 0;

        for (int num : nums) {
            if (num == el1) {
                count1++;
            }
            else if (num == el2) {
                count2++;
            }
        }

        // Step 3: Add valid majority elements
        if (count1 > nums.length / 3) {
            ans.add(el1);
        }

        if (count2 > nums.length / 3) {
            ans.add(el2);
        }

        return ans;
    
    }
}