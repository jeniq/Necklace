package com.company.Model;

import com.company.Constants;

/**
 * Created by Женя on 02.06.2016.
 */
public enum Stones {
    GEMSTONE(Constants.DEFAULT_GEMSTONE_PRICE_COEFFICIENT),
    SEMIPRECIOUS(Constants.DEFAULT_SEMIPRECIOUS_PRICE_COEFFICIENT);

    private final int coefficient;

    Stones(int coefficient){
        this.coefficient = coefficient;
    }

    /**
     * This method counts stone's price
     * @param weight carat
     * @param transparency integer value
     * @return price
     */
    public int price(double weight, int transparency) {
        return (int) (coefficient * weight * transparency);
    }
}
