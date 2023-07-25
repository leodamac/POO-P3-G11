
package terminosAcademicosControllers;

import academico.TerminoAcademico;
import com.mycompany.poop3g11.App;
import com.mycompany.poop3g11.Utilitario;
import com.mycompany.proyectopoo.Menu;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class AgregarTerminosAcademicosController {

    @FXML
    Button agregarButton;
    @FXML
    TextField yearTextField, terminoTextField;
    
    // cambia a la ventana administrarTerminosAcademicos
    @FXML
    private void switchToAdministrarTerminosAcademicos() throws IOException {
        App.cargarArchivoFXML("administrarTerminosAcademicos");
    }
    
    //Funcion que se activa cuando se presiona el boton agregarButton
    @FXML
    private void agregarButtonAccion(Event event){
        String year = yearTextField.getText();
        String termino = terminoTextField.getText();
        //verifica si los campos de años y termino academicos son numeros
        if(!Utilitario.isNumero(year) || !Utilitario.isNumero(termino)){
            //muestra si el pop up es error
            Utilitario.mostrarPopUp("¡ERROR!\nIngrese solo números", event);
        }else{
            TerminoAcademico terminoAcademico = new TerminoAcademico(Menu.convierteTxtAEntero(year), Menu.convierteTxtAEntero(termino));
            //muestra si los datos se agregaron correctamente
            if(terminoAcademico.getAño() >= App.getYearActual()){
                File archive = new File("src/archivos/"+terminoAcademico.toString());
                //Verifica que la ruta del termino academico exita
                if(archive.exists()){
                    //Si exite muestra un mensaje de error
                    Utilitario.mostrarPopUp("¡ERROR!\nTérmino Académico ya EXISTE", event);
                }else{
                    App.getTerminosAcademicos().add(terminoAcademico);
                    //Si no exite muestra un mensaje de éxito y crea el directorio
                    Utilitario.mostrarPopUp("Término Académico añadido con ÉXITO!", event);
                    archive.mkdir();//crea una carpeta con el nombre del termino academico
                    File materias = new File("src/archivos/"+terminoAcademico.toString()+"/materias");
                    //crea una carpeta llamada materias en donde van a ser creadas nuevas carpetas con el codigo de la materia y dentro estaran los paralelos con las listas de alumnos
                    materias.mkdir();
                    //crea un archivo txt con las infomaciones de las materias
                    File archivoMaterias = new File("src/archivos/"+terminoAcademico.toString()+"/materias/materias.txt");
                    agregarCabeceraAMaterias("src/archivos/"+terminoAcademico.toString()+"/materias/materias.txt");
                    try {
                        archivoMaterias.createNewFile();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    File preguntas = new File("src/archivos/"+terminoAcademico.toString()+"/preguntas");
                    preguntas.mkdir();
                    
                }
            }else{
                Utilitario.mostrarPopUp("¡ERROR!\nIngrese años MAYORES a " + App.getYearActual(), event);
            }
        }
    }
    
    private void agregarCabeceraAMaterias(String ruta){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(ruta, true))){
            bw.write("codigo,nombre,nivel");
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    
}
