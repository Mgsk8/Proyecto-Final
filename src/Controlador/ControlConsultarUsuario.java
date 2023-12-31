/**
 * Proposito: Gestiona las interacciones del usuario en la vista Consultar Usuario.
 *
 * @author John Alejandro Vallarino - 2264332
 * @author Jhon Alex Rodriguez - 2264363
 * @author Miguel Ángel Escobar Marín - 2264305
 * @version 1.3
 * @since 4-12-2023
 */
package Controlador;

import Utilerias.Conexion;
import static Utilerias.DatosConexion.baseDatos;
import static Utilerias.DatosConexion.host;
import static Utilerias.DatosConexion.login;
import static Utilerias.DatosConexion.user;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import Vista.ConsultarUsuario;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta clase es responsable de controlar las interacciones del usuario
 * relacionadas con la consulta y visualización de información de usuario.
 * Interactúa con la vista ConsultarUsuario y utiliza la clase Conexion para
 * operaciones de base de datos.
 */
public class ControlConsultarUsuario implements ActionListener, WindowListener {
    /**
     * Objeto de la vista ConsultarUsuario.
     */
    ConsultarUsuario cu;
    /**
     * Constructor de la clase ControlConsultarUsuario.
     *
     * @param obj Objeto de la clase ConsultarUsuario asociado al controlador.
     */
    public ControlConsultarUsuario(ConsultarUsuario obj) {
        cu = obj;
    }
    // Métodos de ActionListener

    /**
     * Método que se ejecuta cuando se realiza una acción en la interfaz.
     *
     * @param e Evento de acción
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(cu.jbVolver)) {
            volver();
        }
        if (e.getSource().equals(cu.jbLimpiar)) {
            if ("Administrador".equals(cu.contextoActualizar)) {
                limpiarAdmin();
            }
            if ("Supervisor".equals(cu.contextoActualizar)) {
                limpiarPersonal();
            }
            if ("Recepcionista".equals(cu.contextoActualizar)) {
                limpiarPersonal();
            }
            if ("Entrenador".equals(cu.contextoActualizar)) {
                limpiarEntrenador();
            }
            if ("Cliente".equals(cu.contextoActualizar)) {
                limpiarCliente();
            }
        }
        if (e.getSource().equals(cu.jtAdministrador)) {
            limpiarAdmin();
            hacerVisibleAdm();
            cu.contextoActualizar = "Administrador";
        }
        if (e.getSource().equals(cu.jtSupervisor)) {
            limpiarPersonal();
            hacerVisibleEmp();
            cu.contextoActualizar = "Supervisor";
        }
        if (e.getSource().equals(cu.jtRecepcionista)) {
            limpiarPersonal();
            hacerVisibleEmp();
            cu.contextoActualizar = "Recepcionista";
        }
        if (e.getSource().equals(cu.jtEntrenador)) {
            limpiarEntrenador();
            hacerVisibleEnt();
            cu.contextoActualizar = "Entrenador";
        }
        if (e.getSource().equals(cu.JTcliente)) {
            limpiarCliente();
            hacerVisibleCl();
            cu.contextoActualizar = "Cliente";
        }
        if (e.getSource().equals(cu.jbConsultar)) {
            if ("Administrador".equals(cu.contextoActualizar)) {
                Conexion con = new Conexion();
                boolean error = con.conectarMySQL(baseDatos, user, login, host);
                if (!error) {
                    String datos[] = con.consultaFila("administrador", "id_administrador", cu.jtCedula.getText());
                    if (datos == null) {
                        JOptionPane.showMessageDialog(cu, "El administrador con cedula "
                                + cu.jtCedula.getText() + " no existe en la tabla");
                    } else {
                        String datos2[] = con.consultaFila("usuario", "cedula_usuario", datos[0]);
                        cu.jtNom.setText(datos2[1]);
                        cu.jtApe.setText(datos2[2]);
                        String fechaString = datos2[3] + "/" + datos2[4] + "/" + datos2[5];
                        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
                        Date fecha = null;
                        try {
                            fecha = formatoFecha.parse(fechaString);
                        } catch (ParseException ex) {
                            Logger.getLogger(ControlConsultarUsuario.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        cu.fecha_nac.setDate(fecha);
                        cu.jtEmail.setText(datos2[6]);
                        if (datos2[8].equals("Activo")) {
                            cu.jrActivo.setSelected(true);
                        }
                        if (datos2[8].equals("Inactivo")) {
                            cu.jrInactivo.setSelected(true);
                        }
                        cu.jtPassword.setText(datos[1]);
                        cu.jtSueldo.setText(datos[2]);
                    }
                }
            }
            if ("Supervisor".equals(cu.contextoActualizar)) {
                Conexion con = new Conexion();
                boolean error = con.conectarMySQL(baseDatos, user, login, host);
                if (!error) {
                    String datos[] = con.consultaFila("supervisor", "id_supervisor", cu.jtCedula.getText());
                    if (datos == null) {
                        JOptionPane.showMessageDialog(cu, "El supervisor con cedula "
                                + cu.jtCedula.getText() + " no existe en la tabla");
                    } else {
                        String datos2[] = con.consultaFila("usuario", "cedula_usuario", datos[0]);
                        cu.jtNom.setText(datos2[1]);
                        cu.jtApe.setText(datos2[2]);
                        String fechaString = datos2[3] + "/" + datos2[4] + "/" + datos2[5];
                        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
                        Date fecha = null;
                        try {
                            fecha = formatoFecha.parse(fechaString);
                        } catch (ParseException ex) {
                            Logger.getLogger(ControlConsultarUsuario.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        cu.fecha_nac.setDate(fecha);
                        cu.jtEmail.setText(datos2[6]);
                        if (datos2[8].equals("Activo")) {
                            cu.jrActivo.setSelected(true);
                        }
                        if (datos2[8].equals("Inactivo")) {
                            cu.jrInactivo.setSelected(true);
                        }
                        cu.jtPassword.setText(datos[1]);
                        cu.jcTurno.setSelectedItem(datos[2]);
                        cu.jtSueldo.setText(datos[3]);
                    }
                }
            }
            if ("Recepcionista".equals(cu.contextoActualizar)) {
                Conexion con = new Conexion();
                boolean error = con.conectarMySQL(baseDatos, user, login, host);
                if (!error) {
                    String datos[] = con.consultaFila("recepcionista", "id_recepcionista", cu.jtCedula.getText());

                    if (datos == null) {
                        JOptionPane.showMessageDialog(cu, "El o la recepcionista con cedula "
                                + cu.jtCedula.getText() + " no existe en la tabla");
                    } else {
                        String datos2[] = con.consultaFila("usuario", "cedula_usuario", datos[0]);
                        cu.jtNom.setText(datos2[1]);
                        cu.jtApe.setText(datos2[2]);
                        String fechaString = datos2[3] + "/" + datos2[4] + "/" + datos2[5];
                        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
                        Date fecha = null;
                        try {
                            fecha = formatoFecha.parse(fechaString);
                        } catch (ParseException ex) {
                            Logger.getLogger(ControlConsultarUsuario.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        cu.fecha_nac.setDate(fecha);
                        cu.jtEmail.setText(datos2[6]);
                        if (datos2[8].equals("Activo")) {
                            cu.jrActivo.setSelected(true);
                        }
                        if (datos2[8].equals("Inactivo")) {
                            cu.jrInactivo.setSelected(true);
                        }
                        cu.jtPassword.setText(datos[1]);
                        cu.jcTurno.setEnabled(true);
                        cu.jcTurno.setSelectedItem(datos[2]);
                        cu.jcTurno.setEnabled(false);
                        cu.jtSueldo.setText(datos[3]);
                    }
                }
            }
            if ("Entrenador".equals(cu.contextoActualizar)) {
                Conexion con = new Conexion();
                boolean error = con.conectarMySQL(baseDatos, user, login, host);
                if (!error) {
                    String datos[] = con.consultaFila("entrenador", "id_entrenador", cu.jtCedula.getText());
                    if (datos == null) {
                        JOptionPane.showMessageDialog(cu, "El entrenador con cedula "
                                + cu.jtCedula.getText() + " no existe en la tabla");
                    } else {
                        String datos2[] = con.consultaFila("usuario", "cedula_usuario", datos[0]);
                        cu.jtNom.setText(datos2[1]);
                        cu.jtApe.setText(datos2[2]);
                        String fechaString = datos2[3] + "/" + datos2[4] + "/" + datos2[5];
                        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
                        Date fecha = null;
                        try {
                            fecha = formatoFecha.parse(fechaString);
                        } catch (ParseException ex) {
                            Logger.getLogger(ControlConsultarUsuario.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        cu.fecha_nac.setDate(fecha);
                        cu.jtEmailNoLoginEnt.setText(datos2[6]);
                        if (datos2[8].equals("Activo")) {
                            cu.jrActivo.setSelected(true);
                        }
                        if (datos2[8].equals("Inactivo")) {
                            cu.jrInactivo.setSelected(true);
                        }
                        cu.jcTurnoEnt.setSelectedItem((String) datos[1]);
                        cu.jtSueldo.setText(datos[2]);
                    }
                }
            }
            if ("Cliente".equals(cu.contextoActualizar)) {
                Conexion con = new Conexion();
                boolean error = con.conectarMySQL(baseDatos, user, login, host);
                if (!error) {
                    String datos[] = con.consultaFila("cliente", "id_cliente", cu.jtCedula.getText());
                    if (datos == null) {
                        JOptionPane.showMessageDialog(cu, "El o la cliente con cedula "
                                + cu.jtCedula.getText() + " no existe en la tabla");
                    } else {
                        String datos2[] = con.consultaFila("usuario", "cedula_usuario", datos[0]);
                        String datos3[] = con.consultaFila("membresia_cliente", "id_cliente", datos[0]);
                        cu.jtNom.setText(datos2[1]);
                        cu.jtApe.setText(datos2[2]);
                        String fechaString = datos2[3] + "/" + datos2[4] + "/" + datos2[5];
                        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
                        Date fecha = null;
                        try {
                            fecha = formatoFecha.parse(fechaString);
                        } catch (ParseException ex) {
                            Logger.getLogger(ControlConsultarUsuario.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        cu.fecha_nac.setDate(fecha);
                        cu.jtEmailNoLoginCl.setText(datos2[6]);
                        if (datos2[8].equals("Activo")) {
                            cu.jrActivo.setSelected(true);
                        }
                        if (datos2[8].equals("Inactivo")) {
                            cu.jrInactivo.setSelected(true);
                        }
                        cu.jcGrupoSanguineo.setSelectedItem(datos[1]);
                        cu.jcMembresia.setSelectedItem(datos3[3]);

                    }
                }
            }
        }
    }

    /**
     * Oculta la ventana actual y muestra la ventana principal.
     */
    private void volver() {
        cu.setVisible(false);
        cu.dispose();
        cu.tc.ma.setVisible(true);
    }

    /**
     * Hace visibles los paneles necesarios para la consulta y edición de datos
     * de un administrador. Este método ajusta la visibilidad de los paneles en
     * la interfaz gráfica de acuerdo al contexto de la operación relacionada
     * con administradores.
     */
    public void hacerVisibleAdm() {
        cu.jpConsultarDatosBase.setVisible(true);
        cu.jpLoguearse.setVisible(true);
        cu.jpConsultarTurno.setVisible(false);
        cu.jpConsultarGrupoSanguineo.setVisible(false);
        cu.jpSueldo.setVisible(true);
    }
    /**
     * Hace visibles los paneles necesarios para la consulta y edición de datos
     * de un supervisor o recepcionista. Este método ajusta la visibilidad de
     * los paneles en la interfaz gráfica de acuerdo al contexto de la operación
     * relacionada con supervisores o recepcionistas.
     */
    public void hacerVisibleEmp() {
        cu.jpConsultarDatosBase.setVisible(true);
        cu.jpLoguearse.setVisible(true);
        cu.jpConsultarTurno.setVisible(true);
        cu.jpConsultarGrupoSanguineo.setVisible(false);
        cu.jpSueldo.setVisible(true);
    }
    /**
     * Hace visibles los paneles necesarios para la consulta y edición de datos
     * de un entrenador. Este método ajusta la visibilidad de los paneles en la
     * interfaz gráfica de acuerdo al contexto de la operación relacionada con
     * entrenadores.
     */
    public void hacerVisibleEnt() {
        cu.jpConsultarDatosBase.setVisible(true);
        cu.jpLoguearse.setVisible(false);
        cu.jpConsultarTurno.setVisible(false);
        cu.jpConsultarTurnoEmail.setVisible(true);
        cu.jpConsultarGrupoSanguineo.setVisible(false);
        cu.jpSueldo.setVisible(true);
    }
    /**
     * Hace visibles los paneles necesarios para la consulta y edición de datos
     * de un cliente. Este método ajusta la visibilidad de los paneles en la
     * interfaz gráfica de acuerdo al contexto de la operación relacionada con
     * clientes.
     */
    public void hacerVisibleCl() {
        cu.jpConsultarDatosBase.setVisible(true);
        cu.jpLoguearse.setVisible(false);
        cu.jpConsultarTurno.setVisible(false);
        cu.jpConsultarTurnoEmail.setVisible(false);
        cu.jpConsultarGrupoSanguineo.setVisible(true);
        cu.jpSueldo.setVisible(false);
    }

    /**
     * Limpia los campos y configuraciones relacionados con la consulta y
     * edición de datos de un administrador. Este método restablece los valores
     * de varios componentes en la interfaz gráfica asociados al contexto de
     * administradores, preparándolos para una nueva operación.
     */
    private void limpiarAdmin() {
        cu.jtCedula.setText("");
        cu.jtNom.setText("");
        cu.jtApe.setText("");
        Calendar actual = Calendar.getInstance();
        cu.fecha_nac.setDate(actual.getTime());
        cu.jtEmail.setText("");
        cu.jtPassword.setText("");
        cu.jtCedula.requestFocus();
        cu.jrActivo.setSelected(false);
        cu.jrInactivo.setSelected(false);
        cu.jtSueldo.setText("");
    }
    /**
     * Limpia los campos y configuraciones relacionados con la consulta y
     * edición de datos de un recepcionista o supervisor. Este método restablece
     * los valores de varios componentes en la interfaz gráfica asociados al
     * contexto de recepcionistas o supervisores, preparándolos para una nueva
     * operación.
     */
    private void limpiarPersonal() {
        cu.jtCedula.setText("");
        cu.jtNom.setText("");
        cu.jtApe.setText("");
        Calendar actual = Calendar.getInstance();
        cu.fecha_nac.setDate(actual.getTime());
        cu.jcTurno.setSelectedItem("mañana");
        cu.jtEmail.setText("");
        cu.jtPassword.setText("");
        cu.jtCedula.requestFocus();
        cu.jtSueldo.setText("");
    }
    /**
     * Limpia los campos y configuraciones relacionados con la consulta y
     * edición de datos de un entrenador. Este método restablece los valores de
     * varios componentes en la interfaz gráfica asociados al contexto de
     * entrenadores, preparándolos para una nueva operación.
     */
    private void limpiarEntrenador() {
        cu.jtCedula.setText("");
        cu.jtNom.setText("");
        cu.jtApe.setText("");
        Calendar actual = Calendar.getInstance();
        cu.fecha_nac.setDate(actual.getTime());
        cu.jcTurnoEnt.setSelectedItem("mañana");
        cu.jtEmailNoLoginEnt.setText("");
        cu.jtCedula.requestFocus();
        cu.jtSueldo.setText("");
    }
    /**
     * Limpia los campos y configuraciones relacionados con la consulta y
     * edición de datos de un cliente. Este método restablece los valores de
     * varios componentes en la interfaz gráfica asociados al contexto de
     * clientes, preparándolos para una nueva operación.
     */
    private void limpiarCliente() {
        cu.jtCedula.setText("");
        cu.jtNom.setText("");
        cu.jtApe.setText("");
        Calendar actual = Calendar.getInstance();
        cu.fecha_nac.setDate(actual.getTime());
        cu.jcGrupoSanguineo.setSelectedItem("A+");
        cu.jtEmailNoLoginCl.setText("");
        cu.jtCedula.requestFocus();
    }
    /**
     * Muestra un cuadro de diálogo de confirmación al intentar cerrar la
     * ventana. Si el usuario elige "Sí", se cierra la aplicación.
     */
    public void evento_salir() {
        int respuesta = JOptionPane.showConfirmDialog(cu,
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