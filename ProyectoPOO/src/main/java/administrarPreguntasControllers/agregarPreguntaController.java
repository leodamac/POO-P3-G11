package administrarPreguntasControllers;

import academico.Materia;
import com.mycompany.poop3g11.App;
import com.mycompany.poop3g11.Utilitario;
import java.io.IOException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import juego.Pregunta;

public class agregarPreguntaController {
    @FXML private ComboBox<Materia> seleccionarMateriaComboBox;
    
    Materia materia;
    Pregunta pregunta;
    ArrayList<Pregunta> preguntas;
    @FXML
    private BorderPane borderPane;
    @FXML
    private Label seleccionarMateriaLabel;
    @FXML
    private TextField preguntaTextField;
    @FXML
    private TextField respuestaCorrectaFieldText;
    @FXML
    private TextField respuestaIncorrecta1FieldText;
    @FXML
    private TextField respuestaIncorrecta2FieldText;
    @FXML
    private TextField respuestaIncorrecta3FieldText;
    @FXML
    private Button salirButton;
    @FXML
    private Button botonAgregarPregunta;
    @FXML
    private TextField nivelPregunta;
    
    private void initialize(){
        cargarMaterias();
        seleccionarMateriaComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            materia = seleccionarMateriaComboBox.getValue();
        });
    }
    
    @FXML
    private void switchToAdministrarPreguntas() throws IOException {
        App.cargarArchivoFXML("administrarPreguntas");
    }
       
     private void cargarMaterias(){
        ArrayList<Materia> materias = App.getTerminoAcademico().getMaterias();
        ObservableList<Materia> observableList = FXCollections.observableArrayList(materias);
        seleccionarMateriaComboBox.setItems(observableList);
    }

    @FXML
    private void clicAgregar(ActionEvent event) {
        
    String materiaCombo = seleccionarMateriaComboBox.getValue();
    String pregunta = preguntaTextField.getText();
    String respuestaCorrecta = respuestaCorrectaFieldText.getText();
    String respuestaIncorrecta1 = respuestaIncorrecta1FieldText.getText();
    String respuestaIncorrecta2 = respuestaIncorrecta2FieldText.getText();
    String respuestaIncorrecta3 = respuestaIncorrecta3FieldText.getText();
    String nivel = nivelPregunta.getText();

    // Validacion
    if (materiaCombo.isEmpty() || pregunta.isEmpty() || respuestaCorrecta.isEmpty() ||
        respuestaIncorrecta1.isEmpty() || respuestaIncorrecta2.isEmpty() ||
        respuestaIncorrecta3.isEmpty() || nivel.isEmpty()) {
        
        Utilitario.mostrarPopUp("¡ERROR!\nTodos los campos son obligatorios", event);
        
        return; 
    }

 
    
    Utilitario.mostrarPopUp("Pregunta agregada con éxito", event);

    
    limpiarCampos();
        
    }
    
    private void limpiarCampos() {
    seleccionarMateriaComboBox.getSelectionModel().clearSelection();
    preguntaTextField.clear();
    respuestaCorrectaFieldText.clear();
    respuestaIncorrecta1FieldText.clear();
    respuestaIncorrecta2FieldText.clear();
    respuestaIncorrecta3FieldText.clear();
    nivelPregunta.clear();
}
}




