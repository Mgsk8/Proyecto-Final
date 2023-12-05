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

public class ControlModificarProducto implements ActionListener, WindowListener {

    ModificarProducto mp;

    public ControlModificarProducto(ModificarProducto mp) {
        this.mp = mp;
    }

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
    public void volverNoEditable(){
        mp.jtIdProducto.setEditable(true);
        mp.jtCantidad.setEditable(false);
    }
    public void volverEditable() {
        mp.jtIdProducto.setEditable(false);
        mp.jtCantidad.setEditable(true);
    }

    public void volver() {
        mp.setVisible(false);
        mp.dispose();
        mp.ma.setVisible(true);
    }

    public void evento_limpiar() {
        mp.jtIdProducto.setText("");
        mp.jtPrecio.setText("");
        mp.jtNombre.setText("");
        mp.jtCantidad.setText("");
    }

    public void evento_salir() {
        int respuesta = JOptionPane.showConfirmDialog(mp,
                "¿Desea salir de la aplicación?",
                "Confirmación",
                JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
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
