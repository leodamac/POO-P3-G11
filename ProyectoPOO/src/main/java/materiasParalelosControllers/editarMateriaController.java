package materiasParalelosControllers;

import academico.Materia;
import com.mycompany.poop3g11.App;
import java.io.IOException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;


public class editarMateriaController {
    private Materia materia;
    @FXML ComboBox<Materia> seleccionarMateriaComboBox;
    @FXML TextField nombreField, codigoField, nivelesField;
    @FXML
    private void initialize(){
        cargarMaterias();
        seleccionarMateriaComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            materia = seleccionarMateriaComboBox.getValue();
            nombreField.setText(materia.getNombre());
            codigoField.setText(materia.getCodigo());
            nivelesField.setText(String.valueOf(materia.getNivel()));
        });
    }
    // cambia a la ventana administrarTerminosAcademicos
    @FXML
    private void switchToAdministrarTerminosAcademicos() throws IOException {
        App.cargarArchivoFXML("administrarMateriasParalelos");
    }
    
    private void cargarMaterias(){
        ArrayList<Materia> materias = App.getTerminoAcademico().getMaterias();
        ObservableList<Materia> observableList = FXCollections.observableArrayList(materias);
        seleccionarMateriaComboBox.setItems(observableList);
    }
}
