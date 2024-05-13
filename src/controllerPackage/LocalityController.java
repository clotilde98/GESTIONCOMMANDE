package controllerPackage;

import businessPackage.LocalityManager;

public class LocalityController {

    private LocalityManager manager;

    public LocalityController() {
        setManager (new LocalityManager());
    }

    private void setManager(LocalityManager localityManager) {
        this.manager = localityManager;
    }



}
