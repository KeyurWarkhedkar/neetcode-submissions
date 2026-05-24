class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> nextGreaterIndexes = new Stack<>();
        int[] nextWarmerTemperature = new int[temperatures.length];

        for(int i=temperatures.length-1;i>=0;i--) {
            while(!nextGreaterIndexes.isEmpty()
            && temperatures[nextGreaterIndexes.peek()] <= temperatures[i]) {
                nextGreaterIndexes.pop();
            }

            if(nextGreaterIndexes.isEmpty()) {
                nextWarmerTemperature[i] = 0;
            } else {
                nextWarmerTemperature[i] = nextGreaterIndexes.peek() - i;
            }

            nextGreaterIndexes.push(i);
        }

        return nextWarmerTemperature;
    }
}
