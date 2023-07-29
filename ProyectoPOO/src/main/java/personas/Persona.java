
package personas;

import java.io.Serializable;

public class Persona implements Serializable{
    private String nombre;
    private static final long serialVersionUID = 1L;
    
    public Persona(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return this.nombre;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Persona)) {
            return false;
        }

        final Persona otro = (Persona) obj;
        return this.nombre.equalsIgnoreCase(otro.getNombre());
    }
    
    
}
