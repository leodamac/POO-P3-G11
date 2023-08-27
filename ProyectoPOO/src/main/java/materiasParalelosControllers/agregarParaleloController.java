package materiasParalelosControllers;

import academico.Materia;
import academico.TerminoAcademico;
import personas.Estudiante;
import com.mycompany.poop3g11.App;
import com.mycompany.poop3g11.Utilitario;
import com.mycompany.proyectopoo.Menu;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class agregarParaleloController {
    private Materia materia;
    @FXML ComboBox<Materia> seleccionarMateriaComboBox;
    @FXML TextField numeroParalelotextField, rutaArchivotextField;
    @FXML Button agregarButton;

    @FXML
    private void initialize(){
        cargarMaterias();
        seleccionarMateriaComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            materia = seleccionarMateriaComboBox.getValue();
            
        });
        agregarButton.setOnAction(ev->{agregarButtonAccion(ev);});    
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
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Archivos de texto", "*.csv"));

        // Mostrar el cuadro de diálogo y obtener el archivo seleccionado
        File file = fileChooser.showOpenDialog(s);

        // Verificar si se seleccionó un archivo
        if (file != null) {
            rutaArchivotextField.setText(file.toString());
            //cargarArchivoEstudiantes(file.getPath(), materia); // Llama a la función para cargar estudiantes 
        }
    }
    
    private void cargarMaterias(){
        ArrayList<Materia> materias = App.getTerminoAcademico().getMaterias();
        ObservableList<Materia> observableList = FXCollections.observableArrayList(materias);
        seleccionarMateriaComboBox.setItems(observableList);
    }
    @FXML
    private void agregarButtonAccion(Event event){
        String ruta = rutaArchivotextField.getText();
        materia = seleccionarMateriaComboBox.getValue();
       
        
        //verifica si el campo el campo Paralelo es un numero
        if(!Utilitario.isNumero(numeroParalelotextField.getText())){
            //muestra si el pop up es error
            Utilitario.mostrarPopUp("¡ERROR!\nIngrese solo números\nen el CAMPO DE PARALELO", event);
        }else{
            
            cargarArchivoEstudiantes();
            Utilitario.mostrarPopUp("Paralelo registrado con ÉXITO", event);
        }
    }
    @FXML
    private void cargarArchivoEstudiantes(){
        //String rutaArchivo = rutaArchivotextField.getText();
        int paralelo = Integer.parseInt(numeroParalelotextField.getText());
        if (seleccionarMateriaComboBox.getValue()!= null && paralelo > 0){
            String rutaGuardar = "archivos/"+App.getTerminoAcademico().toString()+"/materias/"+materia.getCodigo();
            String carpetaNewParalelo = numeroParalelotextField.getText()+".txt";
            String rutaFinal = rutaGuardar+"/"+carpetaNewParalelo;
            File carpetaMateria = new File(rutaFinal);
            System.out.println(rutaFinal);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaFinal))){
    
                try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivotextField.getText()))){
                    String linea;
                    while ((linea = br.readLine()) != null){
                        String[] datos = linea.split(",");
                   // suponiendo que el archivo tiene el formato adecuado (MATRICULA, NOMBRE_ESTUDIANTE, Email)
                        if (datos.length==3){
                            writer.write(datos[0]+"\t"+ datos[1]+"\t"+datos[2]);
                            writer.newLine();
                        }
                    }                      
                }catch (IOException e){
                    e.printStackTrace();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    
}
