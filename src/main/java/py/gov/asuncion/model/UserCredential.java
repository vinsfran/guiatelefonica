package py.gov.asuncion.model;

/**
 *
 * @author vinsfran
 */
public class UserCredential {
    
    private String username; 
    private String password; 

    /**
     *
     */
    public UserCredential() {
    }
    
    /**
     *
     * @param username
     * @param password
     */
    public UserCredential(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }    
    
    /**
     *
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }   

    @Override
    public String toString() {
        return "UserCredential [username=" + username + ", password=" + password + "]";
    }
    
}
