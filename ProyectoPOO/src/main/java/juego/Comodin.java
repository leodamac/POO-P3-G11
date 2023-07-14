package juego;

public class Comodin {
    private String nombre;
    private boolean usado;
    
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
    
    @Override
    public String toString(){
        String u = "";
        if(usado){
            u = "Usado";
        }else{
            u = "NO usado";
        }
        return nombre + " " + u;
    }
}
