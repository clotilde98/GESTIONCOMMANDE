package viewPackage;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Welcome extends JPanel {

    private JLabel jLabel;
    private JLabel imageLabel; // Ajout d'un JLabel pour afficher l'image

    public Welcome() {
        jLabel = new JLabel("BIENVENUE");
        jLabel.setFont(new Font("Verdana", 1, 20));

        imageLabel = new JLabel(); // Initialisation du JLabel pour l'image

        this.setLayout(new BorderLayout()); // Utilisation d'un BorderLayout
        setBorder(new EmptyBorder(20, 20, 20, 20));
        this.add(jLabel, BorderLayout.NORTH); // Ajout du JLabel pour le texte en haut
        this.add(imageLabel, BorderLayout.CENTER); // Ajout du JLabel pour l'image au centre
    }

    // Méthode pour charger et afficher une image
    public void displayImage(String imagePath) {
        try {
            BufferedImage image = ImageIO.read(new File(imagePath));
            ImageIcon icon = new ImageIcon(image);
            imageLabel.setIcon(icon);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}