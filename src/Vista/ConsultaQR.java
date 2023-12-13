    /**
 * Propósito: Clase que representa la interfaz gráfica para consultar información mediante un código QR.
 * 
 * @version 1.4
 * @since 11/12/2023
 * @author  Jhon Alex Rodríguez Benítez - 2264363
 * @author  Miguel Angel Escobar Marín - 2264305
 * @author  John Alejandro Vallarino Cruz - 2264332
 */
package Vista;

import Controlador.ControlConsultaQR;
import Controlador.ControlTipoConsulta;
import Utilerias.Conexion;
import static Utilerias.DatosConexion.baseDatos;
import static Utilerias.DatosConexion.host;
import static Utilerias.DatosConexion.login;
import static Utilerias.DatosConexion.user;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import net.glxn.qrgen.QRCode;


/**
 * Propósito: Clase que representa la interfaz gráfica para consultar información mediante un código QR.
 */

public class ConsultaQR extends JFrame {

    /** Campo de texto para ingresar la cédula. */
    public JTextField jtTexto;

    /** Botón para crear el código QR. */
    public JButton jbCrear;

    /** Botón para volver. */
    public JButton jbvolver;

    /** Etiqueta para mostrar el código QR. */
    public JLabel jlCod;
    
    /** Etiqueta para la cedula. */
    public JLabel jlced;
    
    /** Tipo de consulta. */
    public TipoConsulta tc;
    
     /** Controlador de la clase ConsultaQR. */
    ControlConsultaQR ccq;

    /**
     * Constructor de la clase ConsultaQR.
     * 
     * @param tc Tipo de consulta.
     */
    public ConsultaQR(TipoConsulta tc) {
        super("Consultar x QR");
        this.tc = tc;
        setSize(500, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        Image icono = new ImageIcon(getClass().getResource("/Imagenes/LogoBlancoVentana.png")).getImage();
        setIconImage(icono);
        setLayout(null);
        crearGUI();
        ccq = new ControlConsultaQR(this);
        addWindowListener(ccq);
        setVisible(true);
    }
     /**
     * Método que crea la interfaz gráfica para la consulta mediante código QR.
     */
    private void crearGUI() {
        ccq = new ControlConsultaQR(this);
        jlced = new JLabel("Cedula:");
        jlced.setBounds(20, 30, 80, 25);
        add(jlced);
        
        jtTexto = new JTextField();
        jtTexto.setBounds(100, 30, 250, 25);
        add(jtTexto);

        jbCrear = new JButton("Crear");
        jbCrear.setBounds(390, 30, 80, 25);
        jbCrear.setBackground(new Color(226, 0, 82));
        jbCrear.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jbCrear.addActionListener(ccq);
        jbCrear.setForeground(Color.white);
        jbCrear.setBorderPainted(false);
        jbCrear.setFocusPainted(false);
        add(jbCrear);
        
        jbvolver = new JButton("Volver");
        jbvolver.setBounds(20, 500, 80, 25);
        jbvolver.addActionListener(ccq);
        jbvolver.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jbvolver.setBackground(new Color(226, 0, 82));
        jbvolver.setBorderPainted(false);
        jbvolver.setFocusPainted(false);
        jbvolver.setForeground(Color.white);
        add(jbvolver);

        jlCod = new JLabel();
        jlCod.setBounds(50, 70, 400, 400);
        jlCod.setBorder(new LineBorder(new Color(226, 0, 82)));
        add(jlCod);
    }
}
