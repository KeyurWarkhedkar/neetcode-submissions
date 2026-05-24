class Solution {
    public String decodeString(String s) {
        Stack<Character> st = new Stack<>();

        for(int i=0;i<s.length();i++) {
            if(Character.isLetter(s.charAt(i)) 
            || Character.isDigit(s.charAt(i))
            || s.charAt(i) == '[') {
                st.push(s.charAt(i));
            } else {
                StringBuilder sb = new StringBuilder();
                while(!st.isEmpty() && st.peek() != '[') {
                    sb.append(st.pop());
                }
                sb.reverse();
                st.pop();
                StringBuilder times = new StringBuilder();
                while(!st.isEmpty() && Character.isDigit(st.peek())) {
                    times.insert(0, st.pop());
                }
                for(int k=0;k<Integer.valueOf(times.toString());k++) {
                    for(int j=0;j<sb.length();j++) {
                        st.push(sb.charAt(j));
                    }
                }
            }
        }

        StringBuilder decodedString = new StringBuilder();
        while(!st.isEmpty()) {
            decodedString.append(st.pop());
        }

        return decodedString.reverse().toString();
    }
}