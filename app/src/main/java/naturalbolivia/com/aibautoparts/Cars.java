package naturalbolivia.com.aibautoparts;

import java.io.Serializable;

/**
 * Created by GutO on 11/02/2017.
 */

public class Cars  implements Serializable{
    private int imagen;
    private String nombre;
    private int visitas;

    public Cars(int imagen, String nombre, int visitas) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.visitas = visitas;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVisitas() {
        return visitas;
    }

    public int getImagen() {
        return imagen;
    }
}
