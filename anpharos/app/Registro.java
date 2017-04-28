package anpharos.app;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import anpharos.Main;
import anpharos.structures.Node;

public class Registro
{
    private JPanel LogIn;
    private JPasswordField passwordField1;
    private JTextField textField;
    private JButton entrar;
    private JButton registrarButton;
    private JFrame registro;


    public Registro()
    {
      //  passwordField1.setSize(new Dimension(100,100));
        registro = new JFrame();

        entrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               //
                if(textField.getText().length()>0 && validate() &&passwordField1.getPassword().length>0)
                    Main.entrar();
                else if(passwordField1.getPassword().length<1 || textField.getText().length()<1)
                    JOptionPane.showMessageDialog(null, "Debes ingresar todos los datos");
                else
                    JOptionPane.showMessageDialog(null, "Registrate para acceder");

            }
        });
        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                registro.setSize(300,250);
                registro.setContentPane(new Registrarse().getRegistro());
                registro.setLocation(800,200);
                registro.setVisible(true);


            }
        });
    }

    public JPanel getLogIn() {
        return LogIn;

    }
    public boolean validate()
    {
       int x = (int)Main.getUsuario(textField.getText().hashCode()).getSize();
        String user = "";
        Node<String> temporal =Main.getUsuario(textField.getText().hashCode()).getFirst() ;
        for(int i = 0; i<x; i++)
        {
            if( temporal.getElement().equals(new String(passwordField1.getPassword())) )
                    return true;
            temporal = temporal.getNext();
        }
        return false;
    }

}
