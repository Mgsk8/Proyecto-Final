/**
 * Propósito: Clase que representa la interfaz gráfica para la creación de productos, permitiendo
 * ingresar información básica del producto como el ID, nombre, precio y cantidad.
 * 
 * @version 1.0
 * @since 11/12/2023
 * @author  Jhon Alex Rodríguez Benítez - 2264363
 * @author  Miguel Angel Escobar Marín - 2264305
 * @author  John Alejandro Vallarino Cruz - 2264332
 */

package Vista;

import Controlador.ControlCrearProducto;
import Utilerias.JButtonFuncion;
import Utilerias.JLabelTitulo;
import Utilerias.LimitadorCaracteres;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.border.TitledBorder;


/**
 * Propósito: Clase que representa la interfaz gráfica para la creación de productos, permitiendo
 * ingresar información básica del producto como el ID, nombre, precio y cantidad.
 */

public class CrearProducto extends JFrame {
    
    /** Etiqueta para mostrar el campo del ID del producto. */
    public JLabel jlIdProducto;

    /** Etiqueta para mostrar el campo del nombre del producto. */
    public JLabel jlNombre;

    /** Etiqueta para mostrar el campo del precio del producto. */
    public JLabel jlPrecio;

    /** Etiqueta para mostrar el campo de la cantidad del producto. */
    public JLabel jlCantidad;

    /** Campo de texto para ingresar el ID del producto. */
    public JTextField jtIdProducto;

    /** Campo de texto para ingresar el nombre del producto. */
    public JTextField jtNombre;

    /** Campo de texto para ingresar el precio del producto. */
    public JTextField jtPrecio;

    /** Campo de texto para ingresar la cantidad del producto. */
    public JTextField jtCantidad;

    /** Botón de función para volver al menú principal. */
    public JButtonFuncion jbVolver;

    /** Botón de función para limpiar los campos de entrada. */
    public JButtonFuncion jbLimpiar;

    /** Botón de función para guardar la información del producto. */
    public JButtonFuncion jbGuardar;

    /** Panel para ingresar los datos base del producto. */
    public JPanel jpIngresarDatosBase;

    /** Controlador de la clase CrearProducto. */
    ControlCrearProducto ccp;

    /** Objeto MenuPrincipal que representa el menú principal de la aplicación. */
    public MenuPrincipal ma;

    /**
     * Constructor de la clase CrearProducto.
     * 
     * @param ma Objeto MenuPrincipal que representa el menú principal de la aplicación.
     */
    
    public CrearProducto(MenuPrincipal ma) {
        super("Crear Producto");
        this.ma = ma;
        setSize(1000, 700);
        setLocationRelativeTo(null);
        //getContentPane().setBackground(Color.GRAY);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        Image icono = new ImageIcon(getClass().getResource("/Imagenes/LogoBlancoVentana.png")).getImage();
        setIconImage(icono);
        setResizable(false);
        setLayout(null);
        ccp = new ControlCrearProducto(this);
        addWindowListener(ccp);
        crearGUI();

        setVisible(true);
    }

    /**
     * Método que crea la interfaz gráfica para la creación de productos.
     */
    private void crearGUI() {
        JLabelTitulo jt = new JLabelTitulo(
                60, "Ingresar Producto", this, "/Imagenes/productoIMG.png");
        add(jt);
        
        
        //------------------panel Ingresar datos base producto ---------------------------------------------------------------
        jpIngresarDatosBase = new JPanel();
        jpIngresarDatosBase.setBounds((1000-800)/2, 80, 800, 380);
        jpIngresarDatosBase.setLayout(null);
        jpIngresarDatosBase.setBorder(new TitledBorder("Ingreso de datos base"));
        add(jpIngresarDatosBase);
        
        jlIdProducto = new JLabel("Id producto:");
        jlIdProducto.setBounds(80, 50, 120, 30);
        jpIngresarDatosBase.add(jlIdProducto);
        jtIdProducto = new JTextField();
        jtIdProducto.setBounds(80, 90, 200, 30);
        jtIdProducto.setDocument(new LimitadorCaracteres(jtIdProducto, 10, 0));
        jpIngresarDatosBase.add(jtIdProducto);

        jlNombre = new JLabel("Nombre:");
        jlNombre.setBounds(480, 50, 120, 30);
        jpIngresarDatosBase.add(jlNombre);
        jtNombre = new JTextField();
        jtNombre.setBounds(480, 90, 200, 30);
        jtNombre.setDocument(new LimitadorCaracteres(jtNombre, 20, 1));
        jpIngresarDatosBase.add(jtNombre);
        

        jlPrecio = new JLabel("Precio:");
        jlPrecio.setBounds(80, 150, 120, 30);
        jpIngresarDatosBase.add(jlPrecio);
        jtPrecio = new JTextField();
        jtPrecio.setBounds(80, 190, 200, 30);
        jtPrecio.setDocument(new LimitadorCaracteres(jtPrecio, 6, 0));
        jpIngresarDatosBase.add(jtPrecio);
        
        jlCantidad = new JLabel("cantidad:");
        jlCantidad.setBounds(480, 150, 120, 30);
        jpIngresarDatosBase.add(jlCantidad);
        jtCantidad = new JTextField();
        jtCantidad.setBounds(480, 190, 200, 30);
        jtCantidad.setDocument(new LimitadorCaracteres(jtCantidad, 3, 0));
        jpIngresarDatosBase.add(jtCantidad);
        

        //-----------------------------Botones de Guardar,Limpiar y volver------------------------------------------------------------
        jbVolver = new JButtonFuncion(70, 500, "Volver al menu", 'v', "/Imagenes/volver.png");
        jbVolver.addActionListener(ccp);
        add(jbVolver);

        //-----------------------------Limpiar -----------------------------------------------------------------------------
        jbLimpiar = new JButtonFuncion(370, 500, "Limpiar", 'L', "/Imagenes/limpiar.png");
        jbLimpiar.addActionListener(ccp);
        add(jbLimpiar);

        //----------------------------- Guardar -------------------------------------------------------------------------------
        jbGuardar = new JButtonFuncion(370 + 300, 500, "Guardar", 'G', "/Imagenes/GuardarUser.png");
        jbGuardar.addActionListener(ccp);
        add(jbGuardar);

    }
}
