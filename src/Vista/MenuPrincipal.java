/*
Proposito: Mostrar en pantalla múltiples botones que nos permite la navegación entre ventanas 
@author 
    Jhon Alex Rodríguez Benítez - 2264363
    Miguel Angel Escobar Marín - 2264305
    John Alejandro Vallarino Cruz - 2264332
Fecha de ultima modificacion  26/09/2023
version: 1.0
*/


package Vista;

import Controlador.ControlMenuPrincipal;
import Modelo.Usuario;
import Utilerias.JButtonMenu;
import Utilerias.JButtonRoll;
import Utilerias.JLabelTitulo;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class MenuPrincipal extends JFrame{

    public JButton jbVentanaCrearUsuario, jbVentanaListado;
    public ArrayList<Usuario> usuarios = new ArrayList<>();
    ControlMenuPrincipal cmp;
    
    
    public JButton jbLogo, jbAcerca;
    
    public MenuPrincipal(){
        super("Menú principal");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        getContentPane().setBackground(new Color(255, 255, 255));
        Image icono = new ImageIcon(getClass().getResource("/Imagenes/Menu_p.png")).getImage();
        setIconImage(icono);
        cmp = new ControlMenuPrincipal(this);
        addWindowListener((WindowListener) cmp);
        
        crearGUI();
        
        setVisible(true);
    }
    
    public void crearGUI(){
        JLabelTitulo jt = new JLabelTitulo(
                60, "Menu Principal", this, "/Imagenes/hogar.png");
        add(jt);
        ControlMenuPrincipal cmp = new ControlMenuPrincipal(this);
        jbVentanaCrearUsuario = new JButtonMenu((800-400)/2, 120, 400, 50, 
                "Crear usuarios", "Ir a crear usuarios", 
                "/imagenes/agregar-usuario.png", 'C', this);
        jbVentanaCrearUsuario.setBorderPainted(false);
        jbVentanaCrearUsuario.addActionListener(cmp);
        add(jbVentanaCrearUsuario);
        
        jbVentanaListado = new JButtonMenu((800-400)/2, 200, 400, 50, 
                "Listar usuarios", "Ir a Listado usuarios", 
                "/imagenes/agregar-usuario.png", 'L', this);
        jbVentanaListado.addActionListener(cmp);
        add(jbVentanaListado);
        
        jbAcerca = new JButtonMenu((800-400)/2, 280, 400, 50, 
                "Acerca de...", "Ir a Acerca de", 
                "/imagenes/agregar-usuario.png", 'A', this);
        jbAcerca.setBorderPainted(false);
        jbAcerca.addActionListener(cmp);
        add(jbAcerca);
       
        
        jbLogo = new JButtonRoll(600, 380, 150, 150, 
                "", "Ver info programadores", 
                "/Imagenes/LogoBlanco.png", "/Imagenes/LogoNegro.png", 'L', this);
        add(jbLogo);
        
        
    }

    public static void main(String[] args) {
        MenuPrincipal obj = new MenuPrincipal();
    }
    
}
