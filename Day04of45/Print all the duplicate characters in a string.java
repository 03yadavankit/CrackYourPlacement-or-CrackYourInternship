/**  ## Print all the duplicate characters in a string ##
 * Given a string S, the task is to print all the duplicate characters with their occurrences in the given string.
 * Example:
Input: S = “geeksforgeeks”
Output:
e, count = 4
g, count = 2
k, count = 2
s, count = 2
 */

package Day04of45;

/**
 * Print all the duplicate characters in a string
 */
public class Solution {
    public void duplicateChar(String str){
        int[] ch = new int[26]; 
        Arrays.fill(ch, 0); 
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            ch[c - 'a']++; 
        }
        for(int i = 0; i < 26; i++){
            if(ch[i] > 1){
                System.out.println((char)('a' + i) + ": " + ch[i]);
            }
        }
    }
}
