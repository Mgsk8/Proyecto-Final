package Vista;

import Controlador.ControlCrearProducto;
import Controlador.ControlModificarProducto;
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

public class ModificarProducto extends JFrame{
    public JLabel jlIdProducto, jlNombre, jlPrecio, jlCantidad;
    public JTextField jtIdProducto, jtNombre, jtPrecio, jtCantidad;
    public JButtonFuncion jbVolver, jbLimpiar,jbConsultar,jbActualizar;
    public JPanel jpIngresarDatosBase;
    ControlModificarProducto cmp;
    public MenuPrincipal ma;
    
    public ModificarProducto(MenuPrincipal ma) {
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
        cmp = new ControlModificarProducto(this);
        addWindowListener(cmp);
        crearGUI();

        setVisible(true);
    }

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
        jtNombre.setEditable(false);
        jpIngresarDatosBase.add(jtNombre);
        

        jlPrecio = new JLabel("Precio:");
        jlPrecio.setBounds(80, 150, 120, 30);
        jpIngresarDatosBase.add(jlPrecio);
        jtPrecio = new JTextField();
        jtPrecio.setBounds(80, 190, 200, 30);
        jtPrecio.setDocument(new LimitadorCaracteres(jtPrecio, 6, 0));
        jtPrecio.setEditable(false);
        jpIngresarDatosBase.add(jtPrecio);
        
        jlCantidad = new JLabel("cantidad:");
        jlCantidad.setBounds(480, 150, 120, 30);
        jpIngresarDatosBase.add(jlCantidad);
        jtCantidad = new JTextField();
        jtCantidad.setBounds(480, 190, 200, 30);
        jtCantidad.setDocument(new LimitadorCaracteres(jtCantidad, 3, 0));
        jtCantidad.setEditable(false);
        jpIngresarDatosBase.add(jtCantidad);
        

        //-----------------------------Botones de Guardar,Limpiar y volver------------------------------------------------------------
        jbVolver = new JButtonFuncion(70, 500, "Volver al menu", 'v', "/Imagenes/volver.png");
        jbVolver.addActionListener(cmp);
        add(jbVolver);

        //-----------------------------Limpiar -----------------------------------------------------------------------------
        jbLimpiar = new JButtonFuncion(230, 500, "Limpiar", 'L', "/Imagenes/limpiar.png");
        jbLimpiar.addActionListener(cmp);
        add(jbLimpiar);

        //----------------------------- Consultar -------------------------------------------------------------------------------
        jbConsultar = new JButtonFuncion(370, 500, "Consulta", 'C', "/Imagenes/GuardarUser.png");
        jbConsultar.addActionListener(cmp);
        add(jbConsultar);
        
        //----------------------------- actualizar -------------------------------------------------------------------------------
        jbActualizar = new JButtonFuncion(530, 500, "Actualizar", 'A', "/Imagenes/ActualizarConColor.png");
        jbActualizar.addActionListener(cmp);
        add(jbActualizar);

    }
}
