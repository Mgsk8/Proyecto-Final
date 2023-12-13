/**
 * ControlAcercaDe es la clase que maneja las interacciones del usuario
 * en la ventana AcercaDe.
 *
 * @author John Alejandro Vallarino - 2264332
 * @author Jhon Alex Rodriguez - 2264363
 * @author Miguel Ángel Escobar Marín - 2264305
 * @version 1.3
 * @since 4-12-2023
 */
package Controlador;

import Modelo.Producto;
import Utilerias.Conexion;
import static Utilerias.DatosConexion.baseDatos;
import static Utilerias.DatosConexion.host;
import static Utilerias.DatosConexion.login;
import static Utilerias.DatosConexion.user;
import Vista.CrearProducto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * ControlAcercaDe es la clase que maneja las interacciones del usuario
 * en la ventana AcercaDe.
 */

public class ControlCrearProducto implements ActionListener, WindowListener {
    /** Instancia de la vista CrearProducto. */
    CrearProducto cp;
    /**
     * Constructor que recibe la instancia de la vista CrearProducto.
     *
     * @param cp Instancia de CrearProducto.
     */
    public ControlCrearProducto(CrearProducto cp) {
        this.cp = cp;
    }
    // Métodos de ActionListener
    
    /**
     * Método que se ejecuta cuando se realiza una acción en la interfaz.
     *
     * @param e Evento de acción
     */  
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(cp.jbLimpiar)) {
            evento_limpiar();
        }
        if (e.getSource().equals(cp.jbVolver)) {
            volver();
        }
        if (e.getSource().equals(cp.jbGuardar)) {
            if (cp.jtIdProducto.getText().isEmpty() || cp.jtNombre.getText().isEmpty()
                    || cp.jtCantidad.getText().isEmpty() || cp.jtPrecio.getText().isEmpty()) {
                JOptionPane.showMessageDialog(cp, "Complete todos los datos",
                        "Error", 2);
            } else {
                Producto p = new Producto();
                p.setIdProducto(cp.jtIdProducto.getText());
                p.setNombre(cp.jtNombre.getText());
                p.setCantidad(cp.jtCantidad.getText());
                p.setPrecio(cp.jtPrecio.getText());

                ArrayList<String> producto = new ArrayList<>();
                producto.add(p.getIdProducto());
                producto.add(p.getNombre());
                producto.add(p.getCantidad());
                producto.add(p.getPrecio());

                Conexion con = new Conexion();
                boolean error = con.conectarMySQL(baseDatos, user, login, host);
                if (!error) { // si no hay error de conexion a la bd, entonces ...
                    error = con.insertar("producto", producto); // insertar los datos en la tabla clientes
                    if (!error) { // si no hay error al insertar en la tabla, mostrar un mensaje de confirmación
                        int res = JOptionPane.showConfirmDialog(cp,
                                "Se registro con exito la venta.\n¿Desea registrar otra?",
                                "Confirmación", JOptionPane.YES_NO_OPTION);
                        if (res == JOptionPane.YES_OPTION) { // si el usuario responde si, entonces ...
                            evento_limpiar(); // limpiar el formulario
                        } else {
                            volver(); // de lo contrario volver el menu principal
                        }
                    }

                    con.desconectar(); // cerrar la conexion con la bd
                }
            }
        }
    }
    /**
     * Método para volver a la ventana principal.
     */
    public void volver() {
        cp.setVisible(false);
        cp.dispose();
        cp.ma.setVisible(true);
    }
    /**
     * Método para limpiar los campos de la ventana.
     */
    public void evento_limpiar() {
        cp.jtIdProducto.setText("");
        cp.jtPrecio.setText("");
        cp.jtNombre.setText("");
        cp.jtCantidad.setText("");
    }
    /**
     * Método para manejar el evento de salir de la aplicación.
     */
    public void evento_salir() {
        int respuesta = JOptionPane.showConfirmDialog(cp,
                "¿Desea salir de la aplicación?",
                "Confirmación",
                JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
    // Métodos de WindowListener (sin implementación detallada)
    
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