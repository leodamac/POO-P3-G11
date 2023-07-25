package com.mycompany.poop3g11;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class ConfiguracionController {
    /*
    Administrar términos académicos
    Administrar materias y paralelos
    Administrar preguntas
    Salir"
    */
    @FXML VBox contenedorVBox;

    
    @FXML
    private void switchToAdministrarTerminosAcademicos() throws IOException {
        App.cargarArchivoFXML("administrarTerminosAcademicos");
        //App.setRoot("administrarTerminosAcademicos");
    }
    
    @FXML
    private void switchToAdministrarMateriasParalelos() throws IOException {
        App.cargarArchivoFXML("administrarMateriasParalelos");
    }
    
    @FXML
    private void switchToAdministrarPreguntas() throws IOException {
        App.cargarArchivoFXML("administrarPreguntas");
    }
    
    @FXML
    private void switchToMenuPrincipal() throws IOException {
        App.cargarArchivoFXML("ventanaPrincipal");
    }
}