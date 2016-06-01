package com.company.Model;

import com.company.Constants;

/**
 * Created by Женя on 30.05.2016.
 */
public class SemipreciousStone extends Stone {

    public SemipreciousStone(double radius, int transparency){
        this.radius = radius;
        this.transparency = transparency;
    }

    @Override
    public int price() {
        return (int) (Constants.DEFAULT_SEMIPRECIOUS_PRICE_COEFFICIENT * getWeight() * transparency);
    }
}
