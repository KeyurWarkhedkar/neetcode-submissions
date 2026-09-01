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
        PriorityQueue<Interval> available = new PriorityQueue<>((a, b) -> {
            return a.start - b.start;
        });
        PriorityQueue<Interval> busy = new PriorityQueue<>((a, b) -> {
            return a.end - b.end;
        });

        for(Interval interval : intervals) {
            available.offer(interval);
        }

        int max = 0;
        while(!available.isEmpty()) {
            Interval currentInterval = available.poll();
            int time = currentInterval.start;
            busy.offer(currentInterval);

            while(!busy.isEmpty() && busy.peek().end <= time) {
                busy.poll();
            }

            max = Math.max(max, busy.size());
        }

        return max;
    }
}
