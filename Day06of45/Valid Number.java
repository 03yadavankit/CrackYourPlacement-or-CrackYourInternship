package Day06of45;

class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        int n = s.length();
        if (n == 0) return false;

        boolean hasNumber = false;
        boolean hasPoint = false;
        boolean hasExponent = false;
        int i = 0;

        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            i++;
        }

        while (i < n) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                hasNumber = true;
            } else if (c == '.') {
                if (hasPoint || hasExponent) {
                    return false;
                }
                hasPoint = true;
            } else if (c == 'e' || c == 'E') {
                if (!hasNumber || hasExponent) {
                    return false;
                }
                hasExponent = true;
                hasNumber = false;
                if (i + 1 < n && (s.charAt(i + 1) == '+' || s.charAt(i + 1) == '-')) {
                    i++;
                }
            } else {
                return false;
            }
            i++;
        }

        return hasNumber;
    }
}
