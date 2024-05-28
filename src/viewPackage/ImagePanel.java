package viewPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
public class ImagePanel extends JPanel {
    private BufferedImage image;
    private double scale = 0.7;

    public ImagePanel() {
        // No-argument constructor
    }

    public ImagePanel(String imagePath) {
        loadImage(imagePath);
    }

    public void loadImage(String imagePath) {
        try {
            image = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            int panelWidth = getWidth();
            int panelHeight = getHeight();

            // Calculate the new dimensions while maintaining the aspect ratio
            double aspectRatio = (double) image.getWidth() / image.getHeight();
            int newWidth;
            int newHeight;

            if (panelWidth / aspectRatio < panelHeight) {
                newWidth = (int) (panelWidth * scale*scale);
                newHeight = (int) (newWidth / aspectRatio);
            } else {
                newHeight = (int) (panelHeight * scale);
                newWidth = (int) (newHeight * aspectRatio);
            }

            int x = (panelWidth - newWidth) / 2;
            int y = (panelHeight - newHeight) / 2;

            g.drawImage(image, x, y, newWidth, newHeight, this);
        }
    }
}
