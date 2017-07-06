package py.gov.asuncion.repository;

import py.gov.asuncion.entity.Lugar;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author vinsfran
 */
@Repository("lugarRepository")
public interface LugarRepository extends JpaRepository<Lugar, Serializable> {

    /**
     *
     * @param id
     * @return
     */
    public abstract Lugar findById(int id);

}