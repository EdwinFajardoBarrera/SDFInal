/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bosaDeValores;

import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Edwin Fajardo
 */
public class UserClient {

    static GraphicsConfiguration gc;

    public static void main(String[] args) {

        //CREACION DEL JFRAME
        JFrame frame = new JFrame(gc);
        frame.setTitle("Inicio de sesión");
        frame.setSize(600, 400);
        frame.setLocation(500, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton btn = new JButton("Iniciar sesion");
        JLabel lbl = new JLabel("Ingrese su RFC de cliente");
        JTextField tf = new JTextField("", 10);
        frame.add(lbl);
        frame.add(tf);
        frame.add(btn);
        GridLayout gl = new GridLayout(3, 1);
        gl.setHgap(100);
        frame.setLayout(gl);
        frame.setVisible(true);
        
        
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //lbl.setText("Name has been submitted.");
                try {

                    String username = tf.getText();
                    Registry registry = LocateRegistry.getRegistry("127.0.0.1");
                    IRemoteUser re = (IRemoteUser) registry.lookup("User");
                    //User bmc = new User("AA12001083", "AA10000000");
                    Boolean userExists = re.getUser(username);

                    if (userExists) {
                        lbl.setText("BIENVENIDO!");
                        
                        //INTERFAZ PARA LISTA DE INVERSIONES
                        ArrayList inv = re.getInvestments(username);
                        
                        inv.forEach((n) -> System.out.println(n)); 

                        
                        
                    } else {
                        lbl.setText("NO EXISTES CRACK");
                    }

                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });

    }

}
