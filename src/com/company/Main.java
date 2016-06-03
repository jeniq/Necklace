package com.company;

import com.company.Controller.Controller;
import com.company.Controller.Initialization;
import com.company.View.View;

public class Main {

    public static void main(String[] args) {
	    // Initialization
        View view = new View();
        Initialization init = new Initialization();
        Controller controller = new Controller(init, view, Constants.PATH);

        // Run
        controller.processUser();
    }
}
