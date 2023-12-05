/*
Proposito: Gestiona las interacciones del usuario en la vista Crear Usuario.
@author 
    Jhon Alex Rodríguez Benítez - 2264363
    Miguel Angel Escobar Marín - 2264305
    John Alejandro Vallarino Cruz - 2264332
Fecha de ultima modificacion  14/11/2023
version: 1.2
 */
package Controlador;

import Modelo.Administrador;
import Modelo.Clientes;
import Modelo.Entrenador;
import Modelo.Recepcionista;
import Modelo.Supervisor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import Modelo.Usuario;
import Utilerias.ClienteMembresiaPDF;
import Utilerias.Conexion;
import Utilerias.DatosConexion;
import Utilerias.JCalendarFull;
import Utilerias.ClienteMembresiaPDF;
import static Utilerias.DatosConexion.baseDatos;
import static Utilerias.DatosConexion.host;
import static Utilerias.DatosConexion.login;
import static Utilerias.DatosConexion.user;
import Utilerias.EnviarCorreo;
import Vista.CrearUsuario;
import com.toedter.calendar.JCalendar;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

public class ControlCrearUsuario implements ActionListener, WindowListener, DatosConexion {

    CrearUsuario cu;

    public ControlCrearUsuario(CrearUsuario obj) {
        cu = obj;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(cu.jbLimpiar)) {
            if ("Administrador".equals(cu.contextoGuardar)) {
                limpiarAdmin();
            }
            if ("Supervisor".equals(cu.contextoGuardar)) {
                limpiarPersonal();
            }
            if ("Recepcionista".equals(cu.contextoGuardar)) {
                limpiarPersonal();
            }
            if ("Entrenador".equals(cu.contextoGuardar)) {
                limpiarEntrenador();
            }
            if ("Cliente".equals(cu.contextoGuardar)) {
                limpiarCliente();
            }
        }
        if (e.getSource().equals(cu.jbVolver)) {
            volver();
        }
        if (e.getSource().equals(cu.jtAdministrador)) {
            hacerVisibleAdm();
            cu.contextoGuardar = "Administrador";
        }
        if (e.getSource().equals(cu.jtSupervisor)) {
            hacerVisibleEmp();
            cu.contextoGuardar = "Supervisor";
        }
        if (e.getSource().equals(cu.jtRecepcionista)) {
            hacerVisibleEmp();
            cu.contextoGuardar = "Recepcionista";
        }
        if (e.getSource().equals(cu.jtEntrenador)) {
            hacerVisibleEnt();
            cu.contextoGuardar = "Entrenador";
        }
        if (e.getSource().equals(cu.JTcliente)) {
            hacerVisibleCl();
            cu.contextoGuardar = "Cliente";
        }
        if (e.getSource().equals(cu.jbGuardar)) {
            //System.out.println("hola");
            if ("Administrador".equals(cu.contextoGuardar)) {
                if (cu.jtNom.getText().isEmpty() || cu.jtCedula.getText().isEmpty() || cu.jtApe.getText().isEmpty()
                        || cu.jtEmail.getText().isEmpty() || cu.jpPassword.equals("") || cu.fecha_nac.equals("")) {
                    JOptionPane.showMessageDialog(cu, "Complete todos los datos",
                            "Error", 2);
                } else {
                    Administrador adm = new Administrador();
                    adm.setCedula(cu.jtCedula.getText());
                    adm.setNombre(cu.jtNom.getText());
                    adm.setApellido(cu.jtApe.getText());

                    Calendar calendario = cu.fecha_nac.getCalendar();
                    int dia = calendario.get(Calendar.DATE); // obtener el dia de nacimiento
                    int mes = calendario.get(Calendar.MONTH) + 1; // obtener el mes de nacimiento
                    int year = calendario.get(Calendar.YEAR); // obtener el year de nacimiento
                    adm.setDia(dia + "");
                    adm.setMes(mes + "");
                    adm.setYear(year + "");

                    adm.setEmail(cu.jtEmail.getText());
                    char caracteres[] = cu.jpPassword.getPassword();
                    String password = String.valueOf(caracteres);
                    adm.setPassword(password);

                    ArrayList<String> datosUsu = new ArrayList<>();
                    datosUsu.add(adm.getCedula());
                    datosUsu.add(adm.getNombre());
                    datosUsu.add(adm.getApellido());
                    datosUsu.add(adm.getDia());
                    datosUsu.add(adm.getMes());
                    datosUsu.add(adm.getYear());
                    datosUsu.add(adm.getEmail());
                    datosUsu.add(cu.contextoGuardar);
                    datosUsu.add("Activo");
                    
                    ArrayList<String> datosAdm = new ArrayList<>();
                    datosAdm.add(adm.getCedula());
                    datosAdm.add(adm.getPassword());
                    datosAdm.add(adm.getSalario());
                    
                    Conexion con = new Conexion();
                    boolean error = con.conectarMySQL(baseDatos, user, login, host);
                    boolean error2 = error;
                    if (!error) { // si no hay error de conexion a la bd, entonces ...
                        error = con.insertar("usuario", datosUsu); // insertar los datos en la tabla ventas
                        error2 = con.insertar("administrador", datosAdm);
                        if (!error && !error2) { // si no hay error al insertar en la tabla, mostrar un mensaje de confirmación
                            int res = JOptionPane.showConfirmDialog(cu,
                                    "Se registro con exito al administrador.\n¿Desea registrar otro?",
                                    "Confirmación", JOptionPane.YES_NO_OPTION);
                            if (res == JOptionPane.YES_OPTION) { // si el usuario responde si, entonces ...
                                limpiarAdmin(); // limpiar el formulario
                            } else {
                                volver(); // de lo contrario volver el menu principal
                            }
                        }

                        con.desconectar(); // cerrar la conexion con la bd
                    }
                }
            }
            if ("Supervisor".equals(cu.contextoGuardar)) {
                if (cu.jtNom.getText().isEmpty() || cu.jtCedula.getText().isEmpty() || cu.jtApe.getText().isEmpty()
                        || cu.jtEmail.getText().isEmpty() || cu.jpPassword.equals("") || cu.fecha_nac.equals("")) {
                    JOptionPane.showMessageDialog(cu, "Complete todos los datos",
                            "Error", 2);
                } else {
                    //obtener los datos y mandarlos a la entidad
                    Supervisor sup = new Supervisor();
                    sup.setCedula(cu.jtCedula.getText());
                    sup.setNombre(cu.jtNom.getText());
                    sup.setApellido(cu.jtApe.getText());
                    Calendar calendario = cu.fecha_nac.getCalendar();
                    int dia = calendario.get(Calendar.DATE); // obtener el dia de nacimiento
                    int mes = calendario.get(Calendar.MONTH) + 1; // obtener el mes de nacimiento
                    int year = calendario.get(Calendar.YEAR); // obtener el year de nacimiento
                    sup.setDia(dia + "");
                    sup.setMes(mes + "");
                    sup.setYear(year + "");
                    String turno = (String) cu.jcTurno.getSelectedItem();
                    sup.setTurno(turno);
                    sup.setEmail(cu.jtEmail.getText());
                    char caracteres[] = cu.jpPassword.getPassword();
                    String password = String.valueOf(caracteres);
                    sup.setPassword(password);

                    //guardar los datos en la base de datos
                    ArrayList<String> datosUsu = new ArrayList<>();
                    datosUsu.add(sup.getCedula());
                    datosUsu.add(sup.getNombre());
                    datosUsu.add(sup.getApellido());
                    datosUsu.add(sup.getDia());
                    datosUsu.add(sup.getMes());
                    datosUsu.add(sup.getYear());
                    datosUsu.add(sup.getEmail());
                    datosUsu.add(cu.contextoGuardar);
                    datosUsu.add("Activo");
                    
                    ArrayList<String> datosSup = new ArrayList<>();
                    datosSup.add(sup.getCedula());
                    datosSup.add(sup.getPassword());
                    datosSup.add(sup.getTurno());
                    datosSup.add(sup.getSalario());
                    Conexion con = new Conexion();
                    boolean error = con.conectarMySQL(baseDatos, user, login, host);
                    boolean error2 = error;
                    if (!error) { // si no hay error de conexion a la bd, entonces ...
                        error = con.insertar("usuario", datosUsu); // insertar los datos en la tabla supervisores
                        error2 = con.insertar("supervisor", datosSup);
                        if (!error && !error2) { // si no hay error al insertar en la tabla, mostrar un mensaje de confirmación
                            int res = JOptionPane.showConfirmDialog(cu,
                                    "Se registro con exito al supervisor.\n¿Desea registrar otro?",
                                    "Confirmación", JOptionPane.YES_NO_OPTION);
                            if (res == JOptionPane.YES_OPTION) { // si el usuario responde si, entonces ...
                                limpiarPersonal(); // limpiar el formulario
                            } else {
                                volver(); // de lo contrario volver el menu principal
                            }
                        }

                        con.desconectar(); // cerrar la conexion con la bd
                    }
                }
            }
            if ("Recepcionista".equals(cu.contextoGuardar)) {
                if (cu.jtNom.getText().isEmpty() || cu.jtCedula.getText().isEmpty() || cu.jtApe.getText().isEmpty()
                        || cu.jtEmail.getText().isEmpty() || cu.jpPassword.equals("") || cu.fecha_nac.equals("")) {
                    JOptionPane.showMessageDialog(cu, "Complete todos los datos",
                            "Error", 2);
                } else {
                    //obtener los datos y mandarlos a la entidad
                    Recepcionista rec = new Recepcionista();
                    rec.setCedula(cu.jtCedula.getText());
                    rec.setNombre(cu.jtNom.getText());
                    rec.setApellido(cu.jtApe.getText());
                    Calendar calendario = cu.fecha_nac.getCalendar();
                    int dia = calendario.get(Calendar.DATE); // obtener el dia de nacimiento
                    int mes = calendario.get(Calendar.MONTH) + 1; // obtener el mes de nacimiento
                    int year = calendario.get(Calendar.YEAR); // obtener el year de nacimiento
                    rec.setDia(dia + "");
                    rec.setMes(mes + "");
                    rec.setYear(year + "");
                    String turno = (String) cu.jcTurno.getSelectedItem();
                    rec.setTurno(turno);
                    rec.setEmail(cu.jtEmail.getText());
                    char caracteres[] = cu.jpPassword.getPassword();
                    String password = String.valueOf(caracteres);
                    rec.setPassword(password);

                    //guardar los datos en la base de datos
                    ArrayList<String> datosUsu = new ArrayList<>();
                    datosUsu.add(rec.getCedula());
                    datosUsu.add(rec.getNombre());
                    datosUsu.add(rec.getApellido());
                    datosUsu.add(rec.getDia());
                    datosUsu.add(rec.getMes());
                    datosUsu.add(rec.getYear());
                    datosUsu.add(rec.getEmail());
                    datosUsu.add(cu.contextoGuardar);
                    datosUsu.add("Activo");
                    
                    ArrayList<String> datosRec = new ArrayList<>();
                    datosRec.add(rec.getCedula());
                    datosRec.add(rec.getPassword());
                    datosRec.add(rec.getTurno());
                    datosRec.add(rec.getSalario());
                    Conexion con = new Conexion();
                    boolean error = con.conectarMySQL(baseDatos, user, login, host);
                    boolean error2 = error;
                    if (!error) { // si no hay error de conexion a la bd, entonces ...
                        error = con.insertar("usuario", datosUsu); // insertar los datos en la tabla recepcionista
                        error2 = con.insertar("recepcionista", datosRec);
                        if (!error && !error2) { // si no hay error al insertar en la tabla, mostrar un mensaje de confirmación
                            int res = JOptionPane.showConfirmDialog(cu,
                                    "Se registro con exito al recepcionista.\n¿Desea registrar otro?",
                                    "Confirmación", JOptionPane.YES_NO_OPTION);
                            if (res == JOptionPane.YES_OPTION) { // si el usuario responde si, entonces ...
                                limpiarPersonal(); // limpiar el formulario
                            } else {
                                volver(); // de lo contrario volver el menu principal
                            }
                        }

                        con.desconectar(); // cerrar la conexion con la bd
                    }
                }
            }
            if ("Entrenador".equals(cu.contextoGuardar)) {
                if (cu.jtNom.getText().isEmpty() || cu.jtCedula.getText().isEmpty() || cu.jtApe.getText().isEmpty()
                        || cu.jtEmailNoLoginEnt.getText().isEmpty() || cu.fecha_nac.equals("")) {
                    JOptionPane.showMessageDialog(cu, "Complete todos los datos",
                            "Error", 2);
                } else {
                    //obtener los datos y mandarlos a la entidad
                    Entrenador ent = new Entrenador();
                    ent.setCedula(cu.jtCedula.getText());
                    ent.setNombre(cu.jtNom.getText());
                    ent.setApellido(cu.jtApe.getText());
                    Calendar calendario = cu.fecha_nac.getCalendar();
                    int dia = calendario.get(Calendar.DATE); // obtener el dia de nacimiento
                    int mes = calendario.get(Calendar.MONTH) + 1; // obtener el mes de nacimiento
                    int year = calendario.get(Calendar.YEAR); // obtener el year de nacimiento
                    ent.setDia(dia + "");
                    ent.setMes(mes + "");
                    ent.setYear(year + "");
                    String turno = (String) cu.jcTurno.getSelectedItem();
                    ent.setTurno(turno);
                    ent.setEmail(cu.jtEmailNoLoginEnt.getText());
                    

                    //guardar los datos en la base de datos
                    ArrayList<String> datosUsu = new ArrayList<>();
                    datosUsu.add(ent.getCedula());
                    datosUsu.add(ent.getNombre());
                    datosUsu.add(ent.getApellido());
                    datosUsu.add(ent.getDia());
                    datosUsu.add(ent.getMes());
                    datosUsu.add(ent.getYear());
                    datosUsu.add(ent.getEmail());
                    datosUsu.add(cu.contextoGuardar);
                    datosUsu.add("Activo");
                    
                    ArrayList<String> datosEnt = new ArrayList<>();
                    datosEnt.add(ent.getCedula());
                    datosEnt.add(ent.getTurno());
                    datosEnt.add(ent.getSalario());
                    Conexion con = new Conexion();
                    boolean error = con.conectarMySQL(baseDatos, user, login, host);
                    boolean error2 = error;
                    if (!error) { // si no hay error de conexion a la bd, entonces ...
                        error = con.insertar("usuario", datosUsu); // insertar los datos en la tabla recepcionista
                        error2 = con.insertar("entrenador", datosEnt);
                        if (!error && !error2) { // si no hay error al insertar en la tabla, mostrar un mensaje de confirmación
                            int res = JOptionPane.showConfirmDialog(cu,
                                    "Se registro con exito al entrenador.\n¿Desea registrar otro?",
                                    "Confirmación", JOptionPane.YES_NO_OPTION);
                            if (res == JOptionPane.YES_OPTION) { // si el usuario responde si, entonces ...
                                limpiarEntrenador(); // limpiar el formulario
                            } else {
                                volver(); // de lo contrario volver el menu principal
                            }
                        }

                        con.desconectar(); // cerrar la conexion con la bd
                    }
                }
            }
            if ("Cliente".equals(cu.contextoGuardar)) {
                if (cu.jtNom.getText().isEmpty() || cu.jtCedula.getText().isEmpty() || cu.jtApe.getText().isEmpty()
                        || cu.jtEmailNoLoginCl.getText().isEmpty() || cu.fecha_nac.equals("")) {
                    JOptionPane.showMessageDialog(cu, "Complete todos los datos",
                            "Error", 2);
                } else {
                    //obtener los datos y mandarlos a la entidad
                    Clientes cl = new Clientes();
                    cl.setCedula(cu.jtCedula.getText());
                    cl.setNombre(cu.jtNom.getText());
                    cl.setApellido(cu.jtApe.getText());
                    Calendar calendario = cu.fecha_nac.getCalendar();
                    int dia = calendario.get(Calendar.DATE); // obtener el dia de nacimiento
                    int mes = calendario.get(Calendar.MONTH) + 1; // obtener el mes de nacimiento
                    int year = calendario.get(Calendar.YEAR); // obtener el year de nacimiento
                    cl.setDia(dia + "");
                    cl.setMes(mes + "");
                    cl.setYear(year + "");
                    String grupoSanguineo = (String) cu.jcGrupoSanguineo.getSelectedItem();
                    cl.setGrupoSanguineo(grupoSanguineo);
                    //cl.setMembresia((String) cu.jcMembresia.getSelectedItem());
                    cl.setEmail(cu.jtEmailNoLoginCl.getText());
                    String estado = "Activo";
                    cl.setEstado(estado);

                    //guardar los datos en la base de datos
                    ArrayList<String> datosUsu = new ArrayList<>();
                    datosUsu.add(cl.getCedula());
                    datosUsu.add(cl.getNombre());
                    datosUsu.add(cl.getApellido());
                    datosUsu.add(cl.getDia());
                    datosUsu.add(cl.getMes());
                    datosUsu.add(cl.getYear());
                    datosUsu.add(cl.getEmail());
                    datosUsu.add(cu.contextoGuardar);
                    datosUsu.add("Activo");
                    
                    ArrayList<String> datosCli = new ArrayList<>();
                    datosCli.add(cl.getCedula());
                    datosCli.add(cl.getGrupoSanguineo());
                    
                    LocalDate fechaActual = LocalDate.now();
                    //String fechaInicio = fechaActual.getDayOfMonth() + "-" + fechaActual.getMonth() + "-" + fechaActual.getYear();
                    String fechaInicio = fechaActual.toString();
                    String fechaFinal = fechaActual.plusMonths(1).toString();
                    ArrayList<String> datosMem = new ArrayList<>();
                    datosMem.add(null);
                    datosMem.add(fechaInicio);
                    datosMem.add(fechaFinal);
                    datosMem.add(cu.jcMembresia.getSelectedItem().toString());
                    datosMem.add(cl.getCedula());
                    
                    Conexion con = new Conexion();
                    boolean error = con.conectarMySQL(baseDatos, user, login, host);
                    boolean error2 = error;
                    boolean error3 = error;
                    if (!error) { // si no hay error de conexion a la bd, entonces ...
                        error = con.insertar("usuario", datosUsu); // insertar los datos en la tabla clientes
                        if(!error){error2 = con.insertar("cliente", datosCli);}
                        if(!error2){error3 = con.insertar("membresia_cliente", datosMem);}
                        
                        if (!error && !error2 && !error3) { // si no hay error al insertar en la tabla, mostrar un mensaje de confirmación
                            ClienteMembresiaPDF cmpdf = new ClienteMembresiaPDF(datosUsu, datosCli, datosMem);
                            EnviarCorreo correo = new EnviarCorreo(cl.getEmail());
                            int res = JOptionPane.showConfirmDialog(cu,
                                    "Se registro con exito la venta.\n¿Desea registrar otra?",
                                    "Confirmación", JOptionPane.YES_NO_OPTION);
                            if (res == JOptionPane.YES_OPTION) { // si el usuario responde si, entonces ...
                                limpiarCliente(); // limpiar el formulario
                            } else {
                                volver(); // de lo contrario volver el menu principal
                            }
                        }

                        con.desconectar(); // cerrar la conexion con la bd
                    }
                }
            }
        }
    }

    
    public void hacerVisibleAdm(){
        cu.jpIngresarDatosBase.setVisible(true);
        cu.jpLoguearse.setVisible(true);
        cu.jpIngresarTurno.setVisible(false);
        cu.jpIngresarGrupoSanguineo.setVisible(false);
    }
    public void hacerVisibleEmp(){
        cu.jpIngresarDatosBase.setVisible(true);
        cu.jpLoguearse.setVisible(true);
        cu.jpIngresarTurno.setVisible(true);
        cu.jpIngresarGrupoSanguineo.setVisible(false);
    }
    public void hacerVisibleEnt(){
        cu.jpIngresarDatosBase.setVisible(true);
        cu.jpLoguearse.setVisible(false);
        cu.jpIngresarTurno.setVisible(false);
        cu.jpIngresarTurnoEmail.setVisible(true);
        cu.jpIngresarGrupoSanguineo.setVisible(false);
    }
    public void hacerVisibleCl(){
        cu.jpIngresarDatosBase.setVisible(true);
        cu.jpLoguearse.setVisible(false);
        cu.jpIngresarTurno.setVisible(false);
        cu.jpIngresarTurnoEmail.setVisible(false);
        cu.jpIngresarGrupoSanguineo.setVisible(true);
    }
    private void limpiarAdmin() {
        cu.jtCedula.setText("");
        cu.jtNom.setText("");
        cu.jtApe.setText("");
        Calendar actual = Calendar.getInstance();
        cu.fecha_nac.setDate(actual.getTime());
        cu.jtEmail.setText("");
        cu.jpPassword.setText("");
        cu.jtCedula.requestFocus();
    }
    
    
    private void limpiarPersonal() {
        cu.jtCedula.setText("");
        cu.jtNom.setText("");
        cu.jtApe.setText("");
        Calendar actual = Calendar.getInstance();
        cu.fecha_nac.setDate(actual.getTime());
        cu.jcTurno.setSelectedItem("mañana");
        cu.jtEmail.setText("");
        cu.jpPassword.setText("");
        cu.jtCedula.requestFocus();
    }
    
    private void limpiarEntrenador() {
        cu.jtCedula.setText("");
        cu.jtNom.setText("");
        cu.jtApe.setText("");
        Calendar actual = Calendar.getInstance();
        cu.fecha_nac.setDate(actual.getTime());
        cu.jcTurnoEnt.setSelectedItem("mañana");
        cu.jtEmailNoLoginEnt.setText("");
        cu.jtCedula.requestFocus();
    }
    private void limpiarCliente() {
        cu.jtCedula.setText("");
        cu.jtNom.setText("");
        cu.jtApe.setText("");
        Calendar actual = Calendar.getInstance();
        cu.fecha_nac.setDate(actual.getTime());
        cu.jcGrupoSanguineo.setSelectedItem("A+");
        cu.jcMembresia.setSelectedItem("Bronce");
        cu.jtEmailNoLoginCl.setText("");
        cu.jtCedula.requestFocus();
    }
    
    private void volver() {
        cu.setVisible(false);
        cu.dispose();
        cu.mp.setVisible(true);
    }

    public void evento_salir() {
        int respuesta = JOptionPane.showConfirmDialog(cu,
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
