package com.vinay.practice;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AkunaNew {

    public static class WAL {
        List<List<String>> eventsMap = new ArrayList<>();
        ArrayList<String> events = new ArrayList<>();
        String[] eventValues = new String[]{"INSERT", "UPSERT", "DELETE"};

        public WAL(byte[] input) {
            // TODO
            int val = 0;
            while (val < input.length) {
                byte[] val1 = Arrays.copyOfRange(input, val + 0, val + 8);
                ByteBuffer bb = ByteBuffer.wrap(val1);
                long time = bb.getLong();
                byte[] val2 = Arrays.copyOfRange(input, val + 7, val + 9);
                val2[0] = 0;
                ByteBuffer wrapped = ByteBuffer.wrap(val2); // big-endian by default
                short num = wrapped.getShort();
                byte[] val3 = Arrays.copyOfRange(input, val + 9, val + 11);
                wrapped = ByteBuffer.wrap(val3);
                short num1 = wrapped.getShort();
                byte[] val4 = Arrays.copyOfRange(input, val + 11, val + 11 + num1);
                String st = new String(val4);
                val = val + 11 + num1;
                if (num == 2) {
                    List<String> pers1 = new ArrayList<>();
                    pers1.add(String.valueOf(time));
                    String sr1 = String.valueOf(time) + "|" + eventValues[num] + "|" + st;
                    pers1.add(sr1);
                    eventsMap.add(pers1);
                    continue;
                }
                byte[] val5 = Arrays.copyOfRange(input, val, val + 2);
                wrapped = ByteBuffer.wrap(val5);
                num1 = wrapped.getShort();
                byte[] val6 = Arrays.copyOfRange(input, val + 2, val + 2 + num1);
                String st1 = new String(val6);
                val = val + 2 + num1;
                List<String> pers = new ArrayList<>();
                pers.add(String.valueOf(time));
                String sr = String.valueOf(String.valueOf(time)) + "|" + eventValues[num] + "|" + st + "|" + st1;
                pers.add(sr);
                eventsMap.add(pers);
            }

            Collections.sort(eventsMap, (a, b) -> {
                long aTime = Long.parseLong(a.get(0));
                long bTime = Long.parseLong(b.get(0));
                if (aTime > bTime) {
                    return 1;
                } else if (aTime < bTime) {
                    return -1;
                }
                return 0;
            });
            for (int i = 0; i < eventsMap.size(); i++) {
                events.add(eventsMap.get(i).get(1));
                String st = "(CREATE|FINALIZE):\\s+id=(\\d+)&amount=(\\d+)&currency=(\\w+)";
                String st1 = "PAY:\\s+id=(\\d+)";
            }
        }
    }


}
