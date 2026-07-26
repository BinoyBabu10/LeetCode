class Solution {
    public int findLHS(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();

        //count frequency
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int max=0;
        //Check adjacent values
        for(int key:map.keySet()){
            if(map.containsKey(key+1)){
                int length=map.get(key)+map.get(key+1);
                max=Math.max(max,length);
            }
        }
        return max;
    }
}