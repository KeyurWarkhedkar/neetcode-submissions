class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int[] dp = new int[s.length() + 1];
        Set<String> hs = new HashSet<>();
        for(int i=0;i<dictionary.length;i++) {
            hs.add(dictionary[i]);
        }

        for(int i=1;i<dp.length;i++) {
            dp[i] = dp[i-1] + 1;
            for(int j=i;j>0;j--) {
                if(hs.contains(s.substring(j-1, i))) {
                    dp[i] = Math.min(dp[i], dp[j-1]);
                }
            }
        }
        return dp[dp.length-1];
    }
}