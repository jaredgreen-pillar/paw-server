package paw;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ArtTest {
    @Test
    public void equalsReturnsTrueWhenPropertiesAreEqual() {
        Art artworkOne = new Art("macaroni necklace");
        Art artworkTwo = new Art("macaroni necklace");

        assertTrue(artworkOne.equals(artworkTwo));
    }

    @Test
    public void equalsReturnsFalseWhenPropertiesAreNotEqual() {
        Art artworkOne = new Art("macaroni necklace");
        Art artworkTwo = new Art("spaghetti sneakers");

        assertFalse(artworkOne.equals(artworkTwo));
    }

    @Test
    public void equalsReturnsFalseWhenObjectIsNull() {
        Art artworkOne = new Art("macaroni necklace");
        Art artworkTwo = null;

        assertFalse(artworkOne.equals(artworkTwo));
    }

    @Test
    public void equalsReturnsFalseWhenObjectIsNotAssignableToArt() {
        Art artworkOne = new Art("macaroni necklace");
        HashMap<String, String> artworkTwo = new HashMap<>();
        artworkTwo.put("text", "macaroni necklace");

        assertFalse(artworkOne.equals(artworkTwo));
    }

    @Test
    public void equalsReturnsFalseWhenArtTextPropertyIsNull() {
        Art artworkOne = new Art();
        Art artworkTwo = new Art("macaroni necklace");

        assertFalse(artworkOne.equals(artworkTwo));
    }
}
