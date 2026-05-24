class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> charToFreq = new HashMap<>();
        for(int i=0;i<t.length();i++) {
            charToFreq.put(t.charAt(i), charToFreq.getOrDefault(t.charAt(i), 0) + 1);
        }

        int ctr = charToFreq.size();
        int startIndex = -1;
        int minLength = Integer.MAX_VALUE;

        for(int left=0,right=0;right<s.length();right++) {
            if(charToFreq.containsKey(s.charAt(right))) {
                charToFreq.put(s.charAt(right), charToFreq.get(s.charAt(right)) - 1);
                if(charToFreq.get(s.charAt(right)) == 0) {
                    ctr--;
                }
            }

            while(ctr == 0) {
                if(minLength > (right - left) + 1) {
                    minLength = (right - left) + 1;
                    startIndex = left;
                }
                System.out.println(startIndex + " " + minLength);
                if(charToFreq.containsKey(s.charAt(left))) {
                    charToFreq.put(s.charAt(left), charToFreq.get(s.charAt(left)) + 1);
                    if(charToFreq.get(s.charAt(left)) > 0) {
                        ctr++;
                    }
                }
                left++;
            }
        }

        return startIndex == -1 ? "" : s.substring(startIndex, startIndex + minLength);
    }
}
