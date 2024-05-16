package viewPackage;

import controllerPackage.ApplicationController;

import exceptionPackage.InvalidPasswordFormatException;
import exceptionPackage.customExceptions;
import modelPackage.Customer;
import modelPackage.Locality;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class AddCustomer extends  JFrame{
    private JButton addButton;

    private JTextField firstNameField, lastNameField, emailField, phoneNumberField, passwordField;
    private JRadioButton maleRadioButton, femaleRadioButton;
    private JTextField birthdayDate;
    private JRadioButton yesAdmin, noAdmin;
    private JRadioButton yesAdherent, noAdherent;

    private   JComboBox<Locality> localityComboBox;

    private JTextField streetField;
    private JTextField streetNumberField;
    private JTextField numberSponsorisedField;

    private Container mainContainer;

    private ApplicationController controller;


    public  AddCustomer() throws SQLException {
        setController(new ApplicationController());

        setBounds(100, 100, 800, 800);
        mainContainer = this.getContentPane();
        mainContainer.setLayout(new BorderLayout());

        addButton = new JButton("Ajouter");
        addButton.addActionListener(new AddCustomer.actionnouveau());

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
        String defaultBirthday = "YYYY-MM-DD"; // Format YYYY-MM-DD
        birthdayDate = new JTextField(defaultBirthday);
        yesAdmin = new JRadioButton("OUI");
        noAdmin = new JRadioButton("NON");
        yesAdherent = new JRadioButton("OUI");
        noAdherent = new JRadioButton("NON");



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
        DefaultComboBoxModel<Locality> comboBoxModel = getLocalityDataModel();

        // Initialiser le JComboBox avec le modèle et le renderer
         localityComboBox = new JComboBox<>(comboBoxModel);
        localityComboBox.setRenderer(new LocalityComboBoxRenderer());


        // Ajoutez le JComboBox au panel de texte
        textFieldPanel.add(new JLabel("Localité:"));
        textFieldPanel.add(localityComboBox);
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

        bottomPanel.add(menuButton);
        menuButton.addActionListener(new menuAction());

        JButton logoutButton = new JButton("Se déconnecter");

        bottomPanel.add(logoutButton);
        logoutButton.addActionListener(new logoutAction());




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


    private void setController(ApplicationController controller) {
        this.controller = controller;
    }


    public class actionnouveau implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String firstName = (firstNameField.getText());
                String lastName = CustomUtilities.validateRequiredField(lastNameField.getText(),"Nom");
                String email = CustomUtilities.validateEmail(emailField.getText(),"email");
                String phoneNumber = CustomUtilities.validatePhoneNumberField(phoneNumberField.getText(),"Numéro de Téléphone");
                String password = CustomUtilities.validatePassword(passwordField.getText(),"password");
                char gender = validateGendertStatus(maleRadioButton.isSelected(),femaleRadioButton.isSelected()) ? 'M' : 'F';
                Date birthdayDay = CustomUtilities.validateDate(birthdayDate.getText(), "Date de naissance");
                boolean isAdmin = validateAdminStatus(yesAdmin.isSelected(),noAdmin.isSelected());
                boolean isAdherent = validateAdherentStatus(yesAdherent.isSelected(),noAdherent.isSelected());
                Locality locality = (Locality) localityComboBox.getSelectedItem();
                CustomUtilities.validateRequiredLocality(locality, "Localite");
                String street = CustomUtilities.validateRequiredField(streetField.getText(), "Rue");
                int streetNumber = CustomUtilities.validateNumericField(streetNumberField.getText(), "Numéro de rue");
                int numberSponsorised = CustomUtilities.validateNumericField(numberSponsorisedField.getText(), "Nombre sponsorisations");

                Customer customer = new Customer(firstName, lastName, email, phoneNumber, password, gender, birthdayDay,
                        isAdmin, isAdherent, locality,street,streetNumber, numberSponsorised);
                controller.addCustomer(customer);

                JOptionPane.showMessageDialog(AddCustomer.this, "Client " + customer.getFirstName() + " " + customer.getLastName() + " ajouté avec succès.", "Succès", JOptionPane.INFORMATION_MESSAGE);

                firstNameField.setText("");
                lastNameField.setText("");
                emailField.setText("");
                phoneNumberField.setText("");
                passwordField.setText("");
                maleRadioButton.setSelected(false);
                femaleRadioButton.setSelected(false);
                yesAdmin.setSelected(false);
                noAdmin.setSelected(false);
                yesAdherent.setSelected(false);
                noAdherent.setSelected(false);
                streetField.setText("");
                streetNumberField.setText("");
                numberSponsorisedField.setText("");


            } catch (Exception ex) {

                JOptionPane.showMessageDialog(AddCustomer.this, ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }




    }

    public DefaultComboBoxModel<Locality> getLocalityDataModel() throws SQLException {

        // Récupérer toutes les localités depuis la base de données
        ArrayList<Locality> allLocalities = controller.getAllLocalities();

        // Créer un modèle de données pour le JComboBox
        DefaultComboBoxModel<Locality> comboBoxModel = new DefaultComboBoxModel<>(allLocalities.toArray(new Locality[0]));

        return comboBoxModel;
    }
    private boolean validateAdherentStatus(boolean selected, boolean noAdherentSelected) throws customExceptions {
        // Vérifiez d'abord si l'une des options a été sélectionnée
        if (!yesAdherent.isSelected() && !noAdherent.isSelected()) {
            String message = "Le champ Est Adherent est obligatoire.";
            throw new customExceptions(message);
        }

        // Si l'option "OUI" est sélectionnée, retournez true, sinon retournez false
        return yesAdherent.isSelected();

    }

    private boolean validateGendertStatus(boolean selected, boolean noGenderSelected) throws customExceptions {
        // Vérifiez d'abord si l'une des options a été sélectionnée
        if (!maleRadioButton.isSelected() && ! femaleRadioButton.isSelected()) {
            String message = "Le champ genre est obligatoire.";
            throw new customExceptions(message);
        }

        // Si l'option "OUI" est sélectionnée, retournez true, sinon retournez false
        return maleRadioButton.isSelected();

    }

    private boolean validateAdminStatus(boolean selected, boolean noAdminSelected) throws customExceptions {
        // Vérifiez d'abord si l'une des options a été sélectionnée
        if (!yesAdmin.isSelected() && !noAdmin.isSelected()) {
            String message = "Le champ Est administrateur est obligatoire.";
            throw new customExceptions(message);
        }

        // Si l'option "OUI" est sélectionnée, retournez true, sinon retournez false
        return yesAdmin.isSelected();

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

    public class menuAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Ouvrir une nouvelle fenêtre de gestion utilisateur
            Menu menu = new Menu();
            menu.setVisible(true); // Rendre la fenêtre visible
            setVisible(false);

        }


    }

}
