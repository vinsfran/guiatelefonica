package py.gov.asuncion.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author vinsfran
 */
@Entity
@Table(name = "log")
public class Log {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    
    @Column(name = "date")
    private Date date;
    
    @Column(name = "details")
    private String details;
    
    @Column(name = "username")
    private String username;
    
    @Column(name = "url")
    private String url;

    /**
     *
     */
    public Log() {
    }

    /**
     *
     * @param date
     * @param details
     * @param username
     * @param url
     */
    public Log(Date date, String details, String username, String url) {
        this.date = date;
        this.details = details;
        this.username = username;
        this.url = url;
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
    public Date getDate() {
        return date;
    }

    /**
     *
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     *
     * @return
     */
    public String getDetails() {
        return details;
    }

    /**
     *
     * @param details
     */
    public void setDetails(String details) {
        this.details = details;
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
    public String getUrl() {
        return url;
    }

    /**
     *
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }
    
    

}
