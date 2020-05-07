package com.vinay.practice;

class Sol {
    public static int solution(int[] A) {
        // write your code in Java SE 8
        int s = A.length-1;
        int[] Odd = new int[s];
        int[] Even = new int[s];
        int count = 1;
        for(int i=s;i>=0;i--){
            int t = 0;
//            System.out.println(" i starts here "+i);
            boolean flag = false;
            int j = i;
            while(j <= s){
                int r = j;
                if(t%2==0){
                    if(Odd[j]==1){
                        r = s;
                    }else if(Odd[j]==0){
                        int dif = 10001;
//                    System.out.println("odd");
                        for(int k=j+1;k<=s;k++){
                            int val = A[k] - A[j];
                            if(val > 0 && dif > val){
                                dif = val;
                                r = k;
                            }
                        }
                    }
//                    System.out.println("val is"+dif+" "+ r);
                }else{
                    if(Even[j]==1){
                        r = s;
                    }else{
                        int dif = 10000;
//                    System.out.println("even");
                        for(int k=j+1;k<=s;k++){
                            int val = A[j] - A[k];
                            if(val > 0 && dif > val){
                                dif = val;
                                r = k;
                            }
                        }
                    }
//                    System.out.println("val is"+dif+" "+ r);
                }
//                System.out.println(j + " hi "+ r);
                if(j == r){
                    break;
                }
                j = r;
                if(j == s){
                    count++;
                    break;
                }
                t++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] s = new int[]{10, 13, 12, 14, 15};
        System.out.println(solution(s));
    }
}