package com.mycompany.poop3g11;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;
import juego.Comodin;
import juego.Pregunta;
import juego.Reporte;


/**
 * FXML Controller class
 *
 * @author Leo
 */
public class JuegoController{
    ArrayList<Pregunta> preguntas;
    int indice;
    Timeline timeline = new Timeline();
    IntegerProperty timeSeconds;
    int tiempo = 0;
    Comodin[] comodines;
    ArrayList<Reporte> reportes;
    boolean finalizoElJuego = false;
    Pregunta pregunta;
    @FXML Label preguntaLabel, tiempoLabel;
    @FXML Button opcion1Button, opcion2Button, opcion3Button, opcion4Button, cincuentaButton, apoyoButton, cursoButton;
    @FXML VBox preguntasVBox;
    MediaPlayer mediaPlayer;
    SimpleBooleanProperty booleano = new SimpleBooleanProperty(false);

    //Inicia los valers caargando el tiempo desde 60, el banco de preguntas y la pregunta que se mostrará en pantalla y finalmente carga la lista de reporte para cuando finalice el juego se cree un nuevo reporte
    @FXML
    private void initialize() {
        comodines = new Comodin[]{new Comodin("50/50"), new Comodin("Apoyo"), new Comodin("Curso") };
        cargarTiempo();
        cargarPreguntas();
        cargarPregunta();
        CargarReportes();
    }
    @FXML
    private void reproducirMusica(){
        File file = new File("src/main/resources/musica/quien.mp3");

        // Verificar si se seleccionó un archivo
        if (file != null) {
            Media media = new Media(file.toURI().toString());
            //System.out.print(file.getPath());

            // Crear un objeto MediaPlayer con el objeto Media
            mediaPlayer = new MediaPlayer(media);

            // Establecer el número de ciclos a infinito
            mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);

            // Reproducir el audio en bucle
            mediaPlayer.play();
        }
        
    }
    
    //Carga los reportes del termino académico configurado
    private void CargarReportes(){
        try(ObjectInputStream objectStream = new ObjectInputStream(new FileInputStream("src/archivos/" + App.getTerminoAcademico() +"/reportes.dat"))){
            Object objeto;
            //while((objeto = objectStream.readObject()) != null){
                App.setReportes((ArrayList<Reporte>)objectStream.readObject());
            //}
            reportes = App.getReportes();
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
    //Pone el tiempo en la pantalla
    private void cargarTiempo(){
        timeSeconds = new SimpleIntegerProperty(60);
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
        if (timeSeconds.get() > 0) {
            timeSeconds.set(timeSeconds.get() - 1);
        } else {
            tiempo += 60;
            timeline.stop();
            booleano.set(true);
            Utilitario.mostrarPopUp("PERDIÓ", (Stage)(((Node)tiempoLabel.getParent().getParent()).getScene()).getWindow());
            finalizarJuego();
        }
            }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        tiempoLabel.textProperty().bind(timeSeconds.asString());
        timeline.play();
    }
    
    @FXML
    private void usoComodin(Event event){
        Button boton = (Button)event.getSource();
        if(boton.getId().contains("apoyo")){
            comodines[1].usar();
            comodines[1].setPregunta(pregunta);
        }else if(boton.getId().contains("curso")){
            comodines[2].usar();
            comodines[2].setPregunta(pregunta);
        }
        boton.setDisable(true);
    }
    
    @FXML
    private void comodin50(Event event){
        usoComodin(event);
        comodines[0].usar();
        comodines[0].setPregunta(pregunta);
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
    private void verificarRespuesta(Event event){
        Button boton = (Button) event.getSource();
        tiempo += (60 - Integer.valueOf(tiempoLabel.getText()));
        if(boton.getText().equals(preguntas.get(indice).getRespuestaCorrecta())){
            if(indice < preguntas.size()-1){
                indice++;
                timeSeconds.set(60);
                cargarPregunta();
            }else{
                Utilitario.mostrarPopUp("HA GANADO", event);
                booleano.set(true);
                generarReporte();
            }
        }else{
            Utilitario.mostrarPopUp("PERDIÓ", event);
            booleano.set(true);
            timeline.stop();
            generarReporte();
        }
        finalizarJuego();
    }
    
    private void finalizarJuego(){
        if (booleano.get()){
            desabilitarTodosLosBotones();
            try {
                App.cargarArchivoFXML("nuevoJuego");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    //genera el nuevo reporte y lo agrega a archivo reportes.dat
    private void generarReporte(){
        Reporte reporte = new Reporte(LocalDate.now().toString(), App.getJugador(), indice+1, tiempo, indice, comodines, App.getPremio(), App.getTerminoAcademico(), App.getMateria().getCodigo(), App.getParalelo());
        App.agregarReportes(reporte);
    }
    //Carga la pregunta que se mostrará en pantalla
    private void cargarPregunta(){
        //obtiene la pregunta por el indice
        pregunta = preguntas.get(indice);
        //obtiene un vector con las respuestas ordenadas al azar
        String[] respuestas = pregunta.getRespuestasMezcladas();
        
        //coloca el texto en la opción A
        opcion1Button.setText(respuestas[0]);
        Tooltip tl1 = new Tooltip(respuestas[0]);
        opcion1Button.setTooltip(tl1);
        opcion1Button.setDisable(false);
        
        //coloca el texto en la opción B
        opcion2Button.setText(respuestas[1]);
        Tooltip tl2 = new Tooltip(respuestas[1]);
        opcion2Button.setTooltip(tl2);
        opcion2Button.setDisable(false);
        
        //coloca el texto en la opción C
        opcion3Button.setText(respuestas[2]);
        Tooltip tl3 = new Tooltip(respuestas[2]);
        opcion3Button.setTooltip(tl3);
        opcion3Button.setDisable(false);
        
        //coloca el texto en la opción D
        opcion4Button.setText(respuestas[3]);
        Tooltip tl4 = new Tooltip(respuestas[3]);
        opcion4Button.setTooltip(tl4);
        opcion4Button.setDisable(false);
        
        //Muestra el enunciado de la pregunta
        preguntaLabel.setText(pregunta.getEnunciado());
        
        //Cambia el color de la pregunta actual
        preguntasVBox.getChildren().get(indice+1).setStyle("-fx-text-fill: green;");
    }
    
    private void desabilitarTodosLosBotones(){
        opcion1Button.setDisable(true);
        opcion2Button.setDisable(true);
        opcion3Button.setDisable(true);
        opcion4Button.setDisable(true);
        cincuentaButton.setDisable(true);
        apoyoButton.setDisable(true);
        cursoButton.setDisable(true);
    }
    
}
