/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chat.util;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author libiun
 */
public class CharacterUtilTest {

    public CharacterUtilTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

  @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        assertEquals(true, CharacterUtil.isEmpty(""));
        assertEquals(true, CharacterUtil.isEmpty("  "));
        assertEquals(false, CharacterUtil.isEmpty("adf"));
        assertEquals(false, CharacterUtil.isEmpty("3454"));
    }

    @Test
    public void testIsNumber() {
        System.out.println("isNumber");
        assertEquals(false, CharacterUtil.isNumber("42423t"));
        assertEquals(false, CharacterUtil.isNumber("t42423"));
        assertEquals(true, CharacterUtil.isNumber("648454"));
    }

    @Test
    public void testIsPortCorrect() {
        System.out.println("isPortCorrect");
        assertEquals(false, CharacterUtil.isPortCorrect("1024"));
        assertEquals(false, CharacterUtil.isPortCorrect("65536"));
        assertEquals(false, CharacterUtil.isPortCorrect("90"));
        assertEquals(true, CharacterUtil.isPortCorrect("1025"));
    }
}
