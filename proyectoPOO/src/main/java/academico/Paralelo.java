package academico;

import termino.TerminoAcademico;

public class Paralelo extends Materia{
    
    private TerminoAcademico terminoAcademico;
    private String paralelo;
    private String url;
    
    public Paralelo(String nombre, String codigo, int niveles, TerminoAcademico terminoAcademico, String paralelo, String url){
        super(nombre, codigo, niveles);
        this.terminoAcademico = terminoAcademico;
        this.paralelo = paralelo;
        this.url = url;
    }
    
}
