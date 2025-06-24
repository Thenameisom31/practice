/* Check if two Strings are Anagrams of each other
Given two strings s1 and s2 consisting of lowercase characters, the task is to check whether the two given strings are anagrams of each other or not. An anagram of a string is another string that contains the same characters, only the order of characters can be different.

Examples:

Input: s1 = “geeks”  s2 = “kseeg”
Output: true
Explanation: Both the string have same characters with same frequency. So, they are anagrams.

Input: s1 = “allergy”  s2 = “allergic”
Output: false
Explanation: Characters in both the strings are not same. s1 has extra character 'y' and s2 has extra characters 'i' and 'c', so they are not anagrams.

Input: s1 = "g", s2 = "g"
Output: true
Explanation: Characters in both the strings are same, so they are anagrams. */


class CheckAnagram {
    public static void main(String[] args) {
        String str1 = "allergy";
        String str2 = "allergic";
        CheckAnagram a1 = new CheckAnagram();
        if (a1.areAnagrams(str1, str2)) {
            System.out.println("The strings are anagrams.");
        } else {
            System.out.println("The strings are not anagrams.");

        }
    }

    boolean areAnagrams(String str1, String str2) {
        int[] freq = new int[26];
        for (int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);
            int idx = ch - 'a';
            freq[idx]++;
        }

        for (int i = 0; i < str2.length(); i++) {
            char ch = str2.charAt(i);
            int idx = ch - 'a'; 
            freq[idx]--;
        }

        for (int count : freq) {
            if (count != 0)
                return false;
        }

        return true;
    }
}