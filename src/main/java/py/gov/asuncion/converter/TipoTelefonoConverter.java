package py.gov.asuncion.converter;

import py.gov.asuncion.entity.TipoTelefono;
import py.gov.asuncion.model.TipoTelefonoModel;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author vinsfran
 */
@Component("tipoTelefonoConverter")
public class TipoTelefonoConverter {

    public TipoTelefono convertTipoTelefonoModelToTipoTelefono(TipoTelefonoModel tipoTelefonoModel) {
        TipoTelefono tipoTelefono = new TipoTelefono(tipoTelefonoModel.getId(),
                tipoTelefonoModel.getNombre());
        return tipoTelefono;
    }

    public List<TipoTelefono> convertTiposTelefonosModelToTiposTelefonos(List<TipoTelefonoModel> tiposTelefonosModel) {
        List<TipoTelefono> tiposTelefonos = new ArrayList<>();
        for (TipoTelefonoModel tipoTelefonoModel : tiposTelefonosModel) {
            tiposTelefonos.add(convertTipoTelefonoModelToTipoTelefono(tipoTelefonoModel));
        }
        return tiposTelefonos;
    }

    public TipoTelefonoModel convertTipoTelefonoToTipoTelefonoModel(TipoTelefono tipoTelefono) {
        TipoTelefonoModel tipoTelefonoModel = new TipoTelefonoModel(tipoTelefono.getId(),
                tipoTelefono.getNombre());
        return tipoTelefonoModel;
    }

    public List<TipoTelefonoModel> convertTiposTelefonoesToTiposTelefonoesModel(List<TipoTelefono> tiposTelefonoes) {
        List<TipoTelefonoModel> tiposTelefonoesModel = new ArrayList<>();
        for (TipoTelefono tipoTelefono : tiposTelefonoes) {
            tiposTelefonoesModel.add(convertTipoTelefonoToTipoTelefonoModel(tipoTelefono));
        }
        return tiposTelefonoesModel;
    }

}
