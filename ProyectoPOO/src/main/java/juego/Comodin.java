package juego;

public class Comodin {
    private String nombre;
    private boolean usado;
    private Pregunta pregunta;
    public Comodin(String nombre){
        this.nombre = nombre;
        usado = false;
    }
    
    public boolean isUsado(){
        return usado;
    }
    
    public void usar(){
        this.usado = true;
    }
    public void setPregunta(Pregunta pregunta){
        this.pregunta=pregunta;
    }
    @Override
    public String toString(){
        String u = "";
        if(usado){
            u = "Usado en pregunta: "+pregunta.getNivel();
        }else{
            u = "NO usado";
        }
        return nombre + " " + u;
    }
}
