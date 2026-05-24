class Solution {
    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];

        int res = 0;

        for(int i=0;i<dp.length;i++) {
            res++;
            dp[i][i] = true;
        }


        for(int i=0;i<dp.length;i++) {
            for(int j=0;j<i;j++) {
                if(s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[i-1][j+1])) {
                    res++;
                    dp[i][j] = true;
                }
            }
        }

        return res;
    }
}
