package py.gov.asuncion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 *
 * @author vinsfran
 */
@SpringBootApplication
@EnableScheduling
public class BackendninjaApplication {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(BackendninjaApplication.class, args);
    }
}
