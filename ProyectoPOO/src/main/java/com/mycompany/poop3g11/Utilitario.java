package com.mycompany.poop3g11;

import javafx.event.Event;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Leo
 */
public class Utilitario {
    
    //verifica que una cadena de texto sea un numero entero
    public static boolean isNumero(String cadena){
        if (cadena == null)
            return false;
        return cadena.matches("-?\\d+");
    }
    
    public static void mostrarPopUp(Event event){
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        // crear un nuevo Stage para el pop up
        Stage popUp = new Stage();
        popUp.initStyle(StageStyle.TRANSPARENT);
        // hacer que el pop up sea modal, es decir, que bloquee el acceso a la ventana principal
        popUp.initModality(Modality.APPLICATION_MODAL);
        // hacer que el pop up sea hijo de la ventana principal
        popUp.initOwner(stage);
        // crear un label con un mensaje para el pop up
        HBox hBox = new HBox();
        Label lblMensaje = new Label("Escriba el premio");
        TextField textLabel =  new TextField();
        hBox.getChildren().addAll(lblMensaje, textLabel);
        // crear un botón que cierra el pop up
        Button btnCerrar = new Button("Aceptar");
        btnCerrar.setOnAction(e2 -> {
            // cerrar el pop up
            popUp.close();
            App.setPremio(textLabel.getText());
        });
        // crear un VBox para organizar los controles del pop up
        VBox vbox = new VBox(10);
        vbox.getChildren().addAll(hBox, btnCerrar);
        // crear una escena con el VBox
        Scene escena = new Scene(vbox, 250, 100);
        // asignar la escena al Stage del pop up
        popUp.setScene(escena);
        // mostrar el pop up
        popUp.show();
    }
    
    public static void mostrarPopUp(String mensaje, Stage stage){
        // crear un nuevo Stage para el pop up
        Stage popUp = new Stage();
        popUp.initStyle(StageStyle.UTILITY);
        // hacer que el pop up sea modal, es decir, que bloquee el acceso a la ventana principal
        popUp.initModality(Modality.APPLICATION_MODAL);
        // hacer que el pop up sea hijo de la ventana principal
        popUp.initOwner(stage);
        // crear un label con un mensaje para el pop up
        Label lblMensaje = new Label(mensaje);
        // crear un botón que cierra el pop up
        Button btnCerrar = new Button("X");
        btnCerrar.setOnAction(e2 -> {
            // cerrar el pop up
            popUp.close();
        });
        // crear un VBox para organizar los controles del pop up
        VBox vbox = new VBox(10);
        vbox.getChildren().addAll(lblMensaje, btnCerrar);
        // crear una escena con el VBox
        Scene escena = new Scene(vbox, 250, 100);
        // asignar la escena al Stage del pop up
        popUp.setScene(escena);
        // mostrar el pop up
        popUp.show();
    }
    
    public static void mostrarPopUp(String mensaje, Event event){
        mostrarPopUp(mensaje, (Stage) ((Node) event.getSource()).getScene().getWindow());
    }
    
    public static void verificarSiExisteTerminoAcademico(Event event, String year, String termino, String mensaje){
        
    }
}
