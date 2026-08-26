class Solution {
    public int myAtoi(String s) {
        int start=0;
        while(start<s.length() && s.charAt(start)==' '){
            start++;
        }
        int sign=1;
        if(start<s.length() && s.charAt(start)=='-'){
            sign=-1;
            start++;
        }
        else if(start<s.length() && s.charAt(start)=='+'){
            start++;
        }
        return convert(s,start,sign,0);
    }
    private int convert(String s,int index,int sign,int result){
        //Base Class
        if(index>=s.length()|| !Character.isDigit(s.charAt(index))){
            return result*sign;
        }
        int digit=s.charAt(index)-'0';
        //overflow
        if(result>(Integer.MAX_VALUE-digit)/10){
            return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
        }
        result =result*10+digit;
        //recursive call
        return convert(s,index+1,sign,result);
    }
}