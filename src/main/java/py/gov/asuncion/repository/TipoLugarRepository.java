package py.gov.asuncion.repository;

import py.gov.asuncion.entity.TipoLugar;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author vinsfran
 */
@Repository("tipoLugarRepository")
public interface TipoLugarRepository extends JpaRepository<TipoLugar, Serializable> {

    /**
     *
     * @param id
     * @return
     */
    public abstract TipoLugar findById(int id);

}