package py.gov.asuncion.service.impl;

import py.gov.asuncion.converter.TipoLugarConverter;
import py.gov.asuncion.entity.TipoLugar;
import py.gov.asuncion.model.TipoLugarModel;
import py.gov.asuncion.repository.TipoLugarRepository;
import py.gov.asuncion.service.TipoLugarService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author vinsfran
 */
@Service("tipoLugarServiceImpl")
public class TipoLugarServiceImpl implements TipoLugarService {

    @Autowired
    @Qualifier("tipoLugarRepository")
    private TipoLugarRepository tipoLugarRepository;

    @Autowired
    @Qualifier("tipoLugarConverter")
    private TipoLugarConverter tipoLugarConverter;

    @Override
    public TipoLugarModel addTipoLugar(TipoLugarModel tipoLugarModel) {
        TipoLugar tipoLugar = tipoLugarRepository.save(tipoLugarConverter.convertTipoLugarModelToTipoLugar(tipoLugarModel));
        return tipoLugarConverter.convertTipoLugarToTipoLugarModel(tipoLugar);
    }

//    @PreAuthorize("hasRole('ROLE_USER')")

    @Override
    public List<TipoLugarModel> listAllTiposLugares() {
        return tipoLugarConverter.convertTiposLugaresToTiposLugaresModel(tipoLugarRepository.findAll());
    }

    @Override
    public TipoLugar findTipoLugarById(int id) {
        return tipoLugarRepository.findById(id);
    }

    @Override
    public TipoLugarModel findTipoLugarModelById(int id) {
        return tipoLugarConverter.convertTipoLugarToTipoLugarModel(findTipoLugarById(id));
    }

    @Override
    public void removeTipoLugar(int id) {
        TipoLugar tipoLugar = findTipoLugarById(id);
        if (tipoLugar != null) {
            tipoLugarRepository.delete(tipoLugar);
        }
    }

}
