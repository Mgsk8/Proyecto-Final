/*
Proposito: Gestiona las interacciones del usuario en la vista ventana login.
@author 
    Jhon Alex Rodríguez Benítez - 2264363
    Miguel Angel Escobar Marín - 2264305
    John Alejandro Vallarino Cruz - 2264332
Fecha de ultima modificacion  20/10/2023
version: 1.1
 */
package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JOptionPane;

import Vista.MenuAdmin;
import Vista.VentanaLogin;

public class ControlVentanaLogin implements ActionListener, WindowListener {

    VentanaLogin vl;

    public ControlVentanaLogin(VentanaLogin vl) {
        this.vl = vl;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vl.jtVer)) {
            evento_jtVer();
        }
        if (e.getSource().equals(vl.jbCancelar)) {
            evento_salir();
        }
        if (e.getSource().equals(vl.jbingresar)) {
            String login = vl.jtLogin.getText();
            char caracteres[] = vl.jpPassw.getPassword(); // obtener los caracteres escritos como un arreglo de tipo char[]
            String passw = String.valueOf(caracteres);
            if (login.equals("admin") && passw.equals("admin")) {
                vl.setVisible(false);
                vl.dispose();
                MenuAdmin mp = new MenuAdmin();
            } else {
                if (login.equals("") || passw.equals("")) {
                    JOptionPane.showMessageDialog(vl, "Login y/o password no pueden ser vacios");
                    vl.jtLogin.requestFocus();
                }else{
                    evento_validar();
                }
            }
        }
        if (e.getSource().equals(vl.jtLogin)) {
            vl.jpPassw.requestFocus(); // al precionar enter, pasa el cursur al password
        }
    }

    private void evento_jtVer() {
        if (vl.jtVer.isSelected()) {
            vl.jtVer.setIcon(vl.ver);
            vl.jpPassw.setEchoChar((char) 0);// permitir ver los caracteres escritos en el JPassword
        } else {
            vl.jtVer.setIcon(vl.no_ver);
            vl.jpPassw.setEchoChar('*');
        }
        vl.jpPassw.requestFocus();
    }

    public boolean consultar_x_ced(String ced) {
        FileReader fr = null;// permite leer el archivo
        boolean error = false;
        boolean existe = false;
        try {
            fr = new FileReader("Usuarios.csv");
        } catch (Exception e) {
            error = true;
            JOptionPane.showMessageDialog(null,
                    e + "\n\nError al abrir el archivo");
        }
        if (!error) {
            BufferedReader br = new BufferedReader(fr);// clase que se utiliza para leer texto
            String linea = "";
            String[] tokens;

            try {
                while ((linea = br.readLine()) != null) { // readLine() es un método utilizado para leer una línea de
                    // texto
                    tokens = linea.split(";");// divir los caracteres
                    if (tokens[0].equals(ced)) {
                        existe = true;
                        break; // romper el while, para que no siga buscando en el archivo
                    }
                } // fin while
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        e + "\n\nError al leer el archivo");
            }
            try {
                fr.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        e + "\n\nError al cerrar el archivo");
            }
        }
        return existe;
    }

    private void evento_validar() {
        String login = vl.jtLogin.getText();
        char caracteres[] = vl.jpPassw.getPassword(); // obtener los caracteres escritos como un arreglo de tipo char[]
        String passw = String.valueOf(caracteres);// Convertir el arreglo de char a String
        FileReader fr = null;// permite leer el archivo
        boolean error = false;
        try {
            fr = new FileReader("Usuarios.csv");
        } catch (Exception e) {
            error = true;
            JOptionPane.showMessageDialog(null,
                    e + "\n\nError al abrir el archivo");
        }
        if (!error) {
            BufferedReader br = new BufferedReader(fr);// clase que se utiliza para leer texto
            String linea = "";
            String[] tokens;
            boolean existe = false;
            try {
                while ((linea = br.readLine()) != null) { // readLine() es un método utilizado para leer una línea de
                    // texto
                    tokens = linea.split(";");// divir los caracteres
                    if (login.equals("") || passw.equals("")) {
                        JOptionPane.showMessageDialog(vl, "Login y/o password no pueden ser vacios");
                        vl.jtLogin.requestFocus();
                        existe = true;
                        break;
                    } else {
                        if (login.equals(tokens[8]) && passw.equals(tokens[9])) {
                            existe = true;
                            vl.setVisible(false);
                            vl.dispose();
                            MenuAdmin mp = new MenuAdmin();
                            break;
                        }
                    }

                } // fin while
                if (!existe) {
                    JOptionPane.showMessageDialog(vl, "Ingreso Incorrecto. Login y/o password incorrectos",
                            "Error", JOptionPane.WARNING_MESSAGE);
                    evento_limpiar();
                    vl.jtLogin.requestFocus();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        e + "\n\nError al leer el archivo");
            }
            try {
                fr.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        e + "\n\nError al cerrar el archivo");
            }
        }

    }

    public void evento_salir() {
        int respuesta = JOptionPane.showConfirmDialog(vl,
                "¿Desea salir de la aplicación?",
                "Confirmación",
                JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
    
    public void evento_limpiar(){
        vl.jtLogin.setText("");
        vl.jpPassw.setText("");
    }
    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        evento_salir();
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

}
