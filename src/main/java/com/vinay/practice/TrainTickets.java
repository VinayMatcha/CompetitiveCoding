package com.vinay.practice;

public class TrainTickets {

    public static int mincostTickets(int[] days, int[] costs) {
        int dp[] = new int[366];
        int day  =1;
        dp[0] = 0;
        for(int i=0;i<days.length;i++, day++){
            int p = days[i];
            while(day < p){
                dp[day] = dp[day-1];
                day++;
            }
            dp[p] = dp[p-1] + costs[0];
            if(p > 7){
                dp[p] = Math.min(dp[p-1]+costs[0], dp[p-7]+costs[1]);
            }else{
                dp[p] = Math.min(dp[p-1]+costs[0], costs[1]);
            }
            if(p > 30){
                dp[p] = Math.min(dp[p], dp[p-30]+costs[2]);
            }else{
                dp[p] = Math.min(dp[p], costs[2]);
            }
        }
        while(day <= 365){
            dp[day] = dp[day-1];
            day++;
        }
        return dp[days[days.length-1]];
    }

    public static void main(String[] args) {
        int a[] = new int[]{1,2,3,4,5,6,7,8,9,10,30,31};
        int costs[] = new int[]{2,7,15};
        System.out.println(mincostTickets(a, costs));
    }

}
