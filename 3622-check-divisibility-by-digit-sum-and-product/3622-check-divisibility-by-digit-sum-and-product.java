class Solution {
    public boolean checkDivisibility(int n) {
        int sum=0;
        int p=1;
        int t=n;
        while(t>0){
            int digit =t%10;
            sum+=digit;
            p=p*digit;
            t=t/10;
        }
        if(n%(p+sum)==0){
            return true;
        }
        return false;
    }
}