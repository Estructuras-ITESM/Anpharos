package anpharos.app;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import anpharos.Main;

public class Registrarse extends Registro{
    private JPanel registro;
    private JButton guardarButton;
    private JTextField usuario;
    private JButton registrarButton;
    private JPasswordField passField;
    private JPasswordField passField1;

    public Registrarse() {

        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(usuario.getText().length()>0 && passField.getPassword().length>0 && Arrays.equals(passField.getPassword(),passField1.getPassword())) {
                    JOptionPane.showMessageDialog(null, "Registro exitoso");
                    Main.agregarTabla(usuario.getText(),passField.getPassword());
                }
                else if(usuario.getText().length()==0 ||passField.getPassword().length==0 ||passField1.getPassword().length==0 )
                {

                    JOptionPane.showMessageDialog(null, "Faltan datos");
                }
                else
                    JOptionPane.showMessageDialog(null, "Los passwords no coinciden");

            }
        });
    }

    public JPanel getRegistro() {
        return registro;

    }

}