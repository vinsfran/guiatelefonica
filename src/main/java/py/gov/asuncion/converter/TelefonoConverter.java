package py.gov.asuncion.converter;

import py.gov.asuncion.entity.Telefono;
import py.gov.asuncion.model.TelefonoModel;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import py.gov.asuncion.entity.TipoTelefono;
import py.gov.asuncion.service.TipoTelefonoService;

/**
 *
 * @author vinsfran
 */
@Component("telefonoConverter")
public class TelefonoConverter {

    @Autowired
    @Qualifier("tipoTelefonoServiceImpl")
    private TipoTelefonoService tipoTelefonoService;

    public Telefono convertTelefonoModelToTelefono(TelefonoModel telefonoModel) {

        TipoTelefono tipoTelefono = tipoTelefonoService.findTipoTelefonoById(telefonoModel.getTipoTelefonoId().getId());

        Telefono telefono = new Telefono(telefonoModel.getId(),
                telefonoModel.getNombre(),
                tipoTelefono
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
