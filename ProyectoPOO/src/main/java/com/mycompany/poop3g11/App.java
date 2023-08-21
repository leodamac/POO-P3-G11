package com.mycompany.poop3g11;

import academico.Materia;
import academico.Paralelo;
import academico.TerminoAcademico;
import com.mycompany.proyectopoo.Menu;
import java.io.FileOutputStream;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.StageStyle;
import juego.Pregunta;
import juego.Reporte;
import personas.Estudiante;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static TerminoAcademico terminoAcademico;
    private static ArrayList<TerminoAcademico> terminosAcademicos;
    private static Estudiante jugador;
    private static Estudiante apoyo;
    private static ArrayList<Pregunta> preguntasJuego;
    private static Materia materia;
    private static Paralelo paralelo;
    private static Reporte reporte;
    private static String premio;
    private static int YEAR = 2023;
    private static ArrayList<Reporte> reportes;    

    @Override
    public void start(Stage stage) throws IOException {
        cargarTerminosAcademicos();
        Menu.cargarDatosIniciales(terminoAcademico);
        reportes = new ArrayList();     
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/img/icono.png")));
        
        scene = new Scene(loadFXML("main"), 640, 480);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        cargarVentanaPrincipal();
        
        stage.setTitle("¿Quien Quiere Ser Millonario?");
        scene.getStylesheets().add("/css/estilo.css");
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
    
    private void cargarVentanaPrincipal() throws IOException{
        cargarArchivoFXML("ventanaPrincipal");

    }
    
    public static void cargarArchivoFXML(String nombre) throws IOException{
        FXMLLoader internalLoader = new FXMLLoader(App.class.getResource(nombre+".fxml"));
        Node internal = internalLoader.load();
        VBox vbox = (VBox)scene.getRoot();
        BorderPane borderPane = (BorderPane)((HBox)vbox.getChildren().get(1)).getChildren().get(1);
        borderPane.setCenter(internal);
    }
    
    public static void maximizarVentana(Stage stage){
        if(!stage.isMaximized()){
            //stage.setFullScreen(true);
            stage.setMaximized(true);
        }else{
            stage.setMaximized(false);
            //stage.setFullScreen(false);
        }      
    } 
    
    private void cargarTerminosAcademicos(){
        terminosAcademicos = new ArrayList();
        Menu.cargarTerminosAcademicos(terminosAcademicos);
        Collections.sort(terminosAcademicos);
        terminoAcademico = terminosAcademicos.get(0);
        
    }
       
    public static void setTerminoAcademico(TerminoAcademico nuevoTerminoAcademico){
        terminoAcademico = nuevoTerminoAcademico;
    }
    
    public static void setApoyo(Estudiante estudianteApoyo){
        apoyo = estudianteApoyo;
    }
    
    public static void setJugador(Estudiante estudianteJugador){
        jugador = estudianteJugador;
    }
    
    public static void setPreguntas(ArrayList<ArrayList<Pregunta>> preguntasNivel, int preguntasNiveles){
        preguntasJuego = new ArrayList();
        for(ArrayList<Pregunta> preguntas: preguntasNivel){
            boolean salir = false;
            if(preguntasNiveles <= preguntas.size()){
                int adicionado = 0;
                while(!salir){
                    Random rand = new Random();
                    // Obtiene un numero aleatorio 0 - size(Preguntas.nivel)
                    int n = rand.nextInt(preguntas.size());
                    if(!preguntasJuego.contains(preguntas.get(n))){
                        preguntasJuego.add(preguntas.get(n));
                        adicionado++;
                    }
                    
                    if(adicionado == preguntasNiveles){
                        salir = true;
                    }
                }
            }
        }
    }
    
    public static void setMateria(Materia materiaElegida){
        materia = materiaElegida;
    }
    
    public static void setParalelo(Paralelo paraleloElegido){
        paralelo = paraleloElegido;
    }
    
    public static void setReporte(Reporte nuevoReporte){
        reporte = nuevoReporte;
    }
    
    public static void setReportes(ArrayList<Reporte> nuevoReportes){
        reportes = nuevoReportes;
    }
    
    public static void agregarReportes(Reporte nuevoReporte){
        reportes.add(nuevoReporte);
        try(ObjectOutputStream objectOutput = new ObjectOutputStream (new FileOutputStream("archivos/" + terminoAcademico + "/reportes.dat"))){
            objectOutput.writeObject(reportes);
            objectOutput.flush();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static void setPremio(String nuevoPremio){
        premio = nuevoPremio;
    }
    
    public static TerminoAcademico getTerminoAcademico(){
        return terminoAcademico;
    }
    
    public static ArrayList<TerminoAcademico> getTerminosAcademicos(){
        return terminosAcademicos;
    }
    
    public static int getYearActual(){
        return YEAR;
    }
    
    public static Estudiante getApoyo(){
        return apoyo;
    }
    
    public static Estudiante getJugador(){
        return jugador;
    }
    
    public static ArrayList<Pregunta> getPreguntas(){
        return preguntasJuego;
    }
    
    public static Materia getMateria(){
        return materia;
    }
    
    public static Paralelo getParalelo(){
        return paralelo;
    }
    
    public static Reporte getReporte(){
        return reporte;
    }
    
    public static ArrayList<Reporte> getReportes(){
        return reportes;
    }
    
    public static String getPremio(){
        return premio;
    }
}