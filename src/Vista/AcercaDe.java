/*
Proposito: Muestra información sobre los programadores
@author 
    Jhon Alex Rodríguez Benítez - 2264363
    Miguel Angel Escobar Marín - 2264305
    John Alejandro Vallarino Cruz - 2264332
Fecha de ultima modificacion  20/10/2023
version: 1.1
*/


package Vista;

import Controlador.ControlAcercaDe;
import Utilerias.JLabelTitulo;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class AcercaDe extends JDialog{
    
    public MenuPrincipal mp;
    public ControlAcercaDe cad;
    public JLabel jlNom1, jlCorreo1, jlimg1, jlNom2, jlCorreo2, jlimg2, jlNom3, jlCorreo3, jlimg3;
    public JButton jbVolver;
    
    public AcercaDe(MenuPrincipal mp){
        super(mp, "Acerca de...", true);
        this.mp = mp;
        setSize(800, 700);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(mp);
        setLayout(null);
        cad = new ControlAcercaDe(this);
        //addWindowListener(cad);
        
        crearGUI();
        setVisible(true);
    }

    private void crearGUI() {
        ControlAcercaDe cad = new ControlAcercaDe(this);
        JLabelTitulo titulo = new JLabelTitulo(60, "Info sobre los desarrolladores", this, "/Imagenes/info.png");
        add(titulo);
        /*
        Imagen o avatar
        Nombre
        Código – correo institucional
        */
        ImageIcon imgPro1 = new ImageIcon(
                getClass().getResource("/Imagenes/programador1.png"));
        jlimg1 = new JLabel(imgPro1);
        jlimg1.setBounds(20, 80, 100, 100); 
        add(jlimg1);
        jlNom1 = new JLabel("Miguel Angel Escobar Marin");
        jlNom1.setBounds(180, 100, 400, 30);
        jlNom1.setHorizontalAlignment(SwingConstants.CENTER);
        jlNom1.setFont(new Font("Tahoma", Font.BOLD, 20));
        //jlNom1.setHorizontalAlignment(SwingConstants.CENTER);//centrar texto
        jlCorreo1 = new JLabel("2264305 - miguel.escobar.marin@correounivalle.edu.co");
        jlCorreo1.setBounds(140, 120, 600, 30);
        jlCorreo1.setHorizontalAlignment(SwingConstants.CENTER);
        jlCorreo1.setFont(new Font("Tahoma", Font.BOLD, 20));
        jlCorreo1.setHorizontalAlignment(SwingConstants.CENTER);//centrar texto
        add(jlNom1);
        add(jlCorreo1);
        
        ImageIcon imgPro2 = new ImageIcon(
                getClass().getResource("/Imagenes/programador2.png"));
        jlimg2 = new JLabel(imgPro2);
        jlimg2.setBounds(20, 230, 100, 100); 
        add(jlimg2);
        jlNom2 = new JLabel("Jhon Alex Rodriguez Benitez");
        jlNom2.setBounds(180, 250, 400, 30);
        jlNom2.setFont(new Font("Tahoma", Font.BOLD, 20));
        //jlNom1.setHorizontalAlignment(SwingConstants.CENTER);//centrar texto
        jlCorreo2 = new JLabel("2264363 - jhon.alex.rodriguez@correounivalle.edu.co");
        jlCorreo2.setBounds(140, 270, 600, 30);
        jlCorreo2.setFont(new Font("Tahoma", Font.BOLD, 20));
        jlCorreo2.setHorizontalAlignment(SwingConstants.CENTER);//centrar texto
        add(jlNom2);
        add(jlCorreo2);
        
        ImageIcon imgPro3 = new ImageIcon(
                getClass().getResource("/Imagenes/vallarino.png"));
        jlimg3 = new JLabel(imgPro3);
        jlimg3.setBounds(20, 380, 100, 100); 
        add(jlimg3);
        jlNom3 = new JLabel("John Alejandro Vallarino Cruz");
        jlNom3.setBounds(180, 400, 400, 30);
        jlNom3.setFont(new Font("Tahoma", Font.BOLD, 20));
        //jlNom1.setHorizontalAlignment(SwingConstants.CENTER);//centrar texto
        jlCorreo3 = new JLabel("2264332 - john.vallarino@correounivalle.edu.co");
        jlCorreo3.setBounds(140, 420, 600, 30);
        jlCorreo3.setFont(new Font("Tahoma", Font.BOLD, 20));
        jlCorreo3.setHorizontalAlignment(SwingConstants.CENTER);//centrar texto
        add(jlNom3);
        add(jlCorreo3);
        
        ImageIcon volver = new ImageIcon(getClass().getResource("/imagenes/volver.png"));
        jbVolver = new JButton("Volver al menu",volver);
        jbVolver.setBounds((800-200)/2, 520, 200, 80);
        jbVolver.setMnemonic('V');
        jbVolver.setHorizontalTextPosition(SwingConstants.CENTER);//configurar la posición del texto horizontal
        jbVolver.setVerticalTextPosition(SwingConstants.BOTTOM);//configurar la posición del texto vertical
        jbVolver.setContentAreaFilled(false);//No pinta el area del botón
        jbVolver.setBorderPainted(false);//No pinta los bordes
        jbVolver.setFocusPainted(false);//Desabilita el efecto del botón cuando el cursor se posa sobre el botón
        jbVolver.setCursor(new Cursor(Cursor.HAND_CURSOR));//permite cambiar el tipo de cursor cuando se posa sobre el botón
        jbVolver.addActionListener(cad);
        add(jbVolver);
    }
}

