class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }
        Arrays.sort(strs);
        int i=0,n=strs.length-1;

        while(i<strs[0].length() && strs[0].charAt(i)==strs[n].charAt(i)){
            i++;
        }

        return strs[0].substring(0,i);
    }
}