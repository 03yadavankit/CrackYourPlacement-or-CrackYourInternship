package Day14of45;
class Solution {
    public boolean backspaceCompare(String s, String t) {
        Deque<Character> stackS = new LinkedList<>();
        Deque<Character> stackT = new LinkedList<>();

        for (char ch : s.toCharArray()) {
            if (ch == '#') {
                if (!stackS.isEmpty()) {
                    stackS.pop();
                }
            } else {
                stackS.push(ch);
            }
        }

        for (char ch : t.toCharArray()) {
            if (ch == '#') {
                if (!stackT.isEmpty()) {
                    stackT.pop();
                }
            } else {
                stackT.push(ch);
            }
        }

        return stackS.equals(stackT);
    }
}

