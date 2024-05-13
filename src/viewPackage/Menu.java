package viewPackage;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {

    private JButton searchButton;
    private JButton userManagerButton;
    private JButton logoutButton;

    private Container mainContainer;

    public Menu() {
        setBounds(100,100,500,500);
        mainContainer = this.getContentPane();
        mainContainer.setLayout(new BorderLayout());
        searchButton = new JButton("RECHERCHES");
        userManagerButton = new JButton("GESTION UTILISATEUR");
        logoutButton = new JButton("Se Deconnecter");
        JLabel titleLabel = new JLabel("MENU");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.setBorder(new EmptyBorder(40, 40, 40, 40));

        buttonPanel.add(searchButton);
        buttonPanel.add(userManagerButton);
        userManagerButton.addActionListener(new formAction());

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        mainPanel.add(titleLabel, BorderLayout.NORTH);
        mainPanel.add(logoutButton, BorderLayout.SOUTH);
        logoutButton.addActionListener(new logoutAction());

        add(mainPanel);

        setTitle("Menu");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        // Ajout de l'ActionListener au bouton "GESTION UTILISATEUR"


        // Ajout de l'ActionListener au bouton "Se Deconnecter"

    }

    public class formAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Ouvrir une nouvelle fenêtre de gestion utilisateur
            FormAdmin formAdmin = new FormAdmin();
            formAdmin.setVisible(true); // Rendre la fenêtre visible
            setVisible(false);

        }
    }

    public class logoutAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Ouvrir une nouvelle fenêtre de gestion utilisateur
            Login login = new Login();
            login.setVisible(true); // Rendre la fenêtre visible
            setVisible(false);

        }
    }
}






