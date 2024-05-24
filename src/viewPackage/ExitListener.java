package viewPackage;

import controllerPackage.ApplicationController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitListener implements ActionListener {

    private ApplicationController controller;
    public void actionPerformed (ActionEvent event) {
        controller = new ApplicationController();
        controller.closeConnection();
        System.exit(0);
    }
}
