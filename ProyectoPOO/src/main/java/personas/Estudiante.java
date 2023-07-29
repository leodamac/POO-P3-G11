package personas;

import java.io.Serializable;

public class Estudiante extends Persona implements Serializable{
    private String matricula;
    private String correo;
    private int ganancias;
    private static final long serialVersionUID = 1L;
    
    public Estudiante(String nombre, String matricula, String correo){
        super(nombre);
        this.matricula = matricula;
        this.correo = correo;
        this.ganancias = 0;
    }
    
    public Estudiante(String nombre, String matricula){
        super(nombre);
        this.matricula = matricula;
        this.correo = "";
        this.ganancias = 0;
    }
    
    public void setCorreo(String correo){
        this.correo = correo;
    }
    
    public void aumentarGanancias(int ganancias){
        this.ganancias += ganancias;
    }
    
    public void resetearGanancias(){
        this.ganancias = 0;
    }

    public int getGanancias() {
        return ganancias;
    }
    
    public String getCorreo(){
        return this.correo;
    }
    
    
}
