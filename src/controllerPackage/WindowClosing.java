package controllerPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class WindowClosing extends JFrame {
    public WindowClosing() {

        this.addWindowListener(new ClosingListener());
        setVisible(true);
    }
}
