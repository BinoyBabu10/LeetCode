class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
      HashSet<Integer>set=new HashSet<>();
      for(int i=0;i<nums.length;i++){
        //IF current num is in window
        if(set.contains(nums[i])){
            return true;
        }
        set.add(nums[i]);

        //keep window size at k
        if(set.size()>k){
            set.remove(nums[i-k]);
        }
      }
      return false;

    }
}