class Solution {
    public int maxSumDistinctTriplet(int[] x, int[] y) {
        Map<Integer, Integer> xToY = new HashMap<>();

        for(int i=0;i<x.length;i++) {
            if(xToY.containsKey(x[i])) {
                if(xToY.get(x[i]) < y[i]) {
                    xToY.put(x[i], y[i]);
                }
            } else {
                xToY.put(x[i], y[i]);
            }
        }

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        if(xToY.size() < 3) {
            return -1;
        }

        for(int key : xToY.keySet()) {
            int value = xToY.get(key);
            if(value > first) {
                third = second;
                second = first;
                first = value;
            } else if(value > second) {
                third = second;
                second = value;
            } else if(value > third) {
                third = value;
            }
        }

        return first + second + third;
    }
}