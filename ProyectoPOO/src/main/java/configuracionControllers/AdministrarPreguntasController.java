package configuracionControllers;

import com.mycompany.poop3g11.App;
import java.io.IOException;
import javafx.fxml.FXML;


public class AdministrarPreguntasController {
        // Cambia la ventana al menú de configuraciones
    @FXML
    private void switchToConfiguracion() throws IOException {
        App.cargarArchivoFXML("configuracion");
    }
    
    @FXML
    private void switchToVisualizarPreguntas() throws IOException {
        App.cargarArchivoFXML("visualizarPreguntas");
    }
    
    @FXML
    private void switchToAgregarPregunta() throws IOException {
        App.cargarArchivoFXML("agregarPregunta");
    }
    
    @FXML
    private void switchToEliminarPregunta() throws IOException {
        App.cargarArchivoFXML("eliminarPregunta");
    }
}
