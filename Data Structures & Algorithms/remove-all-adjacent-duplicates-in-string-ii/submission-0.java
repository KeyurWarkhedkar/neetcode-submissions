class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<int[]> st = new Stack<>();
        for(int i=0;i<s.length();i++) {
            if(!st.isEmpty() && (char)st.peek()[0] == s.charAt(i)) {
                st.push(new int[]{s.charAt(i), st.peek()[1] + 1});
            } else {
                st.push(new int[]{s.charAt(i), 1});
            }

            if(st.peek()[1] == k) {
                for(int j=0;j<k;j++) {
                    st.pop();
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) {
            sb.append((char)st.pop()[0]);
        }

        return sb.reverse().toString();
    }
}