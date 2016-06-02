package com.company.Test;

import com.company.Model.Stone;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Женя on 02.06.2016.
 */
public class StoneTest {

    @Test
    public void price() throws Exception {
        Stone stone = new Stone("GEMSTONE", 1, 1);
        int expected = 150;

        int price = stone.price();

        assertEquals(expected, price);
    }

    @Test
    public void getWeight() throws Exception {
        Stone stone = new Stone("GEMSTONE", 1, 1);
        double expected = 1.5;

        double weight = stone.getWeight();

        assertEquals(expected, weight, 0.01);
    }

    @Test
    public void compareTo() throws Exception {
        Stone stone1 = new Stone("GEMSTONE", 1, 1);
        Stone stone2 = new Stone("GEMSTONE", 1.1, 1);

        assertEquals(stone1.compareTo(stone2), -1);
    }
}