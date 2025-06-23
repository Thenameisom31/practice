/* Add two binary strings
Given two binary strings s1 and s2, the task is to return their sum.The input strings may contain leading zeros but the output string should not have any leading zeros.

Example: 

Input: s1 = "1101", s2 = "111"
Output: "10100" */

class AddBinaryString {

    public String addBinary(String a, String b) {
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;

        int base = 2;
        StringBuilder res = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int t1 = 0, t2 = 0;
            int sum = 0;
            if (i >= 0) {
                t1 = a.charAt(i--) - '0';
            }
            if (j >= 0) {
                t2 = b.charAt(j--) - '0';
            }
            sum = t1 + t2 + carry;
            if (sum >= base) {
                carry = 1;
                sum = sum - base;
            } else {
                carry = 0;

            }
            res.append(sum);

        }
        if (carry == 1) {
            res.append(carry);
        }

        return res.reverse().toString();
    }

    public static void main(String[] args) {
        AddBinaryString addBinaryString = new AddBinaryString();
        String a = "1101";
        String b = "111";
        System.out.println("Sum of " + a + " and " + b + " is: " + addBinaryString.addBinary(a, b));
    }
}
