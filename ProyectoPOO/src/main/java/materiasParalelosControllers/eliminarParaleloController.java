package materiasParalelosControllers;

import academico.Materia;
import academico.Paralelo;
import com.mycompany.poop3g11.App;
import com.mycompany.poop3g11.Utilitario;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class eliminarParaleloController {
    private Materia materia;
    private Paralelo paralelo;
    @FXML ComboBox<Materia> seleccionarMateriaComboBox;
    @FXML ComboBox<Paralelo> seleccionarParaleloComboBox;
    @FXML Button eliminarButton;
    @FXML 
    private void initialize(){
        cargarMaterias();
        seleccionarMateriaComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            materia = seleccionarMateriaComboBox.getValue();
            cargarParalelos();
        });
        
        seleccionarParaleloComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            paralelo = seleccionarParaleloComboBox.getValue();
        });
        eliminarButton.setOnAction(ev->{eliminarArchivo(ev);});
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
    
    private void cargarParalelos(){
        ArrayList<Paralelo> paralelos = materia.getParalelos();
        ObservableList<Paralelo> observableList = FXCollections.observableArrayList(paralelos);
        seleccionarParaleloComboBox.setItems(observableList);
    }
    private void eliminarArchivo(Event event){
        String rutaArchivo = "archivos/"+App.getTerminoAcademico().toString()+"/materias/"+materia.getCodigo()+"/"+paralelo.getNumero();

        // Crear un objeto File con la ruta del archivo
        File archivoEliminar = new File(rutaArchivo+".txt");

        // Verificar si el archivo existe antes de intentar eliminarlo
        if (archivoEliminar.exists()) {
            if (archivoEliminar.delete()) {               
                 Utilitario.mostrarPopUp("El paralelo se ha eliminado con exico", event);
                eliminarParalelo();
                
            } else {
                 Utilitario.mostrarPopUp("¡ERROR!\nIngrese solo números\nen el CAMPO DE PARALELO", event);
            }
        } else {
            Utilitario.mostrarPopUp("El archivo no existe en la ruta especificada.", event);
        }
    }
    
    private void eliminarParalelo(){
        Iterator <Paralelo> it = materia.getParalelos().iterator();
        Paralelo peliminar = (Paralelo)seleccionarParaleloComboBox.getValue();
        seleccionarParaleloComboBox.getSelectionModel().clearSelection();
        boolean salir = false;
        while (it.hasNext() && !salir){
            Paralelo p1 = it.next();
            if (p1.equals(peliminar)){
                it.remove();
                salir = true;
            }
        }
    }
  }

