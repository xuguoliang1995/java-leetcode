package leetcode;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer
 * Input: "cbbd"
 * Output: "bb"
 */
public class LongestPalindromicSubstring_5 {
    // 从两边向中间聚合
    public static String longestPailndrimicSubstring1(String s) {
        /**
         * @param String
         * time O(n^2)
         * time O(n^2)
         * */
        if (s == null && s.length() == 0) return s;
        Boolean[][] dp = new Boolean[s.length()][s.length()];
        String res = "";
        int max = 0;
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                // j = 5
                //  b a c  b  c a d
                //  比较(b d)(a,a)(b)是否相等
                dp[i][j] = s.charAt(i) == s.charAt(j) && ((j - i <= 2) || dp[i + 1][j - 1]);
                if (dp[i][j]) {
                    if (j - i + 1 > max) {
                        max = j - i + 1;
                        res = s.substring(i, j + 1);
                    }
                }
            }
        }
        return res;

    }

    //从中间向两边扩散
    static String res = "";
    // space: O(1) time O(n^2)
    public static String longestPailndrimicSubstring2(String s) {

        if (s == null || s.length() == 0) return s;
        for (int i = 0; i < s.length(); i++) {
            helper(s, i, i);
            helper(s, i, i + 1);
        }
        return res;
    }

    private static void helper(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        String cur = s.substring(left + 1, right);
        if (cur.length() > res.length()) {
            res = cur;
        }

    }

    public static void main(String[] args) {
        String s = "qqabaq";
        System.out.println(longestPailndrimicSubstring1(s).toString());
    }
}
