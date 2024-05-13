package viewPackage;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class FormAdmin extends JFrame{

    private JButton addButton;
    private JButton menu;

    private Container mainContainer;

    public FormAdmin() {
        setBounds(100, 100, 500, 500);
        mainContainer = this.getContentPane();
        mainContainer.setLayout(new BorderLayout());

        addButton = new JButton("NOUVEAU UTILISATEUR");
        menu = new JButton("MENU");

        // Réduire la taille et changer la police des boutons
        Font buttonFont = new Font("Arial", Font.BOLD, 12);
        addButton.setFont(buttonFont);
        menu.setFont(buttonFont);

        Dimension buttonSize = new Dimension(200, 30);
        addButton.setPreferredSize(buttonSize);
        menu.setPreferredSize(buttonSize);

        // Mettre en couleur la partie des boutons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 1));
        buttonPanel.setBorder(new EmptyBorder(100, 20, 100, 50));


        // Ajouter le bouton "NOUVEAU UTILISATEUR" aligné à gauche
        JPanel newUserButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        newUserButtonPanel.add(addButton);
        buttonPanel.add(newUserButtonPanel);
        addButton.addActionListener(new nouveauAction());

        // Ajouter le bouton "MENU" aligné à gauche
        JPanel menuButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        menuButtonPanel.add(menu);
        buttonPanel.add(menuButtonPanel);

        mainContainer.add(buttonPanel, BorderLayout.WEST);

        setTitle("Formulaire Admin");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setVisible(true);
        setResizable(false);

 }

    public class nouveauAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Ouvrir une nouvelle fenêtre de gestion utilisateur
            AddCustomer addUsers = null;
            try {
                addUsers = new AddCustomer();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            addUsers.setVisible(true); // Rendre la fenêtre visible
            setVisible(false);

        }
    }

}

