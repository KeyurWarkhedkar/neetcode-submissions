class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int[] left = new int[k];
        int[] right = new int[k];
        left[0] = cardPoints[0];
        right[k-1] = cardPoints[cardPoints.length-1];
        for(int i=1;i<left.length;i++) {
            left[i] = left[i-1] + cardPoints[i];
        }
        int ctr = k-2;
        for(int i=cardPoints.length-2;i>=cardPoints.length-k;i--) {
            right[ctr] = right[ctr+1] + cardPoints[i];
            ctr--;
        }

        int maxSum = Integer.MIN_VALUE;
        for(int i=0;i<k-1;i++) {
            maxSum = Math.max(maxSum, left[i] + right[i+1]);
        }

        maxSum = Math.max(maxSum, Math.max(left[left.length-1], right[0]));
        return maxSum;
    }
}