package com.company.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * This class realises necklace.
 * Necklace consists of stones and stores price, weight fields.
 * Necklace's stones can be sorted by price.
 * There is possibility to find stones in necklace using some range.
 *
 * @version 01 June 2016
 * @author Yevhen Hryshchenko
 */
public class Necklace {
    private List<Stone> necklaceParts;

    // Constructor
    public Necklace(Stone... stone){
        necklaceParts = new ArrayList<>();
        for (Stone s : stone){
            necklaceParts.add(s);
        }
    }

    /**
     * This method counts stone's prices in necklace
     * @return price
     */
    public int getPrice(){
        int sum = 0;
        for (Stone s : necklaceParts){
            sum += s.price();
        }
        return sum;
    }

    /**
     * This method counts stone's weight in necklace
     * @return weight in carats
     */
    public double getWeight(){
        double sum = 0;
        for (Stone s : necklaceParts){
            sum += s.getWeight();
        }
        return sum;
    }

    //Insertion sort
    public void sortStones(){
        Stone key;
        int i;
        for (int j = 1; j < necklaceParts.size(); j++){
            key = necklaceParts.get(j);
            i = j - 1;
            while ((i >= 0)
                    && (necklaceParts.get(i).compareTo(key) > 0)){
                necklaceParts.set(i+1, necklaceParts.get(i));
                i--;
            }
            necklaceParts.set(i + 1, key);
        }
    }

    /**
     * This method append new stones to necklace
     * @param stone
     */
    public void appendToNecklace(Stone stone){
        necklaceParts.add(stone);
    }

    @Override
    public String toString(){
        return "Necklace, price " +
                getPrice() + "$" +
                ", weight: " +
                getWeight() + " carats" +
                "\nInclude stones " +
                "\n" + necklaceParts;
    }

    /**
     * This method searches stones in selected values
     * @param min minimum value of range
     * @param max maximum value of range
     * @return list of stones
     */
    public List<Stone> getStonesFromRange(int min, int max){
        List<Stone> stones = new ArrayList<>();
        for (Stone s : necklaceParts){
            if (s.getTransparency() > min && s.getTransparency() < max) {
                stones.add(s);
            }
        }
        return stones;
    }

}
