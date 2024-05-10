package viewPackage;

import exceptionPackage.InvalidEmailFormatException;
import exceptionPackage.InvalidPasswordFormatException;
import exceptionPackage.customExceptions;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddUsers extends JFrame {

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
                String firstName = validateRequiredField(firstNameField.getText(), "Prénom");
                String lastName = validateRequiredField(lastNameField.getText(), "Nom");
                String email = validateEmail(emailField.getText());
                String phoneNumber = validatePhoneNumber(phoneNumberField.getText());
                String password = validatePassword(passwordField.getText());
                char gender = (maleRadioButton.isSelected()) ? 'M' : 'F';
                Date birthday = validateDate(birthdayDate.getText(), "Date de naissance");
                boolean isAdmin = (yesAdmin.isSelected());
                boolean isAdherent = (yesAdherent.isSelected());
                String locality = validateRequiredField(localityField.getText(), "Localité");
                String street = validateRequiredField(streetField.getText(), "Rue");
                int streetNumber = validateNumericField(streetNumberField.getText(), "Numéro de rue");
                int numberSponsorised = validateNumericField(numberSponsorisedField.getText(), "Nombre sponsorisations");

                // Appel de la méthode pour ajouter l'utilisateur avec gestion des exceptions

            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(AddUsers.this, ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Méthodes utilitaires de validation

    private String validateRequiredField(String field, String fieldName) throws customExceptions {
        if (field.isEmpty()) {
            throw new customExceptions(fieldName + " est obligatoire.");
        }
        return field;
    }

    private String validateEmail(String email) throws InvalidEmailFormatException, customExceptions {
        // Utilisation d'une expression régulière pour valider l'email
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        if (!email.matches(emailRegex)) {
            String message = "Format email invalide";
            throw new InvalidEmailFormatException(message);
        }
        return email;
    }

    private String validatePhoneNumber(String phoneNumber) throws customExceptions {
        // Vous pouvez ajouter une validation pour le numéro de téléphone si nécessaire
        // Ici, je suppose simplement que le champ ne doit pas être vide
        if (phoneNumber.isEmpty()) {
            throw new customExceptions("Numéro de téléphone est obligatoire.");
        }
        return phoneNumber;
    }

    private String validatePassword(String password) throws InvalidPasswordFormatException, customExceptions {
        // Ajoutez ici la validation du format du mot de passe si nécessaire
        // Ici, je suppose simplement que le champ ne doit pas être vide
        if (password.isEmpty()) {
            throw new customExceptions("Mot de passe est obligatoire.");
        }
        return password;
    }

    private Date validateDate(String dateStr, String fieldName) throws customExceptions {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            sdf.setLenient(false); // La date doit être valide
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            throw new customExceptions("Format de " + fieldName + " invalide. Utilisez le format yyyy-MM-dd.");
        }
    }

    private int validateNumericField(String numStr, String fieldName) throws customExceptions {
        try {
            return Integer.parseInt(numStr);
        } catch (NumberFormatException e) {
            throw new customExceptions("Format de " + fieldName + " invalide. Entrez un nombre entier.");
        }
    }

}