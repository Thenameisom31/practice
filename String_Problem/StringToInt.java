public class StringToInt {

    public static void main(String[] args) {

        int res = 0;
        int sign = 1;
        String str = " 1231231231311133";
        int idx = 0;

        // 1. Skip leading spaces
        while (idx < str.length() && str.charAt(idx) == ' ') {
            idx++;
        }

        // 2. Handle sign
        if (idx < str.length()) {
            if (str.charAt(idx) == '-') {
                sign = -1;
                idx++;
            } else if (str.charAt(idx) == '+') {
                idx++;
            }
        }

        // 3. Convert digits
        while (idx < str.length() && Character.isDigit(str.charAt(idx))) {
            int digit = str.charAt(idx) - '0';

            // Optional: check for overflow (safe bounds)
            if (res > (Integer.MAX_VALUE - digit) / 10) {
                res = (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                break;
            }

            res = res * 10 + digit;
            idx++;
        }

        res = res * sign;
        System.out.println("Converted integer: " + res);
    }
}
