package academico;

import java.io.Serializable;
import java.util.ArrayList;
import personas.Estudiante;

public class Paralelo implements Serializable{
    private Materia materia;
    private int numero;
    private ArrayList<Estudiante> estudiantes;
    private String url;
    private static final long serialVersionUID = 1L;

    public Paralelo(Materia materia, int numero, String url) {
        this.materia = materia;
        this.numero = numero;
        this.url = url;
        estudiantes = new ArrayList();
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
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final Paralelo otro = (Paralelo) obj;
        if (this.numero != otro.getNumero() ) {
            return false;
        }

        return this.materia.equals(otro.getMateria());
    }
    
    @Override
    public String toString(){
        return "Par." + numero + ": " + materia.getNombre();
    }
}
