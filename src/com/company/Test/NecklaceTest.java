package com.company.Test;

import com.company.Model.Necklace;
import com.company.Model.Stone;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Женя on 02.06.2016.
 */
public class NecklaceTest {

    @Test
    public void getPrice() throws Exception {
        Necklace necklace = new Necklace(new Stone("GEMSTONE", 1, 1), new Stone("GEMSTONE", 1, 1),
                new Stone("SEMIPRECIOUS", 1, 1));
        int expected = 412;

        int price = necklace.getPrice();

        assertEquals(expected, price);
    }

    @Test
    public void getWeight() throws Exception {
        Necklace necklace = new Necklace(new Stone("GEMSTONE", 1, 1), new Stone("GEMSTONE", 1, 1),
                new Stone("SEMIPRECIOUS", 1, 1));
        double expected = 4.5;

        double weight = necklace.getWeight();

        assertEquals(expected, weight, 0.01);
    }
}