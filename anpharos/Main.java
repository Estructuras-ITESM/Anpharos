package anpharos;
import javax.swing.*;
import java.util.Hashtable;
import anpharos.app.*;
public class Main {

    public static void main(String[] strings)
    {
        Hashtable<Integer,Usuario> hash = new Hashtable<Integer,Usuario>();
        Login l = new Login(hash);
    }
}
