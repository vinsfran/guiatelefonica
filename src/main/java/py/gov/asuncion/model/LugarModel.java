package py.gov.asuncion.model;

import java.util.List;
import py.gov.asuncion.entity.Telefono;
import py.gov.asuncion.entity.TipoLugar;

/**
 *
 * @author vinsfran
 */
public class LugarModel {

    private Integer id;
    private String nombre;
    private TipoLugar tipoLugarId;
    private List<Telefono> telefonoList;

    public LugarModel() {
    }

    public LugarModel(Integer id) {
        this.id = id;
    }

    public LugarModel(Integer id, String nombre, TipoLugar tipoLugarId, List<Telefono> telefonoList) {
        this.id = id;
        this.nombre = nombre;
        this.tipoLugarId = tipoLugarId;
        this.telefonoList = telefonoList;
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

    public TipoLugar getTipoLugarId() {
        return tipoLugarId;
    }

    public void setTipoLugarId(TipoLugar tipoLugarId) {
        this.tipoLugarId = tipoLugarId;
    }

    public List<Telefono> getTelefonoList() {
        return telefonoList;
    }

    public void setTelefonoList(List<Telefono> telefonoList) {
        this.telefonoList = telefonoList;
    }

    @Override
    public String toString() {
        return "LugarModel{" + "id=" + id + ", nombre=" + nombre + ", tipoLugarId=" + tipoLugarId.getId() + ", tipoLugarNombre=" + tipoLugarId.getNombre() + "}";
    }

}
