package juego;

import java.io.Serializable;

public class Comodin implements Serializable{
    private String nombre;
    private boolean usado;
    private Pregunta pregunta;
    
    public Comodin(String nombre, boolean usado, Pregunta pregunta){
        this.nombre = nombre;
        this.usado = usado;
        this.pregunta = pregunta;
    }
    
    public Comodin(String nombre){
        this.nombre = nombre;
        usado = false;
    }
    
    public boolean isUsado(){
        return usado;
    }
    
    public void usar(){
        this.usado = true;
    }
    public void setPregunta(Pregunta pregunta){
        this.pregunta=pregunta;
    }
    @Override
    public String toString(){
        String u = "";
        if(usado){
            u = "Usado en pregunta: "+pregunta.getNivel();
        }else{
            u = "NO usado";
        }
        return nombre + " " + u;
    }
}
