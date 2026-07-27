class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> inc = new LinkedList<>();
        Deque<Integer> dec = new LinkedList<>();
        int maxLength = Integer.MIN_VALUE;


        for(int left=0,right=0;right<nums.length;right++) {
            int num = nums[right];
            while(!inc.isEmpty() && inc.peek() > num) {
                inc.removeLast();
            }
            while(!dec.isEmpty() && dec.peek() < num) {
                dec.removeLast();
            }
            inc.offer(num);
            dec.offer(num);

            while(dec.peek() - inc.peek() > limit) {
                if(nums[left] == inc.peek()) {
                    inc.poll();
                }
                if(nums[left] == dec.peek()) {
                    dec.poll();
                }
                left++;
            }
            
            maxLength = Math.max(maxLength, (right - left) + 1);
        }
        return maxLength;
    }
}