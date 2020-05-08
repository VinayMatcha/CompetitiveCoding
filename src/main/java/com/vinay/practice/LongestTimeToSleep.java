package com.vinay.practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class LongestTimeToSleep {
    public static void main(String[] args) {
        HashMap<String, Integer> days = new HashMap<>();
        days.put("Mon", 1);
        days.put("Tue", 2);
        days.put("Wed", 3);
        days.put("Thu", 4);
        days.put("Fri", 5);
        days.put("Sat", 6);
        days.put("Sun", 7);
        String[] times = new String[] {"Sun 10:00-20:00", "Fri 05:00-10:00", "Fri 16:30-23:50", "Sat 10:00-24:00", "Sun 01:00-04:00", "Sat 02:00-06:00", "Tue 03:30-18:15", "Tue 19:00-20:00", "Wed 04:25-15:14", "Wed 15:14-22:40", "Thu 00:00-23:59", "Mon 05:00-13:00", "Mon 15:00-21:00"};
        ArrayList<MeetingTime> list = new ArrayList<>();
        for (String time : times) {
            String[] splitted = time.split(" ");
            String day = splitted[0];
            int startHour = Integer.parseInt(splitted[1].substring(0, 2));
            int startMin = Integer.parseInt(splitted[1].substring(3, 5));
            int endHour = Integer.parseInt(splitted[1].substring(6, 8));
            int endMin = Integer.parseInt(splitted[1].substring(9, 11));
            MeetingTime meetingTime = new MeetingTime(day, startHour, startMin, endHour, endMin);
            list.add(meetingTime);
        }
        list.sort(new Comparator<MeetingTime>() {
            @Override
            public int compare(MeetingTime str1, MeetingTime str2)
            {
                if (days.get(str1.day) != days.get(str2.day)) {
                    return (days.get(str1.day) - days.get(str2.day));
                }
                if (str1.startHour != str2.startHour) {
                    return str1.startHour - str2.startHour;
                }
                return str1.startMinute - str2.startMinute;
            }
        });
        int maxDiff = 0;
        for (int i=1;i<list.size();i++) {
            MeetingTime first = list.get(i-1);
            MeetingTime second = list.get(i);
            maxDiff = Math.max(maxDiff, findDifference(first, second, days));

        }
        System.out.println(maxDiff);
//        return maxDiff;
    }

    private static int findDifference(MeetingTime first, MeetingTime second, HashMap<String, Integer> days) {
        int diff = 0;
        if (days.get(first.day) != days.get(second.day)) {
            diff = (24 - first.endHour - 1) * 60 + (60 - first.endMinute);
            diff += (second.startHour) * 60 + (second.startMinute);
            return diff;
        }
        if (first.endHour != second.startHour) {
            diff = (second.startHour - first.endHour - 1) * 60 + (60 - first.endMinute) + second.startMinute;
            return diff;
        }
        diff = (second.startMinute - first.endMinute);
        return diff;
    }
}

class MeetingTime {
    String day;
    int startHour;
    int startMinute;
    int endHour;

    int endMinute;
    public MeetingTime(String day, int startHour, int startMinute, int endHour, int endMinute) {
        this.day = day;
        this.startHour = startHour;
        this.startMinute = startMinute;
        this.endHour = endHour;
        this.endMinute = endMinute;
    }
    
}
