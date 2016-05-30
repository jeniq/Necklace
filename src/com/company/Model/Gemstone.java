package com.company.Model;

import com.company.Constants;

/**
 * Created by Женя on 30.05.2016.
 */
public class Gemstone extends Stone {
    private double radius;
    private int transparency; // 1 - transparent, 9 - opaque

    public Gemstone(double radius, int transparency){
        this.radius = radius;
        this.transparency = transparency;
    }

    @Override
    public int price(){
        return (int) (Constants.DEFAULT_GEMSTONE_PRICE_COEFFICIENT * getWeight() * transparency);
    }
}
