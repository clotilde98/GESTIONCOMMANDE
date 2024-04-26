package viewPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {



        private JMenuBar menuBar;
        private JMenu applicationMenu, etudiantMenu ,infoMenu ;

        private JMenuItem Quitter ,Inscription,IESN,Aide;
        private Container mainContainer;



        public Menu() {


            menuBar = new JMenuBar();
            setJMenuBar(menuBar);
            applicationMenu = new JMenu("Application");
            etudiantMenu = new JMenu("Etudiant");
            infoMenu = new JMenu("Infos");
            menuBar.add(applicationMenu);
            menuBar.add(etudiantMenu);
            menuBar.add(infoMenu);



            setBounds(100,100,500,500);// Taille de la fenêtre
            mainContainer = this.getContentPane();
            mainContainer.setLayout(new BorderLayout());
            setTitle("Acceuil"); // Titre de la fenêtre
            setVisible(true); // Affichage de la fenêtre


            Quitter = new JMenuItem("Quitter");
            applicationMenu.add(Quitter);



            Inscription = new JMenuItem("Inscription");
            etudiantMenu.add(Inscription);


            IESN= new JMenuItem("IESN");
            infoMenu.add(IESN);
            //Associe l’écouteur d’évènement aux composants à écouter


            infoMenu.addSeparator();

            Aide= new JMenuItem("Aide");
            infoMenu.add(Aide);
            //Associe l’écouteur d’évènement aux composants à écouter



        }



    }


