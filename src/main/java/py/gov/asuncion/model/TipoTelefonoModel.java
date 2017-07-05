package py.gov.asuncion.model;

/**
 *
 * @author vinsfran
 */

public class TipoTelefonoModel{

    private Integer id;
    private String nombre;

    public TipoTelefonoModel() {
    }

    public TipoTelefonoModel(Integer id) {
        this.id = id;
    }

    public TipoTelefonoModel(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "TipoTelefonoModel{" + "id=" + id + ", nombre=" + nombre + '}';
    }
    
}