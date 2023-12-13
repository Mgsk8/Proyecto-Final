/**
 * Proposito: Gestiona las interacciones con la interfaz de modificar producto
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
import Vista.ModificarProducto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Proposito: Gestiona las interacciones con la interfaz de modificar producto
 */

public class ControlModificarProducto implements ActionListener, WindowListener {
    /**
     * Instancia ModificarProducto asociado al controlador.
     */
    ModificarProducto mp;
    /**
     * Constructor de ControlModificarProducto.
     *
     * @param mp Objeto ModificarProducto asociado al controlador.
     */
    public ControlModificarProducto(ModificarProducto mp) {
        this.mp = mp;
    }
    // Métodos de ActionListener
    
    /**
     * Método que se ejecuta cuando se realiza una acción en la interfaz.
     *
     * @param e Evento de acción
     */  
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(mp.jbLimpiar)) {
            evento_limpiar();
        }
        if (e.getSource().equals(mp.jbVolver)) {
            volver();
        }
        if (e.getSource().equals(mp.jbConsultar)) {
            Conexion con = new Conexion();
            boolean error = con.conectarMySQL(baseDatos, user, login, host);
            if (!error) {
                String datos[] = con.consultaFila("producto", "id_producto", mp.jtIdProducto.getText());

                if (datos == null) {
                    JOptionPane.showMessageDialog(mp, "El producto con id "
                            + mp.jtIdProducto.getText() + " no existe en la tabla");
                } else {
                    volverEditable();
                    mp.jtIdProducto.setText(datos[0]);
                    mp.jtNombre.setText(datos[1]);
                    mp.jtCantidad.setText(datos[2]);
                    mp.jtPrecio.setText(datos[3]);
                }
            }
        }
        if (e.getSource().equals(mp.jbActualizar)) {
            if (mp.jtIdProducto.getText().isEmpty() || mp.jtNombre.getText().isEmpty()
                    || mp.jtCantidad.getText().isEmpty() || mp.jtPrecio.getText().isEmpty()) {
                JOptionPane.showMessageDialog(mp, "Complete todos los datos",
                        "Error", 2);
            } else {
                Producto p = new Producto();
                p.setCantidad(mp.jtCantidad.getText());

                ArrayList<String> producto = new ArrayList<>();
                producto.add("cantidad = '"+p.getCantidad()+"'");

                Conexion con = new Conexion();
                boolean error = con.conectarMySQL(baseDatos, user, login, host);
                if (!error) { // si no hay error de conexion a la bd, entonces ...
                   error = con.actualizarFila("producto",producto,"id_producto = '" + mp.jtIdProducto.getText() + "'");
                    if (!error) { // si no hay error al insertar en la tabla, mostrar un mensaje de confirmación
                        int res = JOptionPane.showConfirmDialog(mp,
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
     * Hace no editable el campo de idProducto.
     */    
    public void volverNoEditable(){
        mp.jtIdProducto.setEditable(true);
        mp.jtCantidad.setEditable(false);
    }
    /**
     * Hace editable el campo de idProducto.
     */    
    public void volverEditable() {
        mp.jtIdProducto.setEditable(false);
        mp.jtCantidad.setEditable(true);
    }
    /**
     * Oculta la ventana actual y muestra la ventana principal.
     */
    public void volver() {
        mp.setVisible(false);
        mp.dispose();
        mp.ma.setVisible(true);
    }
    /**
     * Limpia los campos de la interfaz gráfica.
     */
    public void evento_limpiar() {
        mp.jtIdProducto.setText("");
        mp.jtPrecio.setText("");
        mp.jtNombre.setText("");
        mp.jtCantidad.setText("");
    }
    /**
     * Muestra un cuadro de diálogo de confirmación al intentar cerrar la ventana.
     * Si el usuario elige "Sí", se cierra la aplicación.
     */
    public void evento_salir() {
        int respuesta = JOptionPane.showConfirmDialog(mp,
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