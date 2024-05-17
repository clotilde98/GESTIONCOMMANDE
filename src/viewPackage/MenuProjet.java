package viewPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class MenuProjet extends JFrame {

    private JMenuBar menuBar;
    private JMenu applicationMenu, utilisateursMenu ,rechercheMenu ;

    private JMenuItem Quitter ,utilisateurs,IESN,Aide;
    private Container mainContainer;



    public MenuProjet() {


        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        applicationMenu = new JMenu("Application");
        utilisateursMenu = new JMenu("GESTION UTILISATEURS");
        rechercheMenu = new JMenu("RECHERCHES");
        menuBar.add(applicationMenu);
        menuBar.add(utilisateursMenu);
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



        utilisateurs = new JMenuItem("UTILISATEURS");
        utilisateursMenu.add(utilisateurs);
        utilisateurs.addActionListener(new formAction());


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
/*

    public class iesnAction implements ActionListener {
        public void actionPerformed( ActionEvent event) {
            getContentPane().removeAll();
            getContentPane().add(new IesnInformation(), BorderLayout.CENTER);
            revalidate();
        }
    }

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
