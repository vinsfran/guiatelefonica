package py.gov.asuncion.service;

import py.gov.asuncion.entity.Telefono;
import py.gov.asuncion.model.TelefonoModel;
import java.util.List;

/**
 *
 * @author vinsfran
 */
public interface TelefonoService {

    public abstract TelefonoModel addTelefono(TelefonoModel tipoTelefonoModel);

    public abstract List<TelefonoModel> listAllTelefonos();

    public abstract Telefono findTelefonoById(int id);

    public abstract TelefonoModel findTelefonoModelById(int id);

    public abstract void removeTelefono(int id);

}
