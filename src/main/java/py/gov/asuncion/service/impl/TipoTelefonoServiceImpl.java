package py.gov.asuncion.service.impl;

import py.gov.asuncion.converter.TipoTelefonoConverter;
import py.gov.asuncion.entity.TipoTelefono;
import py.gov.asuncion.model.TipoTelefonoModel;
import py.gov.asuncion.repository.TipoTelefonoRepository;
import py.gov.asuncion.service.TipoTelefonoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author vinsfran
 */
@Service("tipoTelefonoServiceImpl")
public class TipoTelefonoServiceImpl implements TipoTelefonoService {

    @Autowired
    @Qualifier("tipoTelefonoRepository")
    private TipoTelefonoRepository tipoTelefonoRepository;

    @Autowired
    @Qualifier("tipoTelefonoConverter")
    private TipoTelefonoConverter tipoTelefonoConverter;

    @Override
    public TipoTelefonoModel addTipoTelefono(TipoTelefonoModel tipoTelefonoModel) {
        TipoTelefono tipoTelefono = tipoTelefonoRepository.save(tipoTelefonoConverter.convertTipoTelefonoModelToTipoTelefono(tipoTelefonoModel));
        return tipoTelefonoConverter.convertTipoTelefonoToTipoTelefonoModel(tipoTelefono);
    }

//    @PreAuthorize("hasRole('ROLE_USER')")

    @Override
    public List<TipoTelefonoModel> listAllTiposTelefonos() {
        return tipoTelefonoConverter.convertTiposTelefonoesToTiposTelefonoesModel(tipoTelefonoRepository.findAll());
    }

    @Override
    public TipoTelefono findTipoTelefonoById(int id) {
        return tipoTelefonoRepository.findById(id);
    }

    @Override
    public TipoTelefonoModel findTipoTelefonoModelById(int id) {
        return tipoTelefonoConverter.convertTipoTelefonoToTipoTelefonoModel(findTipoTelefonoById(id));
    }

    @Override
    public void removeTipoTelefono(int id) {
        TipoTelefono tipoTelefono = findTipoTelefonoById(id);
        if (tipoTelefono != null) {
            tipoTelefonoRepository.delete(tipoTelefono);
        }
    }

}
