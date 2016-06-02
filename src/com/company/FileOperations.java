package com.company;

import java.io.*;

/**
 * Created by Женя on 01.06.2016.
 */
public class FileOperations {
    public static String readFile(String path) throws IOException {
        FileReader fr = new FileReader(path);
        StringBuilder buffer = new StringBuilder();

        int symbol = 0;

        symbol = fr.read();
        while (symbol != -1) {
            symbol = fr.read();
            buffer.append((char) symbol);
        }
        fr.close();
        return buffer.toString();
    }

    public static void writeFile(String data, String path) throws IOException {
        Writer w = new FileWriter(path, true);
        w.append('\n');
        w.write(data);
        w.close();
    }


}
