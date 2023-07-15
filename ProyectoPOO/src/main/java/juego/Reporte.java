package juego;

import java.time.*;
import academico.TerminoAcademico;
import academico.Paralelo;
import personas.Estudiante;
import java.util.ArrayList;


public class Reporte implements Comparable<Reporte>{
    private String materia;
    private TerminoAcademico termino;
    private Paralelo paralelo;
    private String fecha;
    private Estudiante participante;
    private int level;
    private int tiempo;
    private int preguntasContestadas;
    private Comodin[] comodines;
    private String premio;
    
    public Reporte(String fecha , Estudiante participante, int level, int tiempo, int preguntasContestadas, Comodin[] comodines, String premio, TerminoAcademico t , String cod, Paralelo p){
        this.fecha=fecha;
        this.level=level;
        this.participante=participante;
        this.premio=premio;
        this.preguntasContestadas=preguntasContestadas;
        this.tiempo=tiempo;
        this.comodines=comodines;
        this.termino=t;
        this.materia=cod;
        this.paralelo=p;
    }
    public String getFecha(){
        return fecha;
    }
    public Estudiante getParticipante(){
        return participante;
    }
    public int getLevel(){
        return level;
    }
    public int getTiempo(){
        return tiempo;
    }
    public int getpreguntasContestadas(){
        return preguntasContestadas;
    }
    public Comodin[] getComodines(){
        return comodines;
    }
    public String getPremio(){
        return premio;
    }

    public String getMateria() {
        return materia;
    }

    public TerminoAcademico getT() {
        return termino;
    }

    public Paralelo getP() {
        return paralelo;
    }
    
    
    @Override
    /*Fecha del juego	
    Participante	
    Nivel máximo alcanzado	
    Tiempo  
    CantidadPreguntasContestadas   
    Comodines utilizados
    Premio*/

    public String toString(){
        String comodinesUsados = comodines[0].toString() + " " + comodines[1].toString() + " " + comodines[0].toString() ;

        return fecha + " " + participante.getNombre() + " " + level + " " + tiempo + " " + preguntasContestadas + " " + comodinesUsados + " " + premio;
    }
    @Override
    public int compareTo(Reporte otroReporte) { // En esta parte se ordenan el objeto segun la fecha 
        LocalDate fechaActual = LocalDate.parse(this.fecha);
        LocalDate fechaOtro = LocalDate.parse(otroReporte.getFecha());
        return fechaActual.compareTo(fechaOtro);
    }
    
} 