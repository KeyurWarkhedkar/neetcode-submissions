public class Solution {
    public int maxFrequency(int[] nums, int k) {
        Map<Integer, Integer> cnt = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            int prev = Math.max(cnt.getOrDefault(num, 0), cnt.getOrDefault(k, 0));
            cnt.put(num, prev + 1);
            res = Math.max(res, cnt.get(num) - cnt.getOrDefault(k, 0));
        }
        return cnt.getOrDefault(k, 0) + res;
    }
}