/*
Proposito: Gestiona las interacciones del usuario en la vista Actualizar Usuario.
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
import Utilerias.Conexion;
import static Utilerias.DatosConexion.baseDatos;
import static Utilerias.DatosConexion.host;
import static Utilerias.DatosConexion.login;
import static Utilerias.DatosConexion.user;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import Vista.ActualizarUsuario;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControlActualizarUsuario implements ActionListener, WindowListener {

    ActualizarUsuario au;

    public ControlActualizarUsuario(ActualizarUsuario obj) {
        au = obj;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(au.jbVolver)) {
            volver();
        }
        if (e.getSource().equals(au.jbLimpiar)) {
            if ("Administrador".equals(au.contextoActualizar)) {
                limpiarAdmin();
                volverNoEditableAdm();
            }
            if ("Supervisor".equals(au.contextoActualizar)) {
                limpiarPersonal();
                volverNoEditableSup();
            }
            if ("Recepcionista".equals(au.contextoActualizar)) {
                limpiarPersonal();
                volverNoEditableRec();
            }
            if ("Entrenador".equals(au.contextoActualizar)) {
                limpiarEntrenador();
                volverNoEditableEnt();
            }
            if ("Cliente".equals(au.contextoActualizar)) {
                limpiarCliente();
                volverNoEditableCl();
            }
        }
        if (e.getSource().equals(au.jtAdministrador)) {
            limpiarAdmin();
            volverNoEditableAdm();
            hacerVisibleAdm();
            au.contextoActualizar = "Administrador";
        }
        if (e.getSource().equals(au.jtSupervisor)) {
            limpiarPersonal();
            volverNoEditableSup();
            hacerVisibleEmp();
            au.contextoActualizar = "Supervisor";
        }
        if (e.getSource().equals(au.jtRecepcionista)) {
            limpiarPersonal();
            volverNoEditableRec();
            hacerVisibleEmp();
            au.contextoActualizar = "Recepcionista";
        }
        if (e.getSource().equals(au.jtEntrenador)) {
            limpiarEntrenador();
            volverNoEditableEnt();
            hacerVisibleEnt();
            au.contextoActualizar = "Entrenador";
        }
        if (e.getSource().equals(au.JTcliente)) {
            limpiarCliente();
            volverNoEditableCl();
            hacerVisibleCl();
            au.contextoActualizar = "Cliente";
        }
        if (e.getSource().equals(au.jbConsultar)) {
            if ("Administrador".equals(au.contextoActualizar)) {
                Conexion con = new Conexion();
                boolean error = con.conectarMySQL(baseDatos, user, login, host);
                if (!error) {
                    String datos[] = con.consultaFila("administrador", "id_administrador", au.jtCedula.getText());
                    
                    if (datos == null) {
                        JOptionPane.showMessageDialog(au, "El administrador con cedula "
                                + au.jtCedula.getText() + " no existe en la tabla");
                    } else {
                        String datos2[] = con.consultaFila("usuario", "cedula_usuario", datos[0]);
                        volverEditableAdm();
                        au.jtNom.setText(datos2[1]);
                        au.jtApe.setText(datos2[2]);
                        String fechaString = datos2[3] + "/" + datos2[4] + "/" + datos2[5];
                        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
                        Date fecha = null;
                        try {
                            fecha = formatoFecha.parse(fechaString);
                        } catch (ParseException ex) {
                            Logger.getLogger(ControlConsultarUsuario.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        au.fecha_nac.setDate(fecha);
                        au.jtEmail.setText(datos2[6]);
                        if (datos2[8].equals("Activo")) {
                            au.jrActivo.setSelected(true);
                        }
                        if (datos2[8].equals("Inactivo")) {
                            au.jrInactivo.setSelected(true);
                        }
                        au.jtPassword.setText(datos[1]);
                        au.jtSueldo.setText(datos[2]);
                    }
                }
            }
            if ("Supervisor".equals(au.contextoActualizar)) {
                Conexion con = new Conexion();
                boolean error = con.conectarMySQL(baseDatos, user, login, host);
                if (!error) {
                    String datos[] = con.consultaFila("supervisor", "id_supervisor", au.jtCedula.getText());
                    
                    if (datos == null) {
                        JOptionPane.showMessageDialog(au, "El supervisor con cedula "
                                + au.jtCedula.getText() + " no existe en la tabla");
                    } else {
                        String datos2[] = con.consultaFila("usuario", "cedula_usuario", datos[0]);
                        volverEditableSup();
                        au.jtNom.setText(datos2[1]);
                        au.jtApe.setText(datos2[2]);
                        String fechaString = datos2[3] + "/" + datos2[4] + "/" + datos2[5];
                        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
                        Date fecha = null;
                        try {
                            fecha = formatoFecha.parse(fechaString);
                        } catch (ParseException ex) {
                            Logger.getLogger(ControlConsultarUsuario.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        au.fecha_nac.setDate(fecha);
                        au.jtEmail.setText(datos2[6]);
                        if (datos2[8].equals("Activo")) {
                            au.jrActivo.setSelected(true);
                        }
                        if (datos2[8].equals("Inactivo")) {
                            au.jrInactivo.setSelected(true);
                        }
                        au.jtPassword.setText(datos[1]);
                        au.jcTurno.setSelectedItem(datos[2]);
                        au.jtSueldo.setText(datos[3]);
                    }
                }
            }
            if ("Recepcionista".equals(au.contextoActualizar)) {
                Conexion con = new Conexion();
                boolean error = con.conectarMySQL(baseDatos, user, login, host);
                if (!error) {
                    String datos[] = con.consultaFila("recepcionista", "id_recepcionista", au.jtCedula.getText());
                    
                    if (datos == null) {
                        JOptionPane.showMessageDialog(au, "El o la recepcionista con cedula "
                                + au.jtCedula.getText() + " no existe en la tabla");
                    } else {
                        String datos2[] = con.consultaFila("usuario", "cedula_usuario", datos[0]);
                        volverEditableRec();
                        au.jtNom.setText(datos2[1]);
                        au.jtApe.setText(datos2[2]);
                        String fechaString = datos2[3] + "/" + datos2[4] + "/" + datos2[5];
                        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
                        Date fecha = null;
                        try {
                            fecha = formatoFecha.parse(fechaString);
                        } catch (ParseException ex) {
                            Logger.getLogger(ControlConsultarUsuario.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        au.fecha_nac.setDate(fecha);
                        au.jtEmail.setText(datos2[6]);
                        if (datos2[8].equals("Activo")) {
                            au.jrActivo.setSelected(true);
                        }
                        if (datos2[8].equals("Inactivo")) {
                            au.jrInactivo.setSelected(true);
                        }
                        au.jtPassword.setText(datos[1]);
                        au.jcTurno.setSelectedItem(datos[2]);
                        au.jtSueldo.setText(datos[3]);
                    }
                }
            }
            if ("Entrenador".equals(au.contextoActualizar)) {
                Conexion con = new Conexion();
                boolean error = con.conectarMySQL(baseDatos, user, login, host);
                if (!error) {
                    String datos[] = con.consultaFila("entrenador", "id_entrenador", au.jtCedula.getText());
                    
                    if (datos == null) {
                        JOptionPane.showMessageDialog(au, "El entrenador con cedula "
                                + au.jtCedula.getText() + " no existe en la tabla");
                    } else {
                        String datos2[] = con.consultaFila("usuario", "cedula_usuario", datos[0]);
                        volverEditableEnt();
                        au.jtNom.setText(datos2[1]);
                        au.jtApe.setText(datos2[2]);
                        String fechaString = datos2[3] + "/" + datos2[4] + "/" + datos2[5];
                        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
                        Date fecha = null;
                        try {
                            fecha = formatoFecha.parse(fechaString);
                        } catch (ParseException ex) {
                            Logger.getLogger(ControlConsultarUsuario.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        au.fecha_nac.setDate(fecha);
                        au.jtEmailNoLoginEnt.setText(datos2[6]);
                        if (datos2[8].equals("Activo")) {
                            au.jrActivo.setSelected(true);
                        }
                        if (datos2[8].equals("Inactivo")) {
                            au.jrInactivo.setSelected(true);
                        }
                        au.jcTurnoEnt.setSelectedItem((String) datos[1]);
                        au.jtSueldo.setText(datos[2]);
                    }
                }
            }
            if ("Cliente".equals(au.contextoActualizar)) {
                Conexion con = new Conexion();
                boolean error = con.conectarMySQL(baseDatos, user, login, host);
                if (!error) {
                    String datos[] = con.consultaFila("cliente", "id_cliente", au.jtCedula.getText());
                    if (datos == null) {
                        JOptionPane.showMessageDialog(au, "El o la cliente con cedula "
                                + au.jtCedula.getText() + " no existe en la tabla");
                    } else {
                        String datos2[] = con.consultaFila("usuario", "cedula_usuario", datos[0]);
                        String datos3[] = con.consultaFila("membresia_cliente", "id_cliente", datos[0]); //consulta membresia
                        volverEditableCl();
                        au.jtNom.setText(datos2[1]);
                        au.jtApe.setText(datos2[2]);
                        String fechaString = datos2[3] + "/" + datos2[4] + "/" + datos2[5];
                        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
                        Date fecha = null;
                        try {
                            fecha = formatoFecha.parse(fechaString);
                        } catch (ParseException ex) {
                            Logger.getLogger(ControlConsultarUsuario.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        au.fecha_nac.setDate(fecha);
                        au.jtEmailNoLoginCl.setText(datos2[6]);
                        if (datos2[8].equals("Activo")) {
                            au.jrActivo.setSelected(true);
                        }
                        if (datos2[8].equals("Inactivo")) {
                            au.jrInactivo.setSelected(true);
                        }
                        au.jcGrupoSanguineo.setSelectedItem(datos[1]);
                        au.jcMembresia.setSelectedItem(datos3[3]);

                    }
                }
            }
        }
        if (e.getSource().equals(au.jbActualizar)) {
            if ("Administrador".equals(au.contextoActualizar)) {
                if (au.jtNom.getText().isEmpty() || au.jtApe.getText().isEmpty()
                        || au.jtEmail.getText().isEmpty() || au.jtPassword.equals("") || au.fecha_nac.equals("")) {
                    JOptionPane.showMessageDialog(au, "Complete todos los datos",
                            "Error", 2);
                } else {
                    Administrador adm = new Administrador();
                    adm.setCedula(au.jtCedula.getText());
                    adm.setNombre(au.jtNom.getText());
                    adm.setApellido(au.jtApe.getText());

                    Calendar calendario = au.fecha_nac.getCalendar();
                    int dia = calendario.get(Calendar.DATE); // obtener el dia de nacimiento
                    int mes = calendario.get(Calendar.MONTH) + 1; // obtener el mes de nacimiento
                    int year = calendario.get(Calendar.YEAR); // obtener el year de nacimiento
                    adm.setDia(dia + "");
                    adm.setMes(mes + "");
                    adm.setYear(year + "");
                    adm.setEmail(au.jtEmail.getText());
                    adm.setPassword(au.jtPassword.getText());

                    ArrayList<String> datosUsu = new ArrayList<>();
                    //datosUsu.add(cli.getCedula());
                    datosUsu.add("nombre = '"+ adm.getNombre()+"'");
                    datosUsu.add("apellido = '"+adm.getApellido()+"'");
                    datosUsu.add("dia_nac = '"+adm.getDia()+"'");
                    datosUsu.add("mes_nac = '"+adm.getMes()+"'");
                    datosUsu.add("year_nac = '"+adm.getYear()+"'");
                    datosUsu.add("email = '"+adm.getEmail()+"'");
                    //datosUsu.add("tipo_usuario = "+au.contextoActualizar);
                    if(au.jrActivo.isSelected())datosUsu.add("estado = '"+"Activo"+"'" );
                    if(au.jrInactivo.isSelected())datosUsu.add("estado = '"+"Inactivo"+"'");

                    ArrayList<String> datosAdm = new ArrayList<>();
                    //datosAdm.add(cli.getCedula());
                    datosAdm.add("password = '"+adm.getPassword()+"'");
                    //datosAdm.add("sueldo = "+cli.getSalario());

                    Conexion con = new Conexion();
                    boolean error = con.conectarMySQL(baseDatos, user, login, host);
                    boolean error2 = error;
                    if (!error) { // si no hay error de conexion a la bd, entonces ...
                        error = con.actualizarFila("usuario",datosUsu,"cedula_usuario = '" + au.jtCedula.getText() + "'"); 
                        error2 = con.actualizarFila("administrador",datosAdm,"id_administrador = '" + au.jtCedula.getText() + "'");
                        if (!error && !error2) { // si no hay error al insertar en la tabla, mostrar un mensaje de confirmación
                            int res = JOptionPane.showConfirmDialog(au,
                                    "Se actualzo con exito al administrador.\n¿Desea actualizar otro?",
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
            if ("Supervisor".equals(au.contextoActualizar)) {
                if (au.jtNom.getText().isEmpty() || au.jtCedula.getText().isEmpty() || au.jtApe.getText().isEmpty()
                        || au.jtEmail.getText().isEmpty() || au.jtPassword.equals("") || au.fecha_nac.equals("")) {
                    JOptionPane.showMessageDialog(au, "Complete todos los datos",
                            "Error", 2);
                }else {
                    Supervisor sup = new Supervisor();
                    sup.setCedula(au.jtCedula.getText());
                    sup.setNombre(au.jtNom.getText());
                    sup.setApellido(au.jtApe.getText());
                    Calendar calendario = au.fecha_nac.getCalendar();
                    int dia = calendario.get(Calendar.DATE); // obtener el dia de nacimiento
                    int mes = calendario.get(Calendar.MONTH) + 1; // obtener el mes de nacimiento
                    int year = calendario.get(Calendar.YEAR); // obtener el year de nacimiento
                    sup.setDia(dia + "");
                    sup.setMes(mes + "");
                    sup.setYear(year + "");
                    sup.setEmail(au.jtEmail.getText());
                    sup.setPassword(au.jtPassword.getText());
                    sup.setTurno((String) au.jcTurno.getSelectedItem());

                    ArrayList<String> datosUsu = new ArrayList<>();
                    datosUsu.add("nombre = '"+ sup.getNombre()+"'");
                    datosUsu.add("apellido = '"+sup.getApellido()+"'");
                    datosUsu.add("dia_nac = '"+sup.getDia()+"'");
                    datosUsu.add("mes_nac = '"+sup.getMes()+"'");
                    datosUsu.add("year_nac = '"+sup.getYear()+"'");
                    datosUsu.add("email = '"+sup.getEmail()+"'");
                    if(au.jrActivo.isSelected())datosUsu.add("estado = '"+"Activo"+"'" );
                    if(au.jrInactivo.isSelected())datosUsu.add("estado = '"+"Inactivo"+"'");

                    ArrayList<String> datosSup = new ArrayList<>();
                    datosSup.add("password = '"+sup.getPassword()+"'");
                    datosSup.add("turno = '" +sup.getTurno() +"'");
                    Conexion con = new Conexion();
                    boolean error = con.conectarMySQL(baseDatos, user, login, host);
                    boolean error2 = error;
                    if (!error) { // si no hay error de conexion a la bd, entonces ...
                        error = con.actualizarFila("usuario",datosUsu,"cedula_usuario = '" + au.jtCedula.getText() + "'"); 
                        error2 = con.actualizarFila("supervisor",datosSup,"id_supervisor = '" + au.jtCedula.getText() + "'");
                        if (!error && !error2) { // si no hay error al insertar en la tabla, mostrar un mensaje de confirmación
                            int res = JOptionPane.showConfirmDialog(au,
                                    "Se actualzo con exito al Supervisor.\n¿Desea actualizar otro?",
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
            if ("Recepcionista".equals(au.contextoActualizar)) {
                if (au.jtNom.getText().isEmpty() || au.jtCedula.getText().isEmpty() || au.jtApe.getText().isEmpty()
                        || au.jtEmail.getText().isEmpty() || au.jtPassword.equals("") || au.fecha_nac.equals("")) {
                    JOptionPane.showMessageDialog(au, "Complete todos los datos",
                            "Error", 2);
                }else {
                    Recepcionista rec = new Recepcionista();
                    rec.setCedula(au.jtCedula.getText());
                    rec.setNombre(au.jtNom.getText());
                    rec.setApellido(au.jtApe.getText());
                    Calendar calendario = au.fecha_nac.getCalendar();
                    int dia = calendario.get(Calendar.DATE); // obtener el dia de nacimiento
                    int mes = calendario.get(Calendar.MONTH) + 1; // obtener el mes de nacimiento
                    int year = calendario.get(Calendar.YEAR); // obtener el year de nacimiento
                    rec.setDia(dia + "");
                    rec.setMes(mes + "");
                    rec.setYear(year + "");
                    rec.setEmail(au.jtEmail.getText());
                    rec.setPassword(au.jtPassword.getText());
                    rec.setTurno((String) au.jcTurno.getSelectedItem());

                    ArrayList<String> datosUsu = new ArrayList<>();
                    datosUsu.add("nombre = '"+ rec.getNombre()+"'");
                    datosUsu.add("apellido = '"+rec.getApellido()+"'");
                    datosUsu.add("dia_nac = '"+rec.getDia()+"'");
                    datosUsu.add("mes_nac = '"+rec.getMes()+"'");
                    datosUsu.add("year_nac = '"+rec.getYear()+"'");
                    datosUsu.add("email = '"+rec.getEmail()+"'");
                    if(au.jrActivo.isSelected())datosUsu.add("estado = '"+"Activo"+"'" );
                    if(au.jrInactivo.isSelected())datosUsu.add("estado = '"+"Inactivo"+"'");

                    ArrayList<String> datosRec = new ArrayList<>();
                    datosRec.add("password = '"+rec.getPassword()+"'");
                    datosRec.add("turno = '" +rec.getTurno() +"'");
                    Conexion con = new Conexion();
                    boolean error = con.conectarMySQL(baseDatos, user, login, host);
                    boolean error2 = error;
                    if (!error) { // si no hay error de conexion a la bd, entonces ...
                        error = con.actualizarFila("usuario",datosUsu,"cedula_usuario = '" + au.jtCedula.getText() + "'"); 
                        error2 = con.actualizarFila("recepcionista",datosRec,"id_recepcionista = '" + au.jtCedula.getText() + "'");
                        if (!error && !error2) { // si no hay error al insertar en la tabla, mostrar un mensaje de confirmación
                            int res = JOptionPane.showConfirmDialog(au,
                                    "Se actualzo con exito al o la recepcionista.\n¿Desea actualizar otro?",
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
            if ("Entrenador".equals(au.contextoActualizar)) {
                if (au.jtNom.getText().isEmpty() || au.jtCedula.getText().isEmpty() || au.jtApe.getText().isEmpty()
                        || au.jtEmailNoLoginEnt.getText().isEmpty() || au.fecha_nac.equals("")) {
                    JOptionPane.showMessageDialog(au, "Complete todos los datos",
                            "Error", 2);
                }else {
                    Entrenador entr = new Entrenador();
                    entr.setCedula(au.jtCedula.getText());
                    entr.setNombre(au.jtNom.getText());
                    entr.setApellido(au.jtApe.getText());
                    Calendar calendario = au.fecha_nac.getCalendar();
                    int dia = calendario.get(Calendar.DATE); // obtener el dia de nacimiento
                    int mes = calendario.get(Calendar.MONTH) + 1; // obtener el mes de nacimiento
                    int year = calendario.get(Calendar.YEAR); // obtener el year de nacimiento
                    entr.setDia(dia + "");
                    entr.setMes(mes + "");
                    entr.setYear(year + "");
                    entr.setEmail(au.jtEmailNoLoginEnt.getText());
                    entr.setTurno((String) au.jcTurnoEnt.getSelectedItem());

                    ArrayList<String> datosUsu = new ArrayList<>();
                    datosUsu.add("nombre = '"+ entr.getNombre()+"'");
                    datosUsu.add("apellido = '"+entr.getApellido()+"'");
                    datosUsu.add("dia_nac = '"+entr.getDia()+"'");
                    datosUsu.add("mes_nac = '"+entr.getMes()+"'");
                    datosUsu.add("year_nac = '"+entr.getYear()+"'");
                    datosUsu.add("email = '"+entr.getEmail()+"'");
                    if(au.jrActivo.isSelected())datosUsu.add("estado = '"+"Activo"+"'" );
                    if(au.jrInactivo.isSelected())datosUsu.add("estado = '"+"Inactivo"+"'");

                    ArrayList<String> datosEnt = new ArrayList<>();
                    datosEnt.add("turno = '" +entr.getTurno() +"'");
                    Conexion con = new Conexion();
                    boolean error = con.conectarMySQL(baseDatos, user, login, host);
                    boolean error2 = error;
                    if (!error) { // si no hay error de conexion a la bd, entonces ...
                        error = con.actualizarFila("usuario",datosUsu,"cedula_usuario = '" + au.jtCedula.getText() + "'"); 
                        error2 = con.actualizarFila("entrenador",datosEnt,"id_entrenador = '" + au.jtCedula.getText() + "'");
                        if (!error && !error2) { // si no hay error al insertar en la tabla, mostrar un mensaje de confirmación
                            int res = JOptionPane.showConfirmDialog(au,
                                    "Se actualzo con exito al o la entrenador@.\n¿Desea actualizar otro?",
                                    "Confirmación", JOptionPane.YES_NO_OPTION);
                            if (res == JOptionPane.YES_OPTION) { 
                                limpiarEntrenador(); // limpiar el formulario
                            } else {
                                volver(); // de lo contrario volver el menu principal
                            }
                        }

                        con.desconectar(); // cerrar la conexion con la bd
                    }

                }
            }
            if ("Cliente".equals(au.contextoActualizar)) {
                if (au.jtNom.getText().isEmpty() || au.jtCedula.getText().isEmpty() || au.jtApe.getText().isEmpty()
                        || au.jtEmailNoLoginCl.getText().isEmpty() || au.fecha_nac.equals("")) {
                    JOptionPane.showMessageDialog(au, "Complete todos los datos",
                            "Error", 2);
                }else {
                    Clientes cli = new Clientes();
                    cli.setCedula(au.jtCedula.getText());
                    cli.setNombre(au.jtNom.getText());
                    cli.setApellido(au.jtApe.getText());
                    Calendar calendario = au.fecha_nac.getCalendar();
                    int dia = calendario.get(Calendar.DATE); // obtener el dia de nacimiento
                    int mes = calendario.get(Calendar.MONTH) + 1; // obtener el mes de nacimiento
                    int year = calendario.get(Calendar.YEAR); // obtener el year de nacimiento
                    cli.setDia(dia + "");
                    cli.setMes(mes + "");
                    cli.setYear(year + "");
                    cli.setEmail(au.jtEmailNoLoginCl.getText());
                    cli.setGrupoSanguineo((String) au.jcGrupoSanguineo.getSelectedItem());
                    //cli.setMembresia((String)au.jcMembresia.getSelectedItem());

                    ArrayList<String> datosUsu = new ArrayList<>();
                    datosUsu.add("nombre = '"+ cli.getNombre()+"'");
                    datosUsu.add("apellido = '"+cli.getApellido()+"'");
                    datosUsu.add("dia_nac = '"+cli.getDia()+"'");
                    datosUsu.add("mes_nac = '"+cli.getMes()+"'");
                    datosUsu.add("year_nac = '"+cli.getYear()+"'");
                    datosUsu.add("email = '"+cli.getEmail()+"'");
                    if(au.jrActivo.isSelected())datosUsu.add("estado = '"+"Activo"+"'" );
                    if(au.jrInactivo.isSelected())datosUsu.add("estado = '"+"Inactivo"+"'");

                    ArrayList<String> datosEnt = new ArrayList<>();
                    datosEnt.add("grupo_sanguineo = '" +cli.getGrupoSanguineo()+"'");
                    
                    ArrayList<String> datosMem = new ArrayList<>();
                    datosMem.add("tipo_membresia = '" +au.jcMembresia.getSelectedItem()+"'");
                    
                    Conexion con = new Conexion();
                    boolean error = con.conectarMySQL(baseDatos, user, login, host);
                    boolean error2 = error;
                    boolean error3 = error;
                    if (!error) { // si no hay error de conexion a la bd, entonces ...
                        error = con.actualizarFila("usuario",datosUsu,"cedula_usuario = '" + au.jtCedula.getText() + "'"); 
                        error2 = con.actualizarFila("cliente",datosEnt,"id_cliente = '" + au.jtCedula.getText() + "'");
                        error3 = con.actualizarFila("membresia_cliente",datosMem,"id_cliente = '" + au.jtCedula.getText() + "'");
                        if (!error && !error2 && !error3) { // si no hay error al insertar en la tabla, mostrar un mensaje de confirmación
                            int res = JOptionPane.showConfirmDialog(au,
                                    "Se actualzo con exito al cliente.\n¿Desea actualizar otro?",
                                    "Confirmación", JOptionPane.YES_NO_OPTION);
                            if (res == JOptionPane.YES_OPTION) { 
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
        //--------------------***metodo volver***----------------------------------------------------------------------
    private void volver() {
        au.setVisible(false);
        au.dispose();
        au.mp.setVisible(true);
    }

    //---------------------***metodos hacer visible-----------------------------------------------------------------
    public void hacerVisibleAdm() {
        au.jpConsultarDatosBase.setVisible(true);
        au.jpLoguearse.setVisible(true);
        au.jpConsultarTurno.setVisible(false);
        au.jpConsultarGrupoSanguineo.setVisible(false);
        au.jpSueldo.setVisible(true);
    }

    public void hacerVisibleEmp() {
        au.jpConsultarDatosBase.setVisible(true);
        au.jpLoguearse.setVisible(true);
        au.jpConsultarTurno.setVisible(true);
        au.jpConsultarGrupoSanguineo.setVisible(false);
        au.jpSueldo.setVisible(true);
    }

    public void hacerVisibleEnt() {
        au.jpConsultarDatosBase.setVisible(true);
        au.jpLoguearse.setVisible(false);
        au.jpConsultarTurno.setVisible(false);
        au.jpConsultarTurnoEmail.setVisible(true);
        au.jpConsultarGrupoSanguineo.setVisible(false);
        au.jpSueldo.setVisible(true);
    }

    public void hacerVisibleCl() {
        au.jpConsultarDatosBase.setVisible(true);
        au.jpLoguearse.setVisible(false);
        au.jpConsultarTurno.setVisible(false);
        au.jpConsultarTurnoEmail.setVisible(false);
        au.jpConsultarGrupoSanguineo.setVisible(true);
        au.jpSueldo.setVisible(false);
    }

    //---------------------***metodos limpiar***-------------------------------------------------------------------
    private void limpiarAdmin() {
        au.jtCedula.setText("");
        au.jtNom.setText("");
        au.jtApe.setText("");
        Calendar actual = Calendar.getInstance();
        au.fecha_nac.setDate(actual.getTime());
        au.jtEmail.setText("");
        au.jtPassword.setText("");
        au.jtCedula.requestFocus();
        au.jrActivo.setSelected(false);
        au.jrInactivo.setSelected(false);
        au.jtSueldo.setText("");
    }

    private void limpiarPersonal() {
        au.jtCedula.setText("");
        au.jtNom.setText("");
        au.jtApe.setText("");
        Calendar actual = Calendar.getInstance();
        au.fecha_nac.setDate(actual.getTime());
        au.jcTurno.setSelectedItem("mañana");
        au.jtEmail.setText("");
        au.jtPassword.setText("");
        au.jtSueldo.setText("");
        au.jtCedula.requestFocus();
        au.jtSueldo.setText("");
    }

    private void limpiarEntrenador() {
        au.jtCedula.setText("");
        au.jtNom.setText("");
        au.jtApe.setText("");
        Calendar actual = Calendar.getInstance();
        au.fecha_nac.setDate(actual.getTime());
        au.jcTurnoEnt.setSelectedItem("mañana");
        au.jtEmailNoLoginEnt.setText("");
        au.jtCedula.requestFocus();
        au.jtSueldo.setText("");
    }

    private void limpiarCliente() {
        au.jtCedula.setText("");
        au.jtNom.setText("");
        au.jtApe.setText("");
        Calendar actual = Calendar.getInstance();
        au.fecha_nac.setDate(actual.getTime());
        au.jcGrupoSanguineo.setSelectedItem("A+");
        au.jtEmailNoLoginCl.setText("");
        au.jtCedula.requestFocus();
    }

    //---------------------Volver editables-----------------------------------------------------------
    public void volverEditableAdm() {
        au.jtCedula.setEditable(false);
        au.jtNom.setEditable(true);
        au.jtApe.setEditable(true);
        au.jtNom.setEditable(true);
        au.fecha_nac.setEnabled(true);
        au.jrActivo.setEnabled(true);
        au.jrInactivo.setEnabled(true);
        au.jtEmail.setEditable(true);
        au.jtPassword.setEditable(true);
    }

    public void volverEditableSup() {
        au.jtCedula.setEditable(false);
        au.jtNom.setEditable(true);
        au.jtApe.setEditable(true);
        au.jtNom.setEditable(true);
        au.fecha_nac.setEnabled(true);
        au.jrActivo.setEnabled(true);
        au.jrInactivo.setEnabled(true);
        au.jtEmail.setEditable(true);
        au.jtPassword.setEditable(true);
        au.jcTurno.setEnabled(true);
    }
    public void volverEditableRec() {
        au.jtCedula.setEditable(false);
        au.jtNom.setEditable(true);
        au.jtApe.setEditable(true);
        au.jtNom.setEditable(true);
        au.fecha_nac.setEnabled(true);
        au.jrActivo.setEnabled(true);
        au.jrInactivo.setEnabled(true);
        au.jtEmail.setEditable(true);
        au.jtPassword.setEditable(true);
        au.jcTurno.setEnabled(true);
    }

    public void volverEditableEnt() {
        au.jtCedula.setEditable(false);
        au.jtNom.setEditable(true);
        au.jtApe.setEditable(true);
        au.jtNom.setEditable(true);
        au.fecha_nac.setEnabled(true);
        au.jrActivo.setEnabled(true);
        au.jrInactivo.setEnabled(true);
        au.jtEmailNoLoginEnt.setEditable(true);
        au.jcTurnoEnt.setEnabled(true);
    }

    public void volverEditableCl() {
        au.jtCedula.setEditable(false);
        au.jtNom.setEditable(true);
        au.jtApe.setEditable(true);
        au.jtNom.setEditable(true);
        au.fecha_nac.setEnabled(true);
        au.jrActivo.setEnabled(true);
        au.jrInactivo.setEnabled(true);
        au.jtEmailNoLoginCl.setEditable(true);
        au.jcMembresia.setEnabled(true);
        au.jcGrupoSanguineo.setEnabled(true);
    }

    //----------------volver no editables------------------------------------------------------------------------------
    public void volverNoEditableAdm() {
        au.jtCedula.setEditable(true);
        au.jtNom.setEditable(false);
        au.jtApe.setEditable(false);
        au.jtNom.setEditable(false);
        au.fecha_nac.setEnabled(false);
        au.jrActivo.setEnabled(false);
        au.jrInactivo.setEnabled(false);
        au.jtEmail.setEditable(false);
        au.jtPassword.setEditable(false);
    }

    public void volverNoEditableSup(){
        au.jtCedula.setEditable(true);
        au.jtNom.setEditable(false);
        au.jtApe.setEditable(false);
        au.jtNom.setEditable(false);
        au.fecha_nac.setEnabled(false);
        au.jrActivo.setEnabled(false);
        au.jrInactivo.setEnabled(false);
        au.jtEmail.setEditable(false);
        au.jtPassword.setEditable(false);
        au.jcTurno.setEnabled(false);
    }
    public void volverNoEditableRec() {
        au.jtCedula.setEditable(true);
        au.jtNom.setEditable(false);
        au.jtApe.setEditable(false);
        au.jtNom.setEditable(false);
        au.fecha_nac.setEnabled(false);
        au.jrActivo.setEnabled(false);
        au.jrInactivo.setEnabled(false);
        au.jtEmail.setEditable(false);
        au.jtPassword.setEditable(false);
        au.jcTurno.setEnabled(false);
    }

    public void volverNoEditableEnt() {
        au.jtCedula.setEditable(true);
        au.jtNom.setEditable(false);
        au.jtApe.setEditable(false);
        au.jtNom.setEditable(false);
        au.fecha_nac.setEnabled(false);
        au.jrActivo.setEnabled(false);
        au.jrInactivo.setEnabled(false);
        au.jtEmailNoLoginEnt.setEditable(false);
        au.jcTurnoEnt.setEnabled(false);
    }

    public void volverNoEditableCl() {
        au.jtCedula.setEditable(true);
        au.jtNom.setEditable(false);
        au.jtApe.setEditable(false);
        au.jtNom.setEditable(false);
        au.fecha_nac.setEnabled(false);
        au.jrActivo.setEnabled(false);
        au.jrInactivo.setEnabled(false);
        au.jtEmailNoLoginCl.setEditable(false);
        au.jcMembresia.setEnabled(false);
        au.jcGrupoSanguineo.setEnabled(false);
    }

    public void evento_salir() {
        int respuesta = JOptionPane.showConfirmDialog(au,
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
