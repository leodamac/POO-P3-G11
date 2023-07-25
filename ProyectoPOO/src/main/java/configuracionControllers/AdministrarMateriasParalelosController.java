package configuracionControllers;

import com.mycompany.poop3g11.App;
import java.io.IOException;
import javafx.fxml.FXML;


public class AdministrarMateriasParalelosController {
    
    //cambia la ventana al menu de configuraciones
    @FXML
    private void switchToConfiguracion() throws IOException {
        App.cargarArchivoFXML("configuracion");
    }
    
    //cambia la ventana al menu de ingresar materia
    @FXML
    private void switchToIngresarMateria() throws IOException {
        App.cargarArchivoFXML("ingresarMateria");
    }
    
    //cambia la ventana al menu de editar materia
    @FXML
    private void switchToEditarMateria() throws IOException {
        App.cargarArchivoFXML("editarMateria");
    }
    
    //cambia la ventana al menu de agregar paralelo
    @FXML
    private void switchToAgregarParalelo() throws IOException {
        App.cargarArchivoFXML("agregarParalelo");
    }
    
    //cambia la ventana al menu de eliminar paralelo
    @FXML
    private void switchToEliminarParalelo() throws IOException {
        App.cargarArchivoFXML("eliminarParalelo");
    }
}
