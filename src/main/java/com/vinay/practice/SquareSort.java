package com.vinay.practice;

public class SquareSort {


    public static void main(String[] args) {
        int a[] = new int[]{-9, -2, 0, 2, 3};
        int i =0;
        for(int j=0;j<a.length;j++){
            if(a[j] >= 0){
                i = j;
                break;
            }
        }
        int sq[] = new int[a.length];
        int low = i-1;
        int high = i;
        int k =0;
        while(low >=0 && high < a.length){
            if(Math.abs(a[low]) < a[high]){
                sq[k++] = a[low] * a[low];
                low--;

            }else{
                sq[k++] = a[high] * a[high];
                high++;
            }
        }
        while (low >= 0){
            sq[k++] = a[low] * a[low];
            low--;

        }
        while (high < a.length){
            sq[k++] = a[high] * a[high];
            high++;
        }
        for(int s:sq){
            System.out.println(s);
        }
    }


}
