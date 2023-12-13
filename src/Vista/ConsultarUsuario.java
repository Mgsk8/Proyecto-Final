/**
 * Propósito: Clase que representa la interfaz gráfica para consultar información de usuarios, 
 * permitiendo visualizar datos como la cédula, nombre, apellido, email, entre otros.
 * 
 * @version 1.0
 * @since 11/12/2023
 * @author  Jhon Alex Rodríguez Benítez - 2264363
 * @author  Miguel Angel Escobar Marín - 2264305
 * @author  John Alejandro Vallarino Cruz - 2264332
 */

package Vista;

import Controlador.ControlConsultarUsuario;
import Utilerias.JButtonFuncion;
import Utilerias.JLabelTitulo;
import Utilerias.LimitadorCaracteres;
import com.toedter.calendar.JDateChooser;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.border.TitledBorder;


/**
 * Propósito: Clase que representa la interfaz gráfica para consultar información de usuarios, 
 * permitiendo visualizar datos como la cédula, nombre, apellido, email, entre otros.
 */
public class ConsultarUsuario extends JFrame{
    
    /** Botón de opción para seleccionar el estado "Activo". */
    public JRadioButton jrActivo;

    /** Botón de opción para seleccionar el estado "Inactivo". */
    public JRadioButton jrInactivo;
    
    /** Botón de alternancia para seleccionar el tipo de usuario "Administrador". */
    public JToggleButton jtAdministrador;

    /** Botón de alternancia para seleccionar el tipo de usuario "Supervisor". */
    public JToggleButton jtSupervisor;

    /** Botón de alternancia para seleccionar el tipo de usuario "Entrenador". */
    public JToggleButton jtEntrenador;

    /** Botón de alternancia para seleccionar el tipo de usuario "Recepcionista". */
    public JToggleButton jtRecepcionista;

    /** Botón de alternancia para seleccionar el tipo de usuario "Cliente". */
    public JToggleButton JTcliente;

    /** Botón de función para volver al menú principal. */
    public JButton jbVolver;

    /** Botón de función para realizar la consulta de datos del usuario. */
    public JButton jbConsultar;

    /** Botón de función para limpiar los campos de consulta. */
    public JButton jbLimpiar;

    /** Tipo de consulta (Datos Base, Turno, Grupo Sanguíneo, etc.). */
    public TipoConsulta tc;

    /** Campo de texto para ingresar la cédula del usuario. */
    public JTextField jtCedula;

    /** Campo de texto para ingresar el nombre del usuario. */
    public JTextField jtNom;

    /** Campo de texto para ingresar el apellido del usuario. */
    public JTextField jtApe;

    /** Campo de texto para ingresar el email del usuario. */
    public JTextField jtEmail;

    /** Campo de texto para ingresar el email (sin login) del entrenador. */
    public JTextField jtEmailNoLoginEnt;

    /** Campo de texto para ingresar el email (sin login) del cliente. */
    public JTextField jtEmailNoLoginCl;

    /** Campo de texto para ingresar la contraseña del usuario. */
    public JTextField jtPassword;

    /** Campo de texto para ingresar el sueldo del usuario. */
    public JTextField jtSueldo;

    /** Lista desplegable para seleccionar el grupo sanguíneo del usuario. */
    public JComboBox<String> jcGrupoSanguineo;

    /** Lista desplegable para seleccionar el turno del usuario. */
    public JComboBox<String> jcTurno;

    /** Lista desplegable para seleccionar el turno del entrenador. */
    public JComboBox<String> jcTurnoEnt;

    /** Lista desplegable para seleccionar el tipo de membresía del usuario. */
    public JComboBox<String> jcMembresia;

    /** Selector de fecha de nacimiento. */
    public JDateChooser fecha_nac;

    /** Panel para consultar los datos base del usuario. */
    public JPanel jpConsultarDatosBase;

    /** Panel para consultar el turno del usuario. */
    public JPanel jpConsultarTurno;

    /** Panel para consultar el grupo sanguíneo del usuario. */
    public JPanel jpConsultarGrupoSanguineo;

    /** Panel para consultar el turno y email del usuario. */
    public JPanel jpConsultarTurnoEmail;

    /** Panel para loguearse como otro usuario. */
    public JPanel jpLoguearse;

    /** Panel para consultar el sueldo del usuario. */
    public JPanel jpSueldo;

    /** Etiqueta para mostrar el campo de la cédula del usuario. */
    public JLabel jlCed;

    /** Etiqueta para mostrar el campo del nombre del usuario. */
    public JLabel jlNom;

    /** Etiqueta para mostrar el campo del apellido del usuario. */
    public JLabel jlApe;

    /** Etiqueta para mostrar el campo de la fecha de nacimiento del usuario. */
    public JLabel jlFecha;

    /** Etiqueta para mostrar el campo del grupo sanguíneo del usuario. */
    public JLabel jlGrupoSanguineo;

    /** Etiqueta para mostrar el campo del email del usuario. */
    public JLabel jlEmail;

    /** Etiqueta para mostrar el campo del email (sin login) del entrenador. */
    public JLabel jlEmailNoLoginEnt;

    /** Etiqueta para mostrar el campo del turno del entrenador. */
    public JLabel jlTurnoEnt;

    /** Etiqueta para mostrar el campo del email (sin login) del cliente. */
    public JLabel jlEmailNologinCl;

    /** Etiqueta para mostrar el campo de la contraseña del usuario. */
    public JLabel jlPassword;

    /** Etiqueta para mostrar el campo del turno del usuario. */
    public JLabel jlTurno;

    /** Etiqueta para mostrar el campo del estado del usuario. */
    public JLabel jlEstado;

    /** Etiqueta para mostrar el campo del sueldo del usuario. */
    public JLabel jlSueldo;

    /** Etiqueta para mostrar el campo de la membresía del usuario. */
    public JLabel jlMembresia;

    /** Contexto para indicar si se está actualizando la información. */
    public String contextoActualizar;

    /** Controlador de la clase ConsultarUsuario. */
    ControlConsultarUsuario ccu;

    /** String que almacena los privilegios del usuario. */
    String privilegios = "";

    /**
     * Constructor de la clase ConsultarUsuario.
     * 
     * @param tc Tipo de consulta (Datos Base, Turno, Grupo Sanguíneo, etc.).
     * @param privi String que almacena los privilegios del usuario.
     */
    public ConsultarUsuario(TipoConsulta tc, String privi){
        super("Consultar datos");
        this.tc = tc;
        privilegios = privi;
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        Image icono = new ImageIcon(getClass().getResource("/Imagenes/LogoBlancoVentana.png")).getImage();
        setIconImage(icono);
        setResizable(false);
        setLayout(null);
        ccu = new ControlConsultarUsuario(this);
        addWindowListener(ccu);
        crearGUI();
        
        setVisible(true);
    }
    
    /**
     * Método que crea la interfaz gráfica para la consulta de datos de usuario.
     */
    public void crearGUI(){
        ccu = new ControlConsultarUsuario(this);
        JLabelTitulo jt = new JLabelTitulo(
                60, "Consultar Usuario", this, "/Imagenes/agregar-usuario.png");
        add(jt);
        //----------------------Jpanel Tipo Usuario ----------------------------------------------------------------------
        JPanel jpTipoUsuario = new JPanel();
        jpTipoUsuario.setBounds(20, 80, 220, 360);
        jpTipoUsuario.setLayout(null);
        jpTipoUsuario.setBorder(new TitledBorder("Tipo Usuario a consultar"));
        add(jpTipoUsuario);
        
        // ------------ verificacion privilegios -------------
        
        if (privilegios == "Recepcionista"){
            jtEntrenador = new JToggleButton("Consultar entrenador");
            jtEntrenador.setBounds(10, 40, 200, 40);
            jtEntrenador.setBackground(new Color(226, 0, 82));
            jtEntrenador.setForeground(Color.white);
            jtEntrenador.setFont(new Font("Tahoma", 1, 12));
            jtEntrenador.setBorderPainted(false);
            jtEntrenador.setFocusPainted(false);
            jtEntrenador.setCursor(new Cursor(Cursor.HAND_CURSOR));
            jtEntrenador.addActionListener(ccu);
            jpTipoUsuario.add(jtEntrenador);

            JTcliente = new JToggleButton("Consultar cliente");
            JTcliente.setBounds(10, 100, 200, 40);
            JTcliente.setBackground(new Color(226, 0, 82));
            JTcliente.setForeground(Color.white);
            JTcliente.setFont(new Font("Tahoma", 1, 12));
            JTcliente.setBorderPainted(false);
            JTcliente.setFocusPainted(false);
            JTcliente.setCursor(new Cursor(Cursor.HAND_CURSOR));
            JTcliente.addActionListener(ccu);
            jpTipoUsuario.add(JTcliente);

            ButtonGroup bg = new ButtonGroup();
            bg.add(jtEntrenador);
            bg.add(JTcliente);
        }
        
        if (privilegios == "Supervisor") {
            jtRecepcionista = new JToggleButton("Consultar Recepcionista");
            jtRecepcionista.setBounds(10, 40, 200, 40);
            jtRecepcionista.setBackground(new Color(226, 0, 82));
            jtRecepcionista.setForeground(Color.white);
            jtRecepcionista.setFont(new Font("Tahoma", 1, 12));
            jtRecepcionista.setBorderPainted(false);
            jtRecepcionista.setFocusPainted(false);
            jtRecepcionista.setCursor(new Cursor(Cursor.HAND_CURSOR));
            jtRecepcionista.addActionListener(ccu);
            jpTipoUsuario.add(jtRecepcionista);

            jtEntrenador = new JToggleButton("Consultar entrenador");
            jtEntrenador.setBounds(10, 100, 200, 40);
            jtEntrenador.setBackground(new Color(226, 0, 82));
            jtEntrenador.setForeground(Color.white);
            jtEntrenador.setFont(new Font("Tahoma", 1, 12));
            jtEntrenador.setBorderPainted(false);
            jtEntrenador.setFocusPainted(false);
            jtEntrenador.setCursor(new Cursor(Cursor.HAND_CURSOR));
            jtEntrenador.addActionListener(ccu);
            jpTipoUsuario.add(jtEntrenador);

            JTcliente = new JToggleButton("Consultar cliente");
            JTcliente.setBounds(10, 160, 200, 40);
            JTcliente.setBackground(new Color(226, 0, 82));
            JTcliente.setForeground(Color.white);
            JTcliente.setFont(new Font("Tahoma", 1, 12));
            JTcliente.setBorderPainted(false);
            JTcliente.setFocusPainted(false);
            JTcliente.setCursor(new Cursor(Cursor.HAND_CURSOR));
            JTcliente.addActionListener(ccu);
            jpTipoUsuario.add(JTcliente);

            ButtonGroup bg = new ButtonGroup();
            bg.add(jtRecepcionista);
            bg.add(jtEntrenador);
            bg.add(JTcliente);
        }

        if (privilegios == "Administrador"){
            jtAdministrador = new JToggleButton("Consultar Administrador");
            jtAdministrador.setBounds(10, 40, 200, 40);
            jtAdministrador.setBackground(new Color(226, 0, 82));
            jtAdministrador.setForeground(Color.white);
            jtAdministrador.setFont(new Font("Tahoma", 1, 12));
            jtAdministrador.setBorderPainted(false);
            jtAdministrador.setFocusPainted(false);
            jtAdministrador.setCursor(new Cursor(Cursor.HAND_CURSOR));
            jtAdministrador.addActionListener(ccu);
            jpTipoUsuario.add(jtAdministrador);

            jtSupervisor = new JToggleButton("Consultar Supervisor");
            jtSupervisor.setBounds(10, 100, 200, 40);
            jtSupervisor.setBackground(new Color(226, 0, 82));
            jtSupervisor.setForeground(Color.white);
            jtSupervisor.setFont(new Font("Tahoma", 1, 12));
            jtSupervisor.setBorderPainted(false);
            jtSupervisor.setFocusPainted(false);
            jtSupervisor.setCursor(new Cursor(Cursor.HAND_CURSOR));
            jtSupervisor.addActionListener(ccu);
            jpTipoUsuario.add(jtSupervisor);

            jtRecepcionista = new JToggleButton("Consultar Recepcionista");
            jtRecepcionista.setBounds(10, 160, 200, 40);
            jtRecepcionista.setBackground(new Color(226, 0, 82));
            jtRecepcionista.setForeground(Color.white);
            jtRecepcionista.setFont(new Font("Tahoma", 1, 12));
            jtRecepcionista.setBorderPainted(false);
            jtRecepcionista.setFocusPainted(false);
            jtRecepcionista.setCursor(new Cursor(Cursor.HAND_CURSOR));
            jtRecepcionista.addActionListener(ccu);
            jpTipoUsuario.add(jtRecepcionista);

            jtEntrenador = new JToggleButton("Consultar entrenador");
            jtEntrenador.setBounds(10, 220, 200, 40);
            jtEntrenador.setBackground(new Color(226, 0, 82));
            jtEntrenador.setForeground(Color.white);
            jtEntrenador.setFont(new Font("Tahoma", 1, 12));
            jtEntrenador.setBorderPainted(false);
            jtEntrenador.setFocusPainted(false);
            jtEntrenador.setCursor(new Cursor(Cursor.HAND_CURSOR));
            jtEntrenador.addActionListener(ccu);
            jpTipoUsuario.add(jtEntrenador);

            JTcliente = new JToggleButton("Consultar cliente");
            JTcliente.setBounds(10, 280, 200, 40);
            JTcliente.setBackground(new Color(226, 0, 82));
            JTcliente.setForeground(Color.white);
            JTcliente.setFont(new Font("Tahoma", 1, 12));
            JTcliente.setBorderPainted(false);
            JTcliente.setFocusPainted(false);
            JTcliente.setCursor(new Cursor(Cursor.HAND_CURSOR));
            JTcliente.addActionListener(ccu);
            jpTipoUsuario.add(JTcliente);

            ButtonGroup bg = new ButtonGroup();
            bg.add(jtAdministrador);
            bg.add(jtSupervisor);
            bg.add(jtRecepcionista);
            bg.add(jtEntrenador);
            bg.add(JTcliente);
        }

        //--------------------JPanel Consultar Datos ----------------------------------------------------------------------
        
        //------------------panel Consultar Datos Base---------------------------------------------------------------
        jpConsultarDatosBase = new JPanel();
        jpConsultarDatosBase.setBounds(250, 80, 400, 250);
        jpConsultarDatosBase.setLayout(null);
        jpConsultarDatosBase.setBorder(new TitledBorder("Consulta de datos base"));
        jpConsultarDatosBase.setVisible(false);
        add(jpConsultarDatosBase);
        
        jlCed = new JLabel("Cedula:");
        jlCed.setBounds(40, 20, 120, 30);
        jpConsultarDatosBase.add(jlCed);
        jtCedula = new JTextField();
        jtCedula.setBounds(130, 20, 200, 30);
        jtCedula.setDocument(new LimitadorCaracteres(jtCedula, 20, 0));
        jpConsultarDatosBase.add(jtCedula);

        jlNom = new JLabel("Nombre:");
        jlNom.setBounds(40, 70, 120, 30);
        jpConsultarDatosBase.add(jlNom);
        jtNom = new JTextField();
        jtNom.setBounds(130, 70, 200, 30);
        jtNom.setDocument(new LimitadorCaracteres(jtNom, 20, 1));
        jtNom.setEditable(false);
        jpConsultarDatosBase.add(jtNom);
        

        jlApe = new JLabel("Apellido:");
        jlApe.setBounds(40, 120, 120, 30);
        jpConsultarDatosBase.add(jlApe);
        jtApe = new JTextField();
        jtApe.setBounds(130, 120, 200, 30);
        jtApe.setDocument(new LimitadorCaracteres(jtApe, 20, 1));
        jtApe.setEditable(false);
        jpConsultarDatosBase.add(jtApe);

        jlFecha = new JLabel("<html><center>fecha de <br> nacimiento:</html>");
        jlFecha.setBounds(40, 170, 150, 30);
        jpConsultarDatosBase.add(jlFecha);
        fecha_nac = new JDateChooser(new Date());// crear el dateChooser con la fecha actual
        fecha_nac.setBounds(130, 170, 150, 30);
        fecha_nac.setEnabled(false);
        jpConsultarDatosBase.add(fecha_nac);
        
        jlEstado = new JLabel("Estado:");
        jlEstado.setBounds(40, 220, 120, 30);
        jpConsultarDatosBase.add(jlEstado);
        jrActivo = new JRadioButton("Activo");
        jrActivo.setBounds(130, 220,120,30);
        jrActivo.setFocusPainted(false);
        jrActivo.setContentAreaFilled(false);
        jrActivo.setEnabled(false);
        jpConsultarDatosBase.add(jrActivo);
        
        jrInactivo = new JRadioButton("Inactivo");
        jrInactivo.setBounds(270, 220,120,30);
        jrInactivo.setFocusPainted(false);
        jrInactivo.setContentAreaFilled(false);
        jrInactivo.setEnabled(false);
        jpConsultarDatosBase.add(jrInactivo);
        
        ButtonGroup bgE = new ButtonGroup();
        bgE.add(jrActivo);
        bgE.add(jrInactivo);
        
        
        //---------------------------panel ingresar turno-----------------------------------------------------------
        jpConsultarTurno = new JPanel();
        jpConsultarTurno.setBounds(670, 80, 260, 250);
        jpConsultarTurno.setLayout(null);
        jpConsultarTurno.setBorder(new TitledBorder("Consulta de datos"));
        jpConsultarTurno.setVisible(false);
        add(jpConsultarTurno);
        
        jlTurno = new JLabel("Turno:");
        jlTurno.setBounds(40, 80, 150, 30);
        jpConsultarTurno.add(jlTurno);
        jcTurno = new JComboBox<>();
        String tipo[] = {"Mañana", "Tarde", "Noche"};
        for (int i = 0; i < tipo.length; i++) {
            jcTurno.addItem(tipo[i]);
        }
        jcTurno.setBounds(40, 120, 200, 30);
        jcTurno.setEnabled(false);
        jpConsultarTurno.add(jcTurno);
        
        //----------------------- Panel turno email-----------------------------------------------------
        jpConsultarTurnoEmail = new JPanel();
        jpConsultarTurnoEmail.setBounds(670, 80, 260, 250);
        jpConsultarTurnoEmail.setLayout(null);
        jpConsultarTurnoEmail.setBorder(new TitledBorder("Consulta de datos"));
        jpConsultarTurnoEmail.setVisible(false);
        add(jpConsultarTurnoEmail);
        
        jlTurnoEnt = new JLabel("Turno:");
        jlTurnoEnt.setBounds(40, 40, 150, 30);
        jpConsultarTurnoEmail.add(jlTurnoEnt);
        jcTurnoEnt= new JComboBox<>();
        String tipo1[] = {"Mañana", "Tarde", "Noche"};
        for (int i = 0; i < tipo1.length; i++) {
            jcTurnoEnt.addItem(tipo1[i]);
        }
        jcTurnoEnt.setBounds(40, 80, 200, 30);
        jcTurnoEnt.setEnabled(false);
        jpConsultarTurnoEmail.add(jcTurnoEnt);
        
        jlEmailNoLoginEnt = new JLabel("Email:");
        jlEmailNoLoginEnt.setBounds(40, 140, 120, 30);
        jpConsultarTurnoEmail.add(jlEmailNoLoginEnt);
        jtEmailNoLoginEnt = new JTextField();
        jtEmailNoLoginEnt.setBounds(40, 180, 200, 30);
        jtEmailNoLoginEnt.setEditable(false);
        jpConsultarTurnoEmail.add(jtEmailNoLoginEnt);
        
        //-----------------------------panel grupo sanguineo--------------------------------------------------------
        jpConsultarGrupoSanguineo = new JPanel();
        jpConsultarGrupoSanguineo.setBounds(670, 80, 260, 250);
        jpConsultarGrupoSanguineo.setLayout(null);
        jpConsultarGrupoSanguineo.setBorder(new TitledBorder("Consulta de datos"));
        jpConsultarGrupoSanguineo.setVisible(false);
        add(jpConsultarGrupoSanguineo);
        
        jlGrupoSanguineo = new JLabel("Grupo Sanguineo:");
        jlGrupoSanguineo.setBounds(40, 20, 150, 30);
        jpConsultarGrupoSanguineo.add(jlGrupoSanguineo);
        jcGrupoSanguineo = new JComboBox<>();
        String grupoSanguineo[] = {"A+","O+","B+","AB+","A-","O-","B-","AB-"};
        for (int i = 0; i < grupoSanguineo.length; i++) {
            jcGrupoSanguineo.addItem(grupoSanguineo[i]); 
        }
        jcGrupoSanguineo.setBounds(40, 50, 200, 30);
        jcGrupoSanguineo.setEditable(false);
        jpConsultarGrupoSanguineo.add(jcGrupoSanguineo);
        
        jlMembresia = new JLabel("Tipo membresia:");
        jlMembresia.setBounds(40, 90, 150, 30);
        jpConsultarGrupoSanguineo.add(jlMembresia);
        jcMembresia = new JComboBox<>();
        String membresia[] = {"Bronce", "Plata", "Oro"};
        for (int i = 0; i < membresia.length; i++) {
            jcMembresia.addItem(membresia[i]); 
        }
        jcMembresia.setBounds(40, 120, 200, 30);
        jcMembresia.setEditable(false);
        jpConsultarGrupoSanguineo.add(jcMembresia);
       
        jlEmailNologinCl = new JLabel("Email:");
        jlEmailNologinCl.setBounds(40, 150, 120, 30);
        jpConsultarGrupoSanguineo.add(jlEmailNologinCl);
        jtEmailNoLoginCl = new JTextField();
        jtEmailNoLoginCl.setBounds(40, 180, 200, 30);
        jtEmailNoLoginCl.setEditable(false);
        jpConsultarGrupoSanguineo.add(jtEmailNoLoginCl);

        //--------------------------  JPanel login ----------------------------------------------------------------------------
        jpLoguearse = new JPanel();
        jpLoguearse.setBounds(250, 340, 680, 100);
        jpLoguearse.setLayout(null);
        jpLoguearse.setBorder(new TitledBorder("Login"));
        jpLoguearse.setVisible(false);
        add(jpLoguearse);

        jlEmail = new JLabel("Email:");
        jlEmail.setBounds(40, 30, 120, 30);
        jpLoguearse.add(jlEmail);
        jtEmail = new JTextField();
        jtEmail.setBounds(130, 30, 200, 30);
        jtEmail.setEditable(false);
        jpLoguearse.add(jtEmail);
        

        jlPassword = new JLabel("Password:");
        jlPassword.setBounds(350, 30, 120, 30);
        jpLoguearse.add(jlPassword);
        jtPassword = new JTextField();
        jtPassword.setBounds(440, 30, 200, 30);
        jtPassword.setEditable(false);
        jpLoguearse.add(jtPassword);
        
        //------------------***Jpanel Sueldo***---------------------------------------------------------------------------------------
        jpSueldo = new JPanel();
        jpSueldo.setBounds(670, 500, 260, 80);
        jpSueldo.setLayout(null);
        jpSueldo.setBorder(new TitledBorder(null, "Sueldo", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_JUSTIFICATION, null, Color.white));
        jpSueldo.setBackground(new Color(38, 0, 77));
        jpSueldo.setForeground(Color.white);
        jpSueldo.setVisible(false);
        add(jpSueldo);
        
        
        jtSueldo = new JTextField();
        jtSueldo.setBounds(30, 20, 200, 40);
        jtSueldo.setEditable(false);
        jpSueldo.add(jtSueldo);
        
        
        //-----------------------------Botones de Guardar,Limpiar y volver------------------------------------------------------------
        jbVolver = new JButtonFuncion(70, 500, "Volver al menu", 'v', "/Imagenes/volver.png");
        jbVolver.addActionListener(ccu);
        add(jbVolver);

        //-----------------------------Limpiar -----------------------------------------------------------------------------
        jbLimpiar = new JButtonFuncion(230, 500, "Limpiar", 'L', "/Imagenes/limpiar.png");
        jbLimpiar.addActionListener(ccu);
        add(jbLimpiar);

        //----------------------------- Guardar -------------------------------------------------------------------------------
        jbConsultar = new JButtonFuncion(390, 500, "Consulta", 'C', "/Imagenes/GuardarUser.png");
        jbConsultar.addActionListener(ccu);
        add(jbConsultar);
    }
}
