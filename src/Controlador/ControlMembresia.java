/*
Proposito: Permite realizar la renovación de la membresía de un cliente.
@author 
    Jhon Alex Rodríguez Benítez - 2264363
    Miguel Angel Escobar Marín - 2264305
    John Alejandro Vallarino Cruz - 2264332
Fecha de ultima modificacion  20/10/2023
version: 1.1
 */
package Controlador;

import Utilerias.Conexion;
import Utilerias.DatosConexion;
import static Utilerias.DatosConexion.baseDatos;
import static Utilerias.DatosConexion.host;
import static Utilerias.DatosConexion.login;
import static Utilerias.DatosConexion.user;
import Vista.Membresia;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import static java.time.temporal.TemporalQueries.localDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ControlMembresia implements ActionListener, WindowListener, DatosConexion {

    Membresia m;
    boolean visibilidad = true;

    public ControlMembresia(Membresia obj) {
        m = obj;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(m.jbVolver)) {
            volver();
        }
        if (e.getSource().equals(m.jtConsultar)) {
            limpiar();
            m.jbRenovar.setVisible(false);
            m.jbModificar.setVisible(false);
            visibilidad = true;
            hacerVisiblePaneles(visibilidad);
            visibilidad = false;
            hacerVisiblePanelRenovacion(visibilidad);
            m.contextoGuardar = "Consultar";
        }
        if (e.getSource().equals(m.jtModificar)) {
            limpiar();
            m.jbRenovar.setVisible(false);
            m.jbModificar.setVisible(true);
            visibilidad = true;
            hacerVisiblePaneles(visibilidad);
            visibilidad = false;
            hacerVisiblePanelRenovacion(visibilidad);
            m.contextoGuardar = "Modificar";
        }
        if (e.getSource().equals(m.jtRenovar)) {
            limpiar();
            m.jbModificar.setVisible(false);
            m.jbRenovar.setVisible(true);
            visibilidad = true;
            hacerVisiblePanelRenovacion(visibilidad);
            visibilidad = false;
            hacerVisiblePaneles(visibilidad);
            m.contextoGuardar = "Renovar";
        }
        if (e.getSource().equals(m.jbLimpiar)) {
            limpiar();
        }
        if (e.getSource().equals(m.jbConsultar)) {
            String cedula;
            if (m.contextoGuardar.equals("Renovar")) {
                cedula = m.jtCedulaRenovar.getText();
                consultarMembresia(cedula);
            }
            if (m.contextoGuardar.equals("Consultar") || m.contextoGuardar.equals("Modificar")) {
                cedula = m.jtCedula.getText();
                consultarMembresia(cedula);
            }
        }
        if (e.getSource().equals(m.jbRenovar)) {
            renovarMembresia();
        }
        if (e.getSource().equals(m.jbModificar)) {
            modificarMembresia();
        }

    }

    /*
     * Hace visibles los paneles, este método ajusta la visibilidad de los paneles en
     * la interfaz gráfica.
     */
    public void hacerVisiblePaneles(boolean visibilidad) {
        m.jpDatosCliente.setVisible(visibilidad);
        m.jpDatosMembresia.setVisible(visibilidad);
    }

    public void hacerVisiblePanelRenovacion(boolean visibilidad) {
        m.jpRenovar.setVisible(visibilidad);
    }

    private void consultarMembresia(String cedula) {
        Conexion con = new Conexion();
        boolean error = con.conectarMySQL(baseDatos, user, login, host);
        if (!error) {

            //String datosIniciales[] = con.consultaFila("membresia_cliente", "id_membresia", "(SELECT MAX(id_membresia) FROM membresia_cliente WHERE id_cliente = " + cedula + ")");
            String datos[] = con.consultaFila("cliente", "id_cliente", cedula);
            //String datos[] = con.consultaFila("cliente", "id_membresia", datosIniciales[0]);

            if (datos == null) {
                JOptionPane.showMessageDialog(m, "El cliente con cedula "
                        + cedula + " no existe en la tabla");
            } else {
                String datos2[] = con.consultaFila("usuario", "cedula_usuario", datos[0]);
                String datos3[] = con.consultaFila("membresia_cliente", "id_cliente", datos[0]," ORDER BY id_membresia DESC LIMIT 1");
                

                String fechaIni = datos3[1];
                String[] FechaIniPartes = fechaIni.split("-");
                String part1 = FechaIniPartes[0]; // 123
                String part2 = FechaIniPartes[1];
                String part3 = FechaIniPartes[2];
                fechaIni = part3 + "/" + part2 + "/" + part1;

                String fechaF = datos3[2];
                String[] FechaFPartes = fechaF.split("-");
                part1 = FechaFPartes[0]; // 123
                part2 = FechaFPartes[1];
                part3 = FechaFPartes[2];
                fechaF = part3 + "/" + part2 + "/" + part1;

                SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
                Date fechaInicio = null;
                Date fechaFin = null;
                try {
                    //JOptionPane.showMessageDialog(m, "Fecha inicio: " + datos3[1]);
                    fechaInicio = formatoFecha.parse(fechaIni);
                    fechaFin = formatoFecha.parse(fechaF);
                } catch (ParseException ex) {
                    Logger.getLogger(ControlConsultarUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
                m.jtNombre.setText(datos2[1]);
                m.jtApellido.setText(datos2[2]);
                m.jtEmail.setText(datos2[6]);
                m.jtIDMembresia.setText(datos3[0]);
                m.jtMembresia.setText(datos3[3]);
                m.jcTipoMembresia.setSelectedItem(datos3[3]);
                m.fechaInicio.setDate(fechaInicio);
                m.fechaFin.setDate(fechaFin);
                //m.jcTipoMembresia.setSelectedItem(datos3[3]);
                if (datos3[5].equals("Activo")) {
                    m.jrActivo.setSelected(true);
                }
                if (datos3[5].equals("Inactivo")) {
                    m.jrInactivo.setSelected(true);
                }
            }
        }

        if (m.contextoGuardar.equals("Renovar")) {
            volverEditableRenovar();
        }
        if (m.contextoGuardar.equals("Modificar")) {
            volverEditableModificar();
        }
    }

    private void renovarMembresia() {
        if (m.jtCedulaRenovar.getText().isEmpty()) {
            JOptionPane.showMessageDialog(m, "Aún no ha ingresado la cédula el cliente a renovar",
                    "Error", 2);
        } else {

            LocalDate fechaActual = LocalDate.now();
            String fechaInicio = fechaActual.toString();
            String fechaFinal = fechaActual.plusMonths(1).toString();
            ArrayList<String> datosMem = new ArrayList<>();
            datosMem.add(null);
            datosMem.add(fechaInicio);
            datosMem.add(fechaFinal);
            datosMem.add(m.jcTipoMembresia.getSelectedItem().toString());
            datosMem.add(m.jtCedulaRenovar.getText());
            datosMem.add("Activo");

            ArrayList<String> datosMemAct = new ArrayList<>();
            datosMemAct.add("estado='Inactivo'");
            Conexion con = new Conexion();
            boolean error = con.conectarMySQL(baseDatos, user, login, host);
            boolean error2 = error;
            if (!error) { // si no hay error de conexion a la bd, entonces ...
                error = con.actualizarFila("membresia_cliente", datosMemAct, "id_cliente = '" + m.jtCedulaRenovar.getText() + "'");
                error2 = con.insertar("membresia_cliente", datosMem);
                if (!error && !error2) { // si no hay error al insertar en la tabla, mostrar un mensaje de confirmación
                    int res = JOptionPane.showConfirmDialog(m,
                            "Se renovó con exito la membresia.\n¿Desea renovar otra?",
                            "Confirmación", JOptionPane.YES_NO_OPTION);
                    if (res == JOptionPane.YES_OPTION) { // si el usuario responde si, entonces ...
                        limpiar(); // limpiar el formulario
                    } else {
                        volver(); // de lo contrario volver el menu principal
                    }
                }
                con.desconectar(); // cerrar la conexion con la bd
            }

        }
    }

    public void modificarMembresia() {
        if (m.jtNombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(m, "Aún no ha consultado el cliente a actualizar",
                    "Error", 2);
        } else {

            ArrayList<String> datosMem = new ArrayList<>();
            if (m.jrActivo.isSelected()) {
                        datosMem.add("estado = '" + "Activo" + "'");
                    }
                    if (m.jrInactivo.isSelected()) {
                        datosMem.add("estado = '" + "Inactivo" + "'");
                    }

            Conexion con = new Conexion();
            boolean error = con.conectarMySQL(baseDatos, user, login, host);
            boolean error2 = error;
            if (!error) { // si no hay error de conexion a la bd, entonces ...
                error = con.actualizarFila("membresia_cliente", datosMem, "id_cliente = " + m.jtCedula.getText() + "");
                if (!error && !error2) { // si no hay error al insertar en la tabla, mostrar un mensaje de confirmación
                    int res = JOptionPane.showConfirmDialog(m,
                            "Se renovó con exito la membresia.\n¿Desea renovar otra?",
                            "Confirmación", JOptionPane.YES_NO_OPTION);
                    if (res == JOptionPane.YES_OPTION) { // si el usuario responde si, entonces ...
                        limpiar(); // limpiar el formulario
                    } else {
                        volver(); // de lo contrario volver el menu principal
                    }
                }

                con.desconectar(); // cerrar la conexion con la bd
            }

        }
    }

    /**
     * Oculta la ventana actual y muestra la ventana principal.
     */
    private void volver() {
        m.setVisible(false);
        m.dispose();
        m.mp.setVisible(true);
    }

    /**
     * Limpia los campos y configuraciones relacionados con la consulta y
     * edición de datos de un administrador. Este método restablece los valores
     * de varios componentes en la interfaz gráfica asociados al contexto de
     * administradores, preparándolos para una nueva operación.
     */
    private void limpiar() {
        volverNoEditableRenovar();
        volverEditableModificar();
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaInicioLocal = fechaActual;
        Date fechaInicio = Date.from(fechaInicioLocal.atStartOfDay(ZoneId.systemDefault()).toInstant());
        LocalDate fechaFinLocal = fechaActual.plusMonths(1);
        Date fechaFin = Date.from(fechaFinLocal.atStartOfDay(ZoneId.systemDefault()).toInstant());
        volverNoEditableRenovar();
        m.jtIDMembresia.setText("");
        m.jtMembresia.setText("");
        m.jtCedula.setText("");
        m.jtCedulaRenovar.setText("");
        m.jtNombre.setText("");
        m.jtApellido.setText("");
        m.jtEmail.setText("");
        m.fechaInicio.setDate(fechaInicio);
        m.fechaFin.setDate(fechaFin);
        m.jcTipoMembresia.setSelectedItem("Bronce");
        m.jtCedula.requestFocus();
        m.jrActivo.setSelected(false);
        m.jrInactivo.setSelected(false);
    }

    /**
     * Habilita la edición de los campos relacionados con la consulta y edición
     * de datos de un administrador. Este método permite la edición de varios
     * componentes en la interfaz gráfica asociados al contexto de
     * administradores, preparándolos para la modificación de información.
     */
    public void volverEditableRenovar() {
        m.jtCedula.setEditable(false);
        m.jcTipoMembresia.setEditable(true);
        m.jcTipoMembresia.setEnabled(true);
    }

    /**
     * Desabilita la edición de los campos relacionados con la consulta y
     * edición de datos de un administrador. Este método permite la edición de
     * varios componentes en la interfaz gráfica asociados al contexto de
     * administradores, preparándolos para la modificación de información.
     */
    public void volverNoEditableRenovar() {
        m.jtCedula.setEditable(true);
        m.jcTipoMembresia.setEditable(false);
        m.jcTipoMembresia.setEnabled(false);
    }

    /**
     * Habilita la edición de los campos relacionados con la consulta y edición
     * de datos de un administrador. Este método permite la edición de varios
     * componentes en la interfaz gráfica asociados al contexto de
     * administradores, preparándolos para la modificación de información.
     */
    public void volverEditableModificar() {
        m.jtCedula.setEditable(false);
        m.jrActivo.setEnabled(true);
        m.jrInactivo.setEnabled(true);
    }

    /**
     * Desabilita la edición de los campos relacionados con la consulta y
     * edición de datos de un administrador. Este método permite la edición de
     * varios componentes en la interfaz gráfica asociados al contexto de
     * administradores, preparándolos para la modificación de información.
     */
    public void volverNoEditableModificar() {
        m.jtCedula.setEditable(true);
        m.jrActivo.setEnabled(false);
        m.jrInactivo.setEnabled(false);
    }

    /**
     * Muestra un cuadro de diálogo de confirmación al intentar cerrar la
     * ventana. Si el usuario elige "Sí", se cierra la aplicación.
     */
    public void evento_salir() {
        int respuesta = JOptionPane.showConfirmDialog(m,
                "¿Desea salir de la aplicación?",
                "Confirmación",
                JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    // Implementación de WindowListener
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
