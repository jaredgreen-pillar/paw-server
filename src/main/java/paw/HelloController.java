package paw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping("/")
    public String helloWorld() {
        return helloService.retrieveHelloWorldStatement();
    }

    @PostMapping("/saveText")
    public ResponseEntity<?> saveText(@RequestBody Art art) {
       return new ResponseEntity<>(art, HttpStatus.OK);
    }
}
