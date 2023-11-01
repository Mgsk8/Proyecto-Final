/*
Proposito: Permite buscar un usuario y muestra en pantalla sus campos para la modificación
y actulización de los datos del usuario, con botones para actulizar, buscar, limpiar y volver
al menú principal.
@author 
    Jhon Alex Rodríguez Benítez - 2264363
    Miguel Angel Escobar Marín - 2264305
    John Alejandro Vallarino Cruz - 2264332
Fecha de ultima modificacion  20/10/2023
version: 1.1
*/

package Vista;

import Controlador.ControlActualizarUsuario;
import Utilerias.JButtonFuncion;
import Utilerias.JLabelTitulo;
import Utilerias.LimitadorCaracteres;
import java.awt.Color;
import java.util.Calendar;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class ActualizarUsuario extends JFrame{
    
    public JRadioButton jrActivo, jrInactivo;
    public JButton jbVolver, jbConsultar, jbLimpiar, jbActualizar;
    public MenuAdmin mp;
    public JTextField jtCedula, jtNom, jtApe, jtEmail;
    public JPasswordField jpPassword;
    public JComboBox<String> jcDia, jcMes, jcYear, jcTipoUsuario, jcGrupoSanguineo;
    public Calendar c1 = Calendar.getInstance();
    public int yearActual = c1.get(Calendar.YEAR);
    ControlActualizarUsuario cau;
    
    public ActualizarUsuario(MenuAdmin mp){
        super("Actualizar Usuario");
        this.mp = mp;
        setSize(1000, 700);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.GRAY);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLayout(null);
        cau = new ControlActualizarUsuario(this);
        addWindowListener(cau);
        crearGUI();
        
        setVisible(true);
    }
    
    public void crearGUI(){
        ControlActualizarUsuario ccu = new ControlActualizarUsuario(this);
        
        JPanel jp = new JPanel();
        jp.setBounds(100, 80, 800, 500);
        jp.setBackground(Color.white);
        jp.setLayout(null);
        add(jp);
        
        JLabelTitulo jt = new JLabelTitulo(
                60, "Actualizar Usuario", this, "/Imagenes/Actualizar.png");
        add(jt);
        
        JLabel jlCed = new JLabel("Cedula:");
        jlCed.setBounds(40, 50, 120, 30);
        jp.add(jlCed);
        
        jtCedula = new JTextField();
        jtCedula.setBounds(130, 50, 200, 30);
        jtCedula.setDocument(new LimitadorCaracteres(jtCedula, 20, 0));
        jp.add(jtCedula);
        
        JLabel jlNom = new JLabel("Nombre:");
        jlNom.setBounds(40, 100, 120, 30);
        jp.add(jlNom);
        
        jtNom = new JTextField();
        jtNom.setBounds(130, 100, 200, 30);
        jtNom.setDocument(new LimitadorCaracteres(jtNom, 20, 1));
        jtNom.setEditable(false);
        jp.add(jtNom);
        
        JLabel jlApe = new JLabel("Apellido:");
        jlApe.setBounds(40, 150, 120, 30);
        jp.add(jlApe);
        
        jtApe = new JTextField();
        jtApe.setBounds(130, 150, 200, 30);
        jtApe.setDocument(new LimitadorCaracteres(jtApe, 20, 1));
        jtApe.setEditable(false);
        jp.add(jtApe);
        
        JLabel jlEmail = new JLabel("Email:");
        jlEmail.setBounds(40, 200, 120, 30);
        jp.add(jlEmail);
        
        jtEmail = new JTextField();
        jtEmail.setBounds(130, 200, 200, 30);
        jtEmail.setEditable(false);
        jp.add(jtEmail);

        JLabel jlPassword = new JLabel("Password:");
        jlPassword.setBounds(40, 250, 120, 30);
        jp.add(jlPassword);

        jpPassword = new JPasswordField();
        jpPassword.setBounds(130, 250, 200, 30);
        jpPassword.setEditable(false);
        jp.add(jpPassword);
        
        jrActivo = new JRadioButton("Activo");
        jrActivo.setBounds(40, 300,120,30);
        jrActivo.setFocusPainted(false);
        jrActivo.setContentAreaFilled(false);
        jrActivo.setEnabled(false);
        jp.add(jrActivo);
        
        jrInactivo = new JRadioButton("Inactivo");
        jrInactivo.setBounds(180, 300,120,30);
        jrInactivo.setFocusPainted(false);
        jrInactivo.setContentAreaFilled(false);
        jrInactivo.setEnabled(false);
        jp.add(jrInactivo);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(jrActivo);
        bg.add(jrInactivo);
        
        JLabel jlTipoUsario = new JLabel("Tipo de usuario:");
        jlTipoUsario.setBounds(370, 50, 150, 30);
        jp.add(jlTipoUsario);
        
        JLabel jlGrupoSanguineo = new JLabel("Grupo Sanguineo:");
        jlGrupoSanguineo.setBounds(370, 100, 150, 30);
        jp.add(jlGrupoSanguineo);
        
        jcTipoUsuario = new JComboBox<>();
        String tipoUsuario[] = {"Administrador", "Supervisor", "Entrenador", "Recepcionista", "Cliente"};
        for (int i = 0; i < tipoUsuario.length; i++) {
            jcTipoUsuario.addItem(tipoUsuario[i]);
        }
        
        jcGrupoSanguineo = new JComboBox<>();
        String grupoSanguineo[] = {"A+","O+","B+","AB+","A-","O-","B-","AB-"};
        for (int i = 0; i < grupoSanguineo.length; i++) {
            jcGrupoSanguineo.addItem(grupoSanguineo[i]); 
        }
        
        jcDia = new JComboBox<>();
        for (int i = 1; i <= 31; i++) {
            jcDia.addItem(i + "");
        }
        
        jcMes = new JComboBox<>();
        for (int i = 1; i <= 12; i++) {
            jcMes.addItem(i + "");
        }
        
        jcYear = new JComboBox<>();
        for (int i = yearActual; i >= 1900; i--) {
            jcYear.addItem(i + "");
        }
        
        jcTipoUsuario.setBounds(480, 50, 150, 30);
        jcTipoUsuario.setEnabled(false);
        jp.add(jcTipoUsuario);
        
        jcGrupoSanguineo.setBounds(480, 100,  50, 30);
        jcGrupoSanguineo.setEnabled(false);
        jp.add(jcGrupoSanguineo);
        
        jcDia.setBounds(480, 150, 150, 30);
        jcDia.setEnabled(false);
        jp.add(jcDia);
        
        jcMes.setBounds(480, 200, 150, 30);
        jcMes.setEnabled(false);
        jp.add(jcMes);
        
        jcYear.setBounds(480, 250, 150, 30);
        jcYear.setEnabled(false);
        jp.add(jcYear);
        
        JLabel jlDia = new JLabel("Dia:");
        jlDia.setBounds(370, 150, 150, 30);
        jp.add(jlDia);
        
        JLabel jlMes = new JLabel("Mes:");
        jlMes.setBounds(370, 200, 150, 30);
        jp.add(jlMes);
        
        JLabel jlYear = new JLabel("Año:");
        jlYear.setBounds(370, 250, 150, 30);
        jp.add(jlYear);
       
        
        
        jbVolver = new JButtonFuncion(60, "Volver al menu", 'v', "/Imagenes/volver.png");
        jbVolver.addActionListener(cau);
        jp.add(jbVolver);

        jbLimpiar = new JButtonFuncion(225, "Limpiar", 'L', "/Imagenes/limpiar.png");
        jbLimpiar.addActionListener(cau);
        jp.add(jbLimpiar);

        jbConsultar = new JButtonFuncion(225+165, "Consultar", 'C', "/Imagenes/ConsultarConColor.png");
        jbConsultar.addActionListener(cau);
        jp.add(jbConsultar);
        
        jbActualizar = new JButtonFuncion(225+165+165, "Actualizar", 'A', "/Imagenes/ActualizarConColor.png");
        jbActualizar.addActionListener(cau);
        jp.add(jbActualizar);
      
    }
}