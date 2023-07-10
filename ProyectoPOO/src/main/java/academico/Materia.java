package academico;

import java.util.ArrayList;
import java.util.Arrays;
import juego.Pregunta;

public class Materia {
    private String codigo;
    private String nombre;
    private ArrayList<Paralelo> paralelos;
    private ArrayList<ArrayList> preguntas;

    public Materia(String codigo, String nombre, int niveles) {
        this.codigo = codigo;
        this.nombre = nombre;
        paralelos = new ArrayList();
        preguntas = new ArrayList();
        this.crearNivelesPreguntas(niveles);
    }  
    
    public void crearNivelesPreguntas(int niveles){
        boolean salir = false;
        int indice = 0;
        while(!salir){
            preguntas.add(new ArrayList<Pregunta>());
            indice++;
            if(indice>=15){
                salir = true;
            }
            
        }
    }
    
    public void addParalelo(Paralelo paralelo){
        paralelos.add(paralelo);
    }
    
    public void addPreguntas(ArrayList<Pregunta> preguntas){
        for(Pregunta pregunta: preguntas){
            (this.preguntas.get(pregunta.getNivel() - 1)).add(pregunta);
        }
    }
    
    public void addPregunta(Pregunta pregunta){
        preguntas.get(pregunta.getNivel() - 1).add(pregunta);
    }
    
    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Paralelo> getParalelos() {
        return paralelos;
    }
    
    public ArrayList getPreguntas() {
        return preguntas;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public String toString(){
        return nombre;
    }
}
