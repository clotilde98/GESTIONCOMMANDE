package viewPackage;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Login extends JFrame  {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    public Login() {
        super("Formulaire de Connexion");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setResizable(false);




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
        formPanel.add(new JLabel());
        formPanel.add(loginButton);


        JLabel titleLabel = new JLabel("LOGIN");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setForeground(Color.YELLOW);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);


        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setForeground(Color.GREEN);
        mainPanel.setBorder(new EmptyBorder(50, 50, 50, 50));
        mainPanel.add(titleLabel, BorderLayout.NORTH);
        mainPanel.add(formPanel, BorderLayout.CENTER);

        getContentPane().add(mainPanel);

        setLocationRelativeTo(null);
        setVisible(true);

        setResizable(false);
        }

}






