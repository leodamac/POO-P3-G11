package personas;

public class Estudiante extends Persona{
    private String matricula;
    private int ganancias;
    
    public Estudiante(String nombre, String matricula){
        super(nombre);
        this.matricula = matricula;
        this.ganancias = 0;
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
    
    
    
    
}
