class Solution {

    Boolean[][] memo;

    public boolean isMatch(String s, String p) {

        memo = new Boolean[s.length() + 1][p.length() + 1];

        return def(0, 0, s, p);
    }

    public boolean def(int i, int j, String s, String p) {

        // Already calculated
        if (memo[i][j] != null)
            return memo[i][j];

        // Pattern is finished
        if (j == p.length())
            return memo[i][j] = (i == s.length());

        // Check whether current characters match
        boolean firstMatch =
                i < s.length() &&
                (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        boolean ans;

        // Next pattern character is '*'
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {

            // Option 1: use zero occurrences
            // Option 2: consume one character and stay at j
            ans = def(i, j + 2, s, p)
                    || (firstMatch && def(i + 1, j, s, p));

        } 
        // Normal character or '.'
        else {

            ans = firstMatch &&
                    def(i + 1, j + 1, s, p);
        }

        return memo[i][j] = ans;
    }
}