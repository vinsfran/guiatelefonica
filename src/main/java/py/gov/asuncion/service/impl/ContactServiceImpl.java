package py.gov.asuncion.service.impl;

import py.gov.asuncion.converter.ContactConverter;
import py.gov.asuncion.entity.Contact;
import py.gov.asuncion.model.ContactModel;
import py.gov.asuncion.repository.ContactRepository;
import py.gov.asuncion.service.ContactService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

/**
 *
 * @author vinsfran
 */
@Service("contactServiceImpl")
public class ContactServiceImpl implements ContactService {

    @Autowired
    @Qualifier("contactRepository")
    private ContactRepository contactRepository;

    @Autowired
    @Qualifier("contactConverter")
    private ContactConverter contactConverter;

    /**
     *
     * @param contactModel
     * @return
     */
    @Override
    public ContactModel addContact(ContactModel contactModel) {
        Contact contact = contactRepository.save(contactConverter.convertContactModelToContact(contactModel));
        return contactConverter.convertContactToContactModel(contact);
    }

//    @PreAuthorize("hasRole('ROLE_USER')")

    /**
     *
     * @return
     */
    @Override
    public List<ContactModel> listAllContacts() {
        return contactConverter.convertContactsToContactsModel(contactRepository.findAll());
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Contact findContactById(int id) {
        return contactRepository.findById(id);
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public ContactModel findContactModelById(int id) {
        return contactConverter.convertContactToContactModel(findContactById(id));
    }

    /**
     *
     * @param id
     */
    @Override
    public void removeContact(int id) {
        Contact contact = findContactById(id);
        if (contact != null) {
            contactRepository.delete(contact);
        }

    }

}
