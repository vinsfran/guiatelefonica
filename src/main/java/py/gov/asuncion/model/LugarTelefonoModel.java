package py.gov.asuncion.model;

import py.gov.asuncion.entity.Lugar;
import py.gov.asuncion.entity.Telefono;

/**
 *
 * @author vinsfran
 */
public class LugarTelefonoModel {

    private Lugar lugar;
    private Telefono telefono;

    public LugarTelefonoModel() {
    }

    public LugarTelefonoModel(Lugar lugar, Telefono telefono) {
        this.lugar = lugar;
        this.telefono = telefono;
    }

    public Lugar getLugar() {
        return lugar;
    }

    public void setLugar(Lugar lugar) {
        this.lugar = lugar;
    }

    public Telefono getTelefono() {
        return telefono;
    }

    public void setTelefono(Telefono telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "LugarTelefonoModel{" + "Lugar=" + lugar.getNombre() + ", Telefono=" + telefono.getNumero() + "}";
    }

}
