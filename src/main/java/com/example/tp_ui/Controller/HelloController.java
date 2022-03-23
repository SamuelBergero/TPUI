package com.example.tp_ui.Controller;

import com.example.tp_ui.Model.ressource;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController
{
    ressource r1 = new ressource();

    @FXML
    private Label welcomeText;

    @FXML
    protected void OnR1Click() {
        if(r1.getval()<22)
            r1.setVal(21);

        r1.addToVal(1);
        welcomeText.setText(r1.getval()+"");
    }


}


