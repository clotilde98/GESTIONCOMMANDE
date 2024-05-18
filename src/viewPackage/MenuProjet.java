package viewPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class MenuProjet extends JFrame {

    private JMenuBar menuBar;
    private JMenu applicationMenu, CustomersMenu ,rechercheMenu ;

    private JMenuItem Quitter ,CustomersItem,addCustomerItem,IESN,Aide;
    private Container mainContainer;



    public MenuProjet() {


        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        applicationMenu = new JMenu("Application");
        CustomersMenu = new JMenu("GESTION UTILISATEURS");
        rechercheMenu = new JMenu("RECHERCHES");
        menuBar.add(applicationMenu);
        menuBar.add(CustomersMenu);
        menuBar.add(rechercheMenu);



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


        rechercheMenu.addSeparator();

        Aide= new JMenuItem("Aide");
        rechercheMenu.add(Aide);
        //Associe l’écouteur d’évènement aux composants à écouter
       // Aide.addActionListener(new AideAction());


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
