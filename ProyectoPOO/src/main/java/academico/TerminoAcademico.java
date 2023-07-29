package academico;
import academico.Materia;
import com.mycompany.proyectopoo.Menu;
import java.io.Serializable;

import java.util.ArrayList;

public class TerminoAcademico implements Comparable <TerminoAcademico>, Serializable{

    private int año;
    private int termino;
    private ArrayList<Materia> materias;
    private static final long serialVersionUID = 1L;

    public TerminoAcademico(int año, int termino){
        this.año = año;
        this.termino = termino;
        materias = new ArrayList();
    }
    //Recibe los el año y el termino academico en string e internamente lo convierte en numeros y luego llama el constructor para crear el terminoAcademico
    public TerminoAcademico(String año, String termino){
        this(Menu.convierteTxtAEntero(año), Menu.convierteTxtAEntero(termino));
    }
    
    public void addMateria(Materia materia){
        materias.add(materia);
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public int getTermino() {
        return termino;
    }
    
    public ArrayList<Materia> getMaterias(){
        return materias;
    }

    public void setTermino(int termino) {
        this.termino = termino;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final TerminoAcademico otro = (TerminoAcademico) obj;
        if (this.año != otro.getAño() ) {
            return false;
        }

        if (this.termino != otro.getTermino()) {
            return false;
        }

        return true;
    }

    @Override
    public String toString(){
        return año + "-" + termino;
    }
    
    @Override
    public int compareTo(TerminoAcademico o) {
        if (this.año == o.getAño()){
                return this.termino - o.getTermino();
        }
        else{
                return this.año - o.getAño();
            }
        
    }
}