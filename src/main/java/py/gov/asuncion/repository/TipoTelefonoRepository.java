package py.gov.asuncion.repository;

import py.gov.asuncion.entity.TipoTelefono;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author vinsfran
 */
@Repository("tipoTelefonoRepository")
public interface TipoTelefonoRepository extends JpaRepository<TipoTelefono, Serializable> {

    /**
     *
     * @param id
     * @return
     */
    public abstract TipoTelefono findById(int id);

}