package materiasParalelosControllers;

import academico.Materia;
import com.mycompany.poop3g11.App;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class agregarParaleloController {
    private Materia materia;
    @FXML ComboBox<Materia> seleccionarMateriaComboBox;
    @FXML TextField rutaArchivotextField;

    @FXML
    private void initialize(){
        cargarMaterias();
        seleccionarMateriaComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            materia = seleccionarMateriaComboBox.getValue();
        });
    }
    // cambia a la ventana administrarTerminosAcademicos
    @FXML
    private void switchToAdministrarTerminosAcademicos() throws IOException {
        App.cargarArchivoFXML("administrarMateriasParalelos");
    }
    
    @FXML
    private void seleccionarFichero(Event event){
        Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();
        // Crear un FileChooser para seleccionar los archivos
        FileChooser fileChooser = new FileChooser();

        // Agregar un filtro para solo mostrar archivos de texto
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Archivos de texto", "*.txt"));

        // Mostrar el cuadro de diálogo y obtener el archivo seleccionado
        File file = fileChooser.showOpenDialog(s);

        // Verificar si se seleccionó un archivo
        if (file != null) {
            rutaArchivotextField.setText(file.toString());
        }
    }
    
    private void cargarMaterias(){
        ArrayList<Materia> materias = App.getTerminoAcademico().getMaterias();
        ObservableList<Materia> observableList = FXCollections.observableArrayList(materias);
        seleccionarMateriaComboBox.setItems(observableList);
    }
}
