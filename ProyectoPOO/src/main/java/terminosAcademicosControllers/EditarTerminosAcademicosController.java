
package terminosAcademicosControllers;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import academico.TerminoAcademico;
import com.mycompany.poop3g11.App;
import com.mycompany.poop3g11.Utilitario;
import com.mycompany.proyectopoo.Menu;
import java.io.File;
import java.io.IOException;
import javafx.event.Event;
import javafx.scene.control.TextField;
/**
 *
 * @author Leo
 */
public class EditarTerminosAcademicosController {
    
    @FXML ComboBox terminosAcademicosComboBox;
    @FXML TextField yearTextField, terminoTextField;
    TerminoAcademico terminoAcademico;
    @FXML
    private void initialize(){
        ArrayList<TerminoAcademico> arrayList = App.getTerminosAcademicos();
        ObservableList<TerminoAcademico> observableList = FXCollections.observableArrayList(arrayList);
        terminosAcademicosComboBox.setItems(observableList);
        
        terminosAcademicosComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            terminoAcademico = ((TerminoAcademico)terminosAcademicosComboBox.getSelectionModel().getSelectedItem());
            yearTextField.setText(String.valueOf(terminoAcademico.getAño()));
            terminoTextField.setText(String.valueOf(terminoAcademico.getTermino()));
        });
    }
    
    @FXML
    private void guardarCambios(Event event) throws IOException{
        String year = yearTextField.getText();
        String termino = terminoTextField.getText();
        //verifica si los campos de años y termino academicos son numeros
        if(!Utilitario.isNumero(year) || !Utilitario.isNumero(termino)){
            //muestra si el pop up es error
            Utilitario.mostrarPopUp("¡ERROR!\nIngrese solo números", event);
        }else{
            TerminoAcademico nuevoTerminoAcademico = new TerminoAcademico(Menu.convierteTxtAEntero(year), Menu.convierteTxtAEntero(termino));
            //muestra si los datos se agregaron correctamente
            if(nuevoTerminoAcademico.getAño() >= App.getYearActual()){
                File nuevoArchive = new File("src/archivos/"+nuevoTerminoAcademico.toString());
                //Verifica que la ruta del termino academico exita
                if(nuevoArchive.exists()){
                    //Si exite muestra un mensaje de error
                    Utilitario.mostrarPopUp("¡ERROR!\nTérmino Académico ya EXISTE", event);
                }else{
                    //Si no exite muestra un mensaje de éxito y crea el directorio
                    File archive = new File("src/archivos/"+terminoAcademico.toString());
                    archive.renameTo(nuevoArchive);
                    Utilitario.mostrarPopUp("Término Académico EDITADO con ÉXITO!", event);
                    terminoAcademico.setAño(nuevoTerminoAcademico.getAño());
                    terminoAcademico.setTermino(nuevoTerminoAcademico.getTermino());
                    App.cargarArchivoFXML("administrarTerminosAcademicos");
                }
            }else{
                Utilitario.mostrarPopUp("¡ERROR!\nIngrese años MAYORES a " + App.getYearActual(), event);
            }
        }
    }
    
    // cambia a la ventana administrarTerminosAcademicos
    @FXML
    private void switchToAdministrarTerminosAcademicos() throws IOException {
        App.cargarArchivoFXML("administrarTerminosAcademicos");
    }
}
