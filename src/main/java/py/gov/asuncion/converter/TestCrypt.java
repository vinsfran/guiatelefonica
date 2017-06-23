package py.gov.asuncion.converter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author vinsfran
 */
public class TestCrypt {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
        System.out.println(pe.encode("user"));
    }
}
