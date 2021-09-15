import com.example.aventurasdemarcoyluis.Luigi;
import com.example.aventurasdemarcoyluis.Marcos;
import com.example.aventurasdemarcoyluis.Luigi;
import com.example.aventurasdemarcoyluis.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class TestPlayer {

    private Player testMarcos;
    private Player testLuigi;

    @BeforeEach
    public void setUp() {
        testMarcos= new Marcos(0);
        testLuigi = new Luigi(0);
    }

    @Test
    public void constructorTest(){
        assertEquals("Luigi",testLuigi.getType());
        assertEquals("Marcos",testMarcos.getType());
    }
}
