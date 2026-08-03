class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>>ans=new ArrayList<>();
        for(int row=1;row<=numRows;row++){
            ans.add(generateRow(row));
        }
        return ans;
    }
    public List<Integer>generateRow(int row){
        List<Integer>temp=new ArrayList<>();
        long res=1;
        temp.add(1);
        for(int col=1;col<row;col++){
            res=res*(row-col);
            res=res/col;
            temp.add((int) res);
        }
        return temp;
    }
}