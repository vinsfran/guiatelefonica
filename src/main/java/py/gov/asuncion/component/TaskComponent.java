package py.gov.asuncion.component;

import py.gov.asuncion.controller.ContactController;
import java.util.Date;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component("taskComponent")
public class TaskComponent {

    public static final Log LOG = LogFactory.getLog(ContactController.class);

    @Scheduled(fixedDelay = 5000)
    public void doTask() {
        LOG.info("TIME IS: " + new Date());
    }

}
