package Arrays;
//https://www.programcreek.com/2014/07/leetcode-meeting-rooms-java/
import java.util.Collections;
import java.util.List;

//If a person can attend all meetings, there must not be any overlaps between any meetings.
// After sorting the intervals, we can compare the current end and next start.
public class MeetingRooms {
    class Interval {
        int start, end;
        Interval(int start, int end) {
          this.start = start;
          this.end = end;
        }
    }
    public boolean canAttendMeetings(List<Interval> intervals){
        Collections.sort(intervals, (a,b) -> a.start-b.start);
        for (int i = 0; i+1 < intervals.size(); i++) {
            if(intervals.get(i).end > intervals.get(i+1).start){
                return false;
            }
        }
        return true;
    }
}
