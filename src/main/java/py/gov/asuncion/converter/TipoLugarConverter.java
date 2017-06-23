package py.gov.asuncion.converter;

import py.gov.asuncion.entity.TipoLugar;
import py.gov.asuncion.model.TipoLugarModel;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author vinsfran
 */
@Component("tipoLugarConverter")
public class TipoLugarConverter {

    public TipoLugar convertTipoLugarModelToTipoLugar(TipoLugarModel tipoLugarModel) {
        TipoLugar tipoLugar = new TipoLugar(tipoLugarModel.getId(),
                tipoLugarModel.getNombre());
        return tipoLugar;
    }

    public List<TipoLugar> convertTiposLugaresModelToTiposLugares(List<TipoLugarModel> tiposLugaresModel) {
        List<TipoLugar> tiposLugares = new ArrayList<>();
        for (TipoLugarModel tipoLugarModel : tiposLugaresModel) {
            tiposLugares.add(convertTipoLugarModelToTipoLugar(tipoLugarModel));
        }
        return tiposLugares;
    }

    public TipoLugarModel convertTipoLugarToTipoLugarModel(TipoLugar tipoLugar) {
        TipoLugarModel tipoLugarModel = new TipoLugarModel(tipoLugar.getId(),
                tipoLugar.getNombre());
        return tipoLugarModel;
    }

    public List<TipoLugarModel> convertTiposLugaresToTiposLugaresModel(List<TipoLugar> tiposLugares) {
        List<TipoLugarModel> tiposLugaresModel = new ArrayList<>();
        for (TipoLugar tipoLugar : tiposLugares) {
            tiposLugaresModel.add(convertTipoLugarToTipoLugarModel(tipoLugar));
        }
        return tiposLugaresModel;
    }

}
