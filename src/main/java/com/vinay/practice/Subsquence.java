package com.vinay.practice;

import java.util.ArrayList;

public class Subsquence {

    public class ComponentCode{
        public int value;
        public ArrayList<ComponentCode> components;

        public ComponentCode() {
            components = new ArrayList<>();
        }

        public ComponentCode(int value, ArrayList<ComponentCode> components) {
            this.value = value;
            this.components = components;
        }
    }

    public ComponentCode getFastest(ComponentCode root){
        ComponentCode res  = null;
        double result = 0;
        Utility(root, res, result);
        return res;
    }

    public double[] Utility(ComponentCode root, ComponentCode res, double result){
        ArrayList<ComponentCode> comps = root.components;
        double re[] = new double[2];
        double val = root.value;
        double size = 1;
        for(int i=0;i<comps.size();i++){
            re = Utility(comps.get(i), res, result);
            val += re[0];
            size += re[1];
        }
        if(comps.size() > 0){
            val = val/size;
        }
        if(val > result){
            result = val;
            res = root;
        }
        re[0] = val;
        re[1] = size;
        return re;
    }
}