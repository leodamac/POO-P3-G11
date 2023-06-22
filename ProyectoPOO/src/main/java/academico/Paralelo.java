package academico;

import java.util.ArrayList;
import personas.Estudiante;

public class Paralelo {
    private Materia materia;
    private int numero;
    private ArrayList<Estudiante> estudiantes;
    private String url;

    public Paralelo(Materia materia, int numero, String url) {
        this.materia = materia;
        this.numero = numero;
        this.url = url;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    public void addEstudiante(Estudiante estudiante){
        estudiantes.add(estudiante);
    }
    
    public void addEstudiantes(Estudiante[] listaDeEstudiantes){
        for(Estudiante estudiante: listaDeEstudiantes)
            estudiantes.add(estudiante);
    }
    
    public void addEstudiantes(ArrayList<Estudiante> listaDeEstudiantes){
        estudiantes.addAll(listaDeEstudiantes);
    }

    public Materia getMateria() {
        return materia;
    }

    public int getNumero() {
        return numero;
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public String getUrl() {
        return url;
    }
    
    
}
