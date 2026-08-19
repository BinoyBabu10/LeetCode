class Solution {
    public String reverseWords(String s) {
        char[] arr=s.toCharArray();
        // reverse
        reverse(arr,0,arr.length-1);
        //reverse each word
        int start=0;
        for(int i=0;i<=arr.length;i++){
            if(i==arr.length || arr[i]==' '){
                reverse(arr,start,i-1);
                start=i+1;
            }
        }
        //Remove extra spaces
        StringBuilder ans=new StringBuilder();
        int i=0;
        while(i<arr.length){
            while(i<arr.length && arr[i]==' '){
                i++;
            }
            if(i>=arr.length){
                break;
            }
            if(ans.length()>0){
                ans.append(' ');
            }
            while(i<arr.length && arr[i]!=' '){
                ans.append(arr[i]);
                i++;
            }
        }
        return ans.toString();
    }
    private void reverse(char[] arr, int left, int right){
        while(left<right){
            char temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
            left++;
            right--;
        }
    }
}