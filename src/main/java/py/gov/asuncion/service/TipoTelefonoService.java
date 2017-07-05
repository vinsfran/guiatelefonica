package py.gov.asuncion.service;

import py.gov.asuncion.entity.TipoTelefono;
import py.gov.asuncion.model.TipoTelefonoModel;
import java.util.List;

/**
 *
 * @author vinsfran
 */
public interface TipoTelefonoService {

    public abstract TipoTelefonoModel addTipoTelefono(TipoTelefonoModel tipoTelefonoModel);

    public abstract List<TipoTelefonoModel> listAllTiposTelefonos();

    public abstract TipoTelefono findTipoTelefonoById(int id);

    public abstract TipoTelefonoModel findTipoTelefonoModelById(int id);

    public abstract void removeTipoTelefono(int id);

}
