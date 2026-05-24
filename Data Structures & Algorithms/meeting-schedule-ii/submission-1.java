/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        TreeMap<Integer, Integer> tm = new TreeMap<>();

        for(Interval interval : intervals) {
            tm.put(interval.start, tm.getOrDefault(interval.start, 0) + 1);
            tm.put(interval.end, tm.getOrDefault(interval.end, 0) - 1);
        }

        int max = 0;
        int prev = 0;

        for(int key : tm.keySet()) {
            prev += tm.get(key);
            max = Math.max(max, prev);
        }

        return max;
    }
}
