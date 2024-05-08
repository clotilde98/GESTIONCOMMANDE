package viewPackage;
import controllerPackage.ClosingListener;
import controllerPackage.WindowClosing;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;

public class Login extends JFrame  {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    public Login() {
        super("Formulaire de Connexion");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setResizable(false);



        // Créer un JPanel pour le formulaire de connexion
        JPanel formPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        formPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        formPanel.setBackground(Color.GREEN);
        JLabel usernameLabel = new JLabel("Nom d'utilisateur:");
        usernameField = new JTextField(10);

        JLabel passwordLabel = new JLabel("Mot de passe:");
        passwordField = new JPasswordField(10);

        loginButton = new JButton("Se Connecter");

        formPanel.add(usernameLabel);
        formPanel.add(usernameField);
        formPanel.add(passwordLabel);
        formPanel.add(passwordField);
        formPanel.add(new JLabel()); // Espace vide pour aligner les composants
        formPanel.add(loginButton);

        // Créer un JLabel pour le titre LOGIN
        JLabel titleLabel = new JLabel("LOGIN");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setForeground(Color.YELLOW); // Couleur de texte jaune
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER); // Alignement centré

        // Créer un JPanel pour le conteneur principal
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setForeground(Color.GREEN);
        mainPanel.setBorder(new EmptyBorder(50, 50, 50, 50));
        mainPanel.add(titleLabel, BorderLayout.NORTH); // Ajouter le JLabel du titre en haut
        mainPanel.add(formPanel, BorderLayout.CENTER); // Ajouter le JPanel du formulaire au centre

        getContentPane().add(mainPanel);

        setLocationRelativeTo(null);
        setVisible(true);

        setResizable(false);
        }

}







