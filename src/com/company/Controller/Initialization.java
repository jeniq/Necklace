package com.company.Controller;

import com.company.FileOperations;

import java.io.IOException;

/**
 * Created by Женя on 02.06.2016.
 */
public class Initialization {

    public String[] initialize(String path) throws IOException {
        return FileOperations.readFile(path).trim().split("\n");
    }
}
