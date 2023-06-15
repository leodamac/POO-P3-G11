package academico;


public abstract class Materia {
    private String nombre;
    private String codigo;
    private int niveles;
    
    public Materia(String nombre, String codigo, int niveles){
        this.nombre = nombre;
        this.codigo = codigo;
        this.niveles = niveles;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getNiveles() {
        return niveles;
    }

    public void setNiveles(int niveles) {
        this.niveles = niveles;
    }
    
    
}
