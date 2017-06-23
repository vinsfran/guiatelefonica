package py.gov.asuncion.repository;

import py.gov.asuncion.entity.User;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author vinsfran
 */
@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Serializable>{
    
    /**
     *
     * @param username
     * @return
     */
    public abstract User findByUsername(String username);
    
}