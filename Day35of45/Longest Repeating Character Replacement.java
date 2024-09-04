package Day35of45;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character,Integer>hm=new HashMap<>();
    int l=0;
    int r=0;
    int maxlen=0;
    int maxfreq=0;
        int n=s.length();
        for(r=0;r<n;r++)
        {
            char c=s.charAt(r);
            if(hm.containsKey(c))
            {
                hm.put(c,hm.get(c)+1);
            }
            else
            {
                hm.put(c,1);
            }
         maxfreq=Math.max(maxfreq,hm.get(c));
         
         if((r-l+1)-maxfreq>k)
         {
            while((r-l+1)-maxfreq>k)
            {  char ch=s.charAt(l);
                hm.put(ch,hm.get(ch)-1);
                for(char chh:hm.keySet())
                {
                    maxfreq=Math.max(maxfreq,hm.get(chh));
                }
                l++;
            }
         }
       maxlen=Math.max(maxlen,r-l+1);
        }
        return maxlen;
    }
}