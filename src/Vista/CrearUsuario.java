/*
Proposito: Muestra en pantalla multiples campos para la creación de usuarios, con botones para guardar, limpiar y volver al menú principal.
@author 
    Jhon Alex Rodríguez Benítez - 2264363
    Miguel Angel Escobar Marín - 2264305
    John Alejandro Vallarino Cruz - 2264332
Fecha de ultima modificacion  26/09/2023
version: 1.0
*/

package Vista;

import Controlador.ControlCrearUsuario;
import Utilerias.JLabelTitulo;
import java.awt.Color;
import java.awt.Cursor;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;


public class CrearUsuario extends JFrame{
    
    public JButton jbVolver, jbGuardar, jbLimpiar;
    public MenuPrincipal mp;
    public JTextField jtCedula, jtNom, jtApe, jtEmail, jtPassword;
    public JComboBox<String> jcDia, jcMes, jcYear, jcTipoUsuario, jcGrupoSanguineo;
    public Calendar c1 = Calendar.getInstance();
    public int yearActual = c1.get(Calendar.YEAR);
    ControlCrearUsuario ccu;
    
    public CrearUsuario(MenuPrincipal mp){
        super("Ingreso de datos");
        this.mp = mp;
        setSize(700, 500);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(255, 255, 255));
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLayout(null);
        ccu = new ControlCrearUsuario(this);
        addWindowListener(ccu);
        crearGUI();
        
        setVisible(true);
    }
    
    public void crearGUI(){
        ControlCrearUsuario ccu = new ControlCrearUsuario(this);
        
        JLabelTitulo jt = new JLabelTitulo(
                60, "Ingresar Usuario", this, "/Imagenes/agregar-usuario.png");
        add(jt);
        
        JLabel jlCed = new JLabel("Cedula:");
        jlCed.setBounds(40, 110, 120, 30);
        add(jlCed);
        
        jtCedula = new JTextField();
        jtCedula.setBounds(130, 110, 200, 30);
        add(jtCedula);
        
        JLabel jlNom = new JLabel("Nombre:");
        jlNom.setBounds(40, 160, 120, 30);
        add(jlNom);
        
        jtNom = new JTextField();
        jtNom.setBounds(130, 160, 200, 30);
        add(jtNom);
        
        JLabel jlApe = new JLabel("Apellido:");
        jlApe.setBounds(40, 210, 120, 30);
        add(jlApe);
        
        jtApe = new JTextField();
        jtApe.setBounds(130, 210, 200, 30);
        add(jtApe);
        
        JLabel jlEmail = new JLabel("Email:");
        jlEmail.setBounds(40, 260, 120, 30);
        add(jlEmail);
        
        jtEmail = new JTextField();
        jtEmail.setBounds(130, 260, 200, 30);
        add(jtEmail);
        
        JLabel jlPassword = new JLabel("Password:");
        jlPassword.setBounds(40, 310, 120, 30);
        add(jlPassword);
        
        jtPassword = new JTextField();
        jtPassword.setBounds(130, 310, 200, 30);
        add(jtPassword);
        
        JLabel jlTipoUsario = new JLabel("Tipo de usuario:");
        jlTipoUsario.setBounds(370, 110, 150, 30);
        add(jlTipoUsario);
        
        JLabel jlGrupoSanguineo = new JLabel("Grupo Sanguineo:");
        jlGrupoSanguineo.setBounds(370, 160, 150, 30);
        add(jlGrupoSanguineo);
        
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
        
        jcTipoUsuario.setBounds(480, 110, 150, 30);
        add(jcTipoUsuario);
        
        jcGrupoSanguineo.setBounds(480, 160,  50, 30);
        add(jcGrupoSanguineo);
        
        jcDia.setBounds(480, 210, 150, 30);
        add(jcDia);
        
        jcMes.setBounds(480, 260, 150, 30);
        add(jcMes);
        
        jcYear.setBounds(480, 310, 150, 30);
        add(jcYear);
        
        JLabel jlDia = new JLabel("Dia:");
        jlDia.setBounds(370, 210, 150, 30);
        add(jlDia);
        
        JLabel jlMes = new JLabel("Mes:");
        jlMes.setBounds(370, 260, 150, 30);
        add(jlMes);
        
        JLabel jlYear = new JLabel("Año:");
        jlYear.setBounds(370, 310, 150, 30);
        add(jlYear);
       
        
        
        ImageIcon volver = new ImageIcon(getClass().getResource("/imagenes/volver.png"));
        jbVolver = new JButton("Volver al menu",volver);
        jbVolver.setBounds(60, 360, 200, 80);
        jbVolver.setMnemonic('V');
        jbVolver.addActionListener(ccu);
        jbVolver.setHorizontalTextPosition(SwingConstants.CENTER);//configurar la posición del texto horizontal
        jbVolver.setVerticalTextPosition(SwingConstants.BOTTOM);//configurar la posición del texto vertical
        jbVolver.setContentAreaFilled(false);//No pinta el area del botón
        jbVolver.setBorderPainted(false);//No pinta los bordes
        jbVolver.setFocusPainted(false);//Desabilita el efecto del botón cuando el cursor se posa sobre el botón
        jbVolver.setCursor(new Cursor(Cursor.HAND_CURSOR));//permite cambiar el tipo de cursor cuando se posa sobre el botón
        add(jbVolver);
        
        ImageIcon limpiar = new ImageIcon(getClass().getResource("/imagenes/limpiar.png"));
        jbLimpiar = new JButton("Limpiar", limpiar);
        jbLimpiar.setBounds(225, 360, 150, 80);
        jbLimpiar.setMnemonic('L');
        jbLimpiar.addActionListener(ccu);
        jbLimpiar.setHorizontalTextPosition(SwingConstants.CENTER);//configurar la posición del texto horizontal
        jbLimpiar.setVerticalTextPosition(SwingConstants.BOTTOM);//configurar la posición del texto vertical
        jbLimpiar.setContentAreaFilled(false);//No pinta el area del botón
        jbLimpiar.setBorderPainted(false);//No pinta los bordes
        jbLimpiar.setFocusPainted(false);//Desabilita el efecto del botón cuando el cursor se posa sobre el botón
        jbLimpiar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(jbLimpiar);
        
        ImageIcon guardar = new ImageIcon(getClass().getResource("/imagenes/GuardarUser.png"));
        jbGuardar = new JButton("Guardar", guardar);
        jbGuardar.setBounds(220+150+20, 360, 150, 80);
        jbGuardar.setMnemonic('G');
        jbGuardar.addActionListener(ccu);
        jbGuardar.setHorizontalTextPosition(SwingConstants.CENTER);//configurar la posición del texto horizontal
        jbGuardar.setVerticalTextPosition(SwingConstants.BOTTOM);//configurar la posición del texto vertical
        jbGuardar.setContentAreaFilled(false);//No pinta el area del botón
        jbGuardar.setBorderPainted(false);//No pinta los bordes
        jbGuardar.setFocusPainted(false);//Desabilita el efecto del botón cuando el cursor se posa sobre el botón
        jbGuardar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(jbGuardar);
      
    }
}
