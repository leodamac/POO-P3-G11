package com.mycompany.poop3g11;

import java.io.IOException;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class MainController {
    
    /*
    Configuraciones
    Nuevo juego
    Reporte
    Salir
    */
    @FXML private Button mostrarMasButton, configuracionButton, nuevoJuegoButton, reporteButton, salirButton, cerrarButton, minimizeButton, maxButton;
    @FXML private VBox opcionesVBox;
    @FXML private ImageView imageCerrarButton, imageMaxButton, imageMinimizeButton;
    @FXML private AnchorPane anchorPane;
    
    
    // Se crea una referencia a las coordenadas iniciales del ratón
    private double xOffset = 0;//usada la cordenada X para mover la ventana 
    private double yOffset = 0;//usada la cordenada y para mover la ventana 
    // Cambia la ventana al menú de configuraciones
    @FXML void initialize(){
        
        agregarTooltipBotones();
        // Se registra un manejador de eventos para cuando se presiona el ratón sobre el AnchorPane
        anchorPane.setOnMousePressed (e -> {
          // Se obtiene la ventana actual
          obtenerPosicionMouse(e);
        });

        // Se registra un manejador de eventos para cuando se arrastra el ratón sobre el AnchorPane
        anchorPane.setOnMouseDragged (e -> {
            setPosicionVentana(e);
        });
        
        //Se registrar la posicion del mouse cuando se presiona la barra lateral de opciones
        opcionesVBox.setOnMousePressed (e -> {
          // Se obtiene la ventana actual
          obtenerPosicionMouse(e);
        });
        
        //Se pone la posicion del mouse cuando se arrastra la barra lateral de opciones         
        opcionesVBox.setOnMouseDragged (e -> {
          setPosicionVentana(e);
        });  
    }
    
    //Agrega mensajes a los botones cuando se deja el puntero del mouse encima
    private void agregarTooltipBotones(){
        mostrarMasButton.setTooltip(new Tooltip("Mostrar más"));
        configuracionButton.setTooltip(new Tooltip("Configuración"));
        nuevoJuegoButton.setTooltip(new Tooltip("Nuevo Juego"));
        reporteButton.setTooltip(new Tooltip("Reporte"));
        salirButton.setTooltip(new Tooltip("Salir"));
        cerrarButton.setTooltip(new Tooltip("Cerrar"));
        minimizeButton.setTooltip(new Tooltip("Minimizar"));
        maxButton.setTooltip(new Tooltip("Cambiar tamaño de la ventana"));
    }
    
    //Se obtiene la posicion del Mouse
    private void obtenerPosicionMouse(MouseEvent e){
        // Se obtiene la ventana actual
        Stage stage = (Stage) anchorPane.getScene ().getWindow ();
        // Se guarda la diferencia entre la posición de la ventana y la del ratón
        xOffset = stage.getX () - e.getScreenX ();
        yOffset = stage.getY () - e.getScreenY ();
    }
    
    //Se coloca la posicion en donde esta la ventana siendo arrastrada
    private void setPosicionVentana(MouseEvent e){
        // Se obtiene la ventana actual
        Stage stage = (Stage) anchorPane.getScene ().getWindow ();
        // Se actualiza la posición de la ventana sumando la diferencia guardada a la posición del ratón
        stage.setX (e.getScreenX () + xOffset);
        stage.setY (e.getScreenY () + yOffset);
    }
    
    // Cambia a la ventana de configuraciones
    @FXML
    private void switchToConfiguracion(Event event) throws IOException {
        App.cargarArchivoFXML("configuracion");
    }
    
    // Cambia la ventana al menú de nuevo juego
    @FXML
    private void switchToNuevoJuego() throws IOException {
        App.cargarArchivoFXML("nuevoJuego");
    }
    
    // Cambia la ventana al menú de reporte
    @FXML
    private void switchToReporte() throws IOException {
        App.cargarArchivoFXML("reporte");
    }
    
    //Cierra el programa
    @FXML
    private void onMouseClickedSalirBtn(Event event) {
        Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();
        s.close();
    }
    
    // se activa el evento cuando entra en el boton de cerrar
    @FXML
    private void onMouseEnteredButtonCerrar(){
        imageCerrarButton.setImage(new Image(getClass().getResourceAsStream("/img/cerrar_rojo.png")));
    }
    // se activa el evento cuando sale del boton de cerrar
    @FXML
    private void onMouseExitedButtonCerrar(){
        imageCerrarButton.setImage(new Image(getClass().getResourceAsStream("/img/cerrar.png")));
    }
    // se activa el evento cuando presiona el boton de cerrar
    @FXML
    private void onMousePressedButtonCerrar(){
        imageCerrarButton.setImage(new Image(getClass().getResourceAsStream("/img/cerrar_pressed.png")));
    }
    // se activa el evento cuando deja de presionar el boton de cerrar
    @FXML
    private void onMouseUnpressedButtonCerrar(){
        imageCerrarButton.setImage(new Image(getClass().getResourceAsStream("/img/cerrar_rojo.png")));
    }
    // se activa el evento cuando entra en el boton de cerrar
    @FXML
    private void onMouseEnteredButtonMinimize(){
        imageMinimizeButton.setImage(new Image(getClass().getResourceAsStream("/img/minimize_azul.png")));
    }
    // se activa el evento cuando sale del boton de cerrar
    @FXML
    private void onMouseExitedButtonMinimize(){
        imageMinimizeButton.setImage(new Image(getClass().getResourceAsStream("/img/minimize.png")));
    }
    // se activa el evento cuando presiona el boton de cerrar
    @FXML
    private void onMousePressedButtonMinimize(){
        imageMinimizeButton.setImage(new Image(getClass().getResourceAsStream("/img/minimize_pressed.png")));
    }
    // se activa el evento cuando deja de presionar el boton de cerrar
    @FXML
    private void onMouseUnpressedButtonMinimize(){
        imageMinimizeButton.setImage(new Image(getClass().getResourceAsStream("/img/minimize_azul.png")));
    }
    // se activa el evento cuando entra en el boton de maximizar
    @FXML
    private void onMouseEnteredButtonMax(Event event){
        Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();
        if (s.isMaximized()){
            cambiarImagenButtonMax("min_azul");
        }else{
            cambiarImagenButtonMax("max_azul");
        }
    }
    // se activa el evento cuando sale del boton de maximizar
    @FXML
    private void onMouseExitedButtonMax(Event event){
        Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();
        if (s.isMaximized()){
            cambiarImagenButtonMax("min");
        }else{
            cambiarImagenButtonMax("max");
        }
    }
    // se activa el evento cuando presiona el boton de maximizar
    @FXML
    private void onMousePressedButtonMax(Event event){
        Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();
        if (s.isMaximized()){
            cambiarImagenButtonMax("min_pressed");
        }else{
            cambiarImagenButtonMax("max_pressed");
        }
    }
    // se activa el evento cuando deja de presionar el boton de maximizar
    @FXML
    private void onMouseUnpressedButtonMax(Event event){
        Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();
        if (s.isMaximized()){
            cambiarImagenButtonMax("min_azul");
        }else{
            cambiarImagenButtonMax("max_azul");
        }
    }
    // se maximiza la ventana
    @FXML
    private void onActionButtonMax(Event event) {
        Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();
        App.maximizarVentana(s);
    }
    
    private void cambiarImagenButtonMax(String nombre){
        imageMaxButton.setImage(new Image(getClass().getResourceAsStream("/img/" + nombre + ".png")));
    }
    
    //Cuando se da click en el boton de mostrar más del menú muestra más opciones en del menú
    @FXML
    private void mostrarMas(){
        //Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();
        int ancho = 200;
        if(mostrarMasButton.getLayoutX() == ancho){
            ancho = 32;
            configuracionButton.setText("");
            nuevoJuegoButton.setText("");
            reporteButton.setText("");
            salirButton.setText("");
        }else{
            configuracionButton.setText("Configuración");
            nuevoJuegoButton.setText("Nuevo Juego");
            reporteButton.setText("Reporte");
            salirButton.setText("Salir");
        }

        mostrarMasButton.setLayoutX(ancho);
        opcionesVBox.setMinWidth(ancho);
        configuracionButton.setMinWidth(ancho);
        nuevoJuegoButton.setMinWidth(ancho);
        reporteButton.setMinWidth(ancho);
        salirButton.setMinWidth(ancho);
    }
    
    //Minimiza la ventana
    @FXML
    private void minimizarVentana(Event event){
        Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();
        s.setIconified(true);
    }
    
}
