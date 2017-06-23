package py.gov.asuncion.converter;

import py.gov.asuncion.entity.Contact;
import py.gov.asuncion.model.ContactModel;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author vinsfran
 */
@Component("contactConverter")
public class ContactConverter {

    /**
     *
     * @param contactModel
     * @return
     */
    public Contact convertContactModelToContact(ContactModel contactModel) {
        Contact contact = new Contact(contactModel.getId(),
                contactModel.getFirstname(),
                contactModel.getLastname(),
                contactModel.getTelephone(),
                contactModel.getCity());
        return contact;
    }

    /**
     *
     * @param contactsModel
     * @return
     */
    public List<Contact> convertContactsModelToContacts(List<ContactModel> contactsModel) {
        List<Contact> contacts = new ArrayList<>();
        for (ContactModel contactModel : contactsModel) {
            contacts.add(convertContactModelToContact(contactModel));
        }
        return contacts;
    }

    /**
     *
     * @param contact
     * @return
     */
    public ContactModel convertContactToContactModel(Contact contact) {
        ContactModel contactModel = new ContactModel(contact.getId(),
                contact.getFirstname(),
                contact.getLastname(),
                contact.getTelephone(),
                contact.getCity());
        return contactModel;
    }

    /**
     *
     * @param contacts
     * @return
     */
    public List<ContactModel> convertContactsToContactsModel(List<Contact> contacts) {
        List<ContactModel> contactsModel = new ArrayList<>();
        for (Contact contact : contacts) {
            contactsModel.add(convertContactToContactModel(contact));
        }
        return contactsModel;
    }

}
