package com.vinay.practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class QuickUnionModify {
    int id[];
    int sz[];
    public QuickUnionModify(int n) {
        id = new int[n];
        sz = new int[n];
        for(int i=0;i<n;i++){
            id[i] = i;
            sz[i] = 1;
        }
    }

    public int root(int p){
        while(p!=id[p]){
//            the below line of code further decreases the finding time by changing the root of each element when finding its parent
            id[p] = id[id[p]];
            p = id[p];
        }
        return p;
    }

    public boolean isConnected(int p, int q){
        return root(p)==root(q);
    }

    public void merge(int p, int q){
        int pid = root(p);
        int qid = root(q);
        if(sz[pid] < sz[qid]){
            id[pid] = id[qid];
            sz[pid] += sz[qid];
        }else {
            id[qid] = id[pid];
            sz[qid] += sz[pid];
        }

    }

    public void print(){
        for(int i:id){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        String filePath = new File("").getAbsolutePath();
        filePath = filePath.concat("\\AlgorithmsAndDatastructures\\src\\unionfind.txt");
        System.out.println(filePath);
        File file = new File(filePath);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        int n = Integer.valueOf( br.readLine());
        QuickUnion UF = new QuickUnion(n);
        while((st = br.readLine())!=null){
            int p[] = new int[3];
            String[] str = st.split(" ");
            for(int i=0;i<str.length;i++){
                p[i] = Integer.parseInt(str[i]);
            }
            if(p[0] == 1){
                UF.merge(p[1], p[2]);
            }else{
                String out = p[1] + " and " + p[2];
                if(UF.isConnected(p[1], p[2])){
                    System.out.println(out + " is connected");
                }else{
                    System.out.println(out + " are not connected");
                }
            }
        }
        UF.print();
    }

}
