package basic.javautil;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author libiun
 */
public class PropertiesTest {

    public static void main(String[] args) {
        Properties p = System.getProperties();
        Set set = p.keySet();
        for (Iterator i = set.iterator(); i.hasNext();) {
            String key = (String) i.next();
            String value = p.getProperty(key);
            System.out.println(key + "=" + value);
        }

        try {
            p.list(new PrintStream("resource/printstream.txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PropertiesTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}