class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> lastIndex = new HashMap<>();
        for(int i=0;i<s.length();i++) {
            lastIndex.put(s.charAt(i), i);
        }

        int currentPartitionStart = 0;
        int currentPartitionEnd = lastIndex.get(s.charAt(0));

        List<Integer> partitionLengths = new ArrayList<>();

        for(int i=0;i<s.length();i++) {
            currentPartitionEnd = Math.max(currentPartitionEnd, lastIndex.get(s.charAt(i)));
            if(i == currentPartitionEnd) {
                partitionLengths.add((currentPartitionEnd - currentPartitionStart) + 1);
                currentPartitionStart = i+1;
            } 
        }

        return partitionLengths;
    }
}
