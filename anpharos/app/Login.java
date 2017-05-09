package anpharos.app;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

import anpharos.gui.Anpharos;

public class Login extends JFrame implements ActionListener, Serializable{

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
        registrarse.addActionListener(this);
        registrarse.setActionCommand("registrarse");
        entrar = new JButton("Entrar");
        entrar.addActionListener(this);
        entrar.setActionCommand("entrar");

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

    public void actionPerformed(ActionEvent e){
        String nombre = u.getText();
        String contra = co.getText();
        int hash = nombre.hashCode();
        if ("entrar".equals(e.getActionCommand())) {
            if (usuarios.get(hash) != null) {
                Usuario u = usuarios.get(hash);
                if (u.getContrasena().equals(contra)) {
                Anpharos a = new Anpharos(u,usuarios);
                //serialize(usuarios);
                dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Usuario incorrecto o inexistente");
            }
        }else if ("registrarse".equals(e.getActionCommand())) {
            if (usuarios.get(hash) == null) {
                Usuario u = new Usuario(nombre, contra);
                usuarios.put(hash,u);
                Anpharos a = new Anpharos(u,usuarios);
                JOptionPane.showMessageDialog(null, "Tu cuenta ha sido creada");
                //serialize(usuarios);
                dispose();
            }else{
                JOptionPane.showMessageDialog(null, "Esa cuenta ya existe");
            }
        }
    }
    /*
    public void serialize(Hashtable<Integer,Usuario> usuarios){
        try {
            FileOutputStream fileOut =   new FileOutputStream("UsuarioBD.sph");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(usuarios);
            out.close();
            fileOut.close();
        }catch(IOException i) {
            i.printStackTrace();
        }
    }*/

    public static void main(String[] args) {
        try{
          FileInputStream fis = new FileInputStream("UsuarioBD.sph");
          ObjectInputStream ois = new ObjectInputStream(fis);
          Hashtable<Integer,Usuario> hashTable = (Hashtable<Integer,Usuario>) ois.readObject();
          ois.close();
          fis.close();
          Login l = new Login(hashTable);
        }catch(IOException i){
          JOptionPane.showMessageDialog(null, "ERROR: No existe el archivo");
          Hashtable<Integer,Usuario> ht = new Hashtable<Integer,Usuario>();
          String n = "Hola2";
          String contr = "hOla1";
          ht.put(n.hashCode(), new Usuario(n, contr));
          Login l = new Login(ht);
        }catch(ClassNotFoundException c){
          c.printStackTrace();
        }
    }

}
