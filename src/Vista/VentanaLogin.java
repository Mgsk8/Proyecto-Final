/**
 * VentanaLogin es una clase que representa la interfaz gráfica de usuario
 * para el ingreso al sistema. Permite al usuario introducir su correo y
 * contraseña para autenticarse.
 * 
 * @author  Jhon Alex Rodríguez Benítez - 2264363
 * @author  Miguel Angel Escobar Marín - 2264305
 * @author  John Alejandro Vallarino Cruz - 2264332
 * @since 11/12/2023
 * @version 1.4
 */

package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import Controlador.ControlVentanaLogin;
import Utilerias.LimitadorCaracteres;
import java.awt.Image;
import static java.awt.image.ImageObserver.ABORT;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;


/**
 * VentanaLogin es una clase que representa la interfaz gráfica de usuario
 * para el ingreso al sistema. Permite al usuario introducir su correo y
 * contraseña para autenticarse.
 */
public class VentanaLogin extends JFrame{
    
    /**
     * Campo de texto para ingresar el correo.
     */
    public JTextField jtLogin;
    /**
     * Campo de contraseña para ingresar la contraseña.
     */
    public JPasswordField jpPassw;
    /**
     * Botón de alternancia para mostrar u ocultar la contraseña.
     */
    public JToggleButton jtVer;
     /**
     * Botón para cancelar el proceso de ingreso.
     */
    public JButton jbCancelar;
    /**
     * Botón para realizar el proceso de ingreso.
     */
    public JButton jbingresar;
    /**
     * Icono para mostrar la contraseña.
     */
    public ImageIcon ver;
    /**
     * Icono para ocultar la contraseña.
     */
    public ImageIcon no_ver;
    /**
     * Controlador asociado a la ventana de login.
     */
    ControlVentanaLogin cvl;
    
    /**
     * Constructor de la clase VentanaLogin.
     * Inicializa la interfaz gráfica y muestra la ventana de login.
     */
    public VentanaLogin(){
        super("Ingreso al sistema");
        setSize(400, 300);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        Image icono = new ImageIcon(getClass().getResource("/Imagenes/LogoBlancoVentana.png")).getImage();
        setIconImage(icono);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        crerGUI();
        cvl = new ControlVentanaLogin(this);
        addWindowListener((WindowListener) cvl);
        setVisible(true);
        JOptionPane.showMessageDialog(this, "Usuario por defecto: admin \nPassword por defecto: admin");
    }
    
    /**
     * Método privado para crear y configurar los componentes de la interfaz gráfica.
     */
    private void crerGUI() {
        ControlVentanaLogin cvl = new ControlVentanaLogin(this);
        ImageIcon im = new ImageIcon(getClass().getResource("/Imagenes/login.png"));
        JLabel jlTitulo = new JLabel("Ingreso al sistema", im, JLabel.CENTER);
        jlTitulo.setBounds(0, 0, 400, 75);
        jlTitulo.setOpaque(true);
        jlTitulo.setBackground(Color.white);
        jlTitulo.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(jlTitulo);

        JLabel jlLogin = new JLabel("Correo");
        jlLogin.setBounds(10, 90, 100, 30);
        jlLogin.setHorizontalAlignment(JLabel.RIGHT);
        add(jlLogin);

        jtLogin = new JTextField();
        jtLogin.setBounds(120, 90, 150, 30);
        jtLogin.setDocument(new LimitadorCaracteres(jtLogin, 30, ABORT));   
        jtLogin.addActionListener(cvl);  
        add(jtLogin);

        JLabel jlPass = new JLabel("password");
        jlPass.setBounds(10, 140, 100, 30);
        jlPass.setHorizontalAlignment(JLabel.RIGHT);
        add(jlPass);

        jpPassw = new JPasswordField();
        jpPassw.setBounds(120, 140, 150, 30);
        //jpPassw.setEchoChar('*');
        add(jpPassw);

        ver  = new ImageIcon(getClass().getResource("/Imagenes/visible.png"));
        no_ver  = new ImageIcon(getClass().getResource("/Imagenes/no-visible.png"));
        jtVer = new JToggleButton(no_ver);
        jtVer.setBounds(275, 140, 50, 30);
        jtVer.setBorderPainted(false);//quitar el borde del boton
        jtVer.setFocusPainted(false);//quitar el recuadro del foco del boton
        jtVer.setContentAreaFilled(false);//quita el color de fondo del boton 
        jtVer.addActionListener(cvl);
        add(jtVer);

        jbCancelar = new JButton("Cancelar");
        jbCancelar.setBounds(45, 200, 150, 35);
        jbCancelar.addActionListener(cvl);
        
        add(jbCancelar);

        jbingresar = new JButton("Ingresar");
        jbingresar.setBounds(205, 200, 150, 35);
        jbingresar.setDefaultCapable(true);
        getRootPane().setDefaultButton(jbingresar);
        jbingresar.setToolTipText("Precione enter");
        jbingresar.addActionListener(cvl);
        add(jbingresar);

    /**
     * Método principal para ejecutar la aplicación.
     *
     * @param args Los argumentos de la línea de comandos.
     */
    }
    public static void main(String[] args) {
        VentanaLogin vl = new VentanaLogin();
    }
}
