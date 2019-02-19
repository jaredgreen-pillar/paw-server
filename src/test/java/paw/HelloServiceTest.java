package paw;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class HelloServiceTest {

    @Test
    public void retrieveHelloWorldStatementReturnsHelloWorldStatement() {
        HelloService helloService = new HelloService();

        String helloWorldStatement = helloService.retrieveHelloWorldStatement();

        assertThat(helloWorldStatement, is("Hello World!"));
    }

}