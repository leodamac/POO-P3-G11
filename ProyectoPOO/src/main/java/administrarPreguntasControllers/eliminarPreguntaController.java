package administrarPreguntasControllers;

import academico.Materia;
import com.mycompany.poop3g11.App;
import java.io.IOException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import juego.Pregunta;

public class eliminarPreguntaController {
        @FXML private ListView preguntasListView;
    @FXML private ComboBox<Materia> seleccionarMateriaComboBox;
    @FXML private Label respuesta1Label, respuesta2Label, respuesta3Label, respuesta4Label;
    
    Materia materia;
    Pregunta pregunta;
    ArrayList<Pregunta> preguntas;
    
    @FXML
    private void initialize(){
        cargarMaterias();
        
        seleccionarMateriaComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            materia = seleccionarMateriaComboBox.getValue();
            cargarPreguntas();
        });
        
        preguntasListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            pregunta = (Pregunta)preguntasListView.getSelectionModel().getSelectedItem();
            respuesta1Label.setText(pregunta.getRespuesta1());
            respuesta2Label.setText(pregunta.getRespuesta2());
            respuesta3Label.setText(pregunta.getRespuesta3());
            respuesta4Label.setText(pregunta.getRespuesta4());
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
    
    private void cargarPreguntas(){
        preguntas = new ArrayList();
        for(ArrayList p: materia.getPreguntas()){
            preguntas.addAll(p);
        }
        ObservableList<Pregunta> observableList = FXCollections.observableArrayList(preguntas);
        preguntasListView.setItems(observableList);
    }
}
