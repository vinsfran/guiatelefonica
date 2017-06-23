package py.gov.asuncion.model;

/**
 *
 * @author vinsfran
 */

public class TipoLugarModel{

    private Integer id;
    private String nombre;

    public TipoLugarModel() {
    }

    public TipoLugarModel(Integer id) {
        this.id = id;
    }

    public TipoLugarModel(Integer id, String nombre) {
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
        return "TipoLugarModel{" + "id=" + id + ", nombre=" + nombre + '}';
    }
    
}