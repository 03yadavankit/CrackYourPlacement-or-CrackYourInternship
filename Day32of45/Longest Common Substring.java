package Day32of45;

class Solution {
    public int longestCommonSubstr(String str1, String str2) {
        int len = 0;
        
        for(int i=0;i<str1.length();i++)
        {
            for(int j=i;j<str1.length();j++)
            {
                String s = str1.substring(i,j+1);
                if(str2.contains(s))
                {
                    len = Math.max(len,s.length());
                }
            }
        }
        
        return len;
    }

}