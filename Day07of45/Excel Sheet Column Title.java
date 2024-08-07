package Day07of45;

import java.util.HashMap;

class Solution {
    public String convertToTitle(int columnNumber) {
        
        HashMap<Integer, Character> hm = new HashMap<>();
        hm.put(0, 'Z');
        for(int i=1; i<=26; i++) {
            hm.put(i, (char)(64 + i));
        }
        StringBuilder sb = new StringBuilder("");
        int num = columnNumber;
        if(num < 27) {
            sb.append(hm.get(num));
        }
        while(num>=27) {
            int mod = num%26;
            num = num/26;
            sb.append(hm.get(mod));
            if(mod == 0) {
                num--;
            }
            if(num < 27) {
                sb.append(hm.get(num));
            }
        }
        sb.reverse();
        return sb.toString();
    }
}