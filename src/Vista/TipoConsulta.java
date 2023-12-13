/**
 * La clase TipoConsulta representa la interfaz gráfica de usuario para seleccionar
 * el tipo de consulta que se realizará, ya sea por código QR o por formulario.
 *
 * @author  Jhon Alex Rodríguez Benítez - 2264363
 * @author  Miguel Angel Escobar Marín - 2264305
 * @author  John Alejandro Vallarino Cruz - 2264332
 * @since 11/12/2023
 * @version 1.4
 */


package Vista;

import Controlador.ControlConsultarUsuario;
import Controlador.ControlTipoConsulta;
import Utilerias.JButtonFuncion;
import Utilerias.JButtonMenu;
import Utilerias.JLabelTitulo;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

/**
 * La clase TipoConsulta representa la interfaz gráfica de usuario para seleccionar
 * el tipo de consulta que se realizará, ya sea por código QR o por formulario.
 */

public class TipoConsulta extends JFrame {

    /**
     * Referencia a la instancia de la clase MenuPrincipal.
     */
    public MenuPrincipal ma;
    /**
     * Controlador asociado a la ventana de TipoConsulta.
     */
    ControlTipoConsulta ctc;
    /**
     * Botón para realizar la consulta por código QR.
     */
    public JButton jbQr;
    /**
     * Botón para realizar la consulta por formulario.
     */
    public JButton jbFormulario;
    /**
     * Botón para volver al menú principal.
     */
    public JButtonFuncion jbVolver;
    /**
     * String que almacena los privilegios del usuario.
     */
    String privilegios = "";
    
    /**
     * Constructor de la clase TipoConsulta.
     *
     * @param ma     Instancia de la clase MenuPrincipal.
     * @param privi  Privilegios del usuario.
     */
    public TipoConsulta(MenuPrincipal ma, String privi){
        super("Tipo de consulta");
        this.ma = ma;
        privilegios = privi;
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        Image icono = new ImageIcon(getClass().getResource("/Imagenes/LogoBlancoVentana.png")).getImage();
        setIconImage(icono);
        setResizable(false);
        setLayout(null);
        ctc = new ControlTipoConsulta(this, privilegios);
        addWindowListener(ctc);
        crearGUI();
        
        setVisible(true);
    }
    
    /**
     * Método privado para crear y configurar los componentes de la interfaz gráfica.
     */
    public void crearGUI() {
        ctc = new ControlTipoConsulta(this, privilegios);
        JLabelTitulo jt = new JLabelTitulo(
                60, "Tipo de consulta", this, "/Imagenes/Consultar.png");
        add(jt);
        
        jbQr = new JButtonMenu(60, (700-50)/2, 400, 50, 
                "consulta x codigo QR", "Ir a Consulta x codigo QR", 
                "/imagenes/qr.png", 'C', this);
        jbQr.addActionListener(ctc);
        add(jbQr);
        
        jbFormulario = new JButtonMenu(550, (700-50)/2, 400, 50, 
                "Consulta x formulario", "Ir a Consulta x formulario", 
                "/imagenes/formulario.png", 'C', this);
        jbFormulario.addActionListener(ctc);
        add(jbFormulario);
        
        //-----------------------------Botones de Guardar,Limpiar y volver------------------------------------------------------------
        jbVolver = new JButtonFuncion(70, 500, "Volver al menu", 'v', "/Imagenes/volver.png");
        jbVolver.addActionListener(ctc);
        add(jbVolver);
        
    }
}
