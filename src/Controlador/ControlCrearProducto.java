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

public class ControlCrearProducto implements ActionListener, WindowListener {

    CrearProducto cp;

    public ControlCrearProducto(CrearProducto cp) {
        this.cp = cp;
    }

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

    public void volver() {
        cp.setVisible(false);
        cp.dispose();
        cp.ma.setVisible(true);
    }

    public void evento_limpiar() {
        cp.jtIdProducto.setText("");
        cp.jtPrecio.setText("");
        cp.jtNombre.setText("");
        cp.jtCantidad.setText("");
    }

    public void evento_salir() {
        int respuesta = JOptionPane.showConfirmDialog(cp,
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
