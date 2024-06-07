package viewPackage;

import controllerPackage.ApplicationController;
import exceptionPackage.DataAccessException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitListener implements ActionListener {

    private ApplicationController controller;
    public void actionPerformed (ActionEvent event) {

        try {
            controller = new ApplicationController();
            controller.closeConnection();
        } catch (DataAccessException e) {
            throw new RuntimeException(e);
        }

        System.exit(0);
    }
}
