package org.example.controller;

import org.example.view.CEOView;

public class CEOController {

    private final MainController mainController;
    private final CEOView ceoView;

    public CEOController(MainController mainController) {
        this.mainController = mainController;
        this.ceoView = new CEOView();
    }

    public MainController getMainController() {
        return mainController;
    }

    public CEOView getCeoView() {
        return ceoView;
    }
}
