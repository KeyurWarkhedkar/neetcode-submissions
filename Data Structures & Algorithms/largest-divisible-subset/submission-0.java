public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<Integer>[] dp = new ArrayList[n];
        List<Integer> res = new ArrayList<>();

        for (int i = n - 1; i >= 0; i--) {
            dp[i] = new ArrayList<>();
            dp[i].add(nums[i]);

            for (int j = i + 1; j < n; j++) {
                if (nums[j] % nums[i] == 0) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.addAll(dp[j]);

                    if (tmp.size() > dp[i].size()) {
                        dp[i] = tmp;
                    }
                }
            }
            if (dp[i].size() > res.size()) {
                res = dp[i];
            }
        }
        return res;
    }
}