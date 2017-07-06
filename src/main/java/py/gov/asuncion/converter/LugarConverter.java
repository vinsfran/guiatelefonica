package py.gov.asuncion.converter;

import py.gov.asuncion.entity.Lugar;
import py.gov.asuncion.model.LugarModel;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import py.gov.asuncion.entity.TipoLugar;
import py.gov.asuncion.service.TipoLugarService;

/**
 *
 * @author vinsfran
 */
@Component("lugarConverter")
public class LugarConverter {

    @Autowired
    @Qualifier("tipoLugarServiceImpl")
    private TipoLugarService tipoLugarService;

    public Lugar convertLugarModelToLugar(LugarModel lugarModel) {

        TipoLugar tipoLugar = tipoLugarService.findTipoLugarById(lugarModel.getTipoLugarId().getId());

        Lugar lugar = new Lugar(lugarModel.getId(),
                lugarModel.getNombre(),
                tipoLugar
        );
        return lugar;
    }

    public List<Lugar> convertLugaresModelToLugares(List<LugarModel> tiposLugaresModel) {
        List<Lugar> lugares = new ArrayList<>();
        for (LugarModel lugarModel : tiposLugaresModel) {
            lugares.add(convertLugarModelToLugar(lugarModel));
        }
        return lugares;
    }

    public LugarModel convertLugarToLugarModel(Lugar lugar) {
        LugarModel lugarModel = new LugarModel(lugar.getId(),
                lugar.getNombre(),
                lugar.getTipoLugarId(),
                lugar.getTelefonoList()
        );
        return lugarModel;
    }

    public List<LugarModel> convertLugaresToLugaresModel(List<Lugar> lugares) {
        List<LugarModel> lugaresModel = new ArrayList<>();
        for (Lugar lugar : lugares) {
            lugaresModel.add(convertLugarToLugarModel(lugar));
        }
        return lugaresModel;
    }

}
