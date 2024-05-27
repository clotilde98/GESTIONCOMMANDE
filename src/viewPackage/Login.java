package viewPackage;

import controllerPackage.ApplicationController;

import exceptionPackage.CustomExceptions;
import modelPackage.Customer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame  {

    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginButton;

    private JButton exitButton;
    private ApplicationController controller;
    public Login() {
        super("Formulaire de Connexion");
        setController(new ApplicationController());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setResizable(false);

        JPanel formPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        formPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        formPanel.setBackground(Color.GREEN);

        JLabel usernameLabel = new JLabel("Adresse Mail:");
        emailField = new JTextField(10);
        JLabel passwordLabel = new JLabel("Mot de passe:");
        passwordField = new JPasswordField(10);

        loginButton = new JButton("Se Connecter");
        exitButton = new JButton("Quitter");

        formPanel.add(usernameLabel);
        formPanel.add(emailField);
        formPanel.add(passwordLabel);
        formPanel.add(passwordField);
        formPanel.add(new JLabel()); // Empty cell to create space
        formPanel.add(new JLabel()); // Empty cell to create space
        formPanel.add(loginButton);
        formPanel.add(exitButton);


        // Create the main panel and add components
        JLabel titleLabel = new JLabel("LOGIN");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setForeground(Color.GREEN);
        mainPanel.setBorder(new EmptyBorder(50, 50, 50, 50));
        mainPanel.add(titleLabel, BorderLayout.NORTH);
        mainPanel.add(formPanel, BorderLayout.CENTER);


        // Add the main panel to the frame
        getContentPane().add(mainPanel);

        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //
        loginButton.addActionListener(new loginAction());
        ExitListener exitListener = new ExitListener();
        exitButton.addActionListener(exitListener);


        }

    private void setController(ApplicationController controller) {
        this.controller = controller;
    }

    private void userIsAdmin(Customer user) throws CustomExceptions {
        if (!user.getIsAdmin()) {
            String message = "Le menu client n'est pas encore implémenté\n veuillez utiliser un compte admin";
            throw new CustomExceptions(message);
        }

    }


    public class loginAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                String email = CustomUtilities.validateEmail(emailField.getText(),"email");
                String password = new String(passwordField.getPassword());

                Customer user = controller.getUser(email,password);
                userIsAdmin(user);

                //Open Menu
                ProjectMenu menu = new ProjectMenu();
                menu.setVisible(true);
                setVisible(false);
            }
            catch (Exception ex) {
                JOptionPane.showMessageDialog(Login.this, ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }

            }

        }


    }
