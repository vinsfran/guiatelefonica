package py.gov.asuncion.service;

import py.gov.asuncion.entity.Lugar;
import py.gov.asuncion.model.LugarModel;
import java.util.List;

/**
 *
 * @author vinsfran
 */
public interface LugarService {

    public abstract LugarModel addLugar(LugarModel tipoLugarModel);

    public abstract List<LugarModel> listAllLugares();

    public abstract Lugar findLugarById(int id);

    public abstract LugarModel findLugarModelById(int id);

    public abstract void removeLugar(int id);

}
