package com.mycompany.poop3g11;

import academico.Materia;
import academico.Paralelo;
import academico.TerminoAcademico;
import java.io.IOException;
import java.util.ArrayList;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import juego.Comodin;
import juego.Reporte;
import personas.Estudiante;

public class ReporteController {
    @FXML TableView tableView;
    Comodin[] comodines = {new Comodin("Pene"), new Comodin("Pene"), new Comodin("Pene")};
    @FXML
    private void initialize(){

        ArrayList<Reporte> reportes = new ArrayList();
        // Reporte(String fecha , Estudiante participante, int level, int tiempo, int preguntasContestadas, Comodin[] comodines, String premio, TerminoAcademico t , String cod, Paralelo p)
        reportes.add(new Reporte("25/10/2023", new Estudiante("Nombre", "matricula", "correo"), 15, 60, 0, comodines, "NADA", App.getTerminoAcademico(), "cod", App.getTerminoAcademico().getMaterias().get(0).getParalelos().get(0)));
        reportes.add(new Reporte("28/10/2023", new Estudiante("Juan Nombrado", "matricula", "correo"), 15, 60, 0, comodines, "NADA", App.getTerminoAcademico(), "cod", App.getTerminoAcademico().getMaterias().get(0).getParalelos().get(0)));

        ObservableList<Reporte> data = FXCollections.observableArrayList(reportes);

        cagarColumnas();
        tableView.setItems(data);
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
        columnaPremio.setCellValueFactory(new PropertyValueFactory<>("terminoAcademico"));
        columnas.add(columnaTerminoAcademico);

        TableColumn <Reporte, Materia> columnaMateria= new TableColumn("Materia");
        columnaMateria.setCellValueFactory(new PropertyValueFactory<>("materia"));
        columnas.add(columnaMateria);
        
        TableColumn <Reporte, Paralelo> columnaParalelo= new TableColumn("Paralelo");
        columnaParalelo.setCellValueFactory(new PropertyValueFactory<>("paralelo"));
        columnas.add(columnaParalelo);
        
        /*


    private Paralelo paralelo;
 */
        
        tableView.getColumns().addAll(columnas);
    }
    
    @FXML
    private void switchToVentanaPrincipal() throws IOException {
        App.cargarArchivoFXML("ventanaPrincipal");
        //App.setRoot("ventanaPrincipal");
    }
}
