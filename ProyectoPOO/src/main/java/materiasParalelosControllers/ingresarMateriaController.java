
package materiasParalelosControllers;

import academico.Materia;
import academico.TerminoAcademico;
import com.mycompany.poop3g11.App;
import com.mycompany.poop3g11.Utilitario;
import com.mycompany.proyectopoo.Menu;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class ingresarMateriaController {

    @FXML
    Button agregarButton;
    @FXML
    TextField nombreField, codigoField, nivelesField;
    
    // cambia a la ventana administrarTerminosAcademicos
    @FXML
    private void switchToAdministrarTerminosAcademicos() throws IOException {
        App.cargarArchivoFXML("administrarMateriasParalelos");
    }
    
    //Funcion que se activa cuando se presiona el boton agregarButton
    @FXML
    private void agregarButtonAccion(Event event){
        String nombre = nombreField.getText();
        String codigo = codigoField.getText();
        String niveles = nivelesField.getText();
        //verifica si los campos de años y termino academicos son numeros
        if(!Utilitario.isNumero(niveles)){
            //muestra si el pop up es error
            Utilitario.mostrarPopUp("¡ERROR!\nIngrese solo números\nen el CAMPO DE NIVELES", event);
        }else{

            ArrayList<Materia> materias = App.getTerminoAcademico().getMaterias();
            Materia materiaNueva = new Materia(codigo, nombre, Menu.convierteTxtAEntero(niveles));
            if(materias.contains(materiaNueva)){
                Utilitario.mostrarPopUp("¡ERROR!\nEsa materia ya está registrada", event);
            }else{
                Utilitario.mostrarPopUp("Materia registrad con ÉXITO", event);
                TerminoAcademico terminoAcademico = App.getTerminoAcademico();
                String ruta = "src/archivos/"+terminoAcademico.toString()+"/materias/materias.txt";
                agregarMateriaEnArchivo(ruta, materiaNueva);
                File carpetaMateria = new File("src/archivos/"+terminoAcademico.toString()+"/materias/" + materiaNueva.getCodigo());
                carpetaMateria.mkdir();
                materias.add(materiaNueva);
            }
        }
    }
    
    private void agregarMateriaEnArchivo(String ruta, Materia materia){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(ruta, true))){
            String codigo = materia.getCodigo();
            String nombre = materia.getNombre();
            int nivel = materia.getNivel();
            bw.write("\r\n"+codigo + "," + nombre + "," +nivel);
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    
}
