package academico;

import java.util.ArrayList;
import java.util.Arrays;
import juego.Pregunta;

public class Materia {
    private String codigo;
    private String nombre;
    private int level;
    private ArrayList<Paralelo> paralelos;
    private ArrayList<Pregunta> preguntas;
   
    public Materia(String codigo, String nombre, int level) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.level = level;
        paralelos = new ArrayList();
        preguntas = new ArrayList();
    }  
    
    public void addParalelo(Paralelo paralelo){
        paralelos.add(paralelo);
    }
    
    public void addPreguntas(Pregunta[] ListaPreguntas){
        preguntas.addAll( Arrays.asList(ListaPreguntas)); 
    }
    
    public void addPreguntas(ArrayList ListaPreguntas){
        preguntas.addAll( ListaPreguntas);
    }
    
    public void addPregunta(Pregunta pregunta){
        preguntas.add(pregunta);
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
    public void setLevel(int level) {
        this.level = level;
    }
    @Override
    public String toString(){
        return nombre;
    }
}
