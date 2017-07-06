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
                telefonoModel.getNombre(),
                telefonoModel.getTipoTelefonoId()
        );
        return telefono;
    }

    public List<Telefono> convertTelefonosModelToTelefonos(List<TelefonoModel> tiposTelefonoesModel) {
        List<Telefono> telefonos = new ArrayList<>();
        for (TelefonoModel telefonoModel : tiposTelefonoesModel) {
            telefonos.add(convertTelefonoModelToTelefono(telefonoModel));
        }
        return telefonos;
    }

    public TelefonoModel convertTelefonoToTelefonoModel(Telefono telefono) {
        TelefonoModel telefonoModel = new TelefonoModel(telefono.getId(),
                telefono.getNumero(),
                telefono.getTipoTelefonoId()
        );
        return telefonoModel;
    }

    public List<TelefonoModel> convertTelefonosToTelefonosModel(List<Telefono> telefonos) {
        List<TelefonoModel> telefonosModel = new ArrayList<>();
        for (Telefono telefono : telefonos) {
            telefonosModel.add(convertTelefonoToTelefonoModel(telefono));
        }
        return telefonosModel;
    }

}
