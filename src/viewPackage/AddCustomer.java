package viewPackage;

import controllerPackage.ApplicationController;

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
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;


public class AddCustomer extends  JPanel{

    private JButton addButton;

    private JButton updateButton;

    private JTextField firstNameField, lastNameField, emailField, phoneNumberField ;
    private JRadioButton maleRadioButton, femaleRadioButton;

    private JPasswordField passwordField, ConfirmpasswordField;
    private JTextField birthdayDate;
    private JRadioButton yesAdmin, noAdmin;
    private JRadioButton yesAdherent, noAdherent;

    private JComboBox<Locality> localityComboBox;

    private JTextField streetField;
    private JTextField streetNumberField;
    private JTextField numberSponsorisedField;

    private JCheckBox showPasswordCheckBox;


    private ApplicationController controller;


    public  AddCustomer() throws SQLException {

        setController(new ApplicationController());

        setBounds(100, 100, 800, 800);

       setLayout(new BorderLayout());

        addButton = new JButton("Ajouter");
        addButton.addActionListener(new AddCustomer.actionnouveau());

        updateButton = new JButton("Modifier");

        Font buttonFont = new Font("Arial", Font.PLAIN, 12);
        addButton.setFont(buttonFont);
        updateButton.setFont(buttonFont);



        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 1));

        buttonPanel.setBorder(new EmptyBorder(40, 40, 40, 40));
        buttonPanel.setBackground(Color.LIGHT_GRAY);
        buttonPanel.add(addButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        buttonPanel.add(updateButton);
        updateButton.addActionListener(new updateAction());

        disableUpdateButton();



        JPanel textFieldPanel = new JPanel();
        textFieldPanel.setLayout(new GridLayout(14, 2, 10, 10));
        textFieldPanel.setBorder(new EmptyBorder(30, 30, 30, 30));

        firstNameField = new JTextField();
        lastNameField = new JTextField();
        emailField = new JTextField();
        phoneNumberField = new JTextField();
        passwordField = new  JPasswordField();
        showPasswordCheckBox = new JCheckBox("Afficher le mot de passe");
        ConfirmpasswordField = new  JPasswordField();
        maleRadioButton = new JRadioButton("M");
        femaleRadioButton = new JRadioButton("F");
        String defaultBirthday = "YYYY/MM/DD"; // Format YYYY-MM-DD
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
        JPanel passwordPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        textFieldPanel.add(new JLabel("Mot de passe:"));
        passwordPanel.add(passwordField);
        passwordPanel.add(showPasswordCheckBox);
        textFieldPanel.add(passwordPanel);

        textFieldPanel.add(new JLabel(" Confirmation de Mot de passe:"));
        textFieldPanel.add(ConfirmpasswordField);
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



        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(buttonPanel, BorderLayout.WEST);
        mainPanel.add(textFieldPanel, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        add(mainPanel);
        setSize(700, 600);
        setVisible(true);


    }

    public void disableUpdateButton() {
        updateButton.setEnabled(false);
    }

    public void disableaddButton() {
        addButton.setEnabled(false);
    }

    public void enableUpdateButton() {
        updateButton.setEnabled(true);
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
                String confirmPassword = (ConfirmpasswordField.getText());

                char gender = validateGendertStatus(maleRadioButton.isSelected(),femaleRadioButton.isSelected()) ? 'M' : 'F';
                Date birthdayDay = CustomUtilities.validateDate(birthdayDate.getText(), "Date de naissance");
                boolean isAdmin = validateAdminStatus(yesAdmin.isSelected(),noAdmin.isSelected());
                boolean isAdherent = validateAdherentStatus(yesAdherent.isSelected(),noAdherent.isSelected());
                Locality locality = (Locality) localityComboBox.getSelectedItem();
                CustomUtilities.validateRequiredLocality(locality, "Localite");
                String street = CustomUtilities.validateRequiredField(streetField.getText(), "Rue");
                Integer streetNumber = CustomUtilities.validateNumericField(streetNumberField.getText(), "Numéro de rue");
                Integer numberSponsorised = CustomUtilities.validateNumericField(numberSponsorisedField.getText(), "Nombre sponsorisations");

                Customer customer = new Customer(firstName, lastName, email, phoneNumber, password, gender, birthdayDay,
                        isAdmin, isAdherent, locality,street,streetNumber, numberSponsorised);
                if (password.equals(confirmPassword)) {
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
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(AddCustomer.this, "Les mots de passe ne correspondent pas", "Erreur", JOptionPane.ERROR_MESSAGE);

                }


            } catch (Exception ex) {

                JOptionPane.showMessageDialog(AddCustomer.this, ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }


    }

    public class updateAction implements ActionListener {

        Customer customer = FormAdmin.returnCustomer();

        public void actionPerformed(ActionEvent e) {

            try {
                customer.setFirstName(firstNameField.getText());
                customer.setLastName(lastNameField.getText());
                customer.setEmail(emailField.getText());
                customer.setPhoneNumber(phoneNumberField.getText());
                customer.setStreet(streetField.getText());

                String password = CustomUtilities.validatePassword(passwordField.getText(),"password");
                customer.setPassword(password);
                char gender = validateGendertStatus(maleRadioButton.isSelected(),femaleRadioButton.isSelected()) ? 'M' : 'F';
                customer.setGender(gender);
                String birthdayDayString = (birthdayDate.getText());
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                Date birthdayDay = CustomUtilities.validateDate(birthdayDayString,"Date de naissance");
                try {
                    birthdayDay = (dateFormat.parse(birthdayDayString));
                } catch (ParseException ex) {
                    ex.printStackTrace();
                    // Gérer l'erreur de conversion de la date
                }

                customer.setBirthday(birthdayDay);

                boolean isAdmin = validateAdminStatus(yesAdmin.isSelected(),noAdmin.isSelected());
                boolean isAdherent = validateAdherentStatus(yesAdherent.isSelected(),noAdherent.isSelected());

                customer.setIsAdmin(isAdmin);
                customer.setIsAdherent(isAdherent);

                Locality locality = (Locality) localityComboBox.getSelectedItem();
                CustomUtilities.validateRequiredLocality(locality, "Localite");
                customer.setLocality(locality);
                Integer streetNumber = CustomUtilities.validateNumericField(streetNumberField.getText(), "Numéro de rue");
                Integer numberSponsorised = CustomUtilities.validateNumericField(numberSponsorisedField.getText(), "Nombre sponsorisations");

                customer.setStreetNumber(streetNumber);
                customer.setNumberSponsorised(numberSponsorised);

                controller.updateCustomer(customer);

                // Afficher un message de succès
                JOptionPane.showMessageDialog(AddCustomer.this, "Client mis à jour avec succès.", "Succès", JOptionPane.INFORMATION_MESSAGE);

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




    public void showCustomerData(Customer customer) {

        firstNameField.setText(customer.getFirstName());
        lastNameField.setText(customer.getLastName());
        emailField.setText(customer.getEmail());
        phoneNumberField.setText(customer.getPhoneNumber());
        passwordField.setText(customer.getPassword());

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String formattedDate = dateFormat.format(customer.getBirthday());
        birthdayDate.setText(formattedDate);

        maleRadioButton.setSelected(customer.getGender() == 'M');
        femaleRadioButton.setSelected(customer.getGender() == 'F');
        yesAdmin.setSelected(Boolean.TRUE.equals(customer.getIsAdmin()));
        noAdmin.setSelected(!Boolean.TRUE.equals(customer.getIsAdmin()));
        yesAdherent.setSelected(Boolean.TRUE.equals(customer.getIsAdherent()));
        noAdherent.setSelected(!Boolean.TRUE.equals(customer.getIsAdherent()));
        localityComboBox.setSelectedItem(customer.getLocality().getCity());
        streetField.setText(customer.getStreet());
        streetNumberField.setText(String.valueOf(customer.getStreetNumber()));
        numberSponsorisedField.setText(String.valueOf(customer.getNumberSponsorised()));
    }


}
