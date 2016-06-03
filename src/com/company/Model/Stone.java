package com.company.Model;

import com.company.Constants;

/**
 * This class realises jewellery stone.
 * It consists of type, radius and transparency.
 * It possible to get price of stone.
 * Price is depending of type that stores in Enum Stones.
 * In this class is overrides method compareTo by price.
 *
 * @version 01 June 2016
 * @author Yevhen Hryshchenko
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
