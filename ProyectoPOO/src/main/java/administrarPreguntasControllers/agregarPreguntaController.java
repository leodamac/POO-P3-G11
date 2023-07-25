package administrarPreguntasControllers;

import academico.Materia;
import com.mycompany.poop3g11.App;
import java.io.IOException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import juego.Pregunta;

public class agregarPreguntaController {
    @FXML private ComboBox<Materia> seleccionarMateriaComboBox;
    
    Materia materia;
    Pregunta pregunta;
    ArrayList<Pregunta> preguntas;
    
    @FXML
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
}
