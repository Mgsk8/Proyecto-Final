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

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Controlador.ControlListados;
import Modelo.Administrador;
import Utilerias.Conexion;
import Utilerias.DatosConexion;
import static Utilerias.DatosConexion.baseDatos;
import static Utilerias.DatosConexion.host;
import static Utilerias.DatosConexion.login;
import static Utilerias.DatosConexion.user;
import Utilerias.JButtonFuncion;
import Utilerias.JButtonMenu;
import Utilerias.JLabelTitulo;
import com.mysql.jdbc.ResultSet;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.List;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JToggleButton;
import javax.swing.border.TitledBorder;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

public class Listados extends JFrame implements DatosConexion{
    
    public JButton jbListadoGeneral, jbListadoEstadoxTipo, jbListadoEstadoxSanguineo;
    public JToggleButton jtListadoGeneral, jtListadoEstxSan, jtListadoEstxTip;
    public ControlListados cl;
    public MenuAdministrador mp;
    public JButton jbVolver;
    public JPanel jpListadoGeneral, jpListadoClientes, jpListadoEstxSan, jpListadoEstxTip;
    public Listados l;
    ModeloTabla mt, mt2, mt3;
    JTable tabla, tabla2, tabla3;

    public Listados(MenuAdministrador obj){
        super("Listados");
        mp = obj;
        setSize(1200, 700);
        setLocationRelativeTo(null);
        //getContentPane().setBackground(color.);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLayout(null);
        cl = new ControlListados(this);
        addWindowListener(cl);
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
                60, "Listados", this, "/Imagenes/Consultar.png");
        add(jt);
        cl = new ControlListados(this);
        
        //----------------------Jpanel Listados ----------------------------------------------------------------------
        JPanel jpListados = new JPanel();
        jpListados.setBounds(20, 80, 220, 360);
        jpListados.setLayout(null);
        jpListados.setBorder(new TitledBorder("Listados"));
        add(jpListados);
        
        
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
        
        jtListadoEstxSan = new JToggleButton();
        jtListadoEstxSan.setText("<html><center><p>Listado por</p></center><center><p>estado y grupo sanguineo</p></center></html>");
        jtListadoEstxSan.setBounds(10, 120,200, 40);
        jtListadoEstxSan.setBackground(new Color(226, 0, 82));
        jtListadoEstxSan.setForeground(Color.white);
        jtListadoEstxSan.setFont(new Font("Tahoma", 1, 12));
        jtListadoEstxSan.setBorderPainted(false);
        jtListadoEstxSan.setFocusPainted(false);
        jtListadoEstxSan.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jtListadoEstxSan.addActionListener(cl);
        jpListados.add(jtListadoEstxSan);
        
        jtListadoEstxTip = new JToggleButton();
        jtListadoEstxTip.setText("<html><center><p>Listado por</p></center><center><p>estado y tipo de usuario</p></center></html>");
        jtListadoEstxTip.setBounds(10, 200, 200, 40);
        jtListadoEstxTip.setBackground(new Color(226, 0, 82));
        jtListadoEstxTip.setForeground(Color.white);
        jtListadoEstxTip.setFont(new Font("Tahoma", 1, 12));
        jtListadoEstxTip.setBorderPainted(false);
        jtListadoEstxTip.setFocusPainted(false);
        jtListadoEstxTip.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jtListadoEstxTip.addActionListener(cl);
        jpListados.add(jtListadoEstxTip);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(jtListadoGeneral);
        bg.add(jtListadoEstxSan);
        bg.add(jtListadoEstxTip);
        
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
        
        //-------------------- JPanel Listado Estado x Grupo Sanguineo ----------------------------------------------------------------------
        jpListadoEstxSan = new JPanel();
        jpListadoEstxSan.setBounds(250, 80, 900, 360);
        //jpListadoEstxSan.setBackground(Color.gray);
        jpListadoEstxSan.setLayout(null);
        jpListadoEstxSan.setBorder(new TitledBorder ( "Listado Estado x Grupo Sanguineo"));
        jpListadoEstxSan.setVisible(false);
        add(jpListadoEstxSan);
        
        String encabezados2[] = { "Cedula", "Nombre", "Apellido", "Dia nac", "Mes nac", "Año nac", "Email", "Password", "Sueldo"};
        String datos2[][] = { { "", "", "", "", "", "", "", "", ""} };
        
        mt2 = new ModeloTabla(datos2, encabezados2);
        tabla2 = new JTable(mt2);

        tabla2.setSelectionBackground(Color.lightGray);

        JScrollPane js2 = new JScrollPane(tabla2);
        js2.setBounds(10, 50, 880, 270);

        jpListadoEstxSan.add(js2);
        
        //-------------------- JPanel Listado Estado x Tipo de usuario ----------------------------------------------------------------------
        jpListadoEstxTip = new JPanel();
        jpListadoEstxTip.setBounds(250, 80, 900, 360);
        //jpListadoEstxTip.setBackground(Color.gray);
        jpListadoEstxTip.setLayout(null);
        jpListadoEstxTip.setBorder(new TitledBorder ( "Listado Estado x Tipo de usuario"));
        jpListadoEstxTip.setVisible(false);
        add(jpListadoEstxTip);
        
        String encabezados3[] = {"Cedula", "Nombre", "Apellido", "Dia nac", "Mes nac", "Año nac", "Email", "Tipo usuario",};
        String datos3[][] = { {"", "", "", "", "", "", "", "", ""} };
        
        mt3 = new ModeloTabla(datos3, encabezados3);
        tabla3 = new JTable(mt3);

        tabla3.setSelectionBackground(Color.lightGray);

        JScrollPane js3 = new JScrollPane(tabla3);
        js3.setBounds(10, 50, 880, 270);

        jpListadoEstxTip.add(js3);
        
        //------------------------- boton volver ----------------------------------
        jbVolver = new JButtonFuncion(70,500,"Volver al menu", 'v', "/Imagenes/volver.png");
        jbVolver.addActionListener(cl);
        add(jbVolver);
    }
    
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
    
    /*public void llenarTablaGeneral() {
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
    
    /*private void evento_jbConsultar() {
        Conexion con = new Conexion();
        boolean error = con.conectarMySQL(baseDatos, user, login, host);
        if (!error) {
            String[][] datos =  con.consultaMatriz("administradores", "0");
            if (datos == null) {
                JOptionPane.showMessageDialog(this, "No existen administradores aún");  
            }else{
                jtNom.setText(datos[2]);
                jtApe.setText(datos[1]);
                jcPlanes.setSelectedItem(datos[3]);
            }
        }
    }*/
    

}