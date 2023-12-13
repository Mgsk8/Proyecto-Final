/**
 * Clase Listados que extiende de JFrame e implementa la interfaz DatosConexion.
 * 
 * @author  Jhon Alex Rodríguez Benítez - 2264363
 * @author  Miguel Angel Escobar Marín - 2264305
 * @author  John Alejandro Vallarino Cruz - 2264332
 * @version 1.4
 * @since 11/12/2023
 */

package Vista;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Controlador.ControlListados;
import Utilerias.Conexion;
import Utilerias.DatosConexion;
import static Utilerias.DatosConexion.baseDatos;
import static Utilerias.DatosConexion.host;
import static Utilerias.DatosConexion.login;
import static Utilerias.DatosConexion.user;
import Utilerias.JButtonFuncion;
import Utilerias.JLabelTitulo;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JToggleButton;
import javax.swing.border.TitledBorder;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

/**
 * Clase Listados que extiende de JFrame e implementa la interfaz DatosConexion.
 */

public class Listados extends JFrame implements DatosConexion{
    
    /** Botones para diferentes tipos de listados. */
    public JButton jbListadoGeneral;
    public JButton jbListadoEstadoxTipo;
    public JButton jbListadoEstadoxSanguineo;
    
    /** Botones de acciones. */
    public JButton jbVolver;
    public JButton jbLimpiar;
    public JButton jbConsultar;
    
    /** ToggleButtons para seleccionar el tipo de listado. */
    public JToggleButton jtListadoGeneral;
    public JToggleButton jtListadoEstxSan;
    public JToggleButton jtListadoEstxTip;
    public JToggleButton jtListadoMembresia;
    
    /** Paneles para mostrar los diferentes tipos de listados. */
    public JPanel jpListadoGeneral;
    public JPanel jpListadoEstxSan;
    public JPanel jpListadoEstxTip;
    public JPanel jpListadoRecepcionista;
    public JPanel jpListadoMembresia;
    
    
    /** Etiquetas para los filtros de listado. */
    public JLabel jlEstado;
    public JLabel jlGrupoSanguineo;
    public JLabel jlTipoUsuario;
  
    /** ComboBox para seleccionar estado, grupo sanguíneo y tipo de usuario. */
    public JComboBox jcEstado1;
    public JComboBox jcEstado2;
    public JComboBox jcGrupoSanguineo;
    public JComboBox jcTipoUsuario;
    
    /** Campos de texto para ingresar valores de filtros. */
    public JTextField jtEstado1;
    public JTextField jtEstado2;
    public JTextField jtGrupoSanguineo;
    public JTextField jtTipoUsuario;
    
    /** Instancia de la clase Listados. */
    public Listados l;
    
    /** Modelos de tabla para los diferentes listados. */
    public ModeloTabla mt;
    public ModeloTabla mt2;
    public ModeloTabla mt3;
    public ModeloTabla mtMembresia;
            
    /** Controlador de la clase Listados. */
    public ControlListados cl;
    
    /** Instancia del menú principal. */
    public MenuPrincipal mp;
    
    /** Tablas para mostrar los resultados de los listados. */
    JTable tabla;
    JTable tabla2;
    JTable tabla3;
    JTable tablaMembresia;
    
    /** Privilegios del usuario actual. */
    String privilegios = "";

    
    /**
     * Constructor de la clase Listados.
     * 
     * @param obj Instancia del menú principal.
     * @param privi Privilegios del usuario.
     */
    public Listados(MenuPrincipal obj, String privi){
        super("Listados");
        mp = obj;
        privilegios = privi;
        setSize(1200, 700);
        setLocationRelativeTo(null);
        //getContentPane().setBackground(color.);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        cl = new ControlListados(this);
        Image icono = new ImageIcon(getClass().getResource("/Imagenes/LogoBlancoVentana.png")).getImage();
        setIconImage(icono);
        addWindowListener(cl);
        crearGUI();
        
        setVisible(true);
    }

    /**
     * Método que crea la interfaz gráfica de usuario.
     */
    public void crearGUI(){
        
        JLabelTitulo jt = new JLabelTitulo(
                60, "Listados", this, "/Imagenes/Consultar.png");
        add(jt);
        cl = new ControlListados(this);
        
        //----------------------Jpanel Listados ----------------------------------------------------------------------
        JPanel jpListados = new JPanel();
        jpListados.setBounds(20, 80, 220, 360);
        jpListados.setLayout(null);
        jpListados.setBorder(new TitledBorder("Listados"));
        add(jpListados);
        
        
        if(privilegios == "Administrador"){
            
            // Botón de listado general
            jtListadoGeneral = new JToggleButton("Listado general");
            jtListadoGeneral.setBounds(10, 40, 200, 40);
            jtListadoGeneral.setBackground(new Color(226, 0, 82));
            jtListadoGeneral.setForeground(Color.white);
            jtListadoGeneral.setFont(new Font("Tahoma", 1, 12));
            jtListadoGeneral.setBorderPainted(false);
            jtListadoGeneral.setFocusPainted(false);
            jtListadoGeneral.setCursor(new Cursor(Cursor.HAND_CURSOR));
            jtListadoGeneral.addActionListener(cl);
            jpListados.add(jtListadoGeneral);
            
            // Botón de listado por estado y grupo sanguíneo
            jtListadoEstxSan = new JToggleButton();
            jtListadoEstxSan.setText("<html><center><p>Listado por</p></center><center><p>estado y grupo sanguineo</p></center></html>");
            jtListadoEstxSan.setBounds(10, 120, 200, 40);
            jtListadoEstxSan.setBackground(new Color(226, 0, 82));
            jtListadoEstxSan.setForeground(Color.white);
            jtListadoEstxSan.setFont(new Font("Tahoma", 1, 12));
            jtListadoEstxSan.setBorderPainted(false);
            jtListadoEstxSan.setFocusPainted(false);
            jtListadoEstxSan.setCursor(new Cursor(Cursor.HAND_CURSOR));
            jtListadoEstxSan.addActionListener(cl);
            jpListados.add(jtListadoEstxSan);
        
            // Botón de listado por estado y tipo de usuario
            jtListadoEstxTip = new JToggleButton();
            jtListadoEstxTip.setText("<html><center><p>Listado por</p></center><center><p>estado y tipo de usuario</p></center></html>");
            jtListadoEstxTip.setBounds(10, 200,200, 40);
            jtListadoEstxTip.setBackground(new Color(226, 0, 82));
            jtListadoEstxTip.setForeground(Color.white);
            jtListadoEstxTip.setFont(new Font("Tahoma", 1, 12));
            jtListadoEstxTip.setBorderPainted(false);
            jtListadoEstxTip.setFocusPainted(false);
            jtListadoEstxTip.setCursor(new Cursor(Cursor.HAND_CURSOR));
            jtListadoEstxTip.addActionListener(cl);
            jpListados.add(jtListadoEstxTip);
            
            jtListadoMembresia = new JToggleButton("Listado membresias");
            jtListadoMembresia.setBounds(10, 280, 200, 40);
            jtListadoMembresia.setBackground(new Color(226, 0, 82));
            jtListadoMembresia.setForeground(Color.white);
            jtListadoMembresia.setFont(new Font("Tahoma", 1, 12));
            jtListadoMembresia.setBorderPainted(false);
            jtListadoMembresia.setFocusPainted(false);
            jtListadoMembresia.setCursor(new Cursor(Cursor.HAND_CURSOR));
            jtListadoMembresia.addActionListener(cl);
            jpListados.add(jtListadoMembresia);
        
            ButtonGroup bg = new ButtonGroup();
            bg.add(jtListadoGeneral);
            bg.add(jtListadoEstxSan);
            bg.add(jtListadoEstxTip);
            bg.add(jtListadoMembresia);
        }
        
        if(privilegios == "Supervisor"){
            
            // Botón de listado por estado y grupo sanguíneo
            jtListadoEstxSan = new JToggleButton();
            jtListadoEstxSan.setText("<html><center><p>Listado por</p></center><center><p>estado y grupo sanguineo</p></center></html>");
            jtListadoEstxSan.setBounds(10, 40, 200, 40);
            jtListadoEstxSan.setBackground(new Color(226, 0, 82));
            jtListadoEstxSan.setForeground(Color.white);
            jtListadoEstxSan.setFont(new Font("Tahoma", 1, 12));
            jtListadoEstxSan.setBorderPainted(false);
            jtListadoEstxSan.setFocusPainted(false);
            jtListadoEstxSan.setCursor(new Cursor(Cursor.HAND_CURSOR));
            jtListadoEstxSan.addActionListener(cl);
            jpListados.add(jtListadoEstxSan);
        
            // Botón de listado por estado y tipo de usuario
            jtListadoEstxTip = new JToggleButton();
            jtListadoEstxTip.setText("<html><center><p>Listado por</p></center><center><p>estado y tipo de usuario</p></center></html>");
            jtListadoEstxTip.setBounds(10, 120,200, 40);
            jtListadoEstxTip.setBackground(new Color(226, 0, 82));
            jtListadoEstxTip.setForeground(Color.white);
            jtListadoEstxTip.setFont(new Font("Tahoma", 1, 12));
            jtListadoEstxTip.setBorderPainted(false);
            jtListadoEstxTip.setFocusPainted(false);
            jtListadoEstxTip.setCursor(new Cursor(Cursor.HAND_CURSOR));
            jtListadoEstxTip.addActionListener(cl);
            jpListados.add(jtListadoEstxTip);
            
            jtListadoMembresia = new JToggleButton("Listado membresias");
            jtListadoMembresia.setBounds(10, 200, 200, 40);
            jtListadoMembresia.setBackground(new Color(226, 0, 82));
            jtListadoMembresia.setForeground(Color.white);
            jtListadoMembresia.setFont(new Font("Tahoma", 1, 12));
            jtListadoMembresia.setBorderPainted(false);
            jtListadoMembresia.setFocusPainted(false);
            jtListadoMembresia.setCursor(new Cursor(Cursor.HAND_CURSOR));
            jtListadoMembresia.addActionListener(cl);
            jpListados.add(jtListadoMembresia);
        
            ButtonGroup bg = new ButtonGroup();
            bg.add(jtListadoEstxSan);
            bg.add(jtListadoEstxTip);
            bg.add(jtListadoMembresia);
        }
        
         //-------------------- JPanel Listado General Admin ----------------------------------------------------------------------
        jpListadoGeneral = new JPanel();
        jpListadoGeneral.setBounds(250, 80, 900, 360);
        //jpListadoGeneral.setBackground(Color.gray);
        jpListadoGeneral.setLayout(null);
        jpListadoGeneral.setBorder(new TitledBorder ( "Lista General"));
        jpListadoGeneral.setVisible(false);
        add(jpListadoGeneral);
        
        String encabezados[] = {"Cedula", "Nombre", "Apellido", "Dia nac", "Mes nac", "Año nac", "Email", "Tipo usuario", "Estado"};
        String datos[][] = { {"", "", "", "", "", "", "", "", ""}};
        
        mt = new ModeloTabla(datos, encabezados);
        tabla = new JTable(mt);

        tabla.setSelectionBackground(Color.lightGray);

        JScrollPane js = new JScrollPane(tabla);
        js.setBounds(10, 50, 880, 270);

        jpListadoGeneral.add(js);
        
         //-------------------- JPanel Listado membresias ----------------------------------------------------------------------
        jpListadoMembresia = new JPanel();
        jpListadoMembresia.setBounds(250, 80, 900, 360);
        //jpListadoMembresia.setBackground(Color.gray);
        jpListadoMembresia.setLayout(null);
        jpListadoMembresia.setBorder(new TitledBorder ( "Lista de membresias"));
        jpListadoMembresia.setVisible(false);
        add(jpListadoMembresia);
        
        String encabezadosMem[] = {"ID Membresia", "Fecha inicio", "Fecha fin", "Tipo de membresia", "Cedula cliente", "Estado"};
        String datosMem[][] = { {"", "", "", "", ""}};
        
        mtMembresia = new ModeloTabla(datosMem, encabezadosMem);
        tablaMembresia = new JTable(mtMembresia);

        tablaMembresia.setSelectionBackground(Color.lightGray);

        JScrollPane jsMem = new JScrollPane(tablaMembresia);
        jsMem.setBounds(10, 50, 880, 270);

        jpListadoMembresia.add(jsMem);
        
        //-------------------- JPanel Listado Clientes Estado x Grupo Sanguineo ----------------------------------------------------------------------
        jpListadoEstxSan = new JPanel();
        jpListadoEstxSan.setBounds(250, 80, 900, 400);
        //jpListadoEstxSan.setBackground(Color.gray);
        jpListadoEstxSan.setLayout(null);
        jpListadoEstxSan.setBorder(new TitledBorder ( "Listado Estado x Grupo Sanguineo"));
        jpListadoEstxSan.setVisible(false);
        add(jpListadoEstxSan);
        
        String encabezados2[] = {"Cedula", "Nombre", "Apellido", "Dia nac", "Mes nac", "Año nac", "Email", "Tipo usuario"};
        String datos2[][] = { { "", "", "", "", "", "", "", "", ""} };
        
        mt2 = new ModeloTabla(datos2, encabezados2);
        tabla2 = new JTable(mt2);

        tabla2.setSelectionBackground(Color.lightGray);

        JScrollPane js2 = new JScrollPane(tabla2);
        js2.setBounds(10, 100, 880, 270);

        jpListadoEstxSan.add(js2);
        
        jlEstado = new JLabel("Estado: ");
        jlEstado.setBounds(10, 10, 200, 40);
        jpListadoEstxSan.add(jlEstado);
        jcEstado1 = new JComboBox<>();
        String estado[] = {"Activo", "Inactivo"};
        for (int i = 0; i < estado.length; i++) {
            jcEstado1.addItem(estado[i]); 
        }
        jcEstado1.setBounds(10, 50, 200, 30);
        jpListadoEstxSan.add(jcEstado1);
        
        jlGrupoSanguineo = new JLabel("Grupo sanguineo: ");
        jlGrupoSanguineo.setBounds(300, 10, 200, 40);
        jpListadoEstxSan.add(jlGrupoSanguineo);
        jcGrupoSanguineo = new JComboBox<>();
        String grupoSanguineo[] = {"A+","O+","B+","AB+","A-","O-","B-","AB-"};
        for (int i = 0; i < grupoSanguineo.length; i++) {
            jcGrupoSanguineo.addItem(grupoSanguineo[i]); 
        }
        jcGrupoSanguineo.setBounds(300, 50, 200, 30);
        jpListadoEstxSan.add(jcGrupoSanguineo);
        
        //-------------------- JPanel Listado Estado x Tipo de usuario ----------------------------------------------------------------------
        jpListadoEstxTip = new JPanel();
        jpListadoEstxTip.setBounds(250, 80, 900, 400);
        //jpListadoEstxTip.setBackground(Color.gray);
        jpListadoEstxTip.setLayout(null);
        jpListadoEstxTip.setBorder(new TitledBorder ( "Listado Estado x Tipo de usuario"));
        jpListadoEstxTip.setVisible(false);
        add(jpListadoEstxTip);
        
        String encabezados3[] = {"Cedula", "Nombre", "Apellido", "Dia nac", "Mes nac", "Año nac", "Email", "Tipo usuario"};
        String datos3[][] = { {"", "", "", "", "", "", "", "", ""} };
        
        mt3 = new ModeloTabla(datos3, encabezados3);
        tabla3 = new JTable(mt3);

        tabla3.setSelectionBackground(Color.lightGray);

        JScrollPane js3 = new JScrollPane(tabla3);
        js3.setBounds(10, 100, 880, 270);

        jpListadoEstxTip.add(js3);
        
        jlEstado = new JLabel("Estado: ");
        jlEstado.setBounds(10, 10, 200, 40);
        jpListadoEstxTip.add(jlEstado);
        jcEstado2 = new JComboBox<>();
        String estado2[] = {"Activo", "Inactivo"};
        for (int i = 0; i < estado2.length; i++) {
            jcEstado2.addItem(estado2[i]); 
        }
        jcEstado2.setBounds(10, 50, 200, 30);
        jpListadoEstxTip.add(jcEstado2);
        
        jlTipoUsuario = new JLabel("Tipo de usuario: ");
        jlTipoUsuario.setBounds(300, 10, 200, 40);
        jpListadoEstxTip.add(jlTipoUsuario);
        jcTipoUsuario = new JComboBox<>();
        
        if (privilegios == "Administrador"){
            String tipoUsuario[] = {"Administrador","Supervisor","Recepcionista","Entrenador","Cliente"};
            for (int i = 0; i < tipoUsuario.length; i++) {
                jcTipoUsuario.addItem(tipoUsuario[i]); 
            }
            jcTipoUsuario.setBounds(300, 50, 200, 30);
            jpListadoEstxTip.add(jcTipoUsuario);
        }
        if (privilegios == "Supervisor"){
            String tipoUsuario[] = {"Recepcionista","Entrenador","Cliente"};
            for (int i = 0; i < tipoUsuario.length; i++) {
                jcTipoUsuario.addItem(tipoUsuario[i]); 
            }
            jcTipoUsuario.setBounds(300, 50, 200, 30);
            jpListadoEstxTip.add(jcTipoUsuario);
        }
        
        
        //------------------------- boton volver ----------------------------------
        jbVolver = new JButtonFuncion(70,500,"Volver al menu", 'v', "/Imagenes/volver.png");
        jbVolver.addActionListener(cl);
        add(jbVolver);
        //-----------------------------Limpiar -----------------------------------------------------------------------------
        jbLimpiar = new JButtonFuncion(230, 500, "Limpiar", 'L', "/Imagenes/limpiar.png");
        jbLimpiar.addActionListener(cl);
        jbLimpiar.setVisible(false);
        add(jbLimpiar);

        //----------------------------- Consultar -------------------------------------------------------------------------------
        jbConsultar = new JButtonFuncion(390, 500, "Consultar", 'C', "/Imagenes/ConsultarConColor.png");
        jbConsultar.addActionListener(cl);
        jbConsultar.setVisible(false);
        add(jbConsultar);
    }
    
    /**
     * Método que llena la tabla con el listado general de Membresias.
     */
    
    public void llenarTablaMembresia() {
        for (int i = mtMembresia.getRowCount() - 1; i >= 0; i--) {
            mtMembresia.removeRow(i);
        }
        Conexion con = new Conexion();
        boolean error = con.conectarMySQL(baseDatos, user, login, host);
        if (!error) {
            String[][] datos = con.consultaMatriz("membresia_cliente", "1");
            if (datos == null) {
                JOptionPane.showMessageDialog(this, "No existen membresías aún");  
            }else{
                //mt.removeRow(0);
                try {
                    for (int i = 0; i < datos.length; i++) {
                        String[] arreglo = datos[i];
                        mtMembresia.addRow(arreglo);
                    }
                }catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Error al leer la base de datos");
                }
            }
        }
    }
    
    /**
     * Método que llena la tabla con el listado general de usuarios.
     */
    
    public void llenarTablaGeneral() {
        for (int i = mt.getRowCount() - 1; i >= 0; i--) {
            mt.removeRow(i);
        }
        Conexion con = new Conexion();
        boolean error = con.conectarMySQL(baseDatos, user, login, host);
        if (!error) {
            String[][] datos = con.consultaMatriz("usuario", "1");
            if (datos == null) {
                JOptionPane.showMessageDialog(this, "No existen usuarios aún");  
            }else{
                //mt.removeRow(0);
                try {
                    for (int i = 0; i < datos.length; i++) {
                        String[] arreglo = datos[i];
                        mt.addRow(arreglo);
                    }
                }catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Error al leer la base de datos");
                }
            }
        }
    }
    
    /**
    * Método que llena la tabla con el listado filtrado por estado y grupo sanguíneo.
    * 
    * @param valores Valores a utilizar en la consulta.
    */
    public void llenarTablaEstadoxGrupoSanguineo(String valores) {
        for (int i = mt2.getRowCount() - 1; i >= 0; i--) {
            mt2.removeRow(i);
        }
        Conexion con = new Conexion();
        boolean error = con.conectarMySQL(baseDatos, user, login, host);
        if (!error) {
            String[][] datos = con.consultaMatriz("usuario, cliente", valores);
            //String[][] datos2 = con.consultaMatriz("usuario", "estado = " );
            if (datos == null) {
                JOptionPane.showMessageDialog(this, "No existen usuarios con esta condicion aún");  
            }else{
                //mt.removeRow(0);
                try {
                    for (int i = 0; i < datos.length; i++) {
                        String[] arreglo = datos[i];
                        mt2.addRow(arreglo);
                    }
                }catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Error al leer la base de datos");
                }
            }
        }
    }
    
    /**
    * Método que llena la tabla con el listado filtrado por estado y tipo de usuario.
    * 
   * @param valores Valores a utilizar en la consulta.
   */
    public void llenarTablaEstadoxTipoUsuario(String valores) {
        for (int i = mt3.getRowCount() - 1; i >= 0; i--) {
            mt3.removeRow(i);
        }
        Conexion con = new Conexion();
        boolean error = con.conectarMySQL(baseDatos, user, login, host);
        if (!error) {
            String[][] datos = con.consultaMatriz("usuario", valores);
            
            //datos2 = con.
            if (datos == null) {
                JOptionPane.showMessageDialog(this, "No existen usuarios con esta condicion aún");  
            }else{
                //mt.removeRow(0);
                try {
                    for (int i = 0; i < datos.length; i++) {
                        String[] arreglo = datos[i];
                        mt3.addRow(arreglo);
                    }
                }catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Error al leer la base de datos");
                }
            }
        }
    }
}