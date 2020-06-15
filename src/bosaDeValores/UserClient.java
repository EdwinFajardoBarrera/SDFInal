/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bosaDeValores;

import java.awt.Component;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Edwin Fajardo
 */
public class UserClient {

    static GraphicsConfiguration gc;

    public static void main(String[] args) {

        //SE INICIALIZA LA VISTA
        View vs = new View();
        vs.setVisible(true);
        JTextField tf = vs.getRfcUsuario();
        //> SOLO PARA PRUEBAS
        tf.setText("AA12001082");
        //>
        JButton btn = vs.getIniciarSesion();
        JLabel lbl = vs.getStatus();

        //Inicialización de vista de inversiones
        ListaDeActiones la = new ListaDeActiones();
        JTable jt = la.getInvestments();
        DefaultTableModel model = new DefaultTableModel();

        //ACtion listener de la primera vista
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String username = tf.getText();
                    Registry registry = LocateRegistry.getRegistry("127.0.0.1");
                    IRemoteUser re = (IRemoteUser) registry.lookup("User");

                    //SE BUSCA EL USUARIO Y SE REGRESA SU INFORMACIÓN
                    User usr = re.getUser(username);
                    if (!(usr.getUserRFC() == null)) {
                        lbl.setText("BIENVENIDO!");

//                    LISTA TODAS LAS TRANSACCIONES HECHAS POR DETERMINADO USUARIO (userRFC)
                        ArrayList<Transaction> arr = re.getInvestments(usr.getUserRFC());

                        String headers[] = {"Empresa", "Numero de acciones", "Ultimo precio de compra", "Precio actual"};
                        model.setColumnIdentifiers(headers);
                        la.setTitle("Bienvenido " + username);

                        arr.forEach((n) -> {
                            String rfc = n.getCompanyRFC();
                            int actions = n.getOperatedActions();
                            Double price = n.getOperatedActionsPrice();
                            Double aPrice = n.getActualActionsPrice();
                            Object[] data = {rfc, actions, price, aPrice};
                            model.addRow(data);
                        });

                        //PANEL
                        jt.setModel(model);
                        vs.setVisible(false);
                        la.setVisible(true);

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
