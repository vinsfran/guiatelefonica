package py.gov.asuncion.entity;

import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author vinsfran
 */
@Entity
@Table(name = "lugar")
public class Lugar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    
    @JoinTable(name = "lugar_telefono", joinColumns = {
        @JoinColumn(name = "lugar_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "telefono_id", referencedColumnName = "id")})
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Telefono> telefonoList;
    
    @JoinColumn(name = "tipo_lugar_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TipoLugar tipoLugarId;

    public Lugar() {
    }

    public Lugar(Integer id) {
        this.id = id;
    }

    public Lugar(Integer id, String nombre, TipoLugar tipoLugarId) {
        this.id = id;
        this.nombre = nombre;
        this.tipoLugarId = tipoLugarId;
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

    public List<Telefono> getTelefonoList() {
        return telefonoList;
    }

    public void setTelefonoList(List<Telefono> telefonoList) {
        this.telefonoList = telefonoList;
    }

    public TipoLugar getTipoLugarId() {
        return tipoLugarId;
    }

    public void setTipoLugarId(TipoLugar tipoLugarId) {
        this.tipoLugarId = tipoLugarId;
    }

    @Override
    public String toString() {
        return "Lugar{" + "id=" + id + ", nombre=" + nombre + ", tipoLugarId=" + tipoLugarId.getId() + ", tipoLugarNombre=" + tipoLugarId.getNombre() + '}';
    }

}
