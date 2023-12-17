package org.blind75;

import java.util.Comparator;

public class MeetingRooms {
    public static void main(String[] args) {
        var meetingRooms = new MeetingRooms();
        System.out.println(meetingRooms.canAttendMeetings(new int[][]{{0, 30}, {5, 10}, {15, 20}}));
        System.out.println(meetingRooms.canAttendMeetings(new int[][]{{7, 10}, {2, 4}}));
    }
    private boolean canAttendMeetings(int [][] intervals){
        if(intervals.length == 0) return true;
        java.util.Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] < intervals[i-1][1]) return false;
        }
        return true;
    }

    private int minConferenceRooms(int[][] intervals){
        if(intervals.length == 0) return 0;
        java.util.Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        java.util.PriorityQueue<Integer> pq = new java.util.PriorityQueue<>();
        pq.add(intervals[0][1]);
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] >= pq.peek()) pq.poll();
            pq.add(intervals[i][1]);
        }
        return pq.size();
    }
}
