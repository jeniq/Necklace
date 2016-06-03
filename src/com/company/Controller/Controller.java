package com.company.Controller;

import com.company.FileOperations;
import com.company.Model.Necklace;
import com.company.Model.Stone;
import com.company.Model.Stones;
import com.company.View.View;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Женя on 30.05.2016.
 */
public class Controller {
    Initialization init;
    private Necklace necklace;
    private View view;
    private String path;
    private String[] warehouse; // list of available stones
    private String type;
    private double radius;
    private int transparency;

    // Constructor
    public Controller(Initialization init, View view, String path){
        this.init = init;
        this.view = view;
        this.path = path;
    }

    // The work method
    public void processUser(){
        Scanner sc = new Scanner(System.in);

       if (initFileData()){
           out:
           while (true) {
               view.print(View.MAIN_MENU);
               switch (checkIntegerValue(sc)) { // main menu
                   case 0: // exit
                       break out;
                   case 1: // create necklace
                       view.print(View.POSITION_1 + View.NECKLACE_1);
                       view.print(View.PRICE + checkPrice(View.NECKLACE_1.split(View.SEMICOLON_SPLIT)));
                       view.print(View.POSITION_2 + View.NECKLACE_2);
                       view.print(View.PRICE + checkPrice(View.NECKLACE_2.split(View.SEMICOLON_SPLIT)));
                       view.print(View.ASK_NECKLACE);
                       switch (checkIntegerValue(sc)) { // choice variant of necklace
                           case 1:
                               necklace = tryCreateNecklace(View.NECKLACE_1.split(View.SEMICOLON_SPLIT), warehouse);
                               removeStone(View.NECKLACE_1.split(View.SEMICOLON_SPLIT));
                               break;
                           case 2:
                               necklace = tryCreateNecklace(View.NECKLACE_2.split(View.SEMICOLON_SPLIT), warehouse);
                               removeStone(View.NECKLACE_2.split(View.SEMICOLON_SPLIT));
                               break;
                           default:
                               view.print(View.WRONG_CHOICE);
                       }
                       if (necklace == null) {
                           view.print(View.NECKLACE_NOT_CREATED + View.NEED_CREATE_STONE);
                       } else {
                           view.print(View.NECKLACE_CREATED);
                       }
                       view.waitKey(sc);
                       break;
                   case 2: // add stone
                       String type = View.EMPTY;
                       boolean create = true;
                       view.print(View.ASK_STONE_TYPE);
                       view.print(View.STONE_TYPE_MENU);
                       switch (checkIntegerValue(sc)) {
                           case 1:
                               type = View.GEMSTONE;
                               break;
                           case 2:
                               type = View.SEMIPRECIOUS_STONE;
                               break;
                           default:
                               view.print(View.WRONG_CHOICE);
                               create = false;
                       }
                       if (create) {
                           view.print(View.ENTER_RADIUS);
                           double radius = checkDoubleValue(sc);
                           view.print(View.ENTER_TRANSPARENCY);
                           int transparent = checkIntegerValue(sc);
                           addStone(type, radius, transparent);
                       }
                       break;
                   case 3: // stones sorting
                       necklace.sortStones();
                       view.print(necklace.toString());
                       view.waitKey(sc);
                       break;
                   case 4: // search stones in range
                       view.print(View.MIN_MAX_VALUES);
                       view.print(necklace.getStonesFromRange(checkIntegerValue(sc),
                               checkIntegerValue(sc)).toString());
                       view.waitKey(sc);
                       break;
               }
           }
       }

    }

    /**
     * This method initialize available stones in warehouse
     * @return boolean
     */
    private boolean initFileData(){
        try {
            warehouse = init.initialize(path);
        } catch (IOException e) {
            view.print(View.FILE_EXCEPTION + path);
            return false;
        }
        return true;
    }

    /**
     * This method count stones' price
     * @param stonesList list of stones
     * @return necklace price
     */
    private int checkPrice(String[] stonesList){
        Necklace temp = new Necklace();
        for (String s : stonesList){
            parseStone(s);
            addToNecklace(temp);
        }
        return temp.getPrice();
    }

    /**
     * This method parses stone info
     * @param stoneInfo stone string
     */
    private void parseStone(String stoneInfo){
        String[] stone = stoneInfo.split(View.COMMA_SPLIT);
        radius = Double.parseDouble(stone[1]);
        transparency = Integer.parseInt(stone[2].split(" ")[1]);
        type = Stones.valueOf(stone[0]).name();
    }

    /**
     * This method try create necklace checking available stones
     * @param necklaceComponents needed components
     * @param warehouse available stones
     * @return link to Necklace
     */
    private Necklace tryCreateNecklace(String[] necklaceComponents, String[] warehouse){
        boolean available;
        Necklace temp = new Necklace();

        for (String s : necklaceComponents){
            available = false;
            for (String component : warehouse){
                if (s.equals(component)){
                    available = true;
                    break;
                }
            }
            if (available){
                parseStone(s);
                temp = addToNecklace(temp);
            }else{
                view.print(View.STONE_NOT_FOUND + s.toString());
                return null;
            }
        }
        return temp;
    }

    /**
     * This method creates necklace
     */
    private Necklace addToNecklace(Necklace necklace){
        necklace.appendToNecklace(new Stone(Stones.valueOf(type).name(), radius, transparency));
        return necklace;
    }

    /**
     * This method add stone to warehouse
     * @param type
     * @param radius
     * @param transparency
     */
    private void addStone(String type, double radius, int transparency){
        try {
            FileOperations.writeFile(type + View.COMMA_SPLIT + radius + View.COMMA_SPLIT
                    + View.TRANSPARENCY + transparency, path);
        } catch (IOException e) {
            view.print(View.FILE_NOT_FOUND);
        }
    }

    /**
     * This method checks input value
     * @param sc input
     * @return integer value
     */
    private int checkIntegerValue(Scanner sc){
        while (!sc.hasNextInt()){
            view.print(View.WRONG_INTEGER_VALUE);
            sc.next();
        }
        return sc.nextInt();
    }

    /**
     * This method checks input value
     * @param sc input
     * @return double
     */
    private double checkDoubleValue(Scanner sc){
        while (!sc.hasNextDouble()) {
            view.print(View.WRONG_DOUBLE_VALUE);
            sc.next();
        }
        return sc.nextDouble();
    }

    /**
     * This method remove stone from warehouse after creating necklace
     * @param stoneInfo list of stones
     */
    private void removeStone(String[] stoneInfo){
        for (int i = 0; i < stoneInfo.length; i++){
            if (warehouse[i].equals(stoneInfo[i])){
                warehouse[i] = View.EMPTY;
            }
        }
    }
}
