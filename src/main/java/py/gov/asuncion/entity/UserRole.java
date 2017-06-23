package py.gov.asuncion.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author vinsfran
 */
@Entity
@Table(name = "user_roles", uniqueConstraints = @UniqueConstraint(columnNames = {"role", "username"}))
public class UserRole {

    @Id
    @GeneratedValue
    @Column(name = "user_role_id", unique = true, nullable = false)
    private Integer userRoleId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "username", nullable = false)
    private User user;

    @Column(name = "role", nullable = false, length = 45)
    private String role;

    /**
     *
     * @param user
     * @param role
     */
    public UserRole(User user, String role) {
        super();
        this.user = user;
        this.role = role;
    }

    /**
     *
     */
    public UserRole() {
    }

    /**
     *
     * @return
     */
    public Integer getUserRoleId() {
        return userRoleId;
    }

    /**
     *
     * @param userRoleId
     */
    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    /**
     *
     * @return
     */
    public User getUser() {
        return user;
    }

    /**
     *
     * @param user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     *
     * @return
     */
    public String getRole() {
        return role;
    }

    /**
     *
     * @param role
     */
    public void setRole(String role) {
        this.role = role;
    }

}
