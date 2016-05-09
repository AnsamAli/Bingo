package tests;

import bingo.Space;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Tests for methods involving individual spaces on a board
 */
public class SpaceTest {
    @Test
    public void testToDrawing() {
        Space b4 = new Space(0, 2, 4, true);
        Space n36 = new Space(2, 1, 36, false);
        Space i19 = new Space(1, 4, 19, false);

        assertEquals("B4", b4.toDrawing());
        assertEquals("N36", n36.toDrawing());
        assertEquals("I19", i19.toDrawing());
        System.out.println(new Space(3, 0, 50, true).toDrawing());
    }
}
