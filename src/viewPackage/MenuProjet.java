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



        setBounds(100,100,1000,800);// Taille de la fenêtre
        mainContainer = this.getContentPane();
        mainContainer.setLayout(new BorderLayout());
       // mainContainer.add(new Welcome(),BorderLayout.CENTER);
        setTitle("Acceuil"); // Titre de la fenêtre
        setVisible(true); // Affichage de la fenêtre


        Quitter = new JMenuItem("Quitter");
        applicationMenu.add(Quitter);
      //  ExitListener exitListener = new ExitListener();
        //Quitter.addActionListener(exitListener);



        CustomersItem = new JMenuItem("UTILISATEURS");
        CustomersMenu.add(CustomersItem);
        CustomersItem.addActionListener(new formAction());

        CustomersMenu.addSeparator();

        addCustomerItem = new JMenuItem("AJOUTER CLIENT");
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
                getContentPane().add(new FormAdmin(), BorderLayout.CENTER);
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
