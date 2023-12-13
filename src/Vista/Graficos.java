/**
 * Clase que representa la ventana de estadísticas del sistema.
 * @author  Jhon Alex Rodríguez Benítez - 2264363
 * @author  Miguel Angel Escobar Marín - 2264305
 * @author  John Alejandro Vallarino Cruz - 2264332
 * @version 1.4
 * @since 11/12/2023
 */

package Vista;

import Controlador.ControlGraficos;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;

/**
 * Clase que representa la ventana de estadísticas del sistema.
*/  
public class Graficos extends JFrame implements DatosConexion{
    
    /** ToggleButtons para seleccionar el tipo de Estadistica. */
    public JToggleButton jtGraficoPersonal;
    public JToggleButton jtGraficoAdm;
    public JToggleButton jtGraficoSup;
    public JToggleButton jtGraficoRec;
    public JToggleButton jtGraficoEnt;
    public JToggleButton jtGraficoCli;
    public JToggleButton jtGraficoEstado;
    public JToggleButton jtGraficoGrupoSanquineo;
    
    
    /** Gráfico utilizado para visualizar las estadísticas. */
    public JFreeChart chart;
    
    /** Instancia de Graficos. */
    public Graficos g;
    
     /** Controlador de la clase Graficos. */
    public ControlGraficos cg;
    
    /** Instancia del menú principal. */
    public MenuPrincipal mp;
    
    /** Botones de acciones. */
    public JButton jbVolver;
    public JButton jbLimpiar;
    public JButton jbConsultar;
    
    /** Paneles para mostrar los diferentes tipos de Estadisticas. */
    public JPanel jpGraficoPersonal; 
    public JPanel jpGraficoEstadoxTipoUsuario;
    public JPanel jpGraficoEstado;
    public JPanel jpGrupoSanguineo;
    
    /**
     * Tipo de usuario para el gráfico seleccionado.
     */
    public String tipoUsuarioGrafico;

    /**
     * Constructor de la clase Graficos.
     * @param obj Objeto de la clase MenuPrincipal.
     */
    public Graficos(MenuPrincipal obj){
        super("Estadistica");
        mp = obj;
        setSize(1200, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        cg = new ControlGraficos(this);
        Image icono = new ImageIcon(getClass().getResource("/Imagenes/LogoBlancoVentana.png")).getImage();
        setIconImage(icono);
        addWindowListener(cg);
        crearGUI();
        
        setVisible(true);
    }

    /**
     * Método para crear la interfaz gráfica de la ventana de estadísticas.
     */
    public void crearGUI(){
        
        JLabelTitulo jt = new JLabelTitulo(
                60, "Estadisticas", this, "/Imagenes/Consultar.png");
        add(jt);
        cg = new ControlGraficos(this);
        
        //----------------------Jpanel Graficos ----------------------------------------------------------------------
        JPanel jpGraficos = new JPanel();
        jpGraficos.setBounds(20, 80, 220, 500);
        jpGraficos.setLayout(null);
        jpGraficos.setBorder(new TitledBorder("Tipo de estadisticas"));
        add(jpGraficos);
        
        jtGraficoCli = new JToggleButton("Estadistica clientes");
        jtGraficoCli.setBounds(10, 20, 200, 40);
        jtGraficoCli.setBackground(new Color(226, 0, 82));
        jtGraficoCli.setForeground(Color.white);
        jtGraficoCli.setFont(new Font("Tahoma", 1, 12));
        jtGraficoCli.setBorderPainted(false);
        jtGraficoCli.setFocusPainted(false);
        jtGraficoCli.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jtGraficoCli.addActionListener(cg);
        jpGraficos.add(jtGraficoCli);
        
        jtGraficoEnt = new JToggleButton("Estadistica entrenador");
        jtGraficoEnt.setBounds(10, 80, 200, 40);
        jtGraficoEnt.setBackground(new Color(226, 0, 82));
        jtGraficoEnt.setForeground(Color.white);
        jtGraficoEnt.setFont(new Font("Tahoma", 1, 12));
        jtGraficoEnt.setBorderPainted(false);
        jtGraficoEnt.setFocusPainted(false);
        jtGraficoEnt.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jtGraficoEnt.addActionListener(cg);
        jpGraficos.add(jtGraficoEnt);
        
        jtGraficoRec = new JToggleButton("Estadistica recepcionistas");
        jtGraficoRec.setBounds(10, 140, 200, 40);
        jtGraficoRec.setBackground(new Color(226, 0, 82));
        jtGraficoRec.setForeground(Color.white);
        jtGraficoRec.setFont(new Font("Tahoma", 1, 12));
        jtGraficoRec.setBorderPainted(false);
        jtGraficoRec.setFocusPainted(false);
        jtGraficoRec.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jtGraficoRec.addActionListener(cg);
        jpGraficos.add(jtGraficoRec);
        
        jtGraficoSup = new JToggleButton("Estadistica supervisores");
        jtGraficoSup.setBounds(10, 200, 200, 40);
        jtGraficoSup.setBackground(new Color(226, 0, 82));
        jtGraficoSup.setForeground(Color.white);
        jtGraficoSup.setFont(new Font("Tahoma", 1, 12));
        jtGraficoSup.setBorderPainted(false);
        jtGraficoSup.setFocusPainted(false);
        jtGraficoSup.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jtGraficoSup.addActionListener(cg);
        jpGraficos.add(jtGraficoSup);
        
        jtGraficoAdm = new JToggleButton("Estadistica administradores");
        jtGraficoAdm.setBounds(10, 260, 200, 40);
        jtGraficoAdm.setBackground(new Color(226, 0, 82));
        jtGraficoAdm.setForeground(Color.white);
        jtGraficoAdm.setFont(new Font("Tahoma", 1, 12));
        jtGraficoAdm.setBorderPainted(false);
        jtGraficoAdm.setFocusPainted(false);
        jtGraficoAdm.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jtGraficoAdm.addActionListener(cg);
        jpGraficos.add(jtGraficoAdm);        
        
        jtGraficoPersonal = new JToggleButton("<html><center><p>Estadistica por</p></center><center><p>tipo de usuario</p></center></html>");
        jtGraficoPersonal.setBounds(10, 320, 200, 40);
        jtGraficoPersonal.setBackground(new Color(226, 0, 82));
        jtGraficoPersonal.setForeground(Color.white);
        jtGraficoPersonal.setFont(new Font("Tahoma", 1, 12));
        jtGraficoPersonal.setBorderPainted(false);
        jtGraficoPersonal.setFocusPainted(false);
        jtGraficoPersonal.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jtGraficoPersonal.addActionListener(cg);
        jpGraficos.add(jtGraficoPersonal);
        
        jtGraficoEstado = new JToggleButton();
        jtGraficoEstado.setText("<html><center><p>Estadistica por</p></center><center><p>estado</p></center></html>");
        jtGraficoEstado.setBounds(10, 380,200, 40);
        jtGraficoEstado.setBackground(new Color(226, 0, 82));
        jtGraficoEstado.setForeground(Color.white);
        jtGraficoEstado.setFont(new Font("Tahoma", 1, 12));
        jtGraficoEstado.setBorderPainted(false);
        jtGraficoEstado.setFocusPainted(false);
        jtGraficoEstado.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jtGraficoEstado.addActionListener(cg);
        jpGraficos.add(jtGraficoEstado);
        
        jtGraficoGrupoSanquineo = new JToggleButton();
        jtGraficoGrupoSanquineo.setText("<html><center><p>Estadistica por</p></center><center><p>grupo sanguineo</p></center></html>");
        jtGraficoGrupoSanquineo.setBounds(10, 440, 200, 40);
        jtGraficoGrupoSanquineo.setBackground(new Color(226, 0, 82));
        jtGraficoGrupoSanquineo.setForeground(Color.white);
        jtGraficoGrupoSanquineo.setFont(new Font("Tahoma", 1, 12));
        jtGraficoGrupoSanquineo.setBorderPainted(false);
        jtGraficoGrupoSanquineo.setFocusPainted(false);
        jtGraficoGrupoSanquineo.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jtGraficoGrupoSanquineo.addActionListener(cg);
        jpGraficos.add(jtGraficoGrupoSanquineo);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(jtGraficoCli);
        bg.add(jtGraficoEnt);
        bg.add(jtGraficoRec);
        bg.add(jtGraficoSup);
        bg.add(jtGraficoAdm);
        bg.add(jtGraficoPersonal);
        bg.add(jtGraficoEstado);
        bg.add(jtGraficoGrupoSanquineo);
        
         //-------------------- JPanel Grafico Personal ----------------------------------------------------------------------
        jpGraficoPersonal = new JPanel();
        jpGraficoPersonal.setBounds(250, 80, 780, 570);
        jpGraficoPersonal.setLayout(null);
        jpGraficoPersonal.setBorder(new TitledBorder ( "Estadistica por tipo de usuario"));
        jpGraficoPersonal.setVisible(false);
        add(jpGraficoPersonal);
        
        int[] personal = listadoPersonal();
        crearGraficoPersonal(personal);

        ChartPanel panelPersonal = new ChartPanel(chart, false);
        panelPersonal.setBounds(10, 30, 760, 520);
        jpGraficoPersonal.add(panelPersonal);
    
        //-------------------- JPanel Grafico por Estado x Tipo de Usuario ----------------------------------------------------------------------
        jpGraficoEstadoxTipoUsuario = new JPanel();
        jpGraficoEstadoxTipoUsuario.setBounds(250, 80, 780, 570);
        jpGraficoEstadoxTipoUsuario.setLayout(null);
        jpGraficoEstadoxTipoUsuario.setBorder(new TitledBorder ( "Estadistica..."));
        jpGraficoEstadoxTipoUsuario.setVisible(false);
        add(jpGraficoEstadoxTipoUsuario);
       

        //-------------------- JPanel Grafico por Estado ----------------------------------------------------------------------
        jpGraficoEstado = new JPanel();
        jpGraficoEstado.setBounds(250, 80, 780, 570);
        //jpListadoEstxSan.setBackground(Color.gray);
        jpGraficoEstado.setLayout(null);
        jpGraficoEstado.setBorder(new TitledBorder ( "Estadistica por estado"));
        jpGraficoEstado.setVisible(false);
        add(jpGraficoEstado);
        
        int[] estado = listadoEstado();
        crearGraficoEstado(estado);

        ChartPanel panelEstado = new ChartPanel(chart, false);
        panelEstado.setBounds(10, 30, 760, 520);
        jpGraficoEstado.add(panelEstado);
        
        //-------------------- JPanel Listado Estado x Tipo de usuario ----------------------------------------------------------------------
        jpGrupoSanguineo = new JPanel();
        jpGrupoSanguineo.setBounds(250, 80, 780, 570);
        jpGrupoSanguineo.setLayout(null);
        jpGrupoSanguineo.setBorder(new TitledBorder ( "Estadistica clientes tipo sanguineo"));
        jpGrupoSanguineo.setVisible(false);
        add(jpGrupoSanguineo);
        
        int[] grupoSanguineo = listadoGrupoSanguineo();
        crearGraficoGrupoSanguineo(grupoSanguineo);

        ChartPanel panelGrupoSanguineo = new ChartPanel(chart, false);
        panelGrupoSanguineo.setBounds(10, 30, 760, 520);
        jpGrupoSanguineo.add(panelGrupoSanguineo);
        
        //------------------------- boton volver ----------------------------------
        jbVolver = new JButtonFuncion(70,580,"Volver al menu", 'v', "/Imagenes/volver.png");
        jbVolver.addActionListener(cg);
        add(jbVolver);
    }
    
    /**
    * Método para crear el gráfico de estadísticas por tipo de usuario.
    * @param personal Arreglo con la cantidad de usuarios por tipo.
    */
    public void crearGraficoPersonal(int[] personal) {
        
        for (int i = 0; i < personal.length; i++) {
            System.out.println("Posicion " + i + ": " + personal[i]);
        }
        double usuariosTotales = personal[0];
        double porcAdmin = 0;
        double porcSup = 0;
        double porcRec = 0;
        double porcEnt = 0;
        double porcCli = 0;

        if(personal[1] != 0){
            porcAdmin = (personal[1] * 100) / usuariosTotales;
        }
        if(personal[2] != 0){
            porcSup = (personal[2] * 100) / usuariosTotales;
        }
        if(personal[3] != 0){
            porcRec = (personal[3] * 100) / usuariosTotales;
        }
        if(personal[4] != 0){
            porcEnt = (personal[4] * 100) / usuariosTotales;
        }
        if(personal[5] != 0){
            porcCli = (personal[5] * 100) / usuariosTotales;
        }

        DefaultPieDataset data = new DefaultPieDataset();
        data.setValue("Administradores: " + personal[1] + " || " + porcAdmin + "%", porcAdmin);
        data.setValue("Supervisores: " + personal[2] + " || " + porcSup + "%", porcSup);
        data.setValue("Recepcionistas: " + personal[3] + " || " + porcRec + "%", porcRec);
        data.setValue("Entrenadores: " + personal[4] + " || " + porcEnt + "%", porcEnt);
        data.setValue("Clientes: " + personal[5] + " || " + porcCli + "%", porcCli);

        chart = ChartFactory.createPieChart3D(
                "PERSONAL", // chart title
                data, // data
                true, // include legend
                true,
                true);

        chart.setBackgroundPaint(Color.ORANGE);// Color de fonde de la ventana
        chart.getTitle().setPaint(Color.blue); // Dar color al titulo

        PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setLabelBackgroundPaint(Color.ORANGE);// Color de las etiquetas
        plot.setForegroundAlpha(0.60f);// Color de el fondo del grafico

        // esto es lo que lo hace rotar
        Rotator rotator = new Rotator(plot);
        rotator.start();
    }

    /**
    * Método para obtener la cantidad de usuarios por tipo.
    * @return Arreglo con la cantidad de usuarios por tipo.
    */
    public int [] listadoPersonal() {
        boolean error = false;
        int[] personal = new int[6];
        int contadorUsu = 0;
        int contadorAdmin = 0;
        int contadorSup = 0;
        int contadorRec = 0;
        int contadorEnt = 0;
        int contadorCli = 0;
       
        Conexion con = new Conexion();
        boolean error2 = con.conectarMySQL(baseDatos, user, login, host);
        if (!error) {
            String[][] datos = con.consultaMatriz("usuario", "1");
            if (datos == null) {
                JOptionPane.showMessageDialog(this, "No existen usuarios aún");  
            }else{
                contadorUsu = con.contar("usuario");
                contadorAdmin = con.contar("usuario", "tipo_usuario = 'Administrador'");
                contadorSup = con.contar("usuario", "tipo_usuario = 'Supervisor'");
                contadorRec = con.contar("usuario", "tipo_usuario = 'Recepcionista'");
                contadorEnt = con.contar("usuario", "tipo_usuario = 'Entrenador'");
                contadorCli = con.contar("usuario", "tipo_usuario = 'Cliente'");
            }
        }
        con.cerrarConsulta();
        
        personal[0] = contadorUsu;
        personal[1] = contadorAdmin;
        personal[2] = contadorSup;
        personal[3] = contadorRec;
        personal[4] = contadorEnt;
        personal[5] = contadorCli;
        
        return personal;
    }
    
    /**
     * Crea un gráfico de estadísticas de estado por tipo de usuario.
     * @param estadoxTipoUsuario Arreglo de enteros con la cantidad de usuarios en cada estado.
     */
    public void crearGraficoEstadoxTipoUsuario(int[] estadoxTipoUsuario) {
        int usuariosTotales = estadoxTipoUsuario[0];
        double porcActivo = 0;
        double porcInactivo = 0;

        if(estadoxTipoUsuario[1] != 0){
            porcActivo = (estadoxTipoUsuario[1] * 100) / usuariosTotales;
        }
        if(estadoxTipoUsuario[2] != 0){
            porcInactivo = (estadoxTipoUsuario[2] * 100) / usuariosTotales;
        }

        DefaultPieDataset data = new DefaultPieDataset();
        data.setValue("Activos: " + estadoxTipoUsuario[1] + " || " + porcActivo + "%", porcActivo);
        data.setValue("Inactivos: " + estadoxTipoUsuario[2] + " || " + porcInactivo + "%", porcInactivo);

        chart = ChartFactory.createPieChart3D(
                "ESTADO", // chart title
                data, // data
                true, // include legend
                true,
                true);

        chart.setBackgroundPaint(Color.ORANGE);// Color de fonde de la ventana
        chart.getTitle().setPaint(Color.blue); // Dar color al titulo

        PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setLabelBackgroundPaint(Color.ORANGE);// Color de las etiquetas
        plot.setForegroundAlpha(0.60f);// Color de el fondo del grafico

        // esto es lo que lo hace rotar
        Rotator rotator = new Rotator(plot);
        rotator.start();
    }
    
    /**
     * Crea un gráfico de estadísticas de estado.
     * @param personal Arreglo de enteros con la cantidad de usuarios en cada estado.
     */
    public void crearGraficoEstado(int[] personal) {
        // Método similar al anterior, pero aplicado a estadísticas de estado general
        
        int usuariosTotales = personal[0];
        double porcActivo = 0;
        double porcInactivo = 0;

        if(personal[1] != 0){
            porcActivo = (personal[1] * 100) / usuariosTotales;
        }
        if(personal[2] != 0){
            porcInactivo = (personal[2] * 100) / usuariosTotales;
        }

        DefaultPieDataset data = new DefaultPieDataset();
        data.setValue("Activos: " + personal[1] + " || " + porcActivo + "%", porcActivo);
        data.setValue("Inactivos: " + personal[2] + " || " + porcInactivo + "%", porcInactivo);

        chart = ChartFactory.createPieChart3D(
                "ESTADO", // chart title
                data, // data
                true, // include legend
                true,
                true);

        chart.setBackgroundPaint(Color.ORANGE);// Color de fonde de la ventana
        chart.getTitle().setPaint(Color.blue); // Dar color al titulo

        PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setLabelBackgroundPaint(Color.ORANGE);// Color de las etiquetas
        plot.setForegroundAlpha(0.60f);// Color de el fondo del grafico

        // esto es lo que lo hace rotar
        Rotator rotator = new Rotator(plot);
        rotator.start();
    }
    
     /**
     * Obtiene un listado de estadísticas de estado por tipo de usuario.
     * @param tipoUsuario Tipo de usuario para el cual se desea obtener las estadísticas.
     * @return Arreglo de enteros con la cantidad de usuarios en cada estado.
     */
    public int [] listadoEstadoxTipoUsuario(String tipoUsuario) {
        // Método similar a listadoEstado, pero aplicado a un tipo de usuario específico

        boolean error = false;
        int[] estadoxTipoUsuario = new int[3];
        int contadorUsu = 0;
        int contadorActivo = 0;
        int contadorInactivo = 0;
        Conexion con = new Conexion();
        boolean error2 = con.conectarMySQL(baseDatos, user, login, host);
        if (!error) {
            String[][] datos = con.consultaMatriz("usuario", "1");
            if (datos == null) {
                JOptionPane.showMessageDialog(this, "No existen usuarios aún");  
            }else{
                contadorUsu = con.contar("usuario", "tipo_usuario = '" + tipoUsuario + "'");
                contadorActivo = con.contar("usuario", "tipo_usuario = '" + tipoUsuario + "' AND estado = 'Activo'");
                contadorInactivo = con.contar("usuario", "tipo_usuario = '" + tipoUsuario + "' AND estado = 'Inactivo'");
            }
        }
        con.cerrarConsulta();
        estadoxTipoUsuario[0] = contadorUsu;
        estadoxTipoUsuario[1] = contadorActivo;
        estadoxTipoUsuario[2] = contadorInactivo;
        return estadoxTipoUsuario;
    }
    /**
     * Obtiene un listado de estadísticas de estado general.
     * @return Arreglo de enteros con la cantidad de usuarios en cada estado.
     */
    public int [] listadoEstado() {
    // Método similar a listadoEstadoxTipoUsuario, pero aplicado a estadísticas generales

        boolean error = false;
        int[] personal = new int[3];
        int contadorUsu = 0;
        int contadorActivo = 0;
        int contadorInactivo = 0;
        Conexion con = new Conexion();
        boolean error2 = con.conectarMySQL(baseDatos, user, login, host);
        if (!error) {
            String[][] datos = con.consultaMatriz("usuario", "1");
            if (datos == null) {
                JOptionPane.showMessageDialog(this, "No existen usuarios aún");  
            }else{
                contadorUsu = con.contar("usuario");
                contadorActivo = con.contar("usuario", "estado = 'Activo'");
                contadorInactivo = con.contar("usuario", "estado = 'Inactivo'");
            }
        }
        con.cerrarConsulta();
        personal[0] = contadorUsu;
        personal[1] = contadorActivo;
        personal[2] = contadorInactivo;
        return personal;
    }
    
    /**
     * Crea un gráfico de estadísticas de grupo sanguíneo.
     * @param personal Arreglo de enteros con la cantidad de usuarios en cada grupo sanguíneo.
     */
    public void crearGraficoGrupoSanguineo(int[] personal) {
    // Método similar a los anteriores, pero aplicado a estadísticas de grupo sanguíneo

        int usuariosTotales = personal[0];
        double porcGrupoAP = 0;
        double porcGrupoOP = 0;
        double porcGrupoBP = 0;
        double porcGrupoABP = 0;
        double porcGrupoAN = 0;
        double porcGrupoON = 0;
        double porcGrupoBN = 0;
        double porcGrupoABN = 0;

        if(personal[1] != 0){
            porcGrupoAP = (personal[1] * 100) / usuariosTotales;
        }
        if(personal[2] != 0){
            porcGrupoOP = (personal[2] * 100) / usuariosTotales;
        }
        if(personal[3] != 0){
            porcGrupoBP = (personal[3] * 100) / usuariosTotales;
        }
        if(personal[4] != 0){
            porcGrupoABP = (personal[4] * 100) / usuariosTotales;
        }
        if(personal[5] != 0){
            porcGrupoAN = (personal[5] * 100) / usuariosTotales;
        }
        if(personal[6] != 0){
            porcGrupoON = (personal[6] * 100) / usuariosTotales;
        }
        if(personal[7] != 0){
            porcGrupoBN = (personal[7] * 100) / usuariosTotales;
        }
        if(personal[8] != 0){
            porcGrupoABN = (personal[8] * 100) / usuariosTotales;
        }

        DefaultPieDataset data = new DefaultPieDataset();
        data.setValue("A+: " + personal[1] + " || " + porcGrupoAP + "%", porcGrupoAP);
        data.setValue("O+: " + personal[2] + " || " + porcGrupoOP + "%", porcGrupoOP);
        data.setValue("B+: " + personal[3] + " || " + porcGrupoBP + "%", porcGrupoBP);
        data.setValue("AB+: " + personal[4] + " || " + porcGrupoABP + "%", porcGrupoABP);
        data.setValue("A-: " + personal[5] + " || " + porcGrupoAN + "%", porcGrupoAN);
        data.setValue("O-: " + personal[6] + " || " + porcGrupoON + "%", porcGrupoON);
        data.setValue("B-: " + personal[7] + " || " + porcGrupoBN + "%", porcGrupoBN);
        data.setValue("AB-: " + personal[8] + " || " + porcGrupoABN + "%", porcGrupoABN);

        chart = ChartFactory.createPieChart3D(
                "GRUPO SANGUINEO", // chart title
                data, // data
                true, // include legend
                true,
                true);

        chart.setBackgroundPaint(Color.ORANGE);// Color de fonde de la ventana
        chart.getTitle().setPaint(Color.blue); // Dar color al titulo

        PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setLabelBackgroundPaint(Color.ORANGE);// Color de las etiquetas
        plot.setForegroundAlpha(0.60f);// Color de el fondo del grafico

        // esto es lo que lo hace rotar
        Rotator rotator = new Rotator(plot);
        rotator.start();
    }

    /**
     * Obtiene un listado de estadísticas de grupo sanguíneo.
     * @return Arreglo de enteros con la cantidad de usuarios en cada grupo sanguíneo.
     */
    public int [] listadoGrupoSanguineo() {
     // Método similar a listadoEstado y listadoEstadoxTipoUsuario, pero aplicado a grupo sanguíneo
        boolean error = false;
        int[] personal = new int[9];
        int contadorUsu = 0;
        int contadorGruAP = 0;
        int contadorGruOP = 0;
        int contadorGruBP = 0;
        int contadorGruABP = 0;
        int contadorGruAN = 0;
        int contadorGruON = 0;
        int contadorGruBN = 0;
        int contadorGruABN = 0;
        Conexion con = new Conexion();
        boolean error2 = con.conectarMySQL(baseDatos, user, login, host);
        if (!error) {
            String[][] datos = con.consultaMatriz("usuario", "1");
            if (datos == null) {
                JOptionPane.showMessageDialog(this, "No existen usuarios aún");  
            }else{
                contadorUsu = con.contar("cliente");
                contadorGruAP = con.contar("cliente", "grupo_sanguineo = 'A+'");
                contadorGruOP = con.contar("cliente", "grupo_sanguineo = 'O+'");
                contadorGruBP = con.contar("cliente", "grupo_sanguineo = 'B+'");
                contadorGruABP = con.contar("cliente", "grupo_sanguineo = 'AB+'");
                
                contadorGruAN = con.contar("cliente", "grupo_sanguineo = 'A-'");
                contadorGruON = con.contar("cliente", "grupo_sanguineo = 'O-'");
                contadorGruBN = con.contar("cliente", "grupo_sanguineo = 'B-'");
                contadorGruABN = con.contar("cliente", "grupo_sanguineo = 'AB-'");
            }
        }
        con.cerrarConsulta();
        personal[0] = contadorUsu;
        personal[1] = contadorGruAP;
        personal[2] = contadorGruOP;
        personal[3] = contadorGruBP;
        personal[4] = contadorGruABP;
        personal[5] = contadorGruAN;
        personal[6] = contadorGruON;
        personal[7] = contadorGruBN;
        personal[8] = contadorGruABN;
        return personal;
    }
}