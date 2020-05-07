package com.vinay.practice;

import java.util.Comparator;
import java.util.TreeSet;

public class SmallestString988 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

        public String smallestFromLeaf(TreeNode root) {
            TreeSet<String> res = new TreeSet<>(new Comparator<String>()
            {
                public int compare(String o1, String o2)
                {
                    if(o1.length() == o2.length()){
                        return o1.compareTo(o2);
                    }else if(o1.length() > o2.length()){
                        int s = o1.substring(0, o2.length()).compareTo(o2);
                        if( s == 0){
                            return 1;
                        }else{
                            return s;
                        }
                    }else{
                        int s = o1.compareTo(o2.substring(0, o1.length()));
                        if( s == 0){
                            return -1;
                        }else{
                            return s;
                        }
                    }


                }
            });
            char a = (char) (97 + root.val);
            String sb = String.valueOf(a);
            findString(root.left, sb, res);
            findString(root.right, sb, res);
            return res.first();

        }

        public void findString(TreeNode root, String sb, TreeSet<String> res) {
            if(root == null){
                StringBuilder sr = new StringBuilder();
                sr.append(sb);
                res.add(sr.reverse().toString());
            }else{
                char a = (char) (97 + root.val);
                System.out.println(sb + " "+ a);
                if(root.left == null || root.right == null){
                    StringBuilder sr = new StringBuilder();
                    sr.append(sb);
                    res.add(sr.reverse().toString());
                }
                if(root.left != null){
                    findString(root.left, sb + String.valueOf(a), res);
                }
                if(root.right != null){
                    findString(root.right, sb + String.valueOf(a), res);
                }
            }
        }
 }
