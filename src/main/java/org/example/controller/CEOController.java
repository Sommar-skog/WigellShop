package org.example.controller;

import org.example.view.CEOView;

public class CEOController {

    private final MainController MAIN_CONTROLLER;
    private final CEOView CEOVIEW;

    public CEOController(MainController mainController) {
        this.MAIN_CONTROLLER = mainController;
        this.CEOVIEW = new CEOView();
    }

    public MainController getMAIN_CONTROLLER() {
        return MAIN_CONTROLLER;
    }

    public CEOView getCEOVIEW() {
        return CEOVIEW;
    }
}
