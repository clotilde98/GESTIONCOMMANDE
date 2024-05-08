package viewPackage;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Menu extends JFrame {

    private JButton addButton;
    private JButton deleteButton;
    private JButton editButton;
    private JButton refreshButton;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField emailField;
    private JTextField phoneNumberField;
    private JTextField passwordField;
    private JRadioButton maleRadioButton, femaleRadioButton;
    private JDateChooser birthdayDate;
    private JRadioButton yesAdmin, noAdmin;
    private JRadioButton yesAdherent, noAdherent;;
    private JTextField localityField;
    private JTextField streetField;
    private JTextField streetNumberField;
    private JTextField numberSponsorisedField;

    public Menu() {
        addButton = new JButton("Ajouter");
        deleteButton = new JButton("Supprimer");
        editButton = new JButton("Modifier");
        refreshButton = new JButton("Actualiser");

        // Réduire la taille et changer la police des boutons
        Font buttonFont = new Font("Arial", Font.PLAIN, 12);
        addButton.setFont(buttonFont);
        deleteButton.setFont(buttonFont);
        editButton.setFont(buttonFont);
        refreshButton.setFont(buttonFont);

        // Mettre en couleur la partie des boutons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 1));
        buttonPanel.setBorder(new EmptyBorder(40, 40, 40, 40));
        buttonPanel.setBackground(Color.LIGHT_GRAY); // Couleur de fond

        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(editButton);
        buttonPanel.add(refreshButton);


        JPanel textFieldPanel = new JPanel();
        textFieldPanel.setLayout(new GridLayout(7, 4, 10, 10));
        textFieldPanel.setBorder(new EmptyBorder(30, 30, 30, 30));

        // Ajout des champs de texte
        firstNameField = new JTextField();
        lastNameField = new JTextField();
        emailField = new JTextField();
        phoneNumberField = new JTextField();
        passwordField = new JTextField();
        maleRadioButton = new JRadioButton("M");
        femaleRadioButton = new JRadioButton("F");
        birthdayDate= new JDateChooser(); // Initialisation du JDateChooser
        birthdayDate.setDateFormatString("dd/MM/yyyy");
        yesAdmin = new JRadioButton("OUI");
        noAdmin = new JRadioButton("NON");
        yesAdherent = new JRadioButton("OUI");
        noAdherent = new JRadioButton("NON");
        localityField = new JTextField();
        streetField = new JTextField();
        streetNumberField = new JTextField();
        numberSponsorisedField = new JTextField();


        // Ajout des champs de texte et des labels
        textFieldPanel.add(new JLabel("Prénom:"));
        textFieldPanel.add(firstNameField);
        textFieldPanel.add(new JLabel("Nom:"));
        textFieldPanel.add(lastNameField);
        textFieldPanel.add(new JLabel("Email:"));
        textFieldPanel.add(emailField);
        textFieldPanel.add(new JLabel("Téléphone:"));
        textFieldPanel.add(phoneNumberField);
        textFieldPanel.add(new JLabel("Mot de passe:"));
        textFieldPanel.add(passwordField);
        textFieldPanel.add(new JLabel("Genre:"));
        JPanel genderPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        genderPanel.add(maleRadioButton);
        genderPanel.add(femaleRadioButton);
        textFieldPanel.add(genderPanel);
        textFieldPanel.add(new JLabel("Date de naissance:"));
        textFieldPanel.add(birthdayDate);
        textFieldPanel.add(new JLabel("Est administrateur:"));
        JPanel adminPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        adminPanel.add(yesAdmin);
        adminPanel.add(noAdmin);
        textFieldPanel.add(adminPanel);
        textFieldPanel.add(new JLabel("Est adhérent:"));
        JPanel adherentPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        adherentPanel.add(yesAdherent);
        adherentPanel.add(noAdherent);
        textFieldPanel.add(adherentPanel);
        textFieldPanel.add(new JLabel("Localité:"));
        textFieldPanel.add(localityField);
        textFieldPanel.add(new JLabel("Rue:"));
        textFieldPanel.add(streetField);
        textFieldPanel.add(new JLabel("Numéro de rue:"));
        textFieldPanel.add(streetNumberField);
        textFieldPanel.add(new JLabel("Nombre sponsorisations:"));
        textFieldPanel.add(numberSponsorisedField);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.setBackground(Color.LIGHT_GRAY);

        JButton menuButton = new JButton("Menu");
        JButton logoutButton = new JButton("Se déconnecter");

        bottomPanel.add(menuButton);
        bottomPanel.add(logoutButton);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(buttonPanel, BorderLayout.WEST);
        mainPanel.add(textFieldPanel, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        add(mainPanel);

        setTitle("Formulaire Utilisateur");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(true);
        }



    }


