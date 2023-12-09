
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

public class TipoConsulta extends JFrame {
    
    public MenuAdministrador ma;
    ControlTipoConsulta ctc;
    public JButton jbQr, jbFormulario;
    public JButtonFuncion jbVolver;
    
    public TipoConsulta(MenuAdministrador ma){
        super("Tipo de consulta");
        this.ma = ma;
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        Image icono = new ImageIcon(getClass().getResource("/Imagenes/LogoBlancoVentana.png")).getImage();
        setIconImage(icono);
        setResizable(false);
        setLayout(null);
        ctc = new ControlTipoConsulta(this);
        addWindowListener(ctc);
        crearGUI();
        
        setVisible(true);
    }

    public void crearGUI() {
        ctc = new ControlTipoConsulta(this);
        JLabelTitulo jt = new JLabelTitulo(
                60, "Tipo de consulta", this, "/Imagenes/Consultar.png");
        add(jt);
        
        jbQr = new JButtonMenu(60, (700-50)/2, 400, 50, 
                "consulta x codigo QR", "Consulta x codigo QR", 
                "/imagenes/qr.png", 'C', this);
        jbQr.addActionListener(ctc);
        add(jbQr);
        
        jbFormulario = new JButtonMenu(550, (700-50)/2, 400, 50, 
                "Consulta x formulario", "Ir a crear usuarios", 
                "/imagenes/formulario.png", 'C', this);
        jbFormulario.addActionListener(ctc);
        add(jbFormulario);
        
        //-----------------------------Botones de Guardar,Limpiar y volver------------------------------------------------------------
        jbVolver = new JButtonFuncion(70, 500, "Volver al menu", 'v', "/Imagenes/volver.png");
        jbVolver.addActionListener(ctc);
        add(jbVolver);
        
    }
}