/*
Proposito: Muestra en pantalla un submenú con botones que permiten ir a listados con
información de los usuarios ya registrados.
@author 
    Jhon Alex Rodríguez Benítez - 2264363
    Miguel Angel Escobar Marín - 2264305
    John Alejandro Vallarino Cruz - 2264332
Fecha de ultima modificacion  20/10/2023
version: 1.1
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

public class Graficos extends JFrame implements DatosConexion{
    
    public JToggleButton jtGraficoPersonal, jtGraficoEstado, jtGraficoGrupoSanquineo;
    JFreeChart chart;
    public Graficos g;
    public ControlGraficos cg;
    public MenuAdministrador mp;
    public JButton jbVolver, jbLimpiar, jbConsultar;
    public JPanel jpGraficoPersonal, jpGraficoEstado, jpGrupoSanguineo;

    public Graficos(MenuAdministrador obj){
        super("Graficos");
        mp = obj;
        setSize(1200, 700);
        setLocationRelativeTo(null);
        //getContentPane().setBackground(color.);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLayout(null);
        cg = new ControlGraficos(this);
        Image icono = new ImageIcon(getClass().getResource("/Imagenes/LogoBlancoVentana.png")).getImage();
        setIconImage(icono);
        addWindowListener(cg);
        crearGUI();
        
        setVisible(true);
    }

    public void crearGUI(){
        
        /*
        JPanel jp = new JPanel();
        jp.setBounds(100, 80, 800, 500);
        jp.setBackground(Color.white);
        jp.setLayout(null);
        add(jp);*/
        
        JLabelTitulo jt = new JLabelTitulo(
                60, "Graficos", this, "/Imagenes/Consultar.png");
        add(jt);
        cg = new ControlGraficos(this);
        
        //----------------------Jpanel Graficos ----------------------------------------------------------------------
        JPanel jpGraficos = new JPanel();
        jpGraficos.setBounds(20, 80, 220, 360);
        jpGraficos.setLayout(null);
        jpGraficos.setBorder(new TitledBorder("Listados"));
        add(jpGraficos);
        
        
        jtGraficoPersonal = new JToggleButton("<html><center><p>Grafico por</p></center><center><p>tipo de usuario</p></center></html>");
        jtGraficoPersonal.setBounds(10, 40, 200, 40);
        jtGraficoPersonal.setBackground(new Color(226, 0, 82));
        jtGraficoPersonal.setForeground(Color.white);
        jtGraficoPersonal.setFont(new Font("Tahoma", 1, 12));
        jtGraficoPersonal.setBorderPainted(false);
        jtGraficoPersonal.setFocusPainted(false);
        jtGraficoPersonal.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jtGraficoPersonal.addActionListener(cg);
        jpGraficos.add(jtGraficoPersonal);
        
        jtGraficoEstado = new JToggleButton();
        jtGraficoEstado.setText("<html><center><p>Grafico por</p></center><center><p>estado</p></center></html>");
        jtGraficoEstado.setBounds(10, 120,200, 40);
        jtGraficoEstado.setBackground(new Color(226, 0, 82));
        jtGraficoEstado.setForeground(Color.white);
        jtGraficoEstado.setFont(new Font("Tahoma", 1, 12));
        jtGraficoEstado.setBorderPainted(false);
        jtGraficoEstado.setFocusPainted(false);
        jtGraficoEstado.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jtGraficoEstado.addActionListener(cg);
        jpGraficos.add(jtGraficoEstado);
        
        jtGraficoGrupoSanquineo = new JToggleButton();
        jtGraficoGrupoSanquineo.setText("<html><center><p>Grafico por</p></center><center><p>grupo sanguineo</p></center></html>");
        jtGraficoGrupoSanquineo.setBounds(10, 200, 200, 40);
        jtGraficoGrupoSanquineo.setBackground(new Color(226, 0, 82));
        jtGraficoGrupoSanquineo.setForeground(Color.white);
        jtGraficoGrupoSanquineo.setFont(new Font("Tahoma", 1, 12));
        jtGraficoGrupoSanquineo.setBorderPainted(false);
        jtGraficoGrupoSanquineo.setFocusPainted(false);
        jtGraficoGrupoSanquineo.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jtGraficoGrupoSanquineo.addActionListener(cg);
        jpGraficos.add(jtGraficoGrupoSanquineo);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(jtGraficoPersonal);
        bg.add(jtGraficoEstado);
        bg.add(jtGraficoGrupoSanquineo);
        
         //-------------------- JPanel Grafico Personal ----------------------------------------------------------------------
        jpGraficoPersonal = new JPanel();
        jpGraficoPersonal.setBounds(250, 80, 780, 570);
        jpGraficoPersonal.setLayout(null);
        jpGraficoPersonal.setBorder(new TitledBorder ( "Grafico por tipo de usuario"));
        jpGraficoPersonal.setVisible(false);
        add(jpGraficoPersonal);
        
        int[] personal = listadoPersonal();
        crearGraficoPersonal(personal);

        ChartPanel panelPersonal = new ChartPanel(chart, false);
        panelPersonal.setBounds(10, 30, 760, 520);
        jpGraficoPersonal.add(panelPersonal);
        
        //-------------------- JPanel Grafico por Estado ----------------------------------------------------------------------
        jpGraficoEstado = new JPanel();
        jpGraficoEstado.setBounds(250, 80, 780, 570);
        //jpListadoEstxSan.setBackground(Color.gray);
        jpGraficoEstado.setLayout(null);
        jpGraficoEstado.setBorder(new TitledBorder ( "Grafico por estado"));
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
        jpGrupoSanguineo.setBorder(new TitledBorder ( "Grafico de clientes por tipo sanguineo"));
        jpGrupoSanguineo.setVisible(false);
        add(jpGrupoSanguineo);
        
        int[] grupoSanguineo = listadoGrupoSanguineo();
        crearGraficoGrupoSanguineo(grupoSanguineo);

        ChartPanel panelGrupoSanguineo = new ChartPanel(chart, false);
        panelGrupoSanguineo.setBounds(10, 30, 760, 520);
        jpGrupoSanguineo.add(panelGrupoSanguineo);
        
        //------------------------- boton volver ----------------------------------
        jbVolver = new JButtonFuncion(70,500,"Volver al menu", 'v', "/Imagenes/volver.png");
        jbVolver.addActionListener(cg);
        add(jbVolver);
    }
    
    
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
    
    public void crearGraficoEstado(int[] personal) {
        
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

    public int [] listadoEstado() {
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
    
    public void crearGraficoGrupoSanguineo(int[] personal) {
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

    public int [] listadoGrupoSanguineo() {
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