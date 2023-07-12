package academico;

import java.util.ArrayList;
import juego.Pregunta;

public class Materia {
    private String codigo;
    private String nombre;
    private ArrayList<Paralelo> paralelos;
    private ArrayList<ArrayList<Pregunta>> preguntas;
    private boolean todosLosNivelesTienenPreguntas;
    private int nivel;

    public Materia(String codigo, String nombre, int nivel) {
        this.codigo = codigo;
        this.nombre = nombre;
        paralelos = new ArrayList();
        preguntas = new ArrayList();
        this.nivel = nivel;
        this.crearNivelesPreguntas(nivel);
        todosLosNivelesTienenPreguntas = false;
    }  
    
    public void crearNivelesPreguntas(int nivel){
        boolean salir = false;
        int indice = 0;
        while(!salir){
            preguntas.add(new ArrayList<Pregunta>());
            indice++;
            if(indice>=nivel){
                salir = true;
            }
        }
    }
    
    public void addParalelo(Paralelo paralelo){
        paralelos.add(paralelo);
    }
    
    public void addPreguntas(ArrayList<Pregunta> preguntas){
        for(Pregunta pregunta: preguntas){
            addPregunta(pregunta);
        }
    }
    
    // agrega la pregunta y verifica si hay niveles sin preguntas
    public void addPregunta(Pregunta pregunta){
        preguntas.get(pregunta.getNivel() - 1).add(pregunta);
        todosLosNivelesTienenPreguntas = true;
        boolean salir = false;
        int i = 0;
        while(!salir && i > nivel){
            ArrayList p = preguntas.get(i);
            if(p.isEmpty()){
                todosLosNivelesTienenPreguntas = false;
                salir = true;
            }
            i++;
        }
    }

    public boolean getTodosLosNivelesTienenPreguntas() {
        return todosLosNivelesTienenPreguntas;
    }

    public int getNivel() {
        return nivel;
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
    
    public ArrayList<ArrayList<Pregunta>> getPreguntas() {
        return preguntas;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setNivel(int nivel){
        this.nivel = nivel;
    }

    public void setTodosLosNivelesTienenPreguntas(boolean todosLosNivelesTienenPreguntas) {
        this.todosLosNivelesTienenPreguntas = todosLosNivelesTienenPreguntas;
    }
    
    @Override
    public String toString(){
        return nombre;
    }
}
