package com.company.Model;

import com.company.Constants;

/**
 * Created by Женя on 30.05.2016.
 */
public abstract class Stone implements Comparable<Stone>{
    protected double radius;
    protected int transparency;

    abstract int price();

    public double getWeight(){
        return Constants.CARAT_COEFFICIENT * radius;
    }

    public int getTransparency(){
        return transparency;
    }

    @Override
    public String toString(){
        return "Jewellery stone, "
                + getClass()
                + ", price "+ price() + "($)"
                + " {radius: " + radius
                + " carat: " + getWeight()
                + ", transparency: " + transparency
                + "}";
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
