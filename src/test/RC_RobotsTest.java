package robotcontrollertest;

import robotcontroller.RC_Robots;
import org.junit.Test;

import static org.junit.Assert.*;

public class RC_RobotsTest {

    @Test
    public void testTurnLeft() {
        assertEquals('W', RC_Robots.turnLeft('N'));
        assertEquals('S', RC_Robots.turnLeft('W'));
        assertEquals('E', RC_Robots.turnLeft('S'));
        assertEquals('N', RC_Robots.turnLeft('E'));
    }

    @Test
    public void testTurnRight() {
        assertEquals('E', RC_Robots.turnRight('N'));
        assertEquals('S', RC_Robots.turnRight('E'));
        assertEquals('W', RC_Robots.turnRight('S'));
        assertEquals('N', RC_Robots.turnRight('W'));
    }

    @Test
    public void testMoveForward() {
        assertArrayEquals(new int[]{1, 1}, RC_Robots.moveForward(1, 0, 'N'));
        assertArrayEquals(new int[]{2, 0}, RC_Robots.moveForward(1, 0, 'E'));
        assertArrayEquals(new int[]{1, -1}, RC_Robots.moveForward(1, 0, 'S'));
        assertArrayEquals(new int[]{0, 0}, RC_Robots.moveForward(1, 0, 'W'));
    }

    @Test
    public void testIsWithinBounds() {
        assertTrue(RC_Robots.isWithinBounds(1, 1, 5, 5));
        assertFalse(RC_Robots.isWithinBounds(-1, 1, 5, 5));
        assertFalse(RC_Robots.isWithinBounds(1, -1, 5, 5));
        assertFalse(RC_Robots.isWithinBounds(6, 1, 5, 5));
        assertFalse(RC_Robots.isWithinBounds(1, 6, 5, 5));
    }
}
