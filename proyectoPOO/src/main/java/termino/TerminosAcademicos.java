package termino;

import java.util.ArrayList;

public class TerminosAcademicos {
    private ArrayList<TerminoAcademico> terminos;
    private int size;
    private final int AÑOACTUAL = 2023;
    
    public TerminosAcademicos(){
        terminos = new ArrayList<TerminoAcademico>();
        size = 0;
    }
    
    public void agregarTermino(TerminoAcademico termino){
        if (!terminos.contains(termino) && termino.getAño() >= AÑOACTUAL){
            terminos.add(termino);
            size++;
        }//else{
          //  throw new Exception("El termino ya existe o el año es menor al actual");
        //}
    }
    
    public int obtenerIndiceTermino(TerminoAcademico termino){
        int indice = -1;
        if (terminos.contains(termino)){
            indice = terminos.indexOf(termino);
        }
        return indice;
    }
    
    public TerminoAcademico obtenerTermino(int año, int termino){
        TerminoAcademico terminoAcademico = null;
        int indice = obtenerIndiceTermino(new TerminoAcademico(año, termino));
        if(indice != -1){
            terminoAcademico = terminos.get(indice);
        } 
        return terminoAcademico;
    }
    
    public void eliminarTermino(int año, int termino){
        TerminoAcademico terminoAcademico = new TerminoAcademico(año, termino);
        int indice = obtenerIndiceTermino(terminoAcademico);
        if(indice != -1){
            terminos.remove(terminoAcademico);
        }
    }
    
    public int size(){
        return size;
    }
    
}
