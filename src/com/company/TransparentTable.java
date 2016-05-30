package com.company;

/**
 * Created by Женя on 30.05.2016.
 */
public enum TransparentTable {
    ONE(200),
    TWO(180),
    THREE(160),
    FOUR(140),
    FIRE(120),
    SIX(110),
    SEVEN(95),
    EIGHT(80),
    NINE(65);

    private final int coefficient;
    TransparentTable(int coefficient){
        this.coefficient = coefficient;
    }

    public int coefficient(){
        return coefficient;
    }
}
