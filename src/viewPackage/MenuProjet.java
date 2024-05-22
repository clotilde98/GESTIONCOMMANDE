package viewPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class MenuProjet extends JFrame {

    private JMenuBar menuBar;
    private JMenu applicationMenu, CustomersMenu ,SearchMenu ;

    private JMenuItem Quitter ,CustomersItem,addCustomerItem,CustomerProductItem,CustomerInvoiceItem,InfoProductItem;
    private Container mainContainer;



    public MenuProjet() {


        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        applicationMenu = new JMenu("APPLICATION");
        CustomersMenu = new JMenu("GESTION UTILISATEURS");
        SearchMenu = new JMenu("RECHERCHES");
        menuBar.add(applicationMenu);
        menuBar.add(CustomersMenu);
        menuBar.add(SearchMenu);


        JButton formAdminButton = new JButton("Open Admin Form");
        formAdminButton.addActionListener(new formAction2());

        add(formAdminButton);

        setBounds(100,100,1000,800);// Taille de la fenêtre
        mainContainer = this.getContentPane();
        mainContainer.setLayout(new BorderLayout());
       // mainContainer.add(new Welcome(),BorderLayout.CENTER);
        setTitle("Acceuil"); // Titre de la fenêtre
        setVisible(true); // Affichage de la fenêtre


        Quitter = new JMenuItem("Se deconnecter");
        applicationMenu.add(Quitter);
        Quitter.addActionListener(new quitterAction());



        CustomersItem = new JMenuItem("Utilisateurs");
        CustomersMenu.add(CustomersItem);
        CustomersItem.addActionListener(new formAction());

        CustomersMenu.addSeparator();

        addCustomerItem = new JMenuItem("Ajouter client");
        CustomersMenu.add(addCustomerItem);
        addCustomerItem.addActionListener(new addCustomerAction());




        CustomerProductItem = new JMenuItem("Historique des produits commandés par un client");
        SearchMenu.add(CustomerProductItem);


        SearchMenu.addSeparator();
        CustomerInvoiceItem = new JMenuItem("Liste des factures d’un client");
        SearchMenu.add(CustomerInvoiceItem);
        SearchMenu.addSeparator();

        InfoProductItem = new JMenuItem("Information des produits en fonction d’un prix");
        SearchMenu.add(InfoProductItem);


    }



    public class formAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Ouvrir une nouvelle fenêtre de gestion utilisateur

            try {
                getContentPane().removeAll();
                getContentPane().add(new FormAdmin(MenuProjet.this), BorderLayout.CENTER);
                revalidate();

            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

        }
    }

    public class addCustomerAction implements ActionListener {
        public void actionPerformed( ActionEvent event) {

            try {
                getContentPane().removeAll();
                getContentPane().add(new AddCustomer(), BorderLayout.CENTER);
                revalidate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public class formAction2 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                getContentPane().removeAll();
                FormAdmin formAdmin = new FormAdmin(MenuProjet.this); // Pass the reference correctly
                getContentPane().add(formAdmin, BorderLayout.CENTER);
                revalidate();
                repaint();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public void showAddCustomerForm(AddCustomer addCustomer) {
        getContentPane().removeAll();
        getContentPane().add(addCustomer, BorderLayout.CENTER);
        revalidate();
        repaint();
    }


    public class quitterAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Ouvrir une nouvelle fenêtre de gestion utilisateur
            Login loginForm = new Login();
            loginForm.setVisible(true);
            setVisible(false);

        }
    }



/*



    public class AideAction implements ActionListener {
        public void actionPerformed( ActionEvent event) {
            getContentPane().removeAll();
            getContentPane().add(new Aide(), BorderLayout.CENTER);
            revalidate();
        }
    }

    public class inscriptionAction implements ActionListener {
        public void actionPerformed( ActionEvent event) {
            getContentPane().removeAll();
            getContentPane().add(new RegistrationForm(), BorderLayout.CENTER);
            revalidate();
        }
    }

 */
}
