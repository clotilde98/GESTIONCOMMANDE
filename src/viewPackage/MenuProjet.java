package viewPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class MenuProjet extends JFrame {

    private JMenuBar menuBar;
    private JMenu applicationMenu, customersMenu ,searchMenu ;

    private JMenuItem exit ,customersItem,addCustomerItem,customerProductItem,customerInvoiceItem,infoProductItem;
    private Container mainContainer;



    public MenuProjet() {


        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        applicationMenu = new JMenu("APPLICATION");
        customersMenu = new JMenu("GESTION UTILISATEURS");
        searchMenu = new JMenu("RECHERCHES");
        menuBar.add(applicationMenu);
        menuBar.add(customersMenu);
        menuBar.add(searchMenu);


        JButton formAdminButton = new JButton("Open Admin Form");
        formAdminButton.addActionListener(new formAction2());

        add(formAdminButton);

        setBounds(100,100,1000,800);// Taille de la fenêtre
        mainContainer = this.getContentPane();
        mainContainer.setLayout(new BorderLayout());
       // mainContainer.add(new Welcome(),BorderLayout.CENTER);
        setTitle("Accueil"); // Titre de la fenêtre
        setVisible(true); // Affichage de la fenêtre


        exit = new JMenuItem("Se deconnecter");
        applicationMenu.add(exit);
        exit.addActionListener(new exitAction());



        customersItem = new JMenuItem("Utilisateurs");
        customersMenu.add(customersItem);
        customersItem.addActionListener(new formAction());

        customersMenu.addSeparator();

        addCustomerItem = new JMenuItem("Ajouter client");
        customersMenu.add(addCustomerItem);
        addCustomerItem.addActionListener(new addCustomerAction());




        customerProductItem = new JMenuItem("Historique des produits commandés par un client");
        searchMenu.add(customerProductItem);


        searchMenu.addSeparator();
        customerInvoiceItem = new JMenuItem("Liste des factures d’un client");
        searchMenu.add(customerInvoiceItem);
        searchMenu.addSeparator();

        infoProductItem = new JMenuItem("Information des produits en fonction d’un prix");
        searchMenu.add(infoProductItem);


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


    public class exitAction implements ActionListener {
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
