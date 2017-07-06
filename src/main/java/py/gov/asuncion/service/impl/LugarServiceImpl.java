package py.gov.asuncion.service.impl;

import py.gov.asuncion.converter.LugarConverter;
import py.gov.asuncion.entity.Lugar;
import py.gov.asuncion.model.LugarModel;
import py.gov.asuncion.repository.LugarRepository;
import py.gov.asuncion.service.LugarService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author vinsfran
 */
@Service("lugarServiceImpl")
public class LugarServiceImpl implements LugarService {

    @Autowired
    @Qualifier("lugarRepository")
    private LugarRepository lugarRepository;

    @Autowired
    @Qualifier("lugarConverter")
    private LugarConverter lugarConverter;

    @Override
    public LugarModel addLugar(LugarModel lugarModel) {
        Lugar lugar = lugarRepository.save(lugarConverter.convertLugarModelToLugar(lugarModel));
        return lugarConverter.convertLugarToLugarModel(lugar);
    }

//    @PreAuthorize("hasRole('ROLE_USER')")

    @Override
    public List<LugarModel> listAllLugares() {
        return lugarConverter.convertLugaresToLugaresModel(lugarRepository.findAll());
    }

    @Override
    public Lugar findLugarById(int id) {
        return lugarRepository.findById(id);
    }

    @Override
    public LugarModel findLugarModelById(int id) {
        return lugarConverter.convertLugarToLugarModel(findLugarById(id));
    }

    @Override
    public void removeLugar(int id) {
        Lugar lugar = findLugarById(id);
        if (lugar != null) {
            lugarRepository.delete(lugar);
        }
    }

}
