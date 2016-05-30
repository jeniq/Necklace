package com.company.Model;

import java.util.List;

/**
 * Created by Женя on 30.05.2016.
 */
public class Necklace {
    private List<Stone> necklaceParts;
    private int price;

    public Necklace(Stone... stone){
        for (Stone s : stone){
            necklaceParts.add(s);
        }
    }

    /**
     * This method counts stone's prices in necklace
     * @return integer value
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
     * @return integer value
     */
    public double getWeight(){
        int sum = 0;
        for (Stone s : necklaceParts){
            sum += s.getWeight();
        }
        return sum;
    }

    /**
     * Insertion sort
     */
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

}
