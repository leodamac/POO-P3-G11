
package terminosAcademicosControllers;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import academico.TerminoAcademico;
import com.mycompany.poop3g11.App;
import com.mycompany.poop3g11.Utilitario;
import java.io.IOException;
import javafx.event.Event;
/**
 *
 * @author Leo
 */
public class ConfigurarTerminoAcademicoController {
    
    @FXML ComboBox terminosAcademicosComboBox;
    TerminoAcademico terminoAcademico;
    @FXML
    private void initialize(){
        terminoAcademico = App.getTerminoAcademico();
        ArrayList<TerminoAcademico> arrayList = App.getTerminosAcademicos();
        ObservableList<TerminoAcademico> observableList = FXCollections.observableArrayList(arrayList);
        terminosAcademicosComboBox.setItems(observableList);
        
        terminosAcademicosComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            terminoAcademico = ((TerminoAcademico)terminosAcademicosComboBox.getSelectionModel().getSelectedItem());
        });
    }

    @FXML
    private void guardarCambios(Event event) throws IOException{
        App.setTerminoAcademico(terminoAcademico);
        Utilitario.mostrarPopUp("Término Académico CAMBIADO con ÉXITO!", event);
        App.cargarArchivoFXML("ventanaPrincipal");
    }
    
    // cambia a la ventana administrarTerminosAcademicos
    @FXML
    private void switchToAdministrarTerminosAcademicos() throws IOException {
        App.cargarArchivoFXML("administrarTerminosAcademicos");
    }
}
