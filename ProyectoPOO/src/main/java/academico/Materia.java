package academico;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import juego.Pregunta;

public class Materia implements Serializable{
    private String codigo;
    private String nombre;
    private ArrayList<Paralelo> paralelos;
    private ArrayList<ArrayList<Pregunta>> preguntas;
    private boolean todosLosNivelesTienenPreguntas;
    private int nivel;
    private static final long serialVersionUID = 1L;

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
    
    @Override
    public boolean equals(Object objeto){
        if(objeto == null){
            return false;
        }
        if(objeto.getClass() != this.getClass()) {
            return false;
        }else{
            final Materia otro = (Materia) objeto;
            return this.nombre.equals(otro.getNombre());
        }
    }

    public void addParalelo(int paralelo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
     public void guardarPreguntasEnArchivo(String rutaArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo, StandardCharsets.UTF_8))) {
            for (ArrayList<Pregunta> nivelPreguntas : preguntas) {
                for (Pregunta pregunta : nivelPreguntas) {
                    writer.write(pregunta.toString()); // Supongo que tienes un método toString en la clase Pregunta
                    writer.newLine();
                    writer.write("separacion"); // Separador entre preguntas (ajusta según tus necesidades)
                    writer.newLine();
                }
            }
        } catch (IOException e) {
        }
    }
    
}
