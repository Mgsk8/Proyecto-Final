/**
 * Propósito: Clase que representa la interfaz gráfica para la creación de usuarios, permitiendo
 * definir diferentes tipos de usuarios como administrador, supervisor, entrenador, recepcionista, y cliente.
 * 
 * @version 1.4
 * @since 11/12/2023
 * @author  Jhon Alex Rodríguez Benítez - 2264363
 * @author  Miguel Angel Escobar Marín - 2264305
 * @author  John Alejandro Vallarino Cruz - 2264332
 */

package Vista;

import Controlador.ControlCrearUsuario;
import Utilerias.JButtonFuncion;
import Utilerias.JCalendarFull;
import Utilerias.JLabelTitulo;
import Utilerias.LimitadorCaracteres;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;  
import java.util.Date;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.border.TitledBorder;

/**
 * Propósito: Clase que representa la interfaz gráfica para la creación de usuarios, permitiendo
 * definir diferentes tipos de usuarios como administrador, supervisor, entrenador, recepcionista, y cliente.
 */

public class CrearUsuario extends JFrame {

    /** Botones de alternancia para seleccionar el tipo de usuario. */
    public JToggleButton jtAdministrador;
    public JToggleButton jtSupervisor;
    public JToggleButton jtEntrenador;
    public JToggleButton jtRecepcionista;
    public JToggleButton JTcliente;
    
    /** Botones de acciones en CrearUsuario. */
    public JButton jbVolver;
    public JButton jbGuardar;
    public JButton jbLimpiar;
    
    /** Objeto MenuPrincipal que representa el menú principal de la aplicación. */
    public MenuPrincipal mp;
    
    /** Campos de texto para ingresar la información del usuario. */
    public JTextField jtCedula;
    public JTextField jtNom;
    public JTextField jtApe;
    public JTextField jtEmail;
    public JTextField jtEmailNoLoginEnt;
    public JTextField jtEmailNoLoginCl;
    
    /** Campo de contraseña para ingresar la contraseña del usuario. */
    public JPasswordField jpPassword;
    
    /** Listas desplegables para seleccionar datos del usuaio. */
    public JComboBox<String> jcGrupoSanguineo;
    public JComboBox<String> jcTurno;
    public JComboBox<String> jcTurnoEnt;
    public JComboBox<String> jcMembresia;
    
    /** Selector de fecha de nacimiento del usuario. */
    public JDateChooser fecha_nac;
    
    /** Panel para ingresar datos base del usuario. */
    public JPanel jpIngresarDatosBase;
    /** Panel para ingresar el turno del usuario. */
    public JPanel jpIngresarTurno;
    /** Panel para ingresar el grupo sanguineo del usuario. */
    public JPanel jpIngresarGrupoSanguineo;
    /** Panel para ingresar el turno y correo electrónico sin iniciar sesión del usuario. */
    public JPanel jpIngresarTurnoEmail;
    /** Panel para loguearse con el correo electrónico. */  
    public JPanel jpLoguearse;
    
    /** Etiquetas para mostrar el campo del usuario. */
    public JLabel jlCed;
    public JLabel jlNom;
    public JLabel jlApe;
    public JLabel jlFecha;
    public JLabel jlGrupoSanguineo;
    public JLabel jlEmail;
    public JLabel jlEmailNoLoginEnt;
    public JLabel jlTurnoEnt;
    public JLabel jlEmailNologinCl;
    public JLabel jlPassword;
    public JLabel jlTurno;
    public JLabel jlMembresia;
    
    /** Variable de contexto para guardar información relevante. */
    public String contextoGuardar;
    
     /** Controlador de la clase CrearUsuario. */
    ControlCrearUsuario ccu;
    
    /** Variable que indica los privilegios del usuario. */
    String privilegios = "";

    /**
     * Constructor de la clase CrearUsuario.
     * 
     * @param mp   Objeto MenuPrincipal que representa el menú principal de la aplicación.
     * @param privi String que indica los privilegios del usuario.
     */
    public CrearUsuario(MenuPrincipal mp, String privi) {
        super("Ingreso de datos");
        this.mp = mp;
        contextoGuardar = "";
        privilegios = privi;
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        Image icono = new ImageIcon(getClass().getResource("/Imagenes/LogoBlancoVentana.png")).getImage();
        setIconImage(icono);
        setResizable(false);
        setLayout(null);
        ccu = new ControlCrearUsuario(this);
        addWindowListener(ccu);
        crearGUI();

        setVisible(true);
    }

    /**
     * Método que crea la interfaz gráfica para la creación de usuarios.
     */
    public void crearGUI() {
        ControlCrearUsuario ccu = new ControlCrearUsuario(this);

        JLabelTitulo jt = new JLabelTitulo(
                60, "Ingresar Usuario", this, "/Imagenes/agregar-usuario.png");
        add(jt);
        //----------------------Jpanel Tipo Usuario ----------------------------------------------------------------------
        JPanel jpTipoUsuario = new JPanel();
        jpTipoUsuario.setBounds(20, 80, 220, 360);
        jpTipoUsuario.setLayout(null);
        jpTipoUsuario.setBorder(new TitledBorder("Tipo Usuario a crear"));
        add(jpTipoUsuario);

        // -------------------- verificacion privilegios -------------------
        
        if (privilegios == "Recepcionista"){
            jtEntrenador = new JToggleButton("Crear entrenador");
            jtEntrenador.setBounds(10, 40, 200, 40);
            jtEntrenador.setBackground(new Color(226, 0, 82));
            jtEntrenador.setForeground(Color.white);
            jtEntrenador.setFont(new Font("Tahoma", 1, 12));
            jtEntrenador.setBorderPainted(false);
            jtEntrenador.setFocusPainted(false);
            jtEntrenador.setCursor(new Cursor(Cursor.HAND_CURSOR));
            jtEntrenador.addActionListener(ccu);
            jpTipoUsuario.add(jtEntrenador);

            JTcliente = new JToggleButton("Crear cliente");
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
        
        if (privilegios == "Supervisor"){
            jtRecepcionista = new JToggleButton("Crear Recepcionista");
            jtRecepcionista.setBounds(10, 40, 200, 40);
            jtRecepcionista.setBackground(new Color(226, 0, 82));
            jtRecepcionista.setForeground(Color.white);
            jtRecepcionista.setFont(new Font("Tahoma", 1, 12));
            jtRecepcionista.setBorderPainted(false);
            jtRecepcionista.setFocusPainted(false);
            jtRecepcionista.setCursor(new Cursor(Cursor.HAND_CURSOR));
            jtRecepcionista.addActionListener(ccu);
            jpTipoUsuario.add(jtRecepcionista);

            jtEntrenador = new JToggleButton("Crear entrenador");
            jtEntrenador.setBounds(10, 100, 200, 40);
            jtEntrenador.setBackground(new Color(226, 0, 82));
            jtEntrenador.setForeground(Color.white);
            jtEntrenador.setFont(new Font("Tahoma", 1, 12));
            jtEntrenador.setBorderPainted(false);
            jtEntrenador.setFocusPainted(false);
            jtEntrenador.setCursor(new Cursor(Cursor.HAND_CURSOR));
            jtEntrenador.addActionListener(ccu);
            jpTipoUsuario.add(jtEntrenador);

            JTcliente = new JToggleButton("Crear cliente");
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
            jtAdministrador = new JToggleButton("Crear Administrador");
            jtAdministrador.setBounds(10, 40, 200, 40);
            jtAdministrador.setBackground(new Color(226, 0, 82));
            jtAdministrador.setForeground(Color.white);
            jtAdministrador.setFont(new Font("Tahoma", 1, 12));
            jtAdministrador.setBorderPainted(false);
            jtAdministrador.setFocusPainted(false);
            jtAdministrador.setCursor(new Cursor(Cursor.HAND_CURSOR));
            jtAdministrador.addActionListener(ccu);
            jpTipoUsuario.add(jtAdministrador);

            jtSupervisor = new JToggleButton("Crear Supervisor");
            jtSupervisor.setBounds(10, 100, 200, 40);
            jtSupervisor.setBackground(new Color(226, 0, 82));
            jtSupervisor.setForeground(Color.white);
            jtSupervisor.setFont(new Font("Tahoma", 1, 12));
            jtSupervisor.setBorderPainted(false);
            jtSupervisor.setFocusPainted(false);
            jtSupervisor.setCursor(new Cursor(Cursor.HAND_CURSOR));
            jtSupervisor.addActionListener(ccu);
            jpTipoUsuario.add(jtSupervisor);

            jtRecepcionista = new JToggleButton("Crear Recepcionista");
            jtRecepcionista.setBounds(10, 160, 200, 40);
            jtRecepcionista.setBackground(new Color(226, 0, 82));
            jtRecepcionista.setForeground(Color.white);
            jtRecepcionista.setFont(new Font("Tahoma", 1, 12));
            jtRecepcionista.setBorderPainted(false);
            jtRecepcionista.setFocusPainted(false);
            jtRecepcionista.setCursor(new Cursor(Cursor.HAND_CURSOR));
            jtRecepcionista.addActionListener(ccu);
            jpTipoUsuario.add(jtRecepcionista);

            jtEntrenador = new JToggleButton("Crear entrenador");
            jtEntrenador.setBounds(10, 220, 200, 40);
            jtEntrenador.setBackground(new Color(226, 0, 82));
            jtEntrenador.setForeground(Color.white);
            jtEntrenador.setFont(new Font("Tahoma", 1, 12));
            jtEntrenador.setBorderPainted(false);
            jtEntrenador.setFocusPainted(false);
            jtEntrenador.setCursor(new Cursor(Cursor.HAND_CURSOR));
            jtEntrenador.addActionListener(ccu);
            jpTipoUsuario.add(jtEntrenador);

            JTcliente = new JToggleButton("Crear cliente");
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

        //--------------------JPanel Ingresar Datos ----------------------------------------------------------------------
        
        //------------------panel Ingresar Datos Base---------------------------------------------------------------
        jpIngresarDatosBase = new JPanel();
        jpIngresarDatosBase.setBounds(250, 80, 400, 250);
        jpIngresarDatosBase.setLayout(null);
        jpIngresarDatosBase.setBorder(new TitledBorder("Ingreso de datos base"));
        jpIngresarDatosBase.setVisible(false);
        add(jpIngresarDatosBase);
        
        jlCed = new JLabel("Cedula:");
        jlCed.setBounds(40, 50, 120, 30);
        //jlCed.setVisible(false);
        jpIngresarDatosBase.add(jlCed);
        jtCedula = new JTextField();
        jtCedula.setBounds(130, 50, 200, 30);
        jtCedula.setDocument(new LimitadorCaracteres(jtCedula, 20, 0));
        //jtCedula.setVisible(false);
        jpIngresarDatosBase.add(jtCedula);

        jlNom = new JLabel("Nombre:");
        jlNom.setBounds(40, 100, 120, 30);
        //jlNom.setVisible(false);
        jpIngresarDatosBase.add(jlNom);
        jtNom = new JTextField();
        jtNom.setBounds(130, 100, 200, 30);
        jtNom.setDocument(new LimitadorCaracteres(jtNom, 20, 1));
        //jtNom.setVisible(false);
        jpIngresarDatosBase.add(jtNom);
        

        jlApe = new JLabel("Apellido:");
        jlApe.setBounds(40, 150, 120, 30);
        //jlApe.setVisible(false);
        jpIngresarDatosBase.add(jlApe);
        jtApe = new JTextField();
        jtApe.setBounds(130, 150, 200, 30);
        jtApe.setDocument(new LimitadorCaracteres(jtApe, 20, 1));
        //jtApe.setVisible(false);
        jpIngresarDatosBase.add(jtApe);

        jlFecha = new JLabel("<html><center>fecha de <br> nacimiento:</html>");
        jlFecha.setBounds(40, 200, 150, 30);
        //jlFecha.setVisible(false);
        jpIngresarDatosBase.add(jlFecha);
        fecha_nac = new JDateChooser(new Date());// crear el dateChooser con la fecha actual
        //dateChooser = new JDateChooser(new Date(1979-1900, 2, 7));// crear el dateChooser con la fecha inicial de 7 de marzo de 1979
        fecha_nac.setBounds(130, 200, 150, 30);
        //fecha_nac.setVisible(false);
        jpIngresarDatosBase.add(fecha_nac);
        
        
        //---------------------------panel ingresar turno-----------------------------------------------------------
        jpIngresarTurno = new JPanel();
        jpIngresarTurno.setBounds(670, 80, 260, 250);
        jpIngresarTurno.setLayout(null);
        jpIngresarTurno.setBorder(new TitledBorder("Ingreso de datos"));
        jpIngresarTurno.setVisible(false);
        add(jpIngresarTurno);
        
        jlTurno = new JLabel("Turno:");
        jlTurno.setBounds(40, 80, 150, 30);
        jpIngresarTurno.add(jlTurno);
        jcTurno = new JComboBox<>();
        String tipo[] = {"mañana", "tarde", "noche"};
        for (int i = 0; i < tipo.length; i++) {
            jcTurno.addItem(tipo[i]);
        }
        jcTurno.setBounds(40, 120, 200, 30);
        jpIngresarTurno.add(jcTurno);
        
        //----------------------- Panel turno email-----------------------------------------------------
        jpIngresarTurnoEmail = new JPanel();
        jpIngresarTurnoEmail.setBounds(670, 80, 260, 250);
        jpIngresarTurnoEmail.setLayout(null);
        jpIngresarTurnoEmail.setBorder(new TitledBorder("Ingreso de datos"));
        jpIngresarTurnoEmail.setVisible(false);
        add(jpIngresarTurnoEmail);
        
        jlTurnoEnt = new JLabel("Turno:");
        jlTurnoEnt.setBounds(40, 40, 150, 30);
        jpIngresarTurnoEmail.add(jlTurnoEnt);
        jcTurnoEnt= new JComboBox<>();
        String tipo1[] = {"mañana", "tarde", "noche"};
        for (int i = 0; i < tipo1.length; i++) {
            jcTurnoEnt.addItem(tipo1[i]);
        }
        jcTurnoEnt.setBounds(40, 80, 200, 30);
        jpIngresarTurnoEmail.add(jcTurnoEnt);
        
        jlEmailNoLoginEnt = new JLabel("Email:");
        jlEmailNoLoginEnt.setBounds(40, 140, 120, 30);
        jpIngresarTurnoEmail.add(jlEmailNoLoginEnt);
        jtEmailNoLoginEnt = new JTextField();
        jtEmailNoLoginEnt.setBounds(40, 180, 200, 30);
        jpIngresarTurnoEmail.add(jtEmailNoLoginEnt);
        
        //-----------------------------panel grupo sanguineo--------------------------------------------------------
        jpIngresarGrupoSanguineo = new JPanel();
        jpIngresarGrupoSanguineo.setBounds(670, 80, 260, 250);
        jpIngresarGrupoSanguineo.setLayout(null);
        jpIngresarGrupoSanguineo.setBorder(new TitledBorder("Ingreso de datos"));
        jpIngresarGrupoSanguineo.setVisible(false);
        add(jpIngresarGrupoSanguineo);
        
        jlGrupoSanguineo = new JLabel("Grupo Sanguineo:");
        jlGrupoSanguineo.setBounds(40, 20, 150, 30);
        jpIngresarGrupoSanguineo.add(jlGrupoSanguineo);
        jcGrupoSanguineo = new JComboBox<>();
        String grupoSanguineo[] = {"A+","O+","B+","AB+","A-","O-","B-","AB-"};
        for (int i = 0; i < grupoSanguineo.length; i++) {
            jcGrupoSanguineo.addItem(grupoSanguineo[i]); 
        }
        jcGrupoSanguineo.setBounds(40, 50, 200, 30);
        jpIngresarGrupoSanguineo.add(jcGrupoSanguineo);
        
        jlMembresia = new JLabel("Tipo membresia:");
        jlMembresia.setBounds(40, 90, 150, 30);
        jpIngresarGrupoSanguineo.add(jlMembresia);
        jcMembresia = new JComboBox<>();
        String membresia[] = {"Bronce", "Plata", "Oro"};
        for (int i = 0; i < membresia.length; i++) {
            jcMembresia.addItem(membresia[i]); 
        }
        jcMembresia.setBounds(40, 120, 200, 30);
        jpIngresarGrupoSanguineo.add(jcMembresia);
       
        jlEmailNologinCl = new JLabel("Email:");
        jlEmailNologinCl.setBounds(40, 150, 120, 30);
        jpIngresarGrupoSanguineo.add(jlEmailNologinCl);
        jtEmailNoLoginCl = new JTextField();
        jtEmailNoLoginCl.setBounds(40, 180, 200, 30);
        jpIngresarGrupoSanguineo.add(jtEmailNoLoginCl);

        //--------------------------  JPanel login ----------------------------------------------------------------------------
        jpLoguearse = new JPanel();
        jpLoguearse.setBounds(250, 340, 680, 100);
        jpLoguearse.setLayout(null);
        jpLoguearse.setBorder(new TitledBorder("Login"));
        jpLoguearse.setVisible(false);
        add(jpLoguearse);

        jlEmail = new JLabel("Email:");
        jlEmail.setBounds(40, 30, 120, 30);
        //jlEmail.setVisible(false);
        jpLoguearse.add(jlEmail);
        jtEmail = new JTextField();
        jtEmail.setBounds(130, 30, 200, 30);
        //jtEmail.setVisible(false);
        jpLoguearse.add(jtEmail);
        

        jlPassword = new JLabel("Password:");
        jlPassword.setBounds(350, 30, 120, 30);
        //jlPassword.setVisible(false);
        jpLoguearse.add(jlPassword);
        jpPassword = new JPasswordField();
        jpPassword.setBounds(440, 30, 200, 30);
        //jpPassword.setVisible(false);
        jpLoguearse.add(jpPassword);

        //-----------------------------Botones de Guardar,Limpiar y volver------------------------------------------------------------
        jbVolver = new JButtonFuncion(70, 500, "Volver al menu", 'v', "/Imagenes/volver.png");
        jbVolver.addActionListener(ccu);
        add(jbVolver);

        //-----------------------------Limpiar -----------------------------------------------------------------------------
        jbLimpiar = new JButtonFuncion(370, 500, "Limpiar", 'L', "/Imagenes/limpiar.png");
        jbLimpiar.addActionListener(ccu);
        add(jbLimpiar);

        //----------------------------- Guardar -------------------------------------------------------------------------------
        jbGuardar = new JButtonFuncion(370 + 300, 500, "Guardar", 'G', "/Imagenes/GuardarUser.png");
        jbGuardar.addActionListener(ccu);
        add(jbGuardar);

    }
}
