package py.gov.asuncion.model;

import py.gov.asuncion.entity.TipoTelefono;

/**
 *
 * @author vinsfran
 */
public class TelefonoModel {

    private Integer id;
    private String nombre;
    private TipoTelefono tipoTelefonoId;

    public TelefonoModel() {
    }

    public TelefonoModel(Integer id) {
        this.id = id;
    }

    public TelefonoModel(Integer id, String nombre, TipoTelefono tipoTelefonoId) {
        this.id = id;
        this.nombre = nombre;
        this.tipoTelefonoId = tipoTelefonoId;
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

    public TipoTelefono getTipoTelefonoId() {
        return tipoTelefonoId;
    }

    public void setTipoTelefonoId(TipoTelefono tipoTelefonoId) {
        this.tipoTelefonoId = tipoTelefonoId;
    }

    @Override
    public String toString() {
        return "TelefonoModel{" + "id=" + id + ", nombre=" + nombre + ", tipoTelefonoId=" + tipoTelefonoId.getId() + ", tipoTelefonoNombre=" + tipoTelefonoId.getNombre() + "}";
    }

}
