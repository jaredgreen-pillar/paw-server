package paw;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private HelloService mockHelloService;

    @Test
    public void shouldReturnServiceHelloWorldStatement() throws Exception {
        when(mockHelloService.retrieveHelloWorldStatement()).thenReturn("Hello PillarCon");

        mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello PillarCon")));
    }

    @Test
    public void shouldSaveArtToHelloService() throws Exception {
        Art artPiece = new Art("some text");

        mockMvc.perform(post("/art")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(artPiece)))
                .andExpect(status().isOk());

        verify(mockHelloService, times(1)).saveArt((artPiece));
    }

    @Test
    public void getArtShouldReturnAllArt() throws Exception {
        ArrayList<Art> retrievedArt = new ArrayList<>();
        Art artwork = new Art("macaroni necklace");
        retrievedArt.add(artwork);

        String retrievedArtAsString = objectMapper.writeValueAsString(retrievedArt);

        when(mockHelloService.retrieveArt()).thenReturn(retrievedArt);

        mockMvc.perform(get("/art"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(retrievedArtAsString)));
    }
}