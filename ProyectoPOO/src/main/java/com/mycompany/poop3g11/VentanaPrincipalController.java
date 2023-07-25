package com.mycompany.poop3g11;

import academico.TerminoAcademico;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class VentanaPrincipalController {
    @FXML Label terminoAcademicoLabel;
    TerminoAcademico terminoAcademico;
    @FXML
            
    void initialize(){
        cargarTerminoAcademico();
        terminoAcademicoLabel.setText(terminoAcademico.toString());
    }
    
    //Carga el termino academico actual
    private void cargarTerminoAcademico(){
        terminoAcademico = App.getTerminoAcademico();
    }
}
