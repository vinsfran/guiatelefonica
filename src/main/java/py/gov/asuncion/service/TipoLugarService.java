package py.gov.asuncion.service;

import py.gov.asuncion.entity.TipoLugar;
import py.gov.asuncion.model.TipoLugarModel;
import java.util.List;

/**
 *
 * @author vinsfran
 */
public interface TipoLugarService {

    public abstract TipoLugarModel addTipoLugar(TipoLugarModel tipoLugarModel);

    public abstract List<TipoLugarModel> listAllTiposLugares();

    public abstract TipoLugar findTipoLugarById(int id);

    public abstract TipoLugarModel findTipoLugarModelById(int id);

    public abstract void removeTipoLugar(int id);

}
