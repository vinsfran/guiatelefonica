package py.gov.asuncion.converter;

import py.gov.asuncion.entity.Telefono;
import py.gov.asuncion.model.TelefonoModel;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author vinsfran
 */
@Component("telefonoConverter")
public class TelefonoConverter {

    public Telefono convertTelefonoModelToTelefono(TelefonoModel telefonoModel) {
        Telefono telefono = new Telefono(telefonoModel.getId(),
                telefonoModel.getNombre());
        return telefono;
    }

    public List<Telefono> convertTelefonosModelToTelefonos(List<TelefonoModel> tiposTelefonoesModel) {
        List<Telefono> tiposTelefonoes = new ArrayList<>();
        for (TelefonoModel telefonoModel : tiposTelefonoesModel) {
            tiposTelefonoes.add(convertTelefonoModelToTelefono(telefonoModel));
        }
        return tiposTelefonoes;
    }

    public TelefonoModel convertTelefonoToTelefonoModel(Telefono telefono) {
        TelefonoModel telefonoModel = new TelefonoModel(telefono.getId(),
                telefono.getNumero());
        return telefonoModel;
    }

    public List<TelefonoModel> convertTelefonosToTelefonosModel(List<Telefono> telefonos) {
        List<TelefonoModel> tiposTelefonosModel = new ArrayList<>();
        for (Telefono telefono : telefonos) {
            tiposTelefonosModel.add(convertTelefonoToTelefonoModel(telefono));
        }
        return tiposTelefonosModel;
    }

}
