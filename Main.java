import javax.swing.*;
import java.util.Hashtable;

public class Main {

    public static JFrame ventana;

    private static Hashtable<Integer, SingleLinkedList<String>> hashTable;
    private static SingleLinkedList<String> password;

    public static void main(String[] strings)
    {
        password = new SingleLinkedList<String>();
        hashTable= new Hashtable<Integer, SingleLinkedList<String>>();
        password.addFirst("usuario");
        hashTable.put("usuario".hashCode(),password);
        ventana = new JFrame();
        ventana.setTitle("Proyecto Sphero");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(1000,1000);
        ventana.setContentPane(new Registro().getLogIn());
        ventana.setVisible(true);

    }

    public static void entrar()
    {
       Anpharos a = new Anpharos();   //Aquí se tiene que abrir la ventana de Anpharos
        ventana.setVisible(true);

    }

    public static void agregarTabla(String texto, char[] contra)
    {
        String password = new String(contra);

        if(hashTable.get(texto.hashCode())!=null) {
            hashTable.get(texto.hashCode()).addLast(password);
        }
        else
        {
           SingleLinkedList<String> lista = new SingleLinkedList<String>();
            lista.addLast(password);
            hashTable.put(texto.hashCode(), lista);
        }
    }

    public static SingleLinkedList<String> getUsuario(int usuario)
    {
        if(hashTable.get(usuario) == null) {
            SingleLinkedList<String> vacio = new SingleLinkedList<>();
            vacio.addLast("");
            return vacio;
        }
        return hashTable.get(usuario);
    }

    public static Hashtable<Integer,SingleLinkedList<String>> gethashTable()
    {
        return hashTable;
    }

}
