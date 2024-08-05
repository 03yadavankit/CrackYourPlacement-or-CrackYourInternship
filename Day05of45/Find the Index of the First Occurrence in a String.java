class Solution {
    public int strStr(String h, String n) {
        int j=0;
        int len=n.length();
        String s="";
        for(int i=0;i<h.length();i++){
            s+=h.charAt(i);
            if(i-j+1==len){
                if(s.equals(n)){
                    return j;
                }
                s=s.substring(1);
                j++;
            }
        }
        return -1;
    }
}