package collections.map;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemo {
    public static void main(String[] args) throws IOException {
        Properties p = new Properties();
        FileInputStream fis = new FileInputStream("C:\\Users\\vicky\\Desktop\\Java Programs\\Java\\src\\collections\\map\\abc.properties");
        p.load(fis);
        System.out.println(p);
        String s = p.getProperty("venki");
        System.out.println(s);
        p.setProperty("nag", "8888");
        FileOutputStream fos = new FileOutputStream("abc.properties");
        p.store(fos, "Updated by Vikas");
    }
}
