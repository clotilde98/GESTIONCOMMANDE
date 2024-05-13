package controllerPackage;

import businessPackage.LocalityManager;
import modelPackage.Customer;

public class LocalityController {

    private LocalityManager manager;

    public LocalityController() {
        setManager (new LocalityManager());
    }

    private void setManager(LocalityManager localityManager) {
        this.manager = localityManager;
    }

    public void addCustomer (Customer customer)  {
        manager.addCustomer(customer);
    }

}
