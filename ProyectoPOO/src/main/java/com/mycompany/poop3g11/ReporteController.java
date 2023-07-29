package com.mycompany.poop3g11;

import academico.Materia;
import academico.Paralelo;
import academico.TerminoAcademico;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import juego.Reporte;
import personas.Estudiante;

public class ReporteController {
    @FXML TableView tableView;
    @FXML ComboBox<TerminoAcademico> terminoAcademicoComboBox;
    @FXML ComboBox<Materia> materiaComboBox;
    @FXML ComboBox<Paralelo> paraleloComboBox;
    ArrayList<TerminoAcademico> terminosAcademicos;
    TerminoAcademico terminoAcademico;
    Materia materia;
    Paralelo paralelo;
    ArrayList<Reporte> reportes = new ArrayList<Reporte>();
    ObservableList<Reporte> data;
    @FXML
    private void initialize(){
        cagarColumnas();
        cargarTerminosAcademicos();
        terminoAcademicoComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            terminoAcademico = terminoAcademicoComboBox.getValue();
            cargarMaterias();
            cargarReportes(terminoAcademico);
        });
        
        materiaComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            materia = materiaComboBox.getValue();
            cargarParalelos();
            
        });

        
        paraleloComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            paralelo = paraleloComboBox.getValue();
            removerParaleloReporte();
        });    
    }
    
    private void removerParaleloReporte(){
        cargarReportes(terminoAcademico);
        Iterator<Reporte> iterator = reportes.iterator();
        boolean fin = false;
        while(iterator.hasNext() && !fin){
            Reporte r = iterator.next();
            if(!r.getParalelo().equals(paralelo)){
                System.out.println("Removido " + paralelo);
                reportes.remove(r);
                data = FXCollections.observableArrayList(reportes);
                tableView.setItems(data);
                fin = true;
            }
        }
        tableView.refresh();
    }   
    
    private void cargarTerminosAcademicos(){
        terminosAcademicos = App.getTerminosAcademicos();
        ObservableList<TerminoAcademico> observableList = FXCollections.observableArrayList(terminosAcademicos);
        terminoAcademicoComboBox.setItems(observableList);
    }
    
    private void cargarMaterias(){
        ArrayList<Materia> materias = terminoAcademico.getMaterias();
        ObservableList<Materia> observableList = FXCollections.observableArrayList(materias);
        materiaComboBox.setItems(observableList);
    }
    
    private void cargarParalelos(){
        ArrayList<Paralelo> arrayList = materia.getParalelos();
        ObservableList<Paralelo> observableList = FXCollections.observableArrayList(arrayList);
        paraleloComboBox.setItems(observableList);
    }
        
    
    private void cagarColumnas(){
        ArrayList<TableColumn> columnas= new ArrayList();
        
        TableColumn <Reporte, String> columnaFecha= new TableColumn("Fecha");
        columnaFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        columnas.add(columnaFecha);
        
        TableColumn <Reporte, Estudiante> columnaEstudiante= new TableColumn("Estudiante");
        columnaEstudiante.setCellValueFactory(new PropertyValueFactory<>("participante"));
        columnas.add(columnaEstudiante);
        
        TableColumn <Reporte, Integer> columnaNivel= new TableColumn("Nivel");
        columnaNivel.setCellValueFactory(new PropertyValueFactory<>("nivel"));
        columnas.add(columnaNivel);
        
        TableColumn <Reporte, Integer> columnaTiempo= new TableColumn("Tiempo");
        columnaTiempo.setCellValueFactory(new PropertyValueFactory<>("tiempo"));
        columnas.add(columnaTiempo);
        
        TableColumn <Reporte, Integer> columnaPreguntasContestadas= new TableColumn("Preguntas Contestadas");
        columnaPreguntasContestadas.setCellValueFactory(new PropertyValueFactory<>("preguntasContestadas"));
        columnas.add(columnaPreguntasContestadas);
        
        TableColumn <Reporte, String> columnaComodines= new TableColumn("Comodines");
        columnaComodines.setCellValueFactory(new PropertyValueFactory<>("comodinesUsados"));
        columnas.add(columnaComodines);
        
        TableColumn <Reporte, String> columnaPremio= new TableColumn("Premio");
        columnaPremio.setCellValueFactory(new PropertyValueFactory<>("premio"));
        columnas.add(columnaPremio);
        
        TableColumn <Reporte, TerminoAcademico> columnaTerminoAcademico= new TableColumn("Termino Academico");
        columnaTerminoAcademico.setCellValueFactory(new PropertyValueFactory<>("terminoAcademico"));
        columnas.add(columnaTerminoAcademico);

        TableColumn <Reporte, Materia> columnaMateria= new TableColumn("Materia");
        columnaMateria.setCellValueFactory(new PropertyValueFactory<>("materia"));
        columnas.add(columnaMateria);
        
        TableColumn <Reporte, Paralelo> columnaParalelo= new TableColumn("Paralelo");
        columnaParalelo.setCellValueFactory(new PropertyValueFactory<>("paralelo"));
        
        columnas.add(columnaParalelo);

        tableView.getColumns().addAll(columnas);
    }
    
    private void cargarReportes(TerminoAcademico terminoAcademico){
        try(ObjectInputStream file = new ObjectInputStream(new FileInputStream ("src/archivos/" + terminoAcademico + "/reportes.dat"))){
            ArrayList<Reporte> r2 = (ArrayList<Reporte>)file.readObject();
            reportes = r2;
            data = FXCollections.observableArrayList(reportes);
            tableView.setItems(data);
        }catch(Exception e){
            System.out.println("Cargar Reportes "+e);
        }
    }
    
    @FXML
    private void switchToVentanaPrincipal() throws IOException {
        App.cargarArchivoFXML("ventanaPrincipal");
        //App.setRoot("ventanaPrincipal");
    }
}
