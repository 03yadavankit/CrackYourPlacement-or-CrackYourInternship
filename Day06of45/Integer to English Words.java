package Day06of45;

class Solution {
    private static final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] TENS = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private static final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) return "Zero";

        StringBuilder result = new StringBuilder();
        int thousandCounter = 0;

        while (num > 0) {
            if (num % 1000 != 0) {
                StringBuilder part = new StringBuilder();
                helper(num % 1000, part);
                result.insert(0, part.append(THOUSANDS[thousandCounter]).append(" "));
            }
            num /= 1000;
            thousandCounter++;
        }

        return result.toString().trim();
    }

    private void helper(int num, StringBuilder part) {
        if (num == 0) return;
        if (num < 20) {
            part.append(LESS_THAN_20[num]).append(" ");
        } else if (num < 100) {
            part.append(TENS[num / 10]).append(" ");
            helper(num % 10, part);
        } else {
            part.append(LESS_THAN_20[num / 100]).append(" Hundred ");
            helper(num % 100, part);
        }
    }
}