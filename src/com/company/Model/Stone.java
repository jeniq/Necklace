package com.company.Model;

import com.company.Constants;

/**
 * Created by Женя on 30.05.2016.
 */
public class Stone implements Comparable<Stone>{
    private String type;
    private double radius;
    private int transparency;

    // Constructor
    public Stone(String type, double radius, int transparency){
        this.type = type;
        this.radius = radius;
        this.transparency = transparency;
    }

    /**
     * This method counts price of stone
     * @return integer
     */
    public int price(){
        return Stones.valueOf(type).price(getWeight(), transparency);
    }

    /**
     * This method counts stone's weight
     * @return weight in carats
     */
    public double getWeight(){
        return Constants.CARAT_COEFFICIENT * radius;
    }

    public int getTransparency(){
        return transparency;
    }

    @Override
    public String toString(){
        return "\nJewellery stone"
                + ", price "+ price() + "$"
                + " {radius: " + radius
                + " carat: " + ((double)Math.round(getWeight()*100))/100
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
