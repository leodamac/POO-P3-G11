package materiasParalelosControllers;

import academico.Materia;
import com.mycompany.poop3g11.App;
import com.mycompany.poop3g11.Utilitario;
import com.mycompany.proyectopoo.Menu;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
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
    @FXML
    private void editarMateria(Event event){
        materia.setNombre(nombreField.getText());
        
        if (Menu.isNumero(nivelesField.getText())){
            materia.setNivel(Menu.convierteTxtAEntero(nivelesField.getText()));
            String materiaLinea= "";
            try {
                FileReader materiaArchivo = new FileReader ("archivos/"+App.getTerminoAcademico()+"/materias/materias.txt");
                BufferedReader leerMateria = new BufferedReader(materiaArchivo);
                String linea;
                while ((linea=leerMateria.readLine()) != null){
                    if (linea.contains(materia.getCodigo())){
                        File archive = new File("archivos/"+App.getTerminoAcademico()+"/materias/"+materia.getCodigo());
                        materia.setCodigo(codigoField.getText());
                        materiaLinea += materia.getCodigo()+","+materia.getNombre()+","+materia.getNivel();  
                        archive.renameTo(new File("archivos/"+App.getTerminoAcademico()+"/materias/"+materia.getCodigo()));
                        Utilitario.mostrarPopUp("Editado con exito", event);
                        App.cargarArchivoFXML("administrarMateriasParalelos");
                    }
                    else{
                        materiaLinea += linea;
                        
                    }
                    materiaLinea += "\r\n";
                }
                materiaLinea = materiaLinea.strip();
                leerMateria.close();
                
        
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            
            
            try{
                FileWriter materiaArchivo = new FileWriter("archivos/"+App.getTerminoAcademico()+"/materias/materias.txt" , false);
                BufferedWriter escribirMateria = new BufferedWriter(materiaArchivo);
                escribirMateria.write(materiaLinea);
                escribirMateria.close();
            }
            
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        else{
            Utilitario.mostrarPopUp("Escriba solo numeros enteros", event);
        }
        
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
