package LEETCODE;

//Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer.
//
//The algorithm for myAtoi(string s) is as follows:
//
//Whitespace: Ignore any leading whitespace ( " ").
//Signedness: Determine the sign by checking if the next character is '-' or '+', assuming positivity if neither present.
//Conversion: Read the integer by skipping leading zeros until a non-digit character is encountered or the end of the string is reached. If no digits were read, then the result is 0.
//Rounding: If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then round the integer to remain in the range. Specifically, integers less than -231 should be rounded to -231, and integers greater than 231 - 1 should be rounded to 231 - 1.
//Return the integer as the final result.
public class leetCode_08 {
    public int myAtoi(String s) {
        int i = 0;
        int n = s.length();
        //remove leading whitespaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        int sign = 1;
        if (i < n && s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (i < n && s.charAt(i) == '+') {
            i++;
        }

        long num = 0;

        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            //check for the overflow:
            if (num > Integer.MAX_VALUE / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            if (num == Integer.MAX_VALUE / 10) {
                if (sign == 1 && digit > 7) {
                    return Integer.MAX_VALUE;
                }

                if (sign == -1 && digit > 8) {
                    return Integer.MIN_VALUE;
                }
            }

            num = num * 10 + digit;
            i++;
        }
        return (int) (sign * num);
    }
}
