package com.company.Controller;

import com.company.FileOperations;

import java.io.IOException;

/**
 * This class initialize data from file.
 *
 * @version 01 June 2016
 * @author Yevhen Hryshchenko
 */
public class Initialization {

    /**
     * This method gets data string and divide it by line
     * @param path file path
     * @return available stones in warehouse
     * @throws IOException
     */
    public String[] initialize(String path) throws IOException {
        return FileOperations.readFile(path).trim().split("\n");
    }
}
