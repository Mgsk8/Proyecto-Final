/*
Proposito: Permite realizar la renovación de la membresía de un cliente.
@author 
    Jhon Alex Rodríguez Benítez - 2264363
    Miguel Angel Escobar Marín - 2264305
    John Alejandro Vallarino Cruz - 2264332
Fecha de ultima modificacion  20/10/2023
version: 1.1
*/

package Vista;

import Controlador.ControlMembresia;
import Utilerias.JButtonFuncion;
import Utilerias.JLabelTitulo;
import Utilerias.LimitadorCaracteres;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.border.TitledBorder;

public class Membresia extends JFrame{
    
    public MenuPrincipal mp;
    public JToggleButton jtModificar, jtConsultar, jtRenovar;
    public JButton jbVolver, jbRenovar, jbConsultar, jbModificar,jbLimpiar;
    public JTextField jtIDMembresia, jtCedulaRenovar, jtCedula, jtNombre, jtApellido, jtEmail, jtMembresia, jtEstado;
    public JDateChooser fechaInicio, fechaFin;
    public JLabel jlCedula, jlIDMembresia, jlNombre, jlApellido, jlEmail, jlMembresia, jlEstado, jlFechaInicio, jlFechaFin;
    public JPanel jpOpciones, jpDatosCliente, jpDatosMembresia, jpRenovar;
    public JComboBox<String> jcTipoMembresia;
    public JRadioButton jrActivo, jrInactivo, jrVacio;
    public String contextoGuardar;
    ControlMembresia cm;
    
    public Membresia(MenuPrincipal obj){
        super("Membresía Datos");
        mp = obj;
        contextoGuardar = "";
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        Image icono = new ImageIcon(getClass().getResource("/Imagenes/membresia.png")).getImage();
        setIconImage(icono);
        setResizable(false);
        setLayout(null);
        cm = new ControlMembresia(this);
        addWindowListener(cm);
        crearGUI();
        setVisible(true);
    }
    
    public void crearGUI() {
        ControlMembresia cm = new ControlMembresia(this);

        JLabelTitulo jt = new JLabelTitulo(
                60, "Membresias", this, "/Imagenes/membresia.png");
        add(jt);
        
        //---------------------- Jpanel Opciones -------------------------------------------
        
        JPanel jpOpciones = new JPanel();
        jpOpciones.setBounds(20, 80, 220, 360);
        jpOpciones.setLayout(null);
        jpOpciones.setBorder(new TitledBorder("Opciones Membresia"));
        add(jpOpciones);
        
        // --------------- Opciones Botones ---------------
        
        jtRenovar = new JToggleButton("Renovar Membresia");
        jtRenovar.setBounds(10, 40, 200, 40);
        jtRenovar.setBackground(new Color(226, 0, 82));
        jtRenovar.setForeground(Color.white);
        jtRenovar.setFont(new Font("Tahoma", 1, 12));
        jtRenovar.setBorderPainted(false);
        jtRenovar.setFocusPainted(false);
        jtRenovar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jtRenovar.addActionListener(cm);
        jpOpciones.add(jtRenovar);
       
        jtModificar = new JToggleButton("Modificar Membresia");
        jtModificar.setBounds(10, 100, 200, 40);
        jtModificar.setBackground(new Color(226, 0, 82));
        jtModificar.setForeground(Color.white);
        jtModificar.setFont(new Font("Tahoma", 1, 12));
        jtModificar.setBorderPainted(false);
        jtModificar.setFocusPainted(false);
        jtModificar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jtModificar.addActionListener(cm);
        jpOpciones.add(jtModificar);

        jtConsultar = new JToggleButton("Consultar Membresia");
        jtConsultar.setBounds(10, 160, 200, 40);
        jtConsultar.setBackground(new Color(226, 0, 82));
        jtConsultar.setForeground(Color.white);
        jtConsultar.setFont(new Font("Tahoma", 1, 12));
        jtConsultar.setBorderPainted(false);
        jtConsultar.setFocusPainted(false);
        jtConsultar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jtConsultar.addActionListener(cm);
        jpOpciones.add(jtConsultar);

        ButtonGroup bg = new ButtonGroup();
        bg.add(jtModificar);
        bg.add(jtConsultar);
        bg.add(jtRenovar);
        
        //--------------------JPanel Consultar Datos ----------------------------------------------------------------------
        
        //------------------ panel Datos Clientes -------------------------------
        
        jpDatosCliente = new JPanel();
        jpDatosCliente.setBounds(610, 80, 350, 300);
        jpDatosCliente.setLayout(null);
        jpDatosCliente.setBorder(new TitledBorder("Datos cliente"));
        jpDatosCliente.setVisible(false);
        add(jpDatosCliente);
        
        jlCedula = new JLabel("Cedula:");
        jlCedula.setBounds(40, 20, 120, 30);
        jpDatosCliente.add(jlCedula);
        
        jtCedula = new JTextField();
        jtCedula.setBounds(130, 20, 200, 30);
        jtCedula.setEditable(true);
        jpDatosCliente.add(jtCedula);

        jlNombre = new JLabel("Nombre:");
        jlNombre.setBounds(40, 70, 120, 30);
        jpDatosCliente.add(jlNombre);
        
        jtNombre = new JTextField();
        jtNombre.setBounds(130, 70, 200, 30);
        jtNombre.setEditable(false);
        jpDatosCliente.add(jtNombre);
        

        jlApellido = new JLabel("Apellido:");
        jlApellido.setBounds(40, 120, 120, 30);
        jpDatosCliente.add(jlApellido);
        
        jtApellido = new JTextField();
        jtApellido.setBounds(130, 120, 200, 30);
        jtApellido.setDocument(new LimitadorCaracteres(jtApellido, 20, 1));
        jtApellido.setEditable(false);
        jpDatosCliente.add(jtApellido);
        
        jlEmail = new JLabel("Email:");
        jlEmail.setBounds(40, 170, 120, 30);
        jpDatosCliente.add(jlEmail);
        
        jtEmail = new JTextField();
        jtEmail.setBounds(130, 170, 200, 30);
        jtEmail.setEditable(false);
        jpDatosCliente.add(jtEmail);
        
        //------------------ panel Datos Membresia -------------------------------
        
        jpDatosMembresia = new JPanel();
        jpDatosMembresia.setBounds(250, 80, 350, 300);
        jpDatosMembresia.setLayout(null);
        jpDatosMembresia.setBorder(new TitledBorder("Datos Membresia"));
        jpDatosMembresia.setVisible(false);
        add(jpDatosMembresia);
        
        jlIDMembresia = new JLabel("ID Membresia:");
        jlIDMembresia.setBounds(40, 20, 120, 30);
        jpDatosMembresia.add(jlIDMembresia);
        
        jtIDMembresia = new JTextField();
        jtIDMembresia.setBounds(130, 20, 200, 30);
        jtIDMembresia.setDocument(new LimitadorCaracteres(jtIDMembresia, 20, 0));
        jtIDMembresia.setEditable(false);
        jpDatosMembresia.add(jtIDMembresia);
        
        jlMembresia = new JLabel("Tipo:");
        jlMembresia.setBounds(40, 70, 120, 30);
        jpDatosMembresia.add(jlMembresia);
        
        jtMembresia = new JTextField();
        jtMembresia.setBounds(130, 70, 200, 30);
        jtMembresia.setEditable(false);
        jpDatosMembresia.add(jtMembresia);
        
        jlFechaInicio = new JLabel("<html><center>Fecha <br>inicio:</html>");
        jlFechaInicio.setBounds(40, 120, 180, 30);
        jpDatosMembresia.add(jlFechaInicio);
        fechaInicio = new JDateChooser(new Date());// crear el dateChooser con la fecha actual
        fechaInicio.setBounds(130, 120, 150, 30);
        fechaInicio.setEnabled(false);
        jpDatosMembresia.add(fechaInicio);
        
        jlFechaFin = new JLabel("<html><center>Fecha <br>fin:</html>");
        jlFechaFin.setBounds(40, 170, 180, 30);
        jpDatosMembresia.add(jlFechaFin);
        fechaFin = new JDateChooser(new Date());// crear el dateChooser con la fecha actual
        fechaFin.setBounds(130, 170, 150, 30);
        fechaFin.setEnabled(false);
        jpDatosMembresia.add(fechaFin);
        
        jlEstado = new JLabel("Estado:");
        jlEstado.setBounds(40, 220, 120, 30);
        jpDatosMembresia.add(jlEstado);
        jrActivo = new JRadioButton("Activo");
        jrActivo.setBounds(130, 220,120,30);
        jrActivo.setFocusPainted(false);
        jrActivo.setContentAreaFilled(false);
        jrActivo.setEnabled(false);
        jpDatosMembresia.add(jrActivo);
        
        jrInactivo = new JRadioButton("Inactivo");
        jrInactivo.setBounds(220, 220,120,30);
        jrInactivo.setFocusPainted(false);
        jrInactivo.setContentAreaFilled(false);
        jrInactivo.setEnabled(false);
        jpDatosMembresia.add(jrInactivo);
        
        ButtonGroup bgE = new ButtonGroup();
        bgE.add(jrActivo);
        bgE.add(jrInactivo);

        //------------------ panel Datos Renovación Membresia -------------------------------
        
        jpRenovar = new JPanel();
        jpRenovar.setBounds(250, 80, 350, 300);
        jpRenovar.setLayout(null);
        jpRenovar.setBorder(new TitledBorder("Renovación Membresia"));
        jpRenovar.setVisible(false);
        add(jpRenovar);
        
        jlCedula = new JLabel("Cedula:");
        jlCedula.setBounds(40, 20, 120, 30);
        jpRenovar.add(jlCedula);
        
        jtCedulaRenovar = new JTextField();
        jtCedulaRenovar.setBounds(130, 20, 200, 30);
        jtCedulaRenovar.setEditable(true);
        jpRenovar.add(jtCedulaRenovar);
        
        jlMembresia = new JLabel("Tipo:");
        jlMembresia.setBounds(40, 70, 120, 30);
        jpRenovar.add(jlMembresia);
        
        jcTipoMembresia = new JComboBox<>();
        String tipo[] = {"Oro", "Plata", "Bronce"};
        for (int i = 0; i < tipo.length; i++) {
            jcTipoMembresia.addItem(tipo[i]);
        }
        jcTipoMembresia.setBounds(130, 70, 200, 30);
        jcTipoMembresia.setEnabled(false);
        jpRenovar.add(jcTipoMembresia);
        
        //-----------------------------Botones de Guardar,Limpiar y volver------------------------------------------------------------
        jbVolver = new JButtonFuncion(50, 500, "Volver al menu", 'v', "/Imagenes/volver.png");
        jbVolver.addActionListener(cm);
        add(jbVolver);

        //-----------------------------Limpiar -----------------------------------------------------------------------------
        jbLimpiar = new JButtonFuncion(210, 500, "Limpiar", 'L', "/Imagenes/limpiar.png");
        jbLimpiar.addActionListener(cm);
        add(jbLimpiar);

        //----------------------------- Consultar -------------------------------------------------------------------------------
        jbConsultar = new JButtonFuncion(370, 500, "Consulta", 'C', "/Imagenes/GuardarUser.png");
        jbConsultar.addActionListener(cm);
        add(jbConsultar);
        
        //----------------------------- actualizar -------------------------------------------------------------------------------
        jbModificar = new JButtonFuncion(530, 500, "Actualizar", 'A', "/Imagenes/ActualizarConColor.png");
        jbModificar.addActionListener(cm);
        jbModificar.setVisible(false);
        add(jbModificar);
        
        //----------------------------- renovar -------------------------------------------------------------------------------
        jbRenovar = new JButtonFuncion(530, 500, "Renovar", 'A', "/Imagenes/ActualizarConColor.png");
        jbRenovar.addActionListener(cm);
        jbRenovar.setVisible(false);
        add(jbRenovar);        
        
    }
    
}
