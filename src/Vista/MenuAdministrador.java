/*
Proposito: Muestra en pantalla múltiples botones que nos permite la navegación entre distintas ventanas 
@author 
    Jhon Alex Rodríguez Benítez - 2264363
    Miguel Angel Escobar Marín - 2264305
    John Alejandro Vallarino Cruz - 2264332
Fecha de ultima modificacion  20/10/2023
version: 1.1
*/


package Vista;

import Controlador.ControlMenuAdmin;
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


public class MenuAdministrador extends JFrame{

    public JButton jbNuevoUsuario, jbVentanaListado, jbConsultarUsuario,jbEstadistica,jbLiquidar, jbListados, jbActualizar;
    ControlMenuAdmin cma;
    
    
    public JButton jbLogo, jbAcerca;
    
    public MenuAdministrador(){
        super("Menú principal");                                                    
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        getContentPane().setBackground(new Color(255, 255, 255));
        Image icono = new ImageIcon(getClass().getResource("/Imagenes/LogoBlancoVentana.png")).getImage();
        setIconImage(icono);
        cma = new ControlMenuAdmin(this);
        addWindowListener((WindowListener) cma);
        
        crearGUI();
        
        setVisible(true);
    }
    
    public void crearGUI(){
        
        JLabelTitulo jt = new JLabelTitulo(
                60, "Menu Principal", this, "/Imagenes/hogar.png");
        add(jt);
        cma = new ControlMenuAdmin(this);
        jbNuevoUsuario = new JButtonMenu(60, 150, 400, 50, 
                "Nuevo Usuario", "Ir a crear usuarios", 
                "/imagenes/agregar-usuario.png", 'C', this);
        jbNuevoUsuario.addActionListener(cma);
        add(jbNuevoUsuario);
        
        jbConsultarUsuario = new JButtonMenu(490, 150, 400, 50, 
                "Consultar usuario", "Ir a consulta de usuarios", 
                "/imagenes/Consultar.png", 'C', this);    
        jbConsultarUsuario.addActionListener(cma);
        add(jbConsultarUsuario);
        
        jbListados = new JButtonMenu(60, 250, 400, 50, 
                "Listados", "Ir a Listado Usuarios", 
                "/imagenes/Listado.png", 'l', this);
        jbListados.addActionListener(cma);
        add(jbListados);

        jbActualizar = new JButtonMenu(490, 250, 400, 50, 
                "Actualizar Usuario", "Ir a actualizacion de usuarios", 
                "/imagenes/Actualizar.png", 'A', this);
        jbActualizar.addActionListener(cma);
        add(jbActualizar);
        
        jbEstadistica = new JButtonMenu(60, 350, 400, 50,
                "Estadisticas", "Ir a Estadiscas", 
                "/imagenes/Statistic-icon.png", 'A', this);
        jbEstadistica.addActionListener(cma);
        add(jbEstadistica);
        
        jbAcerca = new JButtonMenu(490, 350, 400, 50, 
                "Acerca de...", "Ir a Acerca de", 
                "/imagenes/info.png", 'A', this);
        jbAcerca.setBorderPainted(false);
        jbAcerca.addActionListener(cma);
        add(jbAcerca);
       
        
        jbLogo = new JButtonRoll(800, 480, 150, 150, 
                "", "Logo", 
                "/Imagenes/LogoBlanco.png", "/Imagenes/LogoNegro.png", 'L', this);
        add(jbLogo);
    }
    public static void main(String[] args) {
        MenuAdministrador ma = new MenuAdministrador();
    }
    
}
