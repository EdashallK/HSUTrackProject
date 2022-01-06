package com.company;

import java.io.Serializable;

public class Runner implements Serializable {
    public String name;
    public double one;
    public double two;
    public double four;
    public Runner(String name,double one,double two, double four){
        this.name = name;
        this.one = one;
        this.two = two;
        this.four=  four;
    }
    public String toString(){
         return (name+"\n"+one+":100\n"+two+":200\n"+four+":400");

    }
    @Override public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Runner))
            return false;
        Runner pn = (Runner)o;
        return pn.name.equalsIgnoreCase(name);
    }
    @Override public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((name == null) ? 0 : name.hashCode());
        return result;
    }

}
