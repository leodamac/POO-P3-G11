package termino;

public class TerminoAcademico {
 
    private int año;
    private int termino;
    
    public TerminoAcademico(int año, int termino){
        this.año = año;
        this.termino = termino;
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
}
