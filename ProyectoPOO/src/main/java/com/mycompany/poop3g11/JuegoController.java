package com.mycompany.poop3g11;

import java.util.ArrayList;
import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import juego.Pregunta;



/**
 * FXML Controller class
 *
 * @author Leo
 */
public class JuegoController{
    ArrayList<Pregunta> preguntas;
    int indice;
    @FXML Label preguntaLabel, tiempoLabel;
    @FXML Button opcion1Button, opcion2Button, opcion3Button, opcion4Button, cincuentaButton, apoyoButton, cursoButton;
    @FXML VBox preguntasVBox;
    Timeline timeline = new Timeline();
    @FXML
    private void initialize() {
        cargarTiempo();
        cargarPreguntas();
        cargarPregunta();
    }
    
    private void cargarTiempo(){
        IntegerProperty timeSeconds = new SimpleIntegerProperty(60);
        
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
        if (timeSeconds.get() > 0) {
            timeSeconds.set(timeSeconds.get() - 1);
        } else {
            timeline.stop();
            Utilitario.mostrarPopUp("PERDIÓ", event);
        }
            }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        tiempoLabel.textProperty().bind(timeSeconds.asString());
        timeline.play();
    }
    
    @FXML
    private void usoComodin(ActionEvent event){
        Button boton = (Button)event.getSource();
        boton.setDisable(true);
    }
    
    @FXML
    private void comodin50(ActionEvent event){
        usoComodin(event);
        Button[] respuestas= {opcion1Button, opcion2Button, opcion3Button, opcion4Button};
        //comodinCincuenta.usar();
        //comodinCincuenta.setPregunta(preguntaActual);
        Random random = new Random();
        boolean fin = false;
        ArrayList<Integer> incorrectas = new ArrayList();
        Pregunta preguntaActual = preguntas.get(indice);
        
        while(!fin){
            int j = random.nextInt(4 );
            if(!respuestas[j].getText().equals(preguntaActual.getRespuestaCorrecta()) && !incorrectas.contains(j)){
                incorrectas.add(j);
            }
            if(incorrectas.size()==2){
                fin = true;
            }
        }
        for(int indice: incorrectas){
            //preguntaActual.getRespuestas()[indice] = " ";
            respuestas[indice].setDisable(true);
        }
    }
    
    private void cargarPreguntas(){
        preguntas = App.getPreguntas();
        while(preguntasVBox.getChildren().size() <= preguntas.size()){
            Label label = new Label();
            label.setText("Pregunta" + (preguntasVBox.getChildren().size()) );
            label.setStyle("-fx-text-fill: grey;");
            preguntasVBox.getChildren().add(label);
        }
        preguntasVBox.setAlignment(Pos.TOP_CENTER);
        preguntasVBox.setSpacing(15);
        
    }
    @FXML
    private void verificarRespuesta(ActionEvent event){
        Button boton = (Button) event.getSource();
        if(boton.getText().equals(preguntas.get(indice).getRespuestaCorrecta())){
            
            if(indice < preguntas.size()-1){
                indice++;
                cargarPregunta();
                cargarTiempo();
            }else{
                Utilitario.mostrarPopUp("HA GANADO", event);
            }
        }else{
            Utilitario.mostrarPopUp("PERDIÓ", event);
            timeline.stop();
        }
    }
    
    private void cargarPregunta(){
        Pregunta pregunta = preguntas.get(indice);
        String[] respuestas = pregunta.getRespuestasMezcladas();
        
        opcion1Button.setText(respuestas[0]);
        Tooltip tl1 = new Tooltip(respuestas[0]);
        opcion1Button.setTooltip(tl1);
        opcion1Button.setDisable(false);
        
        opcion2Button.setText(respuestas[1]);
        Tooltip tl2 = new Tooltip(respuestas[1]);
        opcion2Button.setTooltip(tl2);
        opcion2Button.setDisable(false);
                
        opcion3Button.setText(respuestas[2]);
        Tooltip tl3 = new Tooltip(respuestas[2]);
        opcion3Button.setTooltip(tl3);
        opcion3Button.setDisable(false);
        
        opcion4Button.setText(respuestas[3]);
        Tooltip tl4 = new Tooltip(respuestas[3]);
        opcion4Button.setTooltip(tl4);
        opcion4Button.setDisable(false);
        
        preguntaLabel.setText(pregunta.getEnunciado());
        
        preguntasVBox.getChildren().get(indice+1).setStyle("-fx-text-fill: green;");
    }
    
}
