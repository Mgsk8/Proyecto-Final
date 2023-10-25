/*
Proposito: Nos permite listar a los usuarios creados hasta el momento.
@author 
    Jhon Alex Rodríguez Benítez - 2264363
    Miguel Angel Escobar Marín - 2264305
    John Alejandro Vallarino Cruz - 2264332
Fecha de ultima modificacion  26/09/2023
version: 1.0
*/


package Vista;

import Controlador.ControlListadoUsuarios;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;
import Modelo.Usuario;
import Utilerias.JLabelTitulo;
import java.awt.Cursor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;

public class ListadoUsuarios extends JFrame{

    ModeloTabla mt;
    JTable tabla;
    public MenuPrincipal mp;
    ControlListadoUsuarios clu = new ControlListadoUsuarios(this);
    
    public JButton jbVolver;
        
    public ListadoUsuarios(MenuPrincipal mp){
        super("Listado de Personas");
        this.mp = mp;
        setSize(800, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLayout(null);
        
        crearGUI();
        llenarTabla();
        
        setVisible(true);
    }
        
    private void crearGUI() {
        JLabelTitulo jt = new JLabelTitulo(
                60, "Lista Usuarios", this, "");
        add(jt);
        /*JLabel jl = new JLabel("Listado de usuarios");
        jl.setBounds(0, 0, 800, 50);
        jl.setBorder(new EtchedBorder());
        jl.setOpaque(true);
        jl.setBackground(Color.WHITE);
        jl.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(jl);
        */
        String encabezados[] = {"Cedula", "Nombre", "Apellido", "Tipo Usuario", "Grupo Sanguineo", "Fecha Nac", "Email"};
        String datos[][] = {{"", "", "", "", "", "", ""}};
        
        mt = new ModeloTabla(datos, encabezados);
        tabla = new JTable(mt);
        
        tabla.setSelectionBackground(Color.lightGray);
        tabla.setSelectionForeground(Color.RED);
        
        ImageIcon volver = new ImageIcon(getClass().getResource("/imagenes/volver.png"));
        jbVolver = new JButton("Volver al menu",volver);
        jbVolver.setBounds(60, 460, 200, 80);
        jbVolver.setMnemonic('V');
        jbVolver.addActionListener(clu);
        jbVolver.setHorizontalTextPosition(SwingConstants.CENTER);//configurar la posición del texto horizontal
        jbVolver.setVerticalTextPosition(SwingConstants.BOTTOM);//configurar la posición del texto vertical
        jbVolver.setContentAreaFilled(false);//No pinta el area del botón
        jbVolver.setBorderPainted(false);//No pinta los bordes
        jbVolver.setFocusPainted(false);//Desabilita el efecto del botón cuando el cursor se posa sobre el botón
        jbVolver.setCursor(new Cursor(Cursor.HAND_CURSOR));//permite cambiar el tipo de cursor cuando se posa sobre el botón
        add(jbVolver);
        
        JScrollPane js = new JScrollPane(tabla);
        js.setBounds(20, 80, 745, 350);
        //js.setHorizontalScrollBar(SwingConstants.CENTER);
        add(js);
    }
    
    public void llenarTabla(){
        mt.removeRow(0);
        for (int i = 0; i < mp.usuarios.size(); i++) {
            Usuario u = mp.usuarios.get(i);
            //System.out.println(p.getNombre());
            Object datos[] = new Object[7];            
            datos[0] = u.getCedula();
            datos[1] = u.getNombre();
            datos[2] = u.getApellido();
            datos[3] = u.getTipoUsuario();
            datos[4] = u.getGrupoSanguineo();
            datos[5] = u.getFechaNacimiento();
            datos[6] = u.getEmail();
            
            mt.addRow(datos);
        }
    }
}
