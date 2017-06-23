package py.gov.asuncion.model;

/**
 *
 * @author vinsfran
 */
public class ContactModel {

    private int id;
    private String firstname;
    private String lastname;
    private String telephone;
    private String city;

    /**
     *
     */
    public ContactModel() {
    }

    /**
     *
     * @param id
     * @param firstname
     * @param lastname
     * @param telephone
     * @param city
     */
    public ContactModel(int id, String firstname, String lastname, String telephone, String city) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.telephone = telephone;
        this.city = city;
    }

    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     *
     * @param firstname
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     *
     * @return
     */
    public String getLastname() {
        return lastname;
    }

    /**
     *
     * @param lastname
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     *
     * @return
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     *
     * @param telephone
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     *
     * @return
     */
    public String getCity() {
        return city;
    }

    /**
     *
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "ContactModel{" + "id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", telephone=" + telephone + ", city=" + city + '}';
    }
    
}
