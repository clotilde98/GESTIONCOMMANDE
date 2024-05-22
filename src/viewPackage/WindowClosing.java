package viewPackage;

import javax.swing.*;

public class WindowClosing extends JFrame {
    public WindowClosing() {

        this.addWindowListener(new ClosingListener());
        setVisible(true);
    }
}
