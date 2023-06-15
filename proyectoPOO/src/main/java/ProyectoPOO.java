import termino.TerminoAcademico;
import termino.TerminosAcademicos;
public class ProyectoPOO {

    public static void main(String[] args) {
        TerminoAcademico termino1 = new TerminoAcademico(2022,1);
        TerminoAcademico termino2 = new TerminoAcademico(2022,2);
        TerminoAcademico termino3 = new TerminoAcademico(2022,1);
        TerminosAcademicos terminos = new TerminosAcademicos();
        terminos.agregarTermino(termino1);
        terminos.agregarTermino(termino2);
        terminos.agregarTermino(termino3);
        System.out.println(termino1.equals(termino2));
        System.out.println(terminos.obtenerTermino(2022, 1));
    }
}
