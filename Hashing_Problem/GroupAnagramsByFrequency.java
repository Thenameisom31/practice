/* 
Group Anagrams Together

comments
Given an array of words arr[], the task is to groups strings that are anagrams. An anagram is a word or phrase formed by rearranging the letters of another, using all the original letters exactly once.

Example:

Input: arr[] = ["act", "god", "cat", "dog", "tac"]
Output: [["act", "cat", "tac"], ["god", "dog"]]
Explanation: There are 2 groups of anagrams "god", "dog" make group 1. "act", "cat", "tac" make group 2.

Input: arr[] = ["listen", "silent", "enlist", "abc", "cab", "bac", "rat", "tar", "art"]
Output: [["abc", "cab", "bac"], ["listen", "silent", "enlist"],["rat", "tar", "art"]]
Explanation: 
Group 1: "abc", "bac" and "cab" are anagrams.
Group 2: "listen", "silent" and "enlist" are anagrams.
Group 3: "rat", "tar" and "art" are anagrams. */

package Hashing_Problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GroupAnagramsByFrequency {

    public static String getHash(String s) {
        StringBuilder hash = new StringBuilder();
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            hash.append(freq[i]);
            hash.append("$");
        }
        return hash.toString();
    }

    public ArrayList<ArrayList<String>> anagrams(String[] arr) {
        // code here
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        Map<String, Integer> mp = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            String key = getHash(arr[i]);
            if (!mp.containsKey(key)) {
                mp.put(key, res.size());
                res.add(new ArrayList<>());
            }
            res.get(mp.get(key)).add(arr[i]);
        }

        return res;

    }
    public static void main(String[] args) {
        GroupAnagramsByFrequency groupAnagrams = new GroupAnagramsByFrequency();
        String[] arr = {"act", "god", "cat", "dog", "tac"};
        ArrayList<ArrayList<String>> result = groupAnagrams.anagrams(arr);
        System.out.println(result); // Output: [["act", "cat", "tac"], ["god", "dog"]]
    }
}