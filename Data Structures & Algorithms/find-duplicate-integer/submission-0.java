class Solution {
    public int findDuplicate(int[] nums) {
        int ctr = 0;
        while(ctr< nums.length) {
            int correctIndex = nums[ctr] - 1;
            if(nums[ctr] != nums[correctIndex]) {
                int temp = nums[correctIndex];
                nums[correctIndex] = nums[ctr];
                nums[ctr] = temp;
            } else {
                ctr++;
            }
        }
        for(int i=0;i<nums.length;i++) {
            if(nums[i] != i+1) {
                return nums[i];
            }
        }

        return -1;
    }
}
