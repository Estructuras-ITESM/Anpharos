import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Login extends JFrame{

    private Hashtable<Integer,Usuario> usuarios;
    private JLabel usuario, contrasena;
    private JButton registrarse, entrar;
    private JTextField u, co;

    public Login(Hashtable hashtable){
        usuarios = hashtable;
        setTitle("Registro");
        setSize(300,100);
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        initComponents(c);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void initComponents(GridBagConstraints c){
        usuario = new JLabel("Usuario: ");
        contrasena = new JLabel("Contraseña: ");
        u = new JTextField(6);
        co = new JTextField(6);
        registrarse = new JButton("Crear");
        entrar = new JButton("Entrar");

        c.fill = GridBagConstraints.BOTH;
        c.weighty = 1.0;
        c.weightx = 1.0;
        c.gridwidth = 1;
        c.gridheight = 1;

        c.gridx = 0;
        c.gridy = 0;
        add(usuario,c);

        c.gridy = 1;
        add(contrasena,c);

        c.gridy = 2;
        add(registrarse,c);

        c.gridx = 1;
        add(entrar,c);

        c.gridy = 1;
        add(co,c);

        c.gridy = 0;
        add(u,c);
    }

    public static void main(String[] args) {
        Hashtable<Integer,Usuario> hash = new Hashtable<Integer,Usuario>();
        Login l = new Login(hash);
  }

}
