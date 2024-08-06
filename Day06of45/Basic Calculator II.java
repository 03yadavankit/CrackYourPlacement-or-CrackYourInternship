package Day06of45;

class Solution {
    public int calculate(String s) {
        int currentNumber = 0, lastNumber = 0, result = 0;
        char operator = '+';
        int length = s.length();
        
        for (int i = 0; i < length; i++) {
            char currentChar = s.charAt(i);
            
            if (Character.isDigit(currentChar)) {
                currentNumber = currentNumber * 10 + (currentChar - '0');
            }
            
            if ((!Character.isDigit(currentChar) && currentChar != ' ') || i == length - 1) {
                switch (operator) {
                    case '+':
                        result += lastNumber;
                        lastNumber = currentNumber;
                        break;
                    case '-':
                        result += lastNumber;
                        lastNumber = -currentNumber;
                        break;
                    case '*':
                        lastNumber *= currentNumber;
                        break;
                    case '/':
                        lastNumber /= currentNumber;
                        break;
                }
                
                operator = currentChar;
                currentNumber = 0;
            }
        }
        result += lastNumber;
        return result;
    }
}