class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>>ans=new ArrayList<>();
        for(int i=1;i<=numRows;i++){
            ans.add(triangle(i));
        }
        return ans;
    }
    public List<Integer>triangle(int num){
        List<Integer>temp=new ArrayList<>();
        long res=1;
        temp.add(1);
        for(int i=1;i<num;i++){
            res=res*(num-i);
            res=res/i;
            temp.add((int)res);
        }
        return temp;
    }
    
}