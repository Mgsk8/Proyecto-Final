/**
 * Proposito: Gestiona las interacciones del usuario en la vista ventana login.
 *
 * @author John Alejandro Vallarino - 2264332
 * @author Jhon Alex Rodriguez - 2264363
 * @author Miguel Ángel Escobar Marín - 2264305
 * @version 1.3
 * @since 20-10-2023
 */
package Controlador;

import Utilerias.Conexion;
import static Utilerias.DatosConexion.baseDatos;
import static Utilerias.DatosConexion.host;
import static Utilerias.DatosConexion.login;
import static Utilerias.DatosConexion.user;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

import Vista.MenuPrincipal;
import Vista.VentanaLogin;

/**
 * Proposito: Gestiona las interacciones del usuario en la vista ventana login.
 */
public class ControlVentanaLogin implements ActionListener, WindowListener {

    /**
     * Almacena la instancia de la ventana de login.
     * 
     * @since 1.0
     * @see VentanaLogin
     */
    VentanaLogin vl;
    /**
     * Almacena los privilegios del usuario.
     * 
     * @since 1.0
     */
    String Privilegios = "";
    /**
     * Constructor que recibe una instancia de VentanaLogin.
     * 
     * @param vl Instancia de VentanaLogin.
     * @since 1.0
     */
    public ControlVentanaLogin(VentanaLogin vl) {
        this.vl = vl;
    }
   
    // Métodos de ActionListener
    /**
     * Método que se ejecuta cuando se realiza una acción en la interfaz.
     *
     * @param e Evento de acción
     */    
    @Override
    public void actionPerformed(ActionEvent e) {
        // Métodos de acción para los eventos de los componentes de la ventana login.
        if (e.getSource().equals(vl.jtVer)) {
            evento_jtVer();
        }
        if (e.getSource().equals(vl.jbCancelar)) {
            evento_salir();
        }
        if (e.getSource().equals(vl.jbingresar)) {
            String login1 = vl.jtLogin.getText();
            char caracteres[] = vl.jpPassw.getPassword(); // obtener los caracteres escritos como un arreglo de tipo char[]
            String passw = String.valueOf(caracteres);
            if (login1.equals("admin") && passw.equals("admin")) {
                vl.setVisible(false);
                vl.dispose();
                Privilegios = "Administrador";
                MenuPrincipal mp = new MenuPrincipal(Privilegios);
            } else {
                if (login1.equals("") || passw.equals("")) {
                    JOptionPane.showMessageDialog(vl, "Login y/o password no pueden ser vacios");
                    vl.jtLogin.requestFocus();
                } else {
                    Conexion con = new Conexion();
                    boolean error = con.conectarMySQL(baseDatos, user, login, host);
                    if (!error) {
                        String datos[] = con.consultaFila("usuario", "email", login1);
                        String datos2[] = con.consultaFila("administrador", "password", passw);
                        String datos3[] = con.consultaFila("supervisor", "password", passw);
                        String datos4[] = con.consultaFila("recepcionista", "password", passw);
                        if (datos == null) {
                            JOptionPane.showMessageDialog(vl, "El usuario "
                                    + login1 + " no existe, intente nuevamente");
                        } else {
                            if (datos[7].equals("Administrador") && datos2 != null) {
                                vl.setVisible(false);
                                vl.dispose();
                                Privilegios = "Administrador";
                                MenuPrincipal mp = new MenuPrincipal(Privilegios);
                            } else {
                                if (datos[7].equals("Supervisor") && datos3 != null) {
                                    vl.setVisible(false);
                                    vl.dispose();
                                    Privilegios = "Supervisor";
                                    MenuPrincipal mp = new MenuPrincipal(Privilegios);
                                } else {
                                    if (datos[7].equals("Recepcionista") && datos4 != null) {
                                        vl.setVisible(false);
                                        vl.dispose();
                                        Privilegios = "Recepcionista";
                                        MenuPrincipal mp = new MenuPrincipal(Privilegios);
                                    } else {
                                        JOptionPane.showMessageDialog(vl, "El usuario "
                                                + login1 + " no tiene acceso a la app, intente nuevamente con otro correo");
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (e.getSource().equals(vl.jtLogin)) {
            vl.jpPassw.requestFocus(); // al precionar enter, pasa el cursur al password
        }
    }
    
    /**
     * Maneja el evento de mostrar u ocultar la contraseña al seleccionar/deseleccionar
     * el checkbox correspondiente.
     * 
     * @since 1.0
     */
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
    /**
     * Maneja el evento de salir de la aplicación, mostrando un mensaje de confirmación.
     * 
     * @since 1.0
     */
    public void evento_salir() {
        int respuesta = JOptionPane.showConfirmDialog(vl,
                "¿Desea salir de la aplicación?",
                "Confirmación",
                JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
    /**
     * Maneja el evento de limpiar los campos de login y contraseña.
     * 
     * @since 1.0
     */
    public void evento_limpiar() {
        vl.jtLogin.setText("");
        vl.jpPassw.setText("");
    }
    // Métodos de WindowListener
    /**
     * {@inheritDoc}
     */    
    @Override
    public void windowOpened(WindowEvent e) {

    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void windowClosing(WindowEvent e) {
        evento_salir();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void windowClosed(WindowEvent e) {

    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void windowIconified(WindowEvent e) {

    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void windowDeiconified(WindowEvent e) {

    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void windowActivated(WindowEvent e) {

    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void windowDeactivated(WindowEvent e) {

    }

}