package viewPackage;


import controllerPackage.UsersController;
import modelPackage.UsersModel;
import exceptionPackage.customExceptions;
import exceptionPackage.InvalidEmailFormatException;
import exceptionPackage.InvalidPasswordFormatException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Integer.parseInt;

public class AddUsers extends JFrame {

    private UsersController controller;
    private JButton addButton;

    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField emailField;
    private JTextField phoneNumberField;
    private JTextField passwordField;
    private JRadioButton maleRadioButton, femaleRadioButton;
    private JTextField birthdayDate;
    private JRadioButton yesAdmin, noAdmin;
    private JRadioButton yesAdherent, noAdherent;;
    private JTextField localityField;
    private JTextField streetField;
    private JTextField streetNumberField;
    private JTextField numberSponsorisedField;

    private Container mainContainer;

    public AddUsers() {
        setBounds(100, 100, 800, 800);
        mainContainer = this.getContentPane();
        mainContainer.setLayout(new BorderLayout());

        UsersModel model = new UsersModel("defaultFirstName",
                "defaultLastName",
                "defaultEmail",
                "defaultPhoneNumber",
                "defaultPassword",
                'M',
                2000, 1, 1,
                true,
                true,
                "defaultStreet",
                1,
                0,
                "defaultLocality");

        controller = new UsersController(model);


        addButton = new JButton("Ajouter");
        addButton.addActionListener(new actionnouveau());



        Font buttonFont = new Font("Arial", Font.PLAIN, 12);
        addButton.setFont(buttonFont);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 1));
        buttonPanel.setBorder(new EmptyBorder(40, 40, 40, 40));
        buttonPanel.setBackground(Color.LIGHT_GRAY);
        buttonPanel.add(addButton);

        JPanel textFieldPanel = new JPanel();
        textFieldPanel.setLayout(new GridLayout(14, 2, 10, 10));
        textFieldPanel.setBorder(new EmptyBorder(30, 30, 30, 30));

        firstNameField = new JTextField();
        lastNameField = new JTextField();
        emailField = new JTextField();
        phoneNumberField = new JTextField();
        passwordField = new JTextField();
        maleRadioButton = new JRadioButton("M");
        femaleRadioButton = new JRadioButton("F");
        birthdayDate = new JTextField(); // Initialisation du JDateChooser
        yesAdmin = new JRadioButton("OUI");
        noAdmin = new JRadioButton("NON");
        yesAdherent = new JRadioButton("OUI");
        noAdherent = new JRadioButton("NON");
        localityField = new JTextField();
        streetField = new JTextField();
        streetNumberField = new JTextField();
        numberSponsorisedField = new JTextField();

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);

        ButtonGroup adminGroup = new ButtonGroup();
        adminGroup.add(yesAdmin);
        adminGroup.add(noAdmin);

        ButtonGroup adherentGroup = new ButtonGroup();
        adherentGroup.add(yesAdherent);
        adherentGroup.add(noAdherent);

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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 600);
        setVisible(true);
        setResizable(false);
    }

    public class actionnouveau implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                String email = emailField.getText();
                String phoneNumber = phoneNumberField.getText();
                String password = passwordField.getText();
                char gender = (maleRadioButton.isSelected()) ? 'M' : 'F';
                // Récupérer la date de naissance
                String birthday = birthdayDate.getText();
                String[] parts = birthday.split("-");
                int year = (parts.length > 0 && !parts[0].isEmpty()) ? parseInt(parts[0]) : 0;
                int month = (parts.length > 1 && !parts[1].isEmpty()) ? parseInt(parts[1]) : 0;
                int dayOfMonth = (parts.length > 2 && !parts[2].isEmpty()) ? parseInt(parts[2]) : 0;
                boolean isAdmin = (yesAdmin.isSelected());
                boolean isAdherent = (yesAdherent.isSelected());
                String locality = localityField.getText();
                String street = streetField.getText();
                int streetNumber = (!streetNumberField.getText().isEmpty()) ? parseInt(streetNumberField.getText()) : 0;
                int numberSponsorised = (!numberSponsorisedField.getText().isEmpty()) ? parseInt(numberSponsorisedField.getText()) : 0;

                // Appel de la méthode pour ajouter l'utilisateur avec gestion des exceptions
                controller.addUser(firstName, lastName, email, phoneNumber, password,
                        gender, year, month, dayOfMonth, isAdmin, isAdherent,
                        street, streetNumber, numberSponsorised, locality);

            } catch (customExceptions ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(AddUsers.this, ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            } catch (InvalidEmailFormatException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(AddUsers.this, "Format d'email invalide.", "Erreur", JOptionPane.ERROR_MESSAGE);
            } catch (InvalidPasswordFormatException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(AddUsers.this, "Format de mot de passe invalide.", "Erreur", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(AddUsers.this, "Une erreur est survenue.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }


}

