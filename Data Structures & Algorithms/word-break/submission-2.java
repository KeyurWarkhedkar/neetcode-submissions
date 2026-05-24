class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;

        for(int i=1;i<dp.length;i++) {
            for(String word : wordDict) {
                if(i - word.length() >=0 && s.substring(i - word.length(), i).equals(word)) {
                    dp[i] = dp[i - word.length()];
                }
                if(dp[i]) {
                    break;
                }
            }
        }

        return dp[dp.length-1];
    }
}
