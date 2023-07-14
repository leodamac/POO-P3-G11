package juego;

import java.time.*;
import personas.Estudiante;
import java.util.ArrayList;

public class Reporte{
    private String fecha;
    private Estudiante participante;
    private int level;
    private int tiempo;
    private int preguntasContestadas;
    private Comodin[] comodines;
    private int premio;
    ArrayList reportes = new ArrayList();
    
    public Reporte(String fecha , Estudiante participante, int level, int tiempo, int preguntasContestadas, Comodin[] comodines, int premio){
        this.fecha=fecha;
        this.level=level;
        this.participante=participante;
        this.premio=premio;
        this.preguntasContestadas=preguntasContestadas;
        this.tiempo=tiempo;
        this.comodines=comodines;
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
    public int getPremio(){
        return premio;
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
    
} 