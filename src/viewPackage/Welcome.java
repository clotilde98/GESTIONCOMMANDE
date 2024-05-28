package viewPackage;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Welcome extends JPanel {

    private JLabel jLabel;
    private ImagePanel imagePanel;

    public Welcome() {
        jLabel = new JLabel("BIENVENUE");
        jLabel.setFont(new Font("Verdana", 1, 20));

        imagePanel = new ImagePanel(); // Initialisation du JLabel pour l'image

        this.setLayout(new BorderLayout()); // Utilisation d'un BorderLayout
        setBorder(new EmptyBorder(20, 20, 20, 20));
        this.add(jLabel, BorderLayout.NORTH); // Ajout du JLabel pour le texte en haut
        this.add(imagePanel, BorderLayout.CENTER); // Ajout du JLabel pour l'image au centre


        String currentPath = System.getProperty("user.dir") + "\\src\\images\\";
        String[] imagePaths = {
                currentPath + "image.jpg",
                currentPath + "image2.jpg",
        };


        ImageChangeThread imageChangeThread = new ImageChangeThread(this, imagePaths);
        imageChangeThread.start();

        // Add a shutdown hook to stop the thread when the application closes
        Runtime.getRuntime().addShutdownHook(new Thread(imageChangeThread::stopRunning));
    }

    // Méthode pour charger et afficher une image
    public void displayImage(String imagePath) {
        imagePanel.loadImage(imagePath);
    }

}