package implementation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LengthOfLongestSubstring {
    public static int solution(String s) {
        //return solution_self(s);
        return solution_self(s);
    }

    /**
     * Solution came up by myself
     * @param s
     * @return
     */
    public static int solution_self(String s) {
        Set contain_dict = new HashSet<Character>();
        int max_length = 0;
        for (int i = 0; i < s.length(); i ++) {
            for (int j = i; j < s.length(); j++) {
                if (contain_dict.contains(s.charAt(j))) {
                    contain_dict.clear();
                    break;
                } else {
                    contain_dict.add(s.charAt(j));
                }
                max_length = Integer.max(max_length, contain_dict.size());
            }
        }
        return max_length;
    }

    /**
     * Solution brutal force from leetcode
     *
     * @param s
     * @return
     */
    public static int solution_brutal(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j <= n; j++)
                if (allUnique(s, i, j)) ans = Math.max(ans, j - i);
        return ans;
    }

    /**
     * Brutal force helper function
     *
     * @param s
     * @param start
     * @param end
     * @return
     */
    public static boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) return false;
            set.add(ch);
        }
        return true;
    }

    public static int solutionSlideWindow(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}
