package py.gov.asuncion.service.impl;

import py.gov.asuncion.converter.TelefonoConverter;
import py.gov.asuncion.entity.Telefono;
import py.gov.asuncion.model.TelefonoModel;
import py.gov.asuncion.repository.TelefonoRepository;
import py.gov.asuncion.service.TelefonoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author vinsfran
 */
@Service("telefonoServiceImpl")
public class TelefonoServiceImpl implements TelefonoService {

    @Autowired
    @Qualifier("telefonoRepository")
    private TelefonoRepository telefonoRepository;

    @Autowired
    @Qualifier("telefonoConverter")
    private TelefonoConverter telefonoConverter;

    @Override
    public TelefonoModel addTelefono(TelefonoModel telefonoModel) {
        Telefono telefono = telefonoRepository.save(telefonoConverter.convertTelefonoModelToTelefono(telefonoModel));
        return telefonoConverter.convertTelefonoToTelefonoModel(telefono);
    }

//    @PreAuthorize("hasRole('ROLE_USER')")

    @Override
    public List<TelefonoModel> listAllTelefonos() {
        return telefonoConverter.convertTelefonosToTelefonosModel(telefonoRepository.findAll());
    }

    @Override
    public Telefono findTelefonoById(int id) {
        return telefonoRepository.findById(id);
    }

    @Override
    public TelefonoModel findTelefonoModelById(int id) {
        return telefonoConverter.convertTelefonoToTelefonoModel(findTelefonoById(id));
    }

    @Override
    public void removeTelefono(int id) {
        Telefono telefono = findTelefonoById(id);
        if (telefono != null) {
            telefonoRepository.delete(telefono);
        }
    }

}
