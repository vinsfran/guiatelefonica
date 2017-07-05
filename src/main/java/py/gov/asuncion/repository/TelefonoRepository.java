package py.gov.asuncion.repository;

import py.gov.asuncion.entity.Telefono;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author vinsfran
 */
@Repository("telefonoRepository")
public interface TelefonoRepository extends JpaRepository<Telefono, Serializable> {

    /**
     *
     * @param id
     * @return
     */
    public abstract Telefono findById(int id);

}