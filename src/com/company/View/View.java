package com.company.View;

import java.util.Scanner;

/**
 * Created by Женя on 30.05.2016.
 */
public class View {
    // Constants
    public static final String EMPTY = "";
    public static final String FILE_EXCEPTION = ">>> Error has occurred while work with file! <<<";
    public static final String COMMA_SPLIT = ", ";
    public static final String RET_NLINE_SPLIT = "\r\n";
    public static final String WAIT_BUTTON = "Enter any key to continue...";
    public static final String WRONG_CHOICE = "Wrong choice!";
    public static final String TRANSPARENCY = "transparency ";
    public static final String ENTER_RADIUS = "Enter stone radius:";
    public static final String MIN_MAX_VALUES = "Enter minimum and maximum transparency:";
    public static final String ENTER_TRANSPARENCY = "Enter transparency:";
    public static final String FILE_NOT_FOUND = "Can't find file in path: ";
    public static final String ASK_NECKLACE = "Select necklace:";
    public static final String STONE_NOT_FOUND = "Stone is not found: ";
    public static final String NECKLACE_NOT_CREATED = "Necklace is not created. ";
    public static final String NECKLACE_CREATED = "Necklace is created successfully!";
    public static final String NEED_CREATE_STONE = "Need to add stone!";
    public static final String ASK_STONE_TYPE = "Select type:";
    public static final String WRONG_INTEGER_VALUE = "Incorrect integer value, try again.";
    public static final String WRONG_DOUBLE_VALUE = "Incorrect double value, try again.";
    public static final String SEMICOLON_SPLIT = ";";
    public static final String STONE_TYPE_MENU = "1. Gemstone" +
            "\n2. Semiprecious stone";
    public static final String GEMSTONE = "GEMSTONE";
    public static final String SEMIPRECIOUS_STONE = "SEMIPRECIOUS";
    public static final String PRICE = "Price($) ";
    public static final String MAIN_MENU = "\nMenu:" +
            "\n1. Create necklace" + "\n2. Add stone" +
            "\n3. Sort stones" +
            "\n4. Search stones" +
            "\n0. Exit";
    public static final String POSITION_1 = "1. ";
    public static final String POSITION_2 = "2. ";
    public static final String NECKLACE_1 = "GEMSTONE, 0.6, transparency 2;" +
            "GEMSTONE, 0.6, transparency 3;" +
            "GEMSTONE, 0.4, transparency 3;" +
            "GEMSTONE, 0.4, transparency 3;" +
            "GEMSTONE, 0.3, transparency 4;" +
            "GEMSTONE, 0.3, transparency 4;";
    public static final String NECKLACE_2 = "GEMSTONE, 0.9, transparency 1;" +
            "SEMIPRECIOUS, 0.6, transparency 4;" +
            "SEMIPRECIOUS, 0.6, transparency 4;" +
            "SEMIPRECIOUS, 0.5, transparency 5;" +
            "SEMIPRECIOUS, 0.5, transparency 5;" +
            "GEMSTONE, 0.3, transparency 1;" +
            "GEMSTONE, 0.3, transparency 1;";


    public void print(String message){
        System.out.println(message);
    }

    /**
     * This method waits until key pressed
     * @param sc any key
     */
    public void waitKey(Scanner sc){
        print(WAIT_BUTTON);
        sc.next();
    }
}
