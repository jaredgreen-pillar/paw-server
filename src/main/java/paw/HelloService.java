package paw;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class HelloService {

    public ArrayList<Art> savedArt = new ArrayList<>();

    public String retrieveHelloWorldStatement() {
        return "Hello World!";
    }

    public void saveArt(Art artwork) {
        this.savedArt.add(artwork);
    }
}
