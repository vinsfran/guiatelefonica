package py.gov.asuncion.repository;

import py.gov.asuncion.entity.Log;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author vinsfran
 */
@Repository("logRepository")
public interface LogRepository extends JpaRepository<Log, Serializable>{

}
