package py.gov.asuncion.entity;

import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "telefono")
public class Telefono {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "numero")
    private String numero;
    @ManyToMany(mappedBy = "telefonoList")
    private List<Lugar> lugarList;
    @JoinColumn(name = "tipo_telefono_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TipoTelefono tipoTelefonoId;

    public Telefono() {
    }

    public Telefono(Integer id) {
        this.id = id;
    }

    public Telefono(Integer id, String numero) {
        this.id = id;
        this.numero = numero;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public List<Lugar> getLugarList() {
        return lugarList;
    }

    public void setLugarList(List<Lugar> lugarList) {
        this.lugarList = lugarList;
    }

    public TipoTelefono getTipoTelefonoId() {
        return tipoTelefonoId;
    }

    public void setTipoTelefonoId(TipoTelefono tipoTelefonoId) {
        this.tipoTelefonoId = tipoTelefonoId;
    }

    @Override
    public String toString() {
        return "Telefono{" + "id=" + id + ", numero=" + numero + ", tipoTelefonoId=" + tipoTelefonoId.getId() + ", tipoTelefonoNombre=" + tipoTelefonoId.getNombre() + '}';
    }

}