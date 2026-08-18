class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>>ans=new ArrayList<>();
        for(int i=1;i<=numRows;i++){
            ans.add(triangle(i));
        }
        return ans;
    }
    public List<Integer>triangle(int rows){
        List<Integer>temp=new ArrayList<>();
        int res=1;
        temp.add(1);
        for(int i=1;i<rows;i++){
            res=res*(rows-i);
            res=res/i;
            temp.add(res);
        }
        return temp;
    }    

}
    
    
