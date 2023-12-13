/**
 * La clase MenuPrincipal representa la interfaz gráfica de usuario del
 * menú principal de la aplicación. Proporciona opciones de navegación y acceso
 * a diferentes funcionalidades dependiendo de los privilegios del usuario.
 *
 * @author  Jhon Alex Rodríguez Benítez - 2264363
 * @author  Miguel Angel Escobar Marín - 2264305
 * @author  John Alejandro Vallarino Cruz - 2264332
 * @since 11/12/2023
 * @version 1.4
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
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;


/**
 * La clase MenuPrincipal representa la interfaz gráfica de usuario del
 * menú principal de la aplicación. Proporciona opciones de navegación y acceso
 * a diferentes funcionalidades dependiendo de los privilegios del usuario.
 **/

public class MenuPrincipal extends JFrame{

    /** Botón para acceder a la creación de nuevos usuarios. */
    public JButton jbNuevoUsuario;
    
    /** Botón para acceder a la renovación de membresía (solo para Recepcionista y Administrador). */
    public JButton jbRenovarMembresia;
    
    /** Botón para acceder a la consulta de usuarios. */
    public JButton jbConsultarUsuario;
    
    /** Botón para acceder a la estadísticas (solo para Administrador). */
    public JButton jbEstadistica;
    
    /** Botón para acceder a la lista de usuarios (solo para Supervisor y Administrador). */
    public JButton jbListados;
    
    /** Botón para acceder a la actualización de usuarios. */
    public JButton jbActualizar;
    
    /** Botón para acceder a la actualización de productos. */
    public JButton jbActualizarProd;
    
    /** Botón para acceder a la creación de nuevos productos. */
    public JButton jbProducto;
    
    /** Botón para mostrar el logo de la aplicación. */
    public JButton jbLogo;
    
    /** Botón para mostrar información acerca de la aplicación. */
    public JButton jbAcerca;
            
     /** Controlador asociado al menú principal. */
    ControlMenuPrincipal cma;
    
    /** Privilegios del usuario que accede al menú. */
    String Privilegios = "";
    
    /**
     * Constructor de la clase MenuPrincipal.
     *
     * @param privi Privilegios del usuario.
     */

    public MenuPrincipal(String privi){
        super("Menú principal");
        Privilegios = privi;
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        getContentPane().setBackground(new Color(255, 255, 255));
        Image icono = new ImageIcon(getClass().getResource("/Imagenes/LogoBlancoVentana.png")).getImage();
        setIconImage(icono);
        cma = new ControlMenuPrincipal(this, Privilegios);
        addWindowListener((WindowListener) cma);
        System.out.println("Privilegio: " + Privilegios);
        
        crearGUI();
        
        setVisible(true);
    }
    
    /**
     * Método privado para crear y configurar los componentes de la interfaz gráfica.
     */
    public void crearGUI(){
        
        JLabelTitulo jt = new JLabelTitulo(
                60, "Menu Principal", this, "/Imagenes/hogar.png");
        add(jt);
        cma = new ControlMenuPrincipal(this, Privilegios);
        
// --------------- Verificacion de privilegios --------------------        
        
        if (Privilegios == "Recepcionista"){
            
            jbNuevoUsuario = new JButtonMenu(60, 130, 400, 50, 
                "Nuevo Usuario", "Ir a crear usuarios", 
                "/imagenes/agregar-usuario.png", 'C', this);
            jbNuevoUsuario.addActionListener(cma);
            add(jbNuevoUsuario);
        
            jbConsultarUsuario = new JButtonMenu(490, 130, 400, 50, 
                "Consultar usuario", "Ir a consulta de usuarios", 
                "/imagenes/Consultar.png", 'C', this);    
            jbConsultarUsuario.addActionListener(cma);
            add(jbConsultarUsuario);
            
            jbActualizar = new JButtonMenu(60, 230, 400, 50, 
                "Actualizar Usuario", "Ir a actualizacion de usuarios", 
                "/imagenes/Actualizar.png", 'A', this);
            jbActualizar.addActionListener(cma);
            add(jbActualizar);
            
            jbRenovarMembresia = new JButtonMenu(490, 230, 400, 50,
                "Membresia", "Ir a membresia", 
                "/imagenes/membresia.png", 'r', this);
            jbRenovarMembresia.addActionListener(cma);
            add(jbRenovarMembresia);
            
            jbProducto = new JButtonMenu(60, 330, 400, 50,
                "Nuevo Producto", "Ir a crear producto", 
                "/imagenes/productoIMG.png", 'N', this);
            jbProducto.addActionListener(cma);
            add(jbProducto);
        
            jbActualizarProd = new JButtonMenu(490, 330, 400, 50,
                "Modificar producto", "Ir a actualizar producto", 
                "/imagenes/actualizarProd.png", 'M', this);
            jbActualizarProd.addActionListener(cma);
            add(jbActualizarProd);
            
            jbAcerca = new JButtonMenu((1000-400)/2, 430, 400, 50, 
                "Acerca de...", "Ir a Acerca de", 
                "/imagenes/info.png", 'A', this);
            jbAcerca.setBorderPainted(false);
            jbAcerca.addActionListener(cma);
            add(jbAcerca);
        }
        
        
        if (Privilegios == "Supervisor"){
            jbNuevoUsuario = new JButtonMenu(60, 130, 400, 50, 
                "Nuevo Usuario", "Ir a crear usuarios", 
                "/imagenes/agregar-usuario.png", 'C', this);
            jbNuevoUsuario.addActionListener(cma);
            add(jbNuevoUsuario);
        
            jbConsultarUsuario = new JButtonMenu(490, 130, 400, 50, 
                "Consultar usuario", "Ir a consulta de usuarios", 
                "/imagenes/Consultar.png", 'C', this);    
            jbConsultarUsuario.addActionListener(cma);
            add(jbConsultarUsuario);
        
            jbListados = new JButtonMenu(60, 230, 400, 50, 
                "Listados", "Ir a Listado Usuarios", 
                "/imagenes/Listado.png", 'l', this);
            jbListados.addActionListener(cma);
            add(jbListados);

            jbActualizar = new JButtonMenu(490, 230, 400, 50, 
                "Actualizar Usuario", "Ir a actualizacion de usuarios", 
                "/imagenes/Actualizar.png", 'A', this);
            jbActualizar.addActionListener(cma);
            add(jbActualizar);
      
            jbProducto = new JButtonMenu(60, 330, 400, 50,
                "Nuevo Producto", "Ir a crear producto", 
                "/imagenes/productoIMG.png", 'N', this);
            jbProducto.addActionListener(cma);
            add(jbProducto);
        
            jbActualizarProd = new JButtonMenu(490, 330, 400, 50,
                "Modificar producto", "Ir a actualizar producto", 
                "/imagenes/actualizarProd.png", 'M', this);
            jbActualizarProd.addActionListener(cma);
            add(jbActualizarProd);
        
            jbRenovarMembresia = new JButtonMenu((1000-400)/2, 430, 400, 50,
                "Membresia", "Ir a Membresia", 
                "/imagenes/membresia.png", 'r', this);
            jbRenovarMembresia.addActionListener(cma);
            add(jbRenovarMembresia);
        
            jbAcerca = new JButtonMenu((1000-400)/2, 530, 400, 50, 
                "Acerca de...", "Ir a Acerca de", 
                "/imagenes/info.png", 'A', this);
            jbAcerca.setBorderPainted(false);
            jbAcerca.addActionListener(cma);
            add(jbAcerca);
        }
        
        
        if (Privilegios == "Administrador"){
            jbNuevoUsuario = new JButtonMenu(60, 130, 400, 50, 
                "Nuevo Usuario", "Ir a crear usuarios", 
                "/imagenes/agregar-usuario.png", 'C', this);
            jbNuevoUsuario.addActionListener(cma);
            add(jbNuevoUsuario);
        
            jbConsultarUsuario = new JButtonMenu(490, 130, 400, 50, 
                "Consultar usuario", "Ir a consulta de usuarios", 
                "/imagenes/Consultar.png", 'C', this);    
            jbConsultarUsuario.addActionListener(cma);
            add(jbConsultarUsuario);
        
            jbListados = new JButtonMenu(60, 230, 400, 50, 
                "Listados", "Ir a Listado Usuarios", 
                "/imagenes/Listado.png", 'l', this);
            jbListados.addActionListener(cma);
            add(jbListados);

            jbActualizar = new JButtonMenu(490, 230, 400, 50, 
                "Actualizar Usuario", "Ir a actualizacion de usuarios", 
                "/imagenes/Actualizar.png", 'A', this);
            jbActualizar.addActionListener(cma);
            add(jbActualizar);
        
            jbEstadistica = new JButtonMenu(60, 330, 400, 50,
                "Estadisticas", "Ir a Estadiscas", 
                "/imagenes/Statistic-icon.png", 'A', this);
            jbEstadistica.addActionListener(cma);
            add(jbEstadistica);
        
            jbProducto = new JButtonMenu(490, 330, 400, 50,
                "Nuevo Producto", "Ir a crear producto", 
                "/imagenes/productoIMG.png", 'N', this);
            jbProducto.addActionListener(cma);
            add(jbProducto);
        
            jbActualizarProd = new JButtonMenu(60, 430, 400, 50,
                "Modificar producto", "Ir a actualizar producto", 
                "/imagenes/actualizarProd.png", 'M', this);
            jbActualizarProd.addActionListener(cma);
            add(jbActualizarProd);
        
            jbRenovarMembresia = new JButtonMenu(490, 430, 400, 50,
                "Membresia", "Membresia", 
                "/imagenes/membresia.png", 'r', this);
            jbRenovarMembresia.addActionListener(cma);
            add(jbRenovarMembresia);
        
            jbAcerca = new JButtonMenu((1000-400)/2, 530, 400, 50, 
                "Acerca de...", "Ir a Acerca de", 
                "/imagenes/info.png", 'A', this);
            jbAcerca.setBorderPainted(false);
            jbAcerca.addActionListener(cma);
            add(jbAcerca);
        }
        
        jbLogo = new JButtonRoll(800, 480, 150, 150, 
                "", "Logo", 
                "/Imagenes/LogoBlanco.png", 'L', this);
        add(jbLogo);
    }
}
