package Day15of45;

import java.util.Stack;

class Solution {
    public static int evaluatePostFix(String S) {
        // Your code here
        Stack<Integer> st = new Stack<>();
        for (char c : S.toCharArray()) {
            if (Character.isDigit(c)) {
                st.push(Character.getNumericValue(c));
            } else {
                int v2 = st.pop();
                int v1 = st.pop();
                int result = 0;

                switch (c) {
                    case '+':
                        result = v1 + v2;
                        break;
                    case '-':
                        result = v1 - v2;
                        break;
                    case '*':
                        result = v1 * v2;
                        break;
                    case '/':
                        result = v1 / v2;
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operator: " + c);
                }

                st.push(result);
            }
        }

        return st.pop();
    }
}
