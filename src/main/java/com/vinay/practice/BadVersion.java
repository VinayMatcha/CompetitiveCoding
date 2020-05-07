package com.vinay.practice;

public class BadVersion {

    public int firstBadVersion(int n) {
        int l = 1;
        int h = n;
        while(l < h){
            int mid = l + (h - l)/2;
            if(isBadVersion(mid)){
                h = mid;
            }else{
                l = mid + 1;
            }
        }
        return l;

    }

    private boolean isBadVersion(int mid) {
        return true;
    }

}
