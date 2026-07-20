class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int[] prefix=new int[arr.length];
        prefix[0]=arr[0];
        for(int i=1;i<arr.length;i++){
            prefix[i]=prefix[i-1]+arr[i];
        }
        int ans=0;
        int n=arr.length;
        for(int l=1;l<=arr.length;l+=2){
            for(int start=0;start+l-1<n;start++){
                int end=start+l-1;
                if(start==0){
                    ans+=prefix[end];
                }
                else{
                    ans+=prefix[end]-prefix[start-1];
                }


            }
        }
        return ans;
    }
}