package viewPackage;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Welcome extends  JPanel{

    private JLabel jLabel;


    public Welcome (){
        jLabel = new JLabel("BIENVENUE");
        jLabel.setFont(new Font("Verdana",1,20));

        this.setLayout(new FlowLayout());
        setBorder(new EmptyBorder(20, 20, 20, 20));
        this.add(jLabel);



    }

}