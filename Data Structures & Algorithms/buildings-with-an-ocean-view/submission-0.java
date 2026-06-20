class Solution {
    public int[] findBuildings(int[] heights) {
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<heights.length;i++) {
            while(!st.isEmpty() && heights[st.peek()] <= heights[i]) {
                st.pop();
            }
            st.push(i);
        }

        int[] ans = new int[st.size()];
        int ctr = st.size()-1;
        while(!st.isEmpty()) {
            ans[ctr--] = st.pop();
        }

        return ans;
    }
}