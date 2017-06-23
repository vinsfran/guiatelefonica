package py.gov.asuncion.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author vinsfran
 */
@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "username", unique = true, nullable = false, length = 45)
    private String username;
    
    @Column(name = "password", nullable = false, length = 60)
    private String password;
    
    @Column(name = "enabled", nullable = false)
    private boolean enabled;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private Set<UserRole> userRole = new HashSet<UserRole>();

    /**
     *
     * @param username
     * @param password
     * @param enabled
     */
    public User(String username, String password, boolean enabled) {
        super();
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }

    /**
     *
     * @param username
     * @param password
     * @param enabled
     * @param userRole
     */
    public User(String username, String password, boolean enabled, Set<UserRole> userRole) {
        super();
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.userRole = userRole;
    }

    /**
     *
     */
    public User() {
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

    /**
     *
     * @return
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     *
     * @param enabled
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /**
     *
     * @return
     */
    public Set<UserRole> getUserRole() {
        return userRole;
    }

    /**
     *
     * @param userRole
     */
    public void setUserRole(Set<UserRole> userRole) {
        this.userRole = userRole;
    }   

}
