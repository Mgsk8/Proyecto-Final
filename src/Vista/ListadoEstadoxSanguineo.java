/*
Proposito: Muestra en pantalla un lista con algunos datos de usuarios que coincidan con el Estado y
grupo sanguineo que el usuario selecciono anteriormente en el formulario.
@author 
    Jhon Alex Rodríguez Benítez - 2264363
    Miguel Angel Escobar Marín - 2264305
    John Alejandro Vallarino Cruz - 2264332
Fecha de ultima modificacion  20/10/2023
version: 1.1
*/

package Vista;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import Controlador.ControlListadoEstadoxSanguineo;
import Utilerias.JButtonFuncion;
import Utilerias.JLabelTitulo;


public class ListadoEstadoxSanguineo extends JFrame{
    
    public FormListadoEstadoxSanguineo fles;
    public ControlListadoEstadoxSanguineo cles;
    public JButton jbVolver;
    public String Estado_Buscar, Grupo_Buscar = "";

    ModeloTabla mt;
    JTable tabla;

    public ListadoEstadoxSanguineo(FormListadoEstadoxSanguineo obj, String Estado_Buscar, String Grupo_Buscar){
        super("Listado Estado y Grupo Sanguineo");
        this.Estado_Buscar = Estado_Buscar;
        this.Grupo_Buscar = Grupo_Buscar;
        fles = obj;
        setSize(1000, 700);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.GRAY);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLayout(null);
        cles = new ControlListadoEstadoxSanguineo(this);
        addWindowListener(cles);
        crearGUI();
        llenarTabla();
        
        setVisible(true);
    }

    public void crearGUI(){
        ControlListadoEstadoxSanguineo cles = new ControlListadoEstadoxSanguineo(this);
        
        JPanel jp = new JPanel();
        jp.setBounds(100, 80, 800, 500);
        jp.setBackground(Color.white);
        jp.setLayout(null);
        add(jp);
        
        JLabelTitulo jt = new JLabelTitulo(
                60, "Listado Estado x Sanguineo", this, "");
        add(jt);

        String encabezados[] = {"Cedula", "Nombre", "Apellido", "Email"};
        String datos[][] = {{"", "", "", ""}};

        mt = new ModeloTabla(datos, encabezados);
        tabla = new JTable(mt);

        tabla.setSelectionBackground(Color.lightGray);

        JScrollPane js = new JScrollPane(tabla);
        js.setBounds(60, 40, 700, 270);


        jp.add(js);


        jbVolver = new JButtonFuncion(60, "Volver listados", 'v', "/Imagenes/volver.png");
        jbVolver.addActionListener(cles);
        jp.add(jbVolver);

    }

    public void llenarTabla(){
          FileReader fr = null;
          boolean error = false;
          try {
            fr = new FileReader("usuarios.csv");
          } catch (Exception e) {
            error = true;
            JOptionPane.showMessageDialog(this, "Error al abrir el archivo 'usuarios.csv'");
          }
          if(!error){
            BufferedReader br = new BufferedReader(fr);
            String linea = "";

            mt.removeRow(0);
            try {
            System.out.println("Estado: " + Estado_Buscar);
            System.out.println("Grupo: " + Grupo_Buscar); 
                while((linea = br.readLine()) != null){
                    String tokens [] = linea.split(";");
                    if(tokens[10].equals(Estado_Buscar) && tokens[4].equals(Grupo_Buscar)){
                        mt.addRow(tokens);
                    }
                }
            } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al leer el archivo 'usuarios.csv'");
            }
            try {
                fr.close();
            } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cerrar el archivo 'usuarios.csv'");
            }
          }  
    }

}
