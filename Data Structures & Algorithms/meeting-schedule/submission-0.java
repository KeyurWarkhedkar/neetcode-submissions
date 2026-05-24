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
    public boolean canAttendMeetings(List<Interval> intervals) {
        intervals.sort((a, b) -> {return a.start - b.start;});

        int conflict = 0;
        for(int i=0;i<intervals.size()-1;i++) {
            if(intervals.get(i).end > intervals.get(i+1).start) {
                conflict = 1;
                break;
            }
        }

        return conflict == 0;
    }
}
