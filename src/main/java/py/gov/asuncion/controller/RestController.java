package py.gov.asuncion.controller;

import py.gov.asuncion.model.ContactModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author vinsfran
 */
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {
    
    /**
     *
     * @return
     */
    @GetMapping("checkrest")
    public ResponseEntity<ContactModel> checkRest(){
        ContactModel cm = new ContactModel(2, "Mikel", "Perez", "321213", "Asu");
        return new ResponseEntity<ContactModel>(cm, HttpStatus.OK);
    } 
}
