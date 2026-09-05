class Solution {
    public int[] twoSum(int[] nums, int target) {
     HashMap<Integer,Integer>set=new HashMap<>();
     for(int i=0;i<nums.length;i++){
        int c=target-nums[i];
        if(set.containsKey(c)){
            return new int[]{set.get(c),i};
        }
        set.put(nums[i],i);


     }
     return new int[]{};
    }
}