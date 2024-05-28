package viewPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProjectMenu extends JFrame {

    private JMenuBar menuBar;
    private JMenu applicationMenu, customersMenu ,searchMenu ;

    private JMenuItem disconnect,exit ,receptionItem ,customersItem,addCustomerItem,customerProductItem,customerInvoiceItem,infoProductItem,taskItem;
    private Container mainContainer;




    public ProjectMenu() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

        setBounds(100, 100, 900, 600);
        mainContainer = this.getContentPane();
        mainContainer.setLayout(new BorderLayout());
        Welcome welcomePanel = new Welcome();
        mainContainer.add(welcomePanel, BorderLayout.CENTER);

        setResizable(false);
        setTitle("Menu Administrateur");
        setVisible(true);

        receptionItem = new JMenuItem("Accueil");
        applicationMenu.add(receptionItem);
        receptionItem.addActionListener(new receptionAction());

        applicationMenu.addSeparator();


        disconnect = new JMenuItem("Se deconnecter");
        applicationMenu.add(disconnect);
        disconnect.addActionListener(new disconnectAction());

        applicationMenu.addSeparator();

        exit = new JMenuItem("Quitter");
        applicationMenu.add(exit);
        ExitListener exitListener = new ExitListener();
        exit.addActionListener(exitListener);

        customersItem = new JMenuItem("Utilisateurs");
        customersMenu.add(customersItem);
        customersItem.addActionListener(new formAction());

        customersMenu.addSeparator();

        addCustomerItem = new JMenuItem("Ajouter client");
        customersMenu.add(addCustomerItem);
        addCustomerItem.addActionListener(new addCustomerAction());


        customerProductItem = new JMenuItem("Historique des produits commandés par un client");
        searchMenu.add(customerProductItem);
        customerProductItem.addActionListener(new searchProductAction());

        searchMenu.addSeparator();

        customerInvoiceItem = new JMenuItem("Liste des factures d’un client");
        searchMenu.add(customerInvoiceItem);
        customerInvoiceItem.addActionListener(new searchInvoiceAction());

        searchMenu.addSeparator();

        infoProductItem = new JMenuItem("Information des produits en fonction d’un prix");
        searchMenu.add(infoProductItem);
        infoProductItem.addActionListener(new searchProductInfoAction());

        searchMenu.addSeparator();

        taskItem = new JMenuItem("Calcul total des commandes d'un client sur une année");
        searchMenu.add(taskItem);
        taskItem.addActionListener(new taskAction());


    }



    public class formAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {


            getContentPane().removeAll();
            getContentPane().add(new FormAdmin(ProjectMenu.this), BorderLayout.CENTER);
            revalidate();



        }
    }

    public class addCustomerAction implements ActionListener {
        public void actionPerformed( ActionEvent event) {

            getContentPane().removeAll();
            getContentPane().add(new AddCustomer(ProjectMenu.this), BorderLayout.CENTER);
            revalidate();

        }
    }

    public class formAction2 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            getContentPane().removeAll();
            FormAdmin formAdmin = new FormAdmin(ProjectMenu.this);
            getContentPane().add(formAdmin, BorderLayout.CENTER);
            revalidate();
            repaint();

        }
    }

    public void showAddCustomerForm(AddCustomer addCustomer) {
        getContentPane().removeAll();
        getContentPane().add(addCustomer, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    public void showAdminForm(FormAdmin formAdmin) {
        getContentPane().removeAll();
        getContentPane().add(formAdmin, BorderLayout.CENTER);
        revalidate();
        repaint();
    }



    public class disconnectAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            Login loginForm = new Login();
            loginForm.setVisible(true);
            setVisible(false);

        }
    }

    public class receptionAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            getContentPane().removeAll();
            getContentPane().add(new Welcome(), BorderLayout.CENTER);
            revalidate();
            repaint();
        }
    }

    public class searchProductAction implements ActionListener {
        public void actionPerformed( ActionEvent event) {

            getContentPane().removeAll();
            getContentPane().add(new SearchProductHistoryPanel(), BorderLayout.CENTER);
            revalidate();


        }
    }

    public class searchInvoiceAction implements ActionListener {
        public void actionPerformed( ActionEvent event) {

            getContentPane().removeAll();
            getContentPane().add(new SearchInvoicePanel(), BorderLayout.CENTER);
            revalidate();


        }
    }

    public class searchProductInfoAction implements ActionListener {
        public void actionPerformed( ActionEvent event) {

            getContentPane().removeAll();
            getContentPane().add(new SearchProductInfoPanel(), BorderLayout.CENTER);
            revalidate();

        }
    }

    public class taskAction implements ActionListener {
        public void actionPerformed( ActionEvent event) {

            getContentPane().removeAll();
            getContentPane().add(new TaskPanel(), BorderLayout.CENTER);
            revalidate();

        }
    }

}
