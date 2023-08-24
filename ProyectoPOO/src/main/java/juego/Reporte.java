package juego;

import java.time.*;
import academico.TerminoAcademico;
import academico.Paralelo;
import java.io.Serializable;
import personas.Estudiante;

public class Reporte implements Comparable<Reporte>, Serializable{
    private String materia;
    private TerminoAcademico terminoAcademico;
    private Paralelo paralelo;
    private String fecha;
    private Estudiante participante;
    private int nivel;
    private int tiempo;
    private int preguntasContestadas;
    private Comodin[] comodines;
    private String premio;
    private String comodinesUsados;
    private static final long serialVersionUID = 1L;
    
    public Reporte(String fecha , Estudiante participante, int level, int tiempo, int preguntasContestadas, Comodin[] comodines, String premio, TerminoAcademico t , String cod, Paralelo p){
        this.fecha=fecha;
        this.nivel=level;
        this.participante=participante;
        this.premio=premio;
        this.preguntasContestadas=preguntasContestadas;
        this.tiempo=tiempo;
        this.comodines=comodines;
        this.terminoAcademico=t;
        this.materia=cod;
        this.paralelo=p;
    }
    public String getFecha(){
        return fecha;
    }
    public Estudiante getParticipante(){
        return participante;
    }
    public int getNivel(){
        return nivel;
    }
    public int getTiempo(){
        return tiempo;
    }
    public int getPreguntasContestadas(){
        return preguntasContestadas;
    }
    public Comodin[] getComodines(){
        return comodines;
    }
    public String getComodinesUsados(){
        comodinesUsados = comodines[0].toString() + ", " + comodines[1].toString() + ", " + comodines[2].toString() ;
        return comodinesUsados;
    }
    
    public String getPremio(){
        return premio;
    }

    public String getMateria() {
        return materia;
    }

    public TerminoAcademico getTerminoAcademico() {
        return terminoAcademico;
    }

    public Paralelo getParalelo() {
        return paralelo;
    }
    
    public void setFecha(String fecha){
        this.fecha = fecha;
    }
    
    public void setPremio(String premio){
        this.premio = premio;
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

        return fecha + " " + participante.getNombre() + " " + nivel + " " + tiempo + " " + preguntasContestadas + " " + comodinesUsados + " " + premio;
    }
    @Override
    public int compareTo(Reporte otroReporte) { // En esta parte se ordenan el objeto segun la fecha 
        LocalDate fechaActual = LocalDate.parse(this.fecha);
        LocalDate fechaOtro = LocalDate.parse(otroReporte.getFecha());
        return fechaActual.compareTo(fechaOtro);
    }
    
} 