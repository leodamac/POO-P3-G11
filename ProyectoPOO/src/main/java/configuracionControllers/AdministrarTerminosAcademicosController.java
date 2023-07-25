/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package configuracionControllers;

import com.mycompany.poop3g11.App;
import com.mycompany.poop3g11.App;
import java.io.IOException;
import javafx.fxml.FXML;

/**
 *
 * @author Leo
 */
public class AdministrarTerminosAcademicosController {
    /*
    Ingresar término
    Editar término
    Configurar término para el juego
    Salir
    */
    
    // Cambia la ventana al menú de configuraciones
    @FXML
    private void switchToConfiguracion() throws IOException {
        App.cargarArchivoFXML("configuracion");
    }
    
    @FXML
    private void switchToAgregarTerminosAcademicos() throws IOException {
        App.cargarArchivoFXML("agregarTerminosAcademicos");
    }
    
    @FXML
    private void switchToEditarTerminosAcademicos() throws IOException {
        App.cargarArchivoFXML("editarTerminosAcademicos");
    }
    
    @FXML
    private void switchToConfigurarTerminoAcademico() throws IOException {
        App.cargarArchivoFXML("configurarTerminoAcademico");
    }

}