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
//        JButton newUser = new JButton("Crear usuario");
        JLabel lbl = new JLabel("Ingrese su RFC de cliente");
        JTextField tf = new JTextField("", 10);
//        frame.add(newUser);
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

                    //SE BUSCA EL USUARIO Y SE REGRESA SU INFORMACIÓN
                    User usr = re.getUser(username);
                    //System.out.println("Usuario: " + rfc);
                    System.out.println("===");

                    if ( !(usr.getUserRFC() == null) ) {
                        lbl.setText("BIENVENIDO!");

//                    LISTA TODAS LAS TRANSACCIONES HECHAS POR DETERMINADO USUARIO (userRFC)
                        ArrayList<Transaction> arr = re.getInvestments(usr.getUserRFC());

                        arr.forEach((n) -> {
                            System.out.println("Empresa: " + n.getCompanyRFC());
                            System.out.println("Numero de totales: " + n.getOperatedActions());
                            System.out.println("Ultimo de compra: " + n.getOperatedActionsPrice());
                            System.out.println("Precio actual: " + n.getActualActionsPrice());
                            System.out.println("========");
                        });

                    } else {
                        lbl.setText("NO EXISTES CRACK");
                    }

//                    CREAR NUEVO USUARIO (RFC y Nombre)
//                    User usr = new User("AA12001084", "Hector Burgos");
//                    re.createUser(usr);
//
//                    CREAR NUEVA COMPANIA ("RFC", ACCIONES, PRECIO POR ACCION)
//                    Company comp = new Company("AA30000000", 100, 200.0);
//                    int resp = re.createCompany(comp);
//
//                    CREAR NUEVA TRANSACCIÓN (RFCUsuario, RFCEmpresaa, Acciones [+ es compra, - es venta], precioSugerido)
//                    Transaction tr = new Transaction("AA12001082", "AA10000000", 10, 20.5);
//                    int resp = re.createInvestment(tr);
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });

    }

}
