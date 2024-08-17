package Day17of45;

import java.util.HashMap;

class Solution {
    public static String smallestWindow(String s, String t) {
        if (s.length() < t.length()) return "-1";

        // Step 1: Count the frequency of each character in `t`
        HashMap<Character, Integer> tCount = new HashMap<>();
        for (char c : t.toCharArray()) {
            tCount.put(c, tCount.getOrDefault(c, 0) + 1);
        }

        // Step 2: Sliding window
        HashMap<Character, Integer> windowCount = new HashMap<>();
        int left = 0, right = 0;
        int required = tCount.size();
        int formed = 0;

        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            windowCount.put(c, windowCount.getOrDefault(c, 0) + 1);
            if (tCount.containsKey(c) && windowCount.get(c).intValue() == tCount.get(c).intValue()) {
                formed++;
            }

            while (left <= right && formed == required) {
                c = s.charAt(left);
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }
                windowCount.put(c, windowCount.get(c) - 1);
                if (tCount.containsKey(c) && windowCount.get(c).intValue() < tCount.get(c).intValue()) {
                    formed--;
                }

                left++;
            }

            right++;
        }

        return minLen == Integer.MAX_VALUE ? "-1" : s.substring(start, start + minLen);
    }
}
