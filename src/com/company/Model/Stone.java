package com.company.Model;

import com.company.Constants;

/**
 * Created by Женя on 30.05.2016.
 */
public abstract class Stone implements Comparable<Stone>{
    abstract int price();

    int radius;

    public double getWeight(){
        return Constants.CARAT_COEFFICIENT * radius;
    }

    @Override
    public String toString(){
        return "Jewellery, "
                + "price: " + this.price();
    }

    @Override
    public int compareTo(Stone o){
        if (this.price() > o.price()){
            return 1;
        }
        if (this.price() < o.price()){
            return -1;
        }
        return 0;
    }
}
