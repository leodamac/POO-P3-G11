
package com.mycompany.poop3g11;

import academico.Materia;
import academico.Paralelo;
import java.io.IOException;
import java.util.ArrayList;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import personas.Estudiante;

/**
 * FXML Controller class
 *
 * @author Leo
 */

public class NuevoJuegoController{

    @FXML private ComboBox<Materia> seleccionarMateriaComboBox;
    @FXML private ComboBox<Paralelo> seleccionarParaleloComboBox;
    @FXML private ComboBox<Estudiante> seleccionarEstudianteComboBox;
    @FXML private ComboBox<Estudiante> seleccionarCompañeroApoyoComboBox;
    @FXML private CheckBox materiaCheckBox, paraleloCheckBox, estudianteCheckBox, compañeroApoyoCheckBox;
    @FXML private Button iniciarButton;
    @FXML private TextField premioField;
    
    private Materia materia;
    private Paralelo paralelo;
    private Estudiante jugador;
    private Estudiante apoyo;
    
    @FXML
    private void initialize(){
        
        cargarMaterias();
        
        seleccionarMateriaComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            materiaCheckBox.setSelected(true);
            materia = seleccionarMateriaComboBox.getValue();
            App.setMateria(materia);
            cargarParalelos();
        });
        
        seleccionarParaleloComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
        paraleloCheckBox.setSelected(true);
            paralelo = seleccionarParaleloComboBox.getValue();
            App.setParalelo(paralelo);
            cargarEstudiantes();
            cargarCompañeroApoyo();
        });
        
        seleccionarEstudianteComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
        estudianteCheckBox.setSelected(true);
            jugador = seleccionarEstudianteComboBox.getValue();
            App.setJugador(jugador);
        });
        
        seleccionarCompañeroApoyoComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
        compañeroApoyoCheckBox.setSelected(true);
            apoyo = seleccionarCompañeroApoyoComboBox.getValue();
            App.setApoyo(apoyo);
        });
        
        
        BooleanBinding todosSeleccionados = Bindings.and(estudianteCheckBox.selectedProperty(), compañeroApoyoCheckBox.selectedProperty());
        
        iniciarButton.disableProperty().bind(todosSeleccionados.not());

    }
    
    private void cargarMaterias(){
        ArrayList<Materia> materias = App.getTerminoAcademico().getMaterias();
        ObservableList<Materia> observableList = FXCollections.observableArrayList(materias);
        seleccionarMateriaComboBox.setItems(observableList);
    }
    
    private void cargarParalelos(){
        ArrayList<Paralelo> arrayList = materia.getParalelos();
        ObservableList<Paralelo> observableList = FXCollections.observableArrayList(arrayList);
        seleccionarParaleloComboBox.setItems(observableList);
    }
    
    private void cargarCompañeroApoyo(){
        ArrayList<Estudiante> arrayList = paralelo.getEstudiantes();
        ObservableList<Estudiante> observableList = FXCollections.observableArrayList(arrayList);
        seleccionarCompañeroApoyoComboBox.setItems(observableList);
    }
    
    private void cargarEstudiantes(){
        ArrayList<Estudiante> arrayList = paralelo.getEstudiantes();
        ObservableList<Estudiante> observableList = FXCollections.observableArrayList(arrayList);
        seleccionarEstudianteComboBox.setItems(observableList);
    }   
    // Cambia a la ventana del menú principal
    @FXML
    private void switchToVentanaPrincipal() throws IOException {
        App.cargarArchivoFXML("ventanaPrincipal");
    }
    // Cambia a la ventana del juego
    @FXML
    private void switchToJuego() throws IOException {
        App.setPremio(premioField.getText());
        App.setPreguntas(materia.getPreguntas());
        App.cargarArchivoFXML("juego");
    }    
}
