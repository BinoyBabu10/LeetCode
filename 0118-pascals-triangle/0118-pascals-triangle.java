class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>>ans=new ArrayList<>();
        for(int r=1;r<=numRows;r++){
            ans.add(triangle(r));
        }
        return ans;
    }
    public List<Integer>triangle(int rows){
        List<Integer>temp=new ArrayList<>();
        temp.add(1);
        long res=1;
        for(int i=1;i<rows;i++){
            res=res*(rows-i);
            res=res/i;
            temp.add((int)res);
        }
        return temp;

    }
    
    
}