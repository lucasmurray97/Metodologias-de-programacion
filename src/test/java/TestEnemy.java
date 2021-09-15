
import com.example.aventurasdemarcoyluis.Boo;
import com.example.aventurasdemarcoyluis.Enemies;
import com.example.aventurasdemarcoyluis.Goomba;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class TestEnemy {

    private Enemies testGoomba;
    private Enemies testBoo;

    @BeforeEach
    public void setUp() {
        testGoomba= new Goomba(0);
        testBoo = new Boo(0);
    }

    @Test
    public void constructorTest(){
        assertEquals("Boo",testBoo.getType());
        assertEquals("Goomba",testGoomba.getType());
    }
}
