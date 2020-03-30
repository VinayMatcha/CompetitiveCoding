package com.vinay.programming.TestSysnopsys;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

interface TimeProvider {
    long getMillis();
}

public class CachingDataStructure {

    private int maxSize;
    private TimeProvider timeProvider;
    private Long smallestTime;
    private HashMap<String, CustomObject> data = new HashMap<>();

    CachingDataStructure(TimeProvider timeProvider, int maxSize) {
        this.timeProvider = timeProvider;
        this.maxSize = maxSize;
        this.timeProvider = new TimeProvider() {
            @Override
            public long getMillis() {
                return System.currentTimeMillis();
            }
        };
    }

    public void put(String key, String value, long timeToLeaveInMilliseconds) throws IllegalArgumentException{
        long timeToleave = timeToLeaveInMilliseconds + timeProvider.getMillis();
        if (key == null || value == null || timeToLeaveInMilliseconds <=0 )
            throw new java.lang.IllegalArgumentException();
        if (data.containsKey(key)) {
            data.put(key, new CustomObject(value, timeToleave));

        }
        if (data.size() < this.maxSize) {
            if (this.smallestTime == null) {
                data.put(key, new CustomObject(value, timeToleave));
                this.smallestTime = timeToleave;
            } else if (this.smallestTime < timeToleave){
                data.put(key, new CustomObject(value, timeToleave));
            }
        } else if (this.smallestTime < timeToleave){
                long smallReplace = Long.MAX_VALUE;
                String keyReplace = null;
                for (String keyEach : data.keySet()) {
                    CustomObject customObject = data.get(keyEach);
                    if (this.smallestTime == customObject.timeToExpire)
                        keyReplace = keyEach;
                    else if (smallReplace > customObject.timeToExpire)
                        smallReplace = customObject.timeToExpire;
                }
                data.remove(keyReplace);
                data.put(key, new CustomObject(value, timeToleave));
        }
    }

    public Optional<String> get(String key) {
        String returnValue = null;
        if (data.containsKey(key)) {
            CustomObject customObject = data.get(key);
            if (customObject.timeToExpire >= this.timeProvider.getMillis())
                returnValue = customObject.value;

        }
        if (returnValue == null)
            return null;
        return Optional.ofNullable(returnValue);
    }

    public synchronized int size() {
        List<String> toBeReplcaed = new ArrayList<>();
        long millValue = this.timeProvider.getMillis();
        for (String key: data.keySet()) {
            CustomObject customObject = data.get(key);
            if (customObject.timeToExpire < millValue)
                toBeReplcaed.add(key);
        }
        for (String key : toBeReplcaed)
            data.remove(key);
        return data.size();
    }


}


class CustomObject {
    String value;
    long timeToExpire;

    public CustomObject(String value, long timeToExpire) {
        this.value = value;
        this.timeToExpire =  timeToExpire;
    }
}