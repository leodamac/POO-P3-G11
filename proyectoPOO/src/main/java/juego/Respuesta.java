
package juego;


public class Respuesta {
    private String enunciado;
    private boolean correcto;
    
    public Respuesta(String enunciado, boolean correcto){
        this.enunciado = enunciado;
        this.correcto = correcto;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public boolean isCorrecto() {
        return correcto;
    }

    public void setEsCorrecto(boolean correcto) {
        this.correcto = correcto;
    }
    
    
}
