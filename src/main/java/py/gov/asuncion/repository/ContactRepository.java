package py.gov.asuncion.repository;

import py.gov.asuncion.entity.Contact;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author vinsfran
 */
@Repository("contactRepository")
public interface ContactRepository extends JpaRepository<Contact, Serializable> {

    /**
     *
     * @param id
     * @return
     */
    public abstract Contact findById(int id);

}