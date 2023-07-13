package juego;

import java.time.*;
import personas.Estudiante;
import java.util.ArrayList;

public class Reporte{
    private String fecha;
    private String participante;
    private int level;
    private int tiempo;
    private int preguntasContestadas;
    private String comodines;
    private int premio;
    ArrayList reportes = new ArrayList();
    
    public Reporte(String fecha , String participante, int level, int tiempo, int preguntasContestadas, String comodines, int premio){
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
    public String getParticipante(){
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
    public String getComodines(){
        return comodines;
    }
    public int getPremio(){
        return premio;
    }
    
} 