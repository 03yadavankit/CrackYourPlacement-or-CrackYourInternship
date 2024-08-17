package Day17of45;

import java.util.Arrays;

class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.length() < needle.length()) {
            return -1;
        } else if (needle.isEmpty()) {
            return 0;
        }
        
        char[] text = haystack.toCharArray();
        char[] pattern = needle.toCharArray();
        
        int[] lastOccurrence = preprocessBadCharacters(pattern);
        int m = pattern.length;
        int n = text.length;
        
        int i = 0; 
        
        while (i <= n - m) {
            int j = m - 1; 
            while (j >= 0 && pattern[j] == text[i + j]) {
                j--;
            }
            
            if (j < 0) {
                return i; 
            } else {
                i += Math.max(1, j - lastOccurrence[text[i + j]]);
            }
        }
        
        return -1;
    }
    
    private int[] preprocessBadCharacters(char[] pattern) {
        int[] lastOccurrence = new int[256]; 
        Arrays.fill(lastOccurrence, -1); 
        for (int i = 0; i < pattern.length; i++) {
            lastOccurrence[pattern[i]] = i;
        }
        
        return lastOccurrence;
    }
}

