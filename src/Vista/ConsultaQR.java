/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
 *
 * @author migue
 */
public class ConsultaQR extends JFrame {

    public JTextField jtTexto;
    public JButton jbCrear, jbvolver;
    public JLabel jlCod, jlced;
    public TipoConsulta tc;
    ControlConsultaQR ccq;

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
