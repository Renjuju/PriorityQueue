import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class BlahTest {

    @Test
    public void testmin1() {
        assertEquals(Blah.min(0,1), 0);
    }

    @Test
    public void testshouldfail() {
        assertEquals(Blah.min(0,1), 34);
    }
}
